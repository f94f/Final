
package co.edu.uniandes.csw.ordenreaprovicionamiento.logic.ejb;

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


import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api.IOrdenReaprovicionamientoLogicService;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.OrdenReaprovicionamientoPersistence;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api.IOrdenReaprovicionamientoPersistence;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity.OrdenReaprovicionamientoEntity;

@RunWith(Arquillian.class)
public class OrdenReaprovicionamientoLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(OrdenReaprovicionamientoLogicService.class.getPackage())
				.addPackage(OrdenReaprovicionamientoPersistence.class.getPackage())
				.addPackage(OrdenReaprovicionamientoEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IOrdenReaprovicionamientoLogicService ordenReaprovicionamientoLogicService;
	
	@Inject
	private IOrdenReaprovicionamientoPersistence ordenReaprovicionamientoPersistence;	

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
		List<OrdenReaprovicionamientoDTO> dtos=ordenReaprovicionamientoPersistence.getOrdenReaprovicionamientos();
		for(OrdenReaprovicionamientoDTO dto:dtos){
			ordenReaprovicionamientoPersistence.deleteOrdenReaprovicionamiento(dto.getId());
		}
	}

	private List<OrdenReaprovicionamientoDTO> data=new ArrayList<OrdenReaprovicionamientoDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			OrdenReaprovicionamientoDTO pdto=new OrdenReaprovicionamientoDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setFecha(generateRandom(Date.class));
			pdto.setCantidad(generateRandom(Integer.class));
			pdto=ordenReaprovicionamientoPersistence.createOrdenReaprovicionamiento(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createOrdenReaprovicionamientoTest(){
		OrdenReaprovicionamientoDTO ldto=new OrdenReaprovicionamientoDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setFecha(generateRandom(Date.class));
		ldto.setCantidad(generateRandom(Integer.class));
		
		
		OrdenReaprovicionamientoDTO result=ordenReaprovicionamientoLogicService.createOrdenReaprovicionamiento(ldto);
		
		Assert.assertNotNull(result);
		
		OrdenReaprovicionamientoDTO pdto=ordenReaprovicionamientoPersistence.getOrdenReaprovicionamiento(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getFecha(), pdto.getFecha());	
		Assert.assertEquals(ldto.getCantidad(), pdto.getCantidad());	
	}
	
	@Test
	public void getOrdenReaprovicionamientosTest(){
		List<OrdenReaprovicionamientoDTO> list=ordenReaprovicionamientoLogicService.getOrdenReaprovicionamientos();
		Assert.assertEquals(list.size(), data.size());
        for(OrdenReaprovicionamientoDTO ldto:list){
        	boolean found=false;
            for(OrdenReaprovicionamientoDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getOrdenReaprovicionamientoTest(){
		OrdenReaprovicionamientoDTO pdto=data.get(0);
		OrdenReaprovicionamientoDTO ldto=ordenReaprovicionamientoLogicService.getOrdenReaprovicionamiento(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getFecha(), ldto.getFecha());
		Assert.assertEquals(pdto.getCantidad(), ldto.getCantidad());
        
	}
	
	@Test
	public void deleteOrdenReaprovicionamientoTest(){
		OrdenReaprovicionamientoDTO pdto=data.get(0);
		ordenReaprovicionamientoLogicService.deleteOrdenReaprovicionamiento(pdto.getId());
        OrdenReaprovicionamientoDTO deleted=ordenReaprovicionamientoPersistence.getOrdenReaprovicionamiento(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateOrdenReaprovicionamientoTest(){
		OrdenReaprovicionamientoDTO pdto=data.get(0);
		
		OrdenReaprovicionamientoDTO ldto=new OrdenReaprovicionamientoDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setFecha(generateRandom(Date.class));
		ldto.setCantidad(generateRandom(Integer.class));
		
		
		ordenReaprovicionamientoLogicService.updateOrdenReaprovicionamiento(ldto);
		
		
		OrdenReaprovicionamientoDTO resp=ordenReaprovicionamientoPersistence.getOrdenReaprovicionamiento(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getFecha(), resp.getFecha());	
		Assert.assertEquals(ldto.getCantidad(), resp.getCantidad());	
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