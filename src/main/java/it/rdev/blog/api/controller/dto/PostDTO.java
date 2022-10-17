package it.rdev.blog.api.controller.dto;

import java.time.LocalDate;
import java.util.List;

import it.rdev.blog.api.dao.entity.Comment;
import it.rdev.blog.api.dao.entity.Tag;
import it.rdev.blog.api.dao.entity.User;

public class PostDTO {

	private Integer id;
	private String title;
	private String subTitle;
	private String text;
	private User user;
	private LocalDate insertionDate;
	private List<Tag> tags;
	private List<Comment> comments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer l) {
		this.id = l;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user2) {
		this.user = user2;
	}
	public LocalDate getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(LocalDate insertionDate) {
		this.insertionDate = insertionDate;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> list) {
		this.tags = list;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> list) {
		this.comments = list;
	}
}
