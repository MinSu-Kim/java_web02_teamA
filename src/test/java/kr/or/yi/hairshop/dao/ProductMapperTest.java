package kr.or.yi.hairshop.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.hairshop.AbstractTest;
import kr.or.yi.hairshop.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductMapperTest extends AbstractTest {
	private static ProductMapper dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ProductMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01selectProductByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Product> list = dao.selectProductByAll();
		System.out.println(list);
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}

}
