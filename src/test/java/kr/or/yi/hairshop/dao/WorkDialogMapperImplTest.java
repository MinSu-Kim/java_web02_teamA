package kr.or.yi.hairshop.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.hairshop.AbstractTest;
import kr.or.yi.hairshop.dto.WorkDialog;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkDialogMapperImplTest extends AbstractTest {
	private static WorkDialogMapper dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new WorkDialogMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectDListByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int no = 1;
		List<WorkDialog> list = dao.selectDListByNo(no);
		System.out.println(list);
		Assert.assertNotNull(list);
	}
	@Test
	public void test02selectWDGECPjoinByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int no = 1;
		List<WorkDialog> list = dao.selectWDGECPjoinByWNo(no);
		System.out.println(list);
		Assert.assertNotNull(list);
	}

	@Test
	public void test03selestDetail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<WorkDialog> work = dao.selectReservDetail();
		Assert.assertNotNull(work);
	}
	
	/*
	 * @Test public void test04selectByfivejoinMap() {
	 * log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	 * List<WorkDialog> work = dao.selectByfivejoinMap();
	 * Assert.assertNotNull(work); }
	 */

}
