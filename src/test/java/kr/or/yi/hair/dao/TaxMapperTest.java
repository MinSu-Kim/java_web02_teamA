package kr.or.yi.hair.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.hair.AbstractTest;
import kr.or.yi.hairshop.dao.TaxMapper;
import kr.or.yi.hairshop.dao.TaxMapperImpl;
import kr.or.yi.hairshop.dto.Tax;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaxMapperTest extends AbstractTest {
	private static TaxMapper taxDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		taxDao=new TaxMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		taxDao=null;
	}
	
	@Test
	public void test01SelectTaxByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Tax> list = taxDao.selectTaxByAll();
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}
}
