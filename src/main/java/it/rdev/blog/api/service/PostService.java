package it.rdev.blog.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.rdev.blog.api.controller.dto.PostDTO;
import it.rdev.blog.api.dao.PostDao;
import it.rdev.blog.api.dao.UserDao;
import it.rdev.blog.api.dao.entity.Post;
import it.rdev.blog.api.dao.entity.User;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;
	
	//getter della lista di Post di un solo utente
	public List<PostDTO> loadByUsername(String username) throws UsernameNotFoundException
	{
		List<PostDTO>pDTOs = new ArrayList<PostDTO>();
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Utente non trovato per username: " + username);
		}
		List<Post> posts= postDao.findByUserOrderByInsertionDateDesc(user);
		for(Post p:posts)
		{
			PostDTO pDTO= new PostDTO();
			pDTO.setId(p.getId());
			pDTO.setTitle(p.getTitle());
			pDTO.setSubTitle(p.getSubTitle());
			pDTO.setText(p.getText());
			pDTO.setInsertionDate(p.getInsertionDate());
			pDTO.setUser(user);
			pDTO.setComments(p.getComments());
			pDTO.setTags(p.getTags());
			pDTOs.add(pDTO);
		}
		return pDTOs;
	}
	
	//getter di tutti
	public List<PostDTO> getAll()
	{
		List<PostDTO>pDTOs = new ArrayList<PostDTO>();
		List<Post> posts= (List<Post>) postDao.findAll();
		for(Post p:posts)
		{
			PostDTO pDTO= new PostDTO();
			pDTO.setId(p.getId());
			pDTO.setTitle(p.getTitle());
			pDTO.setSubTitle(p.getSubTitle());
			pDTO.setText(p.getText());
			pDTO.setInsertionDate(p.getInsertionDate());
			pDTO.setUser(p.getUser());
			pDTO.setComments(p.getComments());
			pDTO.setTags(p.getTags());
			pDTOs.add(pDTO);
		}
		return pDTOs;
	}
	
	//getter parte titolo
	public List<PostDTO> getByTitlePart(String part)
	{
		List<PostDTO>pDTOs = new ArrayList<PostDTO>();
		List<Post> posts= (List<Post>) postDao.findByTitleContainsOrderByInsertionDateDesc(part);
		for(Post p:posts)
		{
			PostDTO pDTO= new PostDTO();
			pDTO.setId(p.getId());
			pDTO.setTitle(p.getTitle());
			pDTO.setSubTitle(p.getSubTitle());
			pDTO.setText(p.getText());
			pDTO.setInsertionDate(p.getInsertionDate());
			pDTO.setUser(p.getUser());
			pDTO.setComments(p.getComments());
			pDTO.setTags(p.getTags());
			pDTOs.add(pDTO);
		}
		return pDTOs;
	}
	
	//getter parte sottotitolo
	public List<PostDTO> getBySubTitlePart(String part)
	{
		List<PostDTO>pDTOs = new ArrayList<PostDTO>();
		List<Post> posts= (List<Post>) postDao.findBySubTitleContainsOrderByInsertionDateDesc(part);
		for(Post p:posts)
		{
			PostDTO pDTO= new PostDTO();
			pDTO.setId(p.getId());
			pDTO.setTitle(p.getTitle());
			pDTO.setSubTitle(p.getSubTitle());
			pDTO.setText(p.getText());
			pDTO.setInsertionDate(p.getInsertionDate());
			pDTO.setUser(p.getUser());
			pDTO.setComments(p.getComments());
			pDTO.setTags(p.getTags());
			pDTOs.add(pDTO);
		}
		return pDTOs;
	}
	
	//getter parte testo
	public List<PostDTO> getByTextPart(String part)
	{
		List<PostDTO>pDTOs = new ArrayList<PostDTO>();
		List<Post> posts= (List<Post>) postDao.findByTextContainsOrderByInsertionDateDesc(part);
		for(Post p:posts)
		{
			PostDTO pDTO= new PostDTO();
			pDTO.setId(p.getId());
			pDTO.setTitle(p.getTitle());
			pDTO.setSubTitle(p.getSubTitle());
			pDTO.setText(p.getText());
			pDTO.setInsertionDate(p.getInsertionDate());
			pDTO.setUser(p.getUser());
			pDTO.setComments(p.getComments());
			pDTO.setTags(p.getTags());
			pDTOs.add(pDTO);
		}
		return pDTOs;
	}
	
	//getter data
	public List<PostDTO> getByInsertionDate(LocalDate date)
	{
		List<PostDTO>pDTOs = new ArrayList<PostDTO>();
		List<Post> posts= (List<Post>) postDao.findByInsertionDateOrderByInsertionDateDesc(date);
		for(Post p:posts)
		{
			PostDTO pDTO= new PostDTO();
			pDTO.setId(p.getId());
			pDTO.setTitle(p.getTitle());
			pDTO.setSubTitle(p.getSubTitle());
			pDTO.setText(p.getText());
			pDTO.setInsertionDate(p.getInsertionDate());
			pDTO.setUser(p.getUser());
			pDTO.setComments(p.getComments());
			pDTO.setTags(p.getTags());
			pDTOs.add(pDTO);
		}
		return pDTOs;
	}
	
	//post Post
	public Post save(PostDTO dto, String username)
	{
		User user = userDao.findByUsername(username);
		Post toSave = new Post();
		toSave.setTitle(dto.getTitle());
		toSave.setSubTitle(dto.getSubTitle());
		toSave.setText(dto.getText());
		toSave.setUser(user);
		toSave.setInsertionDate(LocalDate.now());
		toSave.setTags(dto.getTags()!=null? dto.getTags():null);
		toSave.setComments(dto.getComments()!=null?dto.getComments():null);
		
		try {
			return postDao.save(toSave);
		}catch(Exception e) {
		      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Non è possibile salvare il post");
		}
	}
	
	public void delete(Integer postId)
	{
		Optional<Post> opt = postDao.findById(postId);
		if(opt.isPresent())
		{
			postDao.deleteById(postId);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post non esistente");
		}
	}
}
