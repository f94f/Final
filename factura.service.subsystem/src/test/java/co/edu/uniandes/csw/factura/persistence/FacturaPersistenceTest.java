
package co.edu.uniandes.csw.factura.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;


import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;
import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;

@RunWith(Arquillian.class)
public class FacturaPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(FacturaPersistence.class.getPackage())
				.addPackage(FacturaEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IFacturaPersistence facturaPersistence;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	@Before
	public void configTest() {
		System.out.println("em: " + em);
		try {
			utx.begin();
			clearData();
			insertData();
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				utx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void clearData() {
		em.createQuery("delete from FacturaEntity").executeUpdate();
	}

	private List<FacturaEntity> data=new ArrayList<FacturaEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			FacturaEntity entity=new FacturaEntity();
			entity.setName(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createFacturaTest(){
		FacturaDTO dto=new FacturaDTO();
		dto.setName(generateRandom(String.class));
		
		
		FacturaDTO result=facturaPersistence.createFactura(dto);
		
		Assert.assertNotNull(result);
		
		FacturaEntity entity=em.find(FacturaEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());	
	}
	
	@Test
	public void getFacturasTest(){
		List<FacturaDTO> list=facturaPersistence.getFacturas();
		Assert.assertEquals(list.size(), data.size());
        for(FacturaDTO dto:list){
        	boolean found=false;
            for(FacturaEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getFacturaTest(){
		FacturaEntity entity=data.get(0);
		FacturaDTO dto=facturaPersistence.getFactura(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
        
	}
	
	@Test
	public void deleteFacturaTest(){
		FacturaEntity entity=data.get(0);
		facturaPersistence.deleteFactura(entity.getId());
        FacturaEntity deleted=em.find(FacturaEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateFacturaTest(){
		FacturaEntity entity=data.get(0);
		
		FacturaDTO dto=new FacturaDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		
		
		facturaPersistence.updateFactura(dto);
		
		
		FacturaEntity resp=em.find(FacturaEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getName(), resp.getName());	
	}
	
	public <T> T generateRandom(Class<T> objectClass){
		Random r=new Random();
		if(objectClass.isInstance(String.class)){
			String s="";
			for(int i=0;i<10;i++){
				char c=(char)(r.nextInt()/('Z'-'A')+'A');
				s=s+c;
			}
			return objectClass.cast(s);
		}else if(objectClass.isInstance(Integer.class)){
			Integer s=r.nextInt();
			return objectClass.cast(s);
		}else if(objectClass.isInstance(Long.class)){
			Long s=r.nextLong();
			return objectClass.cast(s);
		}else if(objectClass.isInstance(java.util.Date.class)){
			java.util.Calendar c=java.util.Calendar.getInstance();
			c.set(java.util.Calendar.MONTH, r.nextInt()/12);
			c.set(java.util.Calendar.DAY_OF_MONTH,r.nextInt()/30);
			c.setLenient(false);
			return objectClass.cast(c.getTime());
		} 
		return null;
	}
	
}