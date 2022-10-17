package it.rdev.blog.api.dao.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String title;
	
	@Column
	private String subTitle;
	
	@Column(nullable=false)
	private String text;
	
	@ManyToOne
	@JsonManagedReference
	private User user;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate insertionDate;
	
	@OneToMany(mappedBy= "post", cascade= CascadeType.ALL)
	@JsonBackReference
	private List<Tag> tags;
	
	@OneToMany(mappedBy="post", cascade= CascadeType.ALL)
	@JsonBackReference
	private List<Comment> comments;

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

	public void setUser(User user) {
		this.user = user;
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

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
