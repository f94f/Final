
package co.edu.uniandes.csw.ordenfabricacion.persistence;

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


import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;
import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;

@RunWith(Arquillian.class)
public class OrdenFabricacionPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(OrdenFabricacionPersistence.class.getPackage())
				.addPackage(OrdenFabricacionEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IOrdenFabricacionPersistence ordenFabricacionPersistence;

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
		em.createQuery("delete from OrdenFabricacionEntity").executeUpdate();
	}

	private List<OrdenFabricacionEntity> data=new ArrayList<OrdenFabricacionEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			OrdenFabricacionEntity entity=new OrdenFabricacionEntity();
			entity.setName(generateRandom(String.class));
			entity.setFecha(generateRandom(Date.class));
			entity.setCantidad(generateRandom(Integer.class));
			entity.setEstado(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createOrdenFabricacionTest(){
		OrdenFabricacionDTO dto=new OrdenFabricacionDTO();
		dto.setName(generateRandom(String.class));
		dto.setFecha(generateRandom(Date.class));
		dto.setCantidad(generateRandom(Integer.class));
		dto.setEstado(generateRandom(String.class));
		
		
		OrdenFabricacionDTO result=ordenFabricacionPersistence.createOrdenFabricacion(dto);
		
		Assert.assertNotNull(result);
		
		OrdenFabricacionEntity entity=em.find(OrdenFabricacionEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());	
		Assert.assertEquals(dto.getFecha(), entity.getFecha());	
		Assert.assertEquals(dto.getCantidad(), entity.getCantidad());	
		Assert.assertEquals(dto.getEstado(), entity.getEstado());	
	}
	
	@Test
	public void getOrdenFabricacionsTest(){
		List<OrdenFabricacionDTO> list=ordenFabricacionPersistence.getOrdenFabricacions();
		Assert.assertEquals(list.size(), data.size());
        for(OrdenFabricacionDTO dto:list){
        	boolean found=false;
            for(OrdenFabricacionEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getOrdenFabricacionTest(){
		OrdenFabricacionEntity entity=data.get(0);
		OrdenFabricacionDTO dto=ordenFabricacionPersistence.getOrdenFabricacion(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
		Assert.assertEquals(entity.getFecha(), dto.getFecha());
		Assert.assertEquals(entity.getCantidad(), dto.getCantidad());
		Assert.assertEquals(entity.getEstado(), dto.getEstado());
        
	}
	
	@Test
	public void deleteOrdenFabricacionTest(){
		OrdenFabricacionEntity entity=data.get(0);
		ordenFabricacionPersistence.deleteOrdenFabricacion(entity.getId());
        OrdenFabricacionEntity deleted=em.find(OrdenFabricacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateOrdenFabricacionTest(){
		OrdenFabricacionEntity entity=data.get(0);
		
		OrdenFabricacionDTO dto=new OrdenFabricacionDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		dto.setFecha(generateRandom(Date.class));
		dto.setCantidad(generateRandom(Integer.class));
		dto.setEstado(generateRandom(String.class));
		
		
		ordenFabricacionPersistence.updateOrdenFabricacion(dto);
		
		
		OrdenFabricacionEntity resp=em.find(OrdenFabricacionEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getName(), resp.getName());	
		Assert.assertEquals(dto.getFecha(), resp.getFecha());	
		Assert.assertEquals(dto.getCantidad(), resp.getCantidad());	
		Assert.assertEquals(dto.getEstado(), resp.getEstado());	
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