package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Choice;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class ChoiceMapperImpl implements ChoiceMapper {
	private String namespace="kr.or.yi.hairshop.dao.ChoiceMapper";
	
	@Override
	public List<Choice> selectByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectByAll");
		}
	}
}
