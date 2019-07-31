package kr.or.yi.hairshop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Level;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class LevelMapperImpl implements LevelMapper {
	private String namespace = "kr.or.yi.hairshop.dao.LevelMapper";
	
	@Override
	public List<Level> selectLevelByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectLevelByAll");
		}
	}

	@Override
	public int insertLevel(Level level) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertLevel", level);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateLevel(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateLevel", map);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public void deleteLevel(String name) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteLevel", name);
			sqlSession.commit();
			return;
		}
	}
	
}
