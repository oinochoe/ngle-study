package com.ym.blog.repository;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ym.blog.UserSession;
import com.ym.blog.entity.Post;
import com.ym.blog.infrastructure.dao.PostDao;
import com.ym.blog.utility.IllegalUserException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PostRepository {

	@Autowired
	private PostDao postDao;

/*	public Page<Post> getPostList(Pageable pageable) {
		Page<Post> postPage = postDao.findAll(pageable);
		log.debug("postPage = {}", postPage);

		return postPage;
	}*/

	public Page<Post> getPostList(Pageable pageable, int categoryId) {
		Page<Post> postPage;

		if (categoryId > 0) {
			postPage = postDao.findByCategoryId(categoryId, pageable);
		} else {
			postPage = postDao.findAll(pageable);
		}

		return postPage;
	}

	public Post getPostById(int id) throws IllegalArgumentException {
		Post post = postDao.getOne(id);

		if (post == null) {
			throw new IllegalArgumentException("포스트를 찾을 수 없습니다.");
		}

		return post;
	}
	
	
	public Post writePost(Post post, UserSession user) {

		post.setRegDate(LocalDateTime.now());
		post.setUserId(user.getProviderUserId());
		post.setName(user.getDisplayName());

		return postDao.save(post);
	}
	
	
	public void deletePost(int id, UserSession user) throws IllegalUserException, IllegalArgumentException {
		if (isThisUserPostWriter(user, id)) {
			postDao.delete(id);
		} else {
			throw new IllegalUserException("작성자가 아닙니다.");
		}
	}
	
	@Transactional
	public Post editPost(Post post, UserSession user) throws RuntimeException {
		Post oldPost = findByIdAndUser(post.getId(), user);

		oldPost.setTitle(post.getTitle());
		oldPost.setSubtitle(post.getSubtitle());
		oldPost.setContent(post.getContent());
		oldPost.setCategoryId(post.getCategoryId());

		return oldPost;
	}	
	

	public Post findByIdAndUser(int id, UserSession user) throws RuntimeException {
		if (isThisUserPostWriter(user, id))
			return getPostById(id);
		else
			throw new IllegalUserException("작성자가 아닙니다.");
	}

	public boolean isThisUserPostWriter(UserSession user, int id) throws IllegalArgumentException {
		Post post = getPostById(id);

		return post.getUserId().equals(user.getProviderUserId());
	}

}
