
package co.edu.uniandes.csw.factura.logic.ejb;

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
import co.edu.uniandes.csw.factura.logic.api.IFacturaLogicService;
import co.edu.uniandes.csw.factura.persistence.FacturaPersistence;
import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;
import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;

@RunWith(Arquillian.class)
public class FacturaLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(FacturaLogicService.class.getPackage())
				.addPackage(FacturaPersistence.class.getPackage())
				.addPackage(FacturaEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IFacturaLogicService facturaLogicService;
	
	@Inject
	private IFacturaPersistence facturaPersistence;	

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
		List<FacturaDTO> dtos=facturaPersistence.getFacturas();
		for(FacturaDTO dto:dtos){
			facturaPersistence.deleteFactura(dto.getId());
		}
	}

	private List<FacturaDTO> data=new ArrayList<FacturaDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			FacturaDTO pdto=new FacturaDTO();
			pdto.setName(generateRandom(String.class));
			pdto=facturaPersistence.createFactura(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createFacturaTest(){
		FacturaDTO ldto=new FacturaDTO();
		ldto.setName(generateRandom(String.class));
		
		
		FacturaDTO result=facturaLogicService.createFactura(ldto);
		
		Assert.assertNotNull(result);
		
		FacturaDTO pdto=facturaPersistence.getFactura(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
	}
	
	@Test
	public void getFacturasTest(){
		List<FacturaDTO> list=facturaLogicService.getFacturas();
		Assert.assertEquals(list.size(), data.size());
        for(FacturaDTO ldto:list){
        	boolean found=false;
            for(FacturaDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getFacturaTest(){
		FacturaDTO pdto=data.get(0);
		FacturaDTO ldto=facturaLogicService.getFactura(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
        
	}
	
	@Test
	public void deleteFacturaTest(){
		FacturaDTO pdto=data.get(0);
		facturaLogicService.deleteFactura(pdto.getId());
        FacturaDTO deleted=facturaPersistence.getFactura(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateFacturaTest(){
		FacturaDTO pdto=data.get(0);
		
		FacturaDTO ldto=new FacturaDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		
		
		facturaLogicService.updateFactura(ldto);
		
		
		FacturaDTO resp=facturaPersistence.getFactura(pdto.getId());
		
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