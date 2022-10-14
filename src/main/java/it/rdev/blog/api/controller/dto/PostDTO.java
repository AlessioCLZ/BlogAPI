package it.rdev.blog.api.controller.dto;

import java.time.LocalDate;
import java.util.List;

public class PostDTO {

	private Integer id;
	private String title;
	private String subTitle;
	private String text;
	private UserDTO user;
	private LocalDate insertionDate;
	private List<TagDTO> tags;
	private List<CommentDTO> comments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public LocalDate getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(LocalDate insertionDate) {
		this.insertionDate = insertionDate;
	}
	public List<TagDTO> getTags() {
		return tags;
	}
	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}
	public List<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
}
