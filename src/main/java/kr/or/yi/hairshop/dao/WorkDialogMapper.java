package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.WorkDialog;

public interface WorkDialogMapper {
	List<WorkDialog> selectDListByNo(int dNo);
}