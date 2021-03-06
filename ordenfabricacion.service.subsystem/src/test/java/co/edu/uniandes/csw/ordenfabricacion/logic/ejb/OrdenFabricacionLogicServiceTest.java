
package co.edu.uniandes.csw.ordenfabricacion.logic.ejb;

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
import co.edu.uniandes.csw.ordenfabricacion.logic.api.IOrdenFabricacionLogicService;
import co.edu.uniandes.csw.ordenfabricacion.persistence.OrdenFabricacionPersistence;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;
import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;

@RunWith(Arquillian.class)
public class OrdenFabricacionLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(OrdenFabricacionLogicService.class.getPackage())
				.addPackage(OrdenFabricacionPersistence.class.getPackage())
				.addPackage(OrdenFabricacionEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IOrdenFabricacionLogicService ordenFabricacionLogicService;
	
	@Inject
	private IOrdenFabricacionPersistence ordenFabricacionPersistence;	

	@Before
	public void configTest() {
		try {
			clearData();
			insertData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearData() {
		List<OrdenFabricacionDTO> dtos=ordenFabricacionPersistence.getOrdenFabricacions();
		for(OrdenFabricacionDTO dto:dtos){
			ordenFabricacionPersistence.deleteOrdenFabricacion(dto.getId());
		}
	}

	private List<OrdenFabricacionDTO> data=new ArrayList<OrdenFabricacionDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			OrdenFabricacionDTO pdto=new OrdenFabricacionDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setFecha(generateRandom(Date.class));
			pdto.setCantidad(generateRandom(Integer.class));
			pdto.setEstado(generateRandom(String.class));
			pdto=ordenFabricacionPersistence.createOrdenFabricacion(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createOrdenFabricacionTest(){
		OrdenFabricacionDTO ldto=new OrdenFabricacionDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setFecha(generateRandom(Date.class));
		ldto.setCantidad(generateRandom(Integer.class));
		ldto.setEstado(generateRandom(String.class));
		
		
		OrdenFabricacionDTO result=ordenFabricacionLogicService.createOrdenFabricacion(ldto);
		
		Assert.assertNotNull(result);
		
		OrdenFabricacionDTO pdto=ordenFabricacionPersistence.getOrdenFabricacion(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getFecha(), pdto.getFecha());	
		Assert.assertEquals(ldto.getCantidad(), pdto.getCantidad());	
		Assert.assertEquals(ldto.getEstado(), pdto.getEstado());	
	}
	
	@Test
	public void getOrdenFabricacionsTest(){
		List<OrdenFabricacionDTO> list=ordenFabricacionLogicService.getOrdenFabricacions();
		Assert.assertEquals(list.size(), data.size());
        for(OrdenFabricacionDTO ldto:list){
        	boolean found=false;
            for(OrdenFabricacionDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getOrdenFabricacionTest(){
		OrdenFabricacionDTO pdto=data.get(0);
		OrdenFabricacionDTO ldto=ordenFabricacionLogicService.getOrdenFabricacion(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getFecha(), ldto.getFecha());
		Assert.assertEquals(pdto.getCantidad(), ldto.getCantidad());
		Assert.assertEquals(pdto.getEstado(), ldto.getEstado());
        
	}
	
	@Test
	public void deleteOrdenFabricacionTest(){
		OrdenFabricacionDTO pdto=data.get(0);
		ordenFabricacionLogicService.deleteOrdenFabricacion(pdto.getId());
        OrdenFabricacionDTO deleted=ordenFabricacionPersistence.getOrdenFabricacion(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateOrdenFabricacionTest(){
		OrdenFabricacionDTO pdto=data.get(0);
		
		OrdenFabricacionDTO ldto=new OrdenFabricacionDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setFecha(generateRandom(Date.class));
		ldto.setCantidad(generateRandom(Integer.class));
		ldto.setEstado(generateRandom(String.class));
		
		
		ordenFabricacionLogicService.updateOrdenFabricacion(ldto);
		
		
		OrdenFabricacionDTO resp=ordenFabricacionPersistence.getOrdenFabricacion(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getFecha(), resp.getFecha());	
		Assert.assertEquals(ldto.getCantidad(), resp.getCantidad());	
		Assert.assertEquals(ldto.getEstado(), resp.getEstado());	
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