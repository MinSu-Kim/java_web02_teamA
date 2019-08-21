package kr.or.yi.hairshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.hairshop.dto.Post;
import kr.or.yi.hairshop.jdbc.MyBatisSqlSessionFactory;

public class PostMapperImpl implements PostMapper{
	private String namespace="kr.or.yi.hairshop.dao.PostMapper";

	@Override
	public List<Post> selectPostBypDoro(Post post) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectPostBypDoro", post);
		}
	}

	
}