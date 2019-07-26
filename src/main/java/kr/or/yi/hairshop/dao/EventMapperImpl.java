package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Event;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class EventMapperImpl implements EventMapper {
	private static final String namespace = "kr.or.yi.hairshop.dao.EventMapper";

	@Override
	public List<Event> selectEventByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectEventByAll");
		}
	}

	@Override
	public Event selectByName(String name) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectByName", name);
		}
	}

	@Override
	public int updateByName(Event event) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int result = sqlSession.update(namespace + ".updateByName", event);
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public int insert(Event event) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int result = sqlSession.update(namespace + ".insert", event);
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public int deleteByName(String name) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int result = sqlSession.delete(namespace + ".deleteByName", name);
			sqlSession.commit();
			return result;
		}
	}

}
