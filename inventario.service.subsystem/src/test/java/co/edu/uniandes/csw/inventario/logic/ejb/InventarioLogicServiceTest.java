
package co.edu.uniandes.csw.inventario.logic.ejb;

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


import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.logic.api.IInventarioLogicService;
import co.edu.uniandes.csw.inventario.persistence.InventarioPersistence;
import co.edu.uniandes.csw.inventario.persistence.api.IInventarioPersistence;
import co.edu.uniandes.csw.inventario.persistence.entity.InventarioEntity;

@RunWith(Arquillian.class)
public class InventarioLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(InventarioLogicService.class.getPackage())
				.addPackage(InventarioPersistence.class.getPackage())
				.addPackage(InventarioEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IInventarioLogicService inventarioLogicService;
	
	@Inject
	private IInventarioPersistence inventarioPersistence;	

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
		List<InventarioDTO> dtos=inventarioPersistence.getInventarios();
		for(InventarioDTO dto:dtos){
			inventarioPersistence.deleteInventario(dto.getId());
		}
	}

	private List<InventarioDTO> data=new ArrayList<InventarioDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			InventarioDTO pdto=new InventarioDTO();
			pdto.setName(generateRandom(String.class));
			pdto=inventarioPersistence.createInventario(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createInventarioTest(){
		InventarioDTO ldto=new InventarioDTO();
		ldto.setName(generateRandom(String.class));
		
		
		InventarioDTO result=inventarioLogicService.createInventario(ldto);
		
		Assert.assertNotNull(result);
		
		InventarioDTO pdto=inventarioPersistence.getInventario(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
	}
	
	@Test
	public void getInventariosTest(){
		List<InventarioDTO> list=inventarioLogicService.getInventarios();
		Assert.assertEquals(list.size(), data.size());
        for(InventarioDTO ldto:list){
        	boolean found=false;
            for(InventarioDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getInventarioTest(){
		InventarioDTO pdto=data.get(0);
		InventarioDTO ldto=inventarioLogicService.getInventario(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
        
	}
	
	@Test
	public void deleteInventarioTest(){
		InventarioDTO pdto=data.get(0);
		inventarioLogicService.deleteInventario(pdto.getId());
        InventarioDTO deleted=inventarioPersistence.getInventario(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateInventarioTest(){
		InventarioDTO pdto=data.get(0);
		
		InventarioDTO ldto=new InventarioDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		
		
		inventarioLogicService.updateInventario(ldto);
		
		
		InventarioDTO resp=inventarioPersistence.getInventario(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
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