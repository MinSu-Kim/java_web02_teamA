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
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.Tax;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GuestMapperTest extends AbstractTest {
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
	public void test01SelectTaxByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Guest> list = guestDao.selectGuestByAll();
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}
	@Test
	public void test02InsertGuest() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Guest guest = new Guest();
		guest.setG_no(6);
		guest.setG_Name("구구까까");
		guest.setG_tel("010-0000-0000");
		guest.setG_email("zlzlzl@zlzl.com");
		guest.setG_birth(new Date());
		guest.setG_join(new Date());
		guest.setG_memo("zzzlzlzlzlz");
		int res = guestDao.insertGuest(guest);
		log.debug(guest.toString());
		Assert.assertEquals(1, res);
	}
}
