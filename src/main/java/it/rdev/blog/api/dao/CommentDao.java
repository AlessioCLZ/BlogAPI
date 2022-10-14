package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Comment;

public interface CommentDao extends CrudRepository<Comment, Integer> {

}
