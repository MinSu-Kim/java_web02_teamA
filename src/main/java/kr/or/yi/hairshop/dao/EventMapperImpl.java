package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Event;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class EventMapperImpl implements EventMapper {
	private String namespace="kr.or.yi.hairshop.dao.EventMapper";

	@Override
	public List<Event> selectEventByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectEventByAll");
		}
	}

}
