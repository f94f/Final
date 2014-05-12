
package co.edu.uniandes.csw.ordendespacho.persistence;

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


import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;
import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;

@RunWith(Arquillian.class)
public class OrdenDespachoPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(OrdenDespachoPersistence.class.getPackage())
				.addPackage(OrdenDespachoEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IOrdenDespachoPersistence ordenDespachoPersistence;

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
		em.createQuery("delete from OrdenDespachoEntity").executeUpdate();
	}

	private List<OrdenDespachoEntity> data=new ArrayList<OrdenDespachoEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			OrdenDespachoEntity entity=new OrdenDespachoEntity();
			entity.setName(generateRandom(String.class));
			entity.setFecha(generateRandom(Date.class));
			entity.setCantidad(generateRandom(Integer.class));
			entity.setEstado(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createOrdenDespachoTest(){
		OrdenDespachoDTO dto=new OrdenDespachoDTO();
		dto.setName(generateRandom(String.class));
		dto.setFecha(generateRandom(Date.class));
		dto.setCantidad(generateRandom(Integer.class));
		dto.setEstado(generateRandom(String.class));
		
		
		OrdenDespachoDTO result=ordenDespachoPersistence.createOrdenDespacho(dto);
		
		Assert.assertNotNull(result);
		
		OrdenDespachoEntity entity=em.find(OrdenDespachoEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());	
		Assert.assertEquals(dto.getFecha(), entity.getFecha());	
		Assert.assertEquals(dto.getCantidad(), entity.getCantidad());	
		Assert.assertEquals(dto.getEstado(), entity.getEstado());	
	}
	
	@Test
	public void getOrdenDespachosTest(){
		List<OrdenDespachoDTO> list=ordenDespachoPersistence.getOrdenDespachos();
		Assert.assertEquals(list.size(), data.size());
        for(OrdenDespachoDTO dto:list){
        	boolean found=false;
            for(OrdenDespachoEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getOrdenDespachoTest(){
		OrdenDespachoEntity entity=data.get(0);
		OrdenDespachoDTO dto=ordenDespachoPersistence.getOrdenDespacho(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
		Assert.assertEquals(entity.getFecha(), dto.getFecha());
		Assert.assertEquals(entity.getCantidad(), dto.getCantidad());
		Assert.assertEquals(entity.getEstado(), dto.getEstado());
        
	}
	
	@Test
	public void deleteOrdenDespachoTest(){
		OrdenDespachoEntity entity=data.get(0);
		ordenDespachoPersistence.deleteOrdenDespacho(entity.getId());
        OrdenDespachoEntity deleted=em.find(OrdenDespachoEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateOrdenDespachoTest(){
		OrdenDespachoEntity entity=data.get(0);
		
		OrdenDespachoDTO dto=new OrdenDespachoDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		dto.setFecha(generateRandom(Date.class));
		dto.setCantidad(generateRandom(Integer.class));
		dto.setEstado(generateRandom(String.class));
		
		
		ordenDespachoPersistence.updateOrdenDespacho(dto);
		
		
		OrdenDespachoEntity resp=em.find(OrdenDespachoEntity.class, entity.getId());
		
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