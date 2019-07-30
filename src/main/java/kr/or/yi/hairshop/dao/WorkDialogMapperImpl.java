package kr.or.yi.hairshop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class WorkDialogMapperImpl implements WorkDialogMapper{
	private String namespace="kr.or.yi.hairshop.dao.WorkDialogMapper";

	@Override
	public List<WorkDialog> selectDListByNo(int dNo) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectDListByNo",dNo);
		}
	}

	@Override
	public List<WorkDialog> selectByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectByAll");
		}
	}

	@Override
	public List<WorkDialog> selectByfivejoinMap() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectByfivejoinMap");
		}
	}
	@Override
	public List<WorkDialog> selectWDGECPjoinByWNo(int wNo) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectWDGECPjoinByWNo",wNo);
		}
	}

	@Override
	public List<WorkDialog> selectWDGECPjoinByWDNoDate(Map<String, String> map) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectWDGECPjoinByWDNoDate",map);
		}
	}

	@Override
	public List<WorkDialog> selectWDGECPjoinByNo(int no) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectWDGECPjoinByNo", no);
		}
	}

	@Override
	public List<WorkDialog> selectReservDetail() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectReservDetail");
		}
	}

	@Override
	public List<WorkDialog> selectReservDetailByDate(Map<String, String> map) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectReservDetailByDate", map);
		}
	}

	@Override
	public int insertWorkDialogResWNo(WorkDialog workDialog) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			sqlSession.insert(namespace + ".insertWorkDialogResWNo", workDialog);
			sqlSession.commit();
			return workDialog.getwNo();
		}
	}

	@Override
	public int insertChoice(Map<String, String> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertChoice", map);
			sqlSession.commit();
			return res;
		}
	}

}