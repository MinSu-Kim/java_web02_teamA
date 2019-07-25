package kr.or.yi.hairshop.dao;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.hairshop.AbstractTest;
import kr.or.yi.hairshop.dto.Designer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesignerMapperTest extends AbstractTest {
	private static DesignerMapper dsDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dsDao = new DesignerMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dsDao = null;
	}

	@Test
	public void test01selectDesignerByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Designer> list = dsDao.selectDesignerByAll();
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}

	
	@Test
	public void Test02selectDesignerByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Designer> designer = dsDao.selectDesignerByNo(1);
		log.debug(designer.toString());
		Assert.assertNotNull(designer);
	}
	/*
	 * @Test public void test02insertDesigner() {
	 * log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	 * 
	 * Designer ds = new Designer(); ds.setdGrade("테스트"); ds.setdName("테스트");
	 * ds.setdTel("테스트"); ds.setdTel2("테스트"); ds.setdAddr("테스트");
	 * ds.setdAddr2("테스트"); ds.setdAddr3("테스트"); ds.setdBirth(new Date());
	 * ds.setdJoin(new Date()); ds.setdMemo("테스트");
	 * 
	 * int res = dsDao.insertDesigner(ds);
	 * 
	 * Assert.assertEquals(1, res);
	 * 
	 * }
	 */
	
	/*
	 * @Test public void test03deleteDesigner() {
	 * log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	 * int res = dsDao.deleteDesigner(6); Assert.assertEquals(1, res);
	 * 
	 * }
	 */

	  @Test public void test04updateDesigner() {
	  log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	  
	  Designer ds = new Designer(); 
	  ds.setdNo(4); 
	  ds.setdGrade("테스트");
	  ds.setdName("테스트"); 
	  ds.setdTel("테스트"); 
	  ds.setdTel2("테스트");
	  ds.setdAddr("테스트"); 
	  ds.setdAddr2("테스트"); 
	  ds.setdAddr3("테스트");
	  ds.setdBirth(new Date()); 
	  ds.setdJoin(new Date()); 
	  ds.setdMemo("테스트");
	  
	  int res = dsDao.updateDesigner(ds); 
	  Assert.assertEquals(1, res);
	  
	  test01selectDesignerByAll(); 
	  }


}
