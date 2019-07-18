package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Tax;

public interface TaxMapper {
	List<Tax> selectByAll();
}
