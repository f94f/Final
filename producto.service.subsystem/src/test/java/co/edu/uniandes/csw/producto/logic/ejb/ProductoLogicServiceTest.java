
package co.edu.uniandes.csw.producto.logic.ejb;

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


import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.logic.api.IProductoLogicService;
import co.edu.uniandes.csw.producto.persistence.ProductoPersistence;
import co.edu.uniandes.csw.producto.persistence.api.IProductoPersistence;
import co.edu.uniandes.csw.producto.persistence.entity.ProductoEntity;

@RunWith(Arquillian.class)
public class ProductoLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(ProductoLogicService.class.getPackage())
				.addPackage(ProductoPersistence.class.getPackage())
				.addPackage(ProductoEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IProductoLogicService productoLogicService;
	
	@Inject
	private IProductoPersistence productoPersistence;	

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
		List<ProductoDTO> dtos=productoPersistence.getProductos();
		for(ProductoDTO dto:dtos){
			productoPersistence.deleteProducto(dto.getId());
		}
	}

	private List<ProductoDTO> data=new ArrayList<ProductoDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			ProductoDTO pdto=new ProductoDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setTipo(generateRandom(String.class));
			pdto.setEsPerecedero(generateRandom(Boolean.class));
			pdto.setPrecioPromedio(generateRandom(Double.class));
			pdto.setTiempoPromedio(generateRandom(Double.class));
			pdto.setCantidadPromedio(generateRandom(Double.class));
			pdto.setMinimoNivelInventario(generateRandom(Double.class));
			pdto=productoPersistence.createProducto(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createProductoTest(){
		ProductoDTO ldto=new ProductoDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setTipo(generateRandom(String.class));
		ldto.setEsPerecedero(generateRandom(Boolean.class));
		ldto.setPrecioPromedio(generateRandom(Double.class));
		ldto.setTiempoPromedio(generateRandom(Double.class));
		ldto.setCantidadPromedio(generateRandom(Double.class));
		ldto.setMinimoNivelInventario(generateRandom(Double.class));
		
		
		ProductoDTO result=productoLogicService.createProducto(ldto);
		
		Assert.assertNotNull(result);
		
		ProductoDTO pdto=productoPersistence.getProducto(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getTipo(), pdto.getTipo());	
		Assert.assertEquals(ldto.getEsPerecedero(), pdto.getEsPerecedero());	
		Assert.assertEquals(ldto.getPrecioPromedio(), pdto.getPrecioPromedio());	
		Assert.assertEquals(ldto.getTiempoPromedio(), pdto.getTiempoPromedio());	
		Assert.assertEquals(ldto.getCantidadPromedio(), pdto.getCantidadPromedio());	
		Assert.assertEquals(ldto.getMinimoNivelInventario(), pdto.getMinimoNivelInventario());	
	}
	
	@Test
	public void getProductosTest(){
		List<ProductoDTO> list=productoLogicService.getProductos();
		Assert.assertEquals(list.size(), data.size());
        for(ProductoDTO ldto:list){
        	boolean found=false;
            for(ProductoDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getProductoTest(){
		ProductoDTO pdto=data.get(0);
		ProductoDTO ldto=productoLogicService.getProducto(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getTipo(), ldto.getTipo());
		Assert.assertEquals(pdto.getEsPerecedero(), ldto.getEsPerecedero());
		Assert.assertEquals(pdto.getPrecioPromedio(), ldto.getPrecioPromedio());
		Assert.assertEquals(pdto.getTiempoPromedio(), ldto.getTiempoPromedio());
		Assert.assertEquals(pdto.getCantidadPromedio(), ldto.getCantidadPromedio());
		Assert.assertEquals(pdto.getMinimoNivelInventario(), ldto.getMinimoNivelInventario());
        
	}
	
	@Test
	public void deleteProductoTest(){
		ProductoDTO pdto=data.get(0);
		productoLogicService.deleteProducto(pdto.getId());
        ProductoDTO deleted=productoPersistence.getProducto(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateProductoTest(){
		ProductoDTO pdto=data.get(0);
		
		ProductoDTO ldto=new ProductoDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setTipo(generateRandom(String.class));
		ldto.setEsPerecedero(generateRandom(Boolean.class));
		ldto.setPrecioPromedio(generateRandom(Double.class));
		ldto.setTiempoPromedio(generateRandom(Double.class));
		ldto.setCantidadPromedio(generateRandom(Double.class));
		ldto.setMinimoNivelInventario(generateRandom(Double.class));
		
		
		productoLogicService.updateProducto(ldto);
		
		
		ProductoDTO resp=productoPersistence.getProducto(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getTipo(), resp.getTipo());	
		Assert.assertEquals(ldto.getEsPerecedero(), resp.getEsPerecedero());	
		Assert.assertEquals(ldto.getPrecioPromedio(), resp.getPrecioPromedio());	
		Assert.assertEquals(ldto.getTiempoPromedio(), resp.getTiempoPromedio());	
		Assert.assertEquals(ldto.getCantidadPromedio(), resp.getCantidadPromedio());	
		Assert.assertEquals(ldto.getMinimoNivelInventario(), resp.getMinimoNivelInventario());	
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