package kr.or.yi.hairshop.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.hairshop.AbstractTest;
import kr.or.yi.hairshop.daoImpl.TaxMapperImpl;
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
	@Test
	public void test02InsertTax() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Tax tax = new Tax();
		tax.settNo(10);
		tax.settName("구구까까");
		int res = taxDao.insertTax(tax);
		log.debug(tax.toString());
		Assert.assertEquals(1, res);
		
		
	}
}
