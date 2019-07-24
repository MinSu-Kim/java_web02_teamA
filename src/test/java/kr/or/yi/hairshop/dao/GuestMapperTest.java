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
	@Test
	public void test02InsertGuest() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Guest guest = new Guest();
		guest.setgNo(5);
		guest.setgName("구구까까");
		guest.setgTel("010-0000-0000");
		guest.setgEmail("zlzlzl@zlzl.com");
		guest.setgBirth(new Date());
		guest.setgJoin(new Date());
		guest.setgMemo("zzzlzlzlzlz");
		int res = guestDao.insertGuest(guest);
		log.debug(guest.toString());
		Assert.assertEquals(1, res);
	}
	@Test
	public void test03UpdateGuest() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Guest guest = new Guest();
		guest.setgNo(5);
		guest.setgName("구구까까1");
		guest.setgTel("010-1111-1111");
		guest.setgEmail("dkdkdk@zlzl.com");
		guest.setgBirth(new Date());
		guest.setgJoin(new Date());
		guest.setgMemo("hhhhhh");
		
		int res = guestDao.updateGuest(guest);
		Assert.assertEquals(1, res);
	}

}
