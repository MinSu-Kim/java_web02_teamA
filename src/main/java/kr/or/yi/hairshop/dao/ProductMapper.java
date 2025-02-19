package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Product;

public interface ProductMapper {

	public List<Product> selectProductByAll();
	public int insert(Product pro);
	public int updateByName(Product pro);
	public int deleteByName(String name);
	public List<Product> selectDateYearPriceChart(int year);
	public List<Product> searchByName(String name);
	
	
	/* 뭥????? */
	public Product selectByName(String name);
	public List<Product> selectByProductName();
	
	
}
