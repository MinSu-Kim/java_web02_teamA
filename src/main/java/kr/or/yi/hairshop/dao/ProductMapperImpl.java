package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class ProductMapperImpl implements ProductMapper {
	private static final String namespace = "kr.or.yi.hairshop.dao.ProductMapper";

	@Override
	public List<Product> selectProductByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectProductByAll");
		}

	}

	@Override
	public Product selectByName(String name) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectByName", name);
		}
	}

	@Override
	public int insert(Product pro) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int result = sqlSession.update(namespace + ".insert", pro);
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public int updateByName(Product pro) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int result = sqlSession.update(namespace + ".updateByName", pro);
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

	@Override
	public List<Product> selectDateYearPriceChart() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectDateYearPriceChart");
		}

	}
	
	@Override
	public List<Product> selectByProductName() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectByProductName");
		}
	}


}
