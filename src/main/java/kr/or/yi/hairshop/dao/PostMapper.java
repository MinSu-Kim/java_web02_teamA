package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Post;

public interface PostMapper {
	public List<Post> selectPostBypDoro(Post post);
	
}