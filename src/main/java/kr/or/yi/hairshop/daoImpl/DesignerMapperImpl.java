package kr.or.yi.hairshop.daoImpl;

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

}
