
package co.edu.uniandes.csw.ordendespacho.logic.ejb;

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
import co.edu.uniandes.csw.ordendespacho.logic.api.IOrdenDespachoLogicService;
import co.edu.uniandes.csw.ordendespacho.persistence.OrdenDespachoPersistence;
import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;
import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;

@RunWith(Arquillian.class)
public class OrdenDespachoLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(OrdenDespachoLogicService.class.getPackage())
				.addPackage(OrdenDespachoPersistence.class.getPackage())
				.addPackage(OrdenDespachoEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IOrdenDespachoLogicService ordenDespachoLogicService;
	
	@Inject
	private IOrdenDespachoPersistence ordenDespachoPersistence;	

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
		List<OrdenDespachoDTO> dtos=ordenDespachoPersistence.getOrdenDespachos();
		for(OrdenDespachoDTO dto:dtos){
			ordenDespachoPersistence.deleteOrdenDespacho(dto.getId());
		}
	}

	private List<OrdenDespachoDTO> data=new ArrayList<OrdenDespachoDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			OrdenDespachoDTO pdto=new OrdenDespachoDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setFecha(generateRandom(Date.class));
			pdto.setCantidad(generateRandom(Integer.class));
			pdto.setEstado(generateRandom(String.class));
			pdto=ordenDespachoPersistence.createOrdenDespacho(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createOrdenDespachoTest(){
		OrdenDespachoDTO ldto=new OrdenDespachoDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setFecha(generateRandom(Date.class));
		ldto.setCantidad(generateRandom(Integer.class));
		ldto.setEstado(generateRandom(String.class));
		
		
		OrdenDespachoDTO result=ordenDespachoLogicService.createOrdenDespacho(ldto);
		
		Assert.assertNotNull(result);
		
		OrdenDespachoDTO pdto=ordenDespachoPersistence.getOrdenDespacho(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getFecha(), pdto.getFecha());	
		Assert.assertEquals(ldto.getCantidad(), pdto.getCantidad());	
		Assert.assertEquals(ldto.getEstado(), pdto.getEstado());	
	}
	
	@Test
	public void getOrdenDespachosTest(){
		List<OrdenDespachoDTO> list=ordenDespachoLogicService.getOrdenDespachos();
		Assert.assertEquals(list.size(), data.size());
        for(OrdenDespachoDTO ldto:list){
        	boolean found=false;
            for(OrdenDespachoDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getOrdenDespachoTest(){
		OrdenDespachoDTO pdto=data.get(0);
		OrdenDespachoDTO ldto=ordenDespachoLogicService.getOrdenDespacho(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getFecha(), ldto.getFecha());
		Assert.assertEquals(pdto.getCantidad(), ldto.getCantidad());
		Assert.assertEquals(pdto.getEstado(), ldto.getEstado());
        
	}
	
	@Test
	public void deleteOrdenDespachoTest(){
		OrdenDespachoDTO pdto=data.get(0);
		ordenDespachoLogicService.deleteOrdenDespacho(pdto.getId());
        OrdenDespachoDTO deleted=ordenDespachoPersistence.getOrdenDespacho(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateOrdenDespachoTest(){
		OrdenDespachoDTO pdto=data.get(0);
		
		OrdenDespachoDTO ldto=new OrdenDespachoDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setFecha(generateRandom(Date.class));
		ldto.setCantidad(generateRandom(Integer.class));
		ldto.setEstado(generateRandom(String.class));
		
		
		ordenDespachoLogicService.updateOrdenDespacho(ldto);
		
		
		OrdenDespachoDTO resp=ordenDespachoPersistence.getOrdenDespacho(pdto.getId());
		
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