
package co.edu.uniandes.csw.inventario.persistence;

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
import co.edu.uniandes.csw.inventario.persistence.api.IInventarioPersistence;
import co.edu.uniandes.csw.inventario.persistence.entity.InventarioEntity;

@RunWith(Arquillian.class)
public class InventarioPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(InventarioPersistence.class.getPackage())
				.addPackage(InventarioEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IInventarioPersistence inventarioPersistence;

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
		em.createQuery("delete from InventarioEntity").executeUpdate();
	}

	private List<InventarioEntity> data=new ArrayList<InventarioEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			InventarioEntity entity=new InventarioEntity();
			entity.setName(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createInventarioTest(){
		InventarioDTO dto=new InventarioDTO();
		dto.setName(generateRandom(String.class));
		
		
		InventarioDTO result=inventarioPersistence.createInventario(dto);
		
		Assert.assertNotNull(result);
		
		InventarioEntity entity=em.find(InventarioEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());	
	}
	
	@Test
	public void getInventariosTest(){
		List<InventarioDTO> list=inventarioPersistence.getInventarios();
		Assert.assertEquals(list.size(), data.size());
        for(InventarioDTO dto:list){
        	boolean found=false;
            for(InventarioEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getInventarioTest(){
		InventarioEntity entity=data.get(0);
		InventarioDTO dto=inventarioPersistence.getInventario(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
        
	}
	
	@Test
	public void deleteInventarioTest(){
		InventarioEntity entity=data.get(0);
		inventarioPersistence.deleteInventario(entity.getId());
        InventarioEntity deleted=em.find(InventarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateInventarioTest(){
		InventarioEntity entity=data.get(0);
		
		InventarioDTO dto=new InventarioDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		
		
		inventarioPersistence.updateInventario(dto);
		
		
		InventarioEntity resp=em.find(InventarioEntity.class, entity.getId());
		
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