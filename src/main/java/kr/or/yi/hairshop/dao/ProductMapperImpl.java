package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class ProductMapperImpl implements ProductMapper {
	private String namespace="kr.or.yi.hairshop.dao.ProductMapper";
	
	@Override
	public List<Product> selectProductByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectProductByAll");
		}

	}

}
