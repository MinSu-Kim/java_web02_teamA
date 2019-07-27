package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class GuestMapperImpl implements GuestMapper {
	private String namespace = "kr.or.yi.hairshop.dao.GuestMapper";

	@Override
	public List<Guest> selectGuestByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectGuestByAll");
		}
	}

	@Override
	public int insertGuest(Guest guest) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertGuest", guest);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateGuest(Guest guest) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateGuest", guest);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteGuest(Guest guest) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteGuest", guest);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public void deleteGuest(int getgNo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteGuest", getgNo);
			sqlSession.commit();
			return;
		}
	}
}
