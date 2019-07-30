package kr.or.yi.hairshop.dao;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.hairshop.AbstractTest;
import kr.or.yi.hairshop.dto.Guest;

public class GuestMapperTest extends AbstractTest{
private static GuestMapper guestDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		guestDao=new GuestMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		guestDao=null;
	}
	
	@Test
	public void test01SelectGuestByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Guest> list = guestDao.selectGuestByAll();
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}

}
