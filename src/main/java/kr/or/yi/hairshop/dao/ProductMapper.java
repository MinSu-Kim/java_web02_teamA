package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Product;

public interface ProductMapper {

	public List<Product> selectProductByAll();
	
}
