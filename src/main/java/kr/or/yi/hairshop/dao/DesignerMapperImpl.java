package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class DesignerMapperImpl implements DesignerMapper{
	private String namespace="kr.or.yi.hairshop.dao.DesignerMapper";

	@Override
	public List<Designer> selectDesignerByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectDesignerByAll");
		}
	}
	
	@Override
	public int insertDesigner(Designer ds) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+".insertDesigner", ds);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteDesigner(int dNo) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+".deleteDesigner", dNo);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateDesigner(Designer ds) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+".updateDesigner", ds);
			sqlSession.commit();
			return res;
		}
	}

}