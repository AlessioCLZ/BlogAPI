package it.rdev.blog.api.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Post;
import it.rdev.blog.api.dao.entity.User;

public interface PostDao extends CrudRepository<Post, Integer> {

	public List<Post> findByUserOrderByInsertionDateDesc(User user);
	
	public List<Post> findByTitleContainsOrderByInsertionDateDesc(String string);
	
	public List<Post> findBySubTitleContainsOrderByInsertionDateDesc(String string);
	
	public List<Post> findByTextContainsOrderByInsertionDateDesc(String string);
	
	public List<Post> findByInsertionDateOrderByInsertionDateDesc(LocalDate date);
	
	
	
}
