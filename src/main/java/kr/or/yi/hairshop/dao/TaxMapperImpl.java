package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dao.TaxMapper;
import kr.or.yi.hairshop.dto.Tax;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class TaxMapperImpl implements TaxMapper {
	private String namespace="kr.or.yi.hairshop.dao.TaxMapper";
	
	@Override
	public List<Tax> selectTaxByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectTaxByAll");
		}
	}

	@Override
	public int insertTax(Tax tax) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			int res=sqlSession.insert(namespace+".insertTax",tax);
			sqlSession.commit();
			return res;
		}
	}

}