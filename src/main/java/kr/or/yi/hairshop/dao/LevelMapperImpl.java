package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Level;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class LevelMapperImpl implements LevelMapper {
	private String namespace = "kr.or.yi.hairshop.dao.LevelMapper";
	
	@Override
	public List<Level> selectLevelByAll(Level level) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectLevelByAll",level);
		}
	}
	
}
