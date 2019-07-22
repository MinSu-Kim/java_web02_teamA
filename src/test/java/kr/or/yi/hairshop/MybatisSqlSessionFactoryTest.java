package kr.or.yi.hairshop;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;



public class MybatisSqlSessionFactoryTest extends AbstractTest{
	private static final Log log = LogFactory.getLog(MybatisSqlSessionFactoryTest.class);
	
	@Test
	public void testOpenSession() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		log.debug("session " + session);
		Assert.assertNotNull(session);
	}
}
