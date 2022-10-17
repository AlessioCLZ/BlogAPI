package it.rdev.blog.api.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.rdev.blog.api.controller.dto.PostDTO;
import it.rdev.blog.api.dao.entity.Post;
import it.rdev.blog.api.service.PostService;

@RestController
@CrossOrigin
public class PostController {
	
	@Autowired
	private PostService pService;
	
	@GetMapping("posts")
	public List<PostDTO> getAll()
	{
		return pService.getAll();
	}
	
	@GetMapping("posts/{username}")
	public List<PostDTO> getByUsername(@PathVariable (name="username") String username)
	{
		return pService.loadByUsername(username);
	}
	
	@GetMapping("posts/title/{part}")
	public List<PostDTO> getByTitlePart(@PathVariable (name="part") String part)
	{
		return pService.getByTitlePart(part);
	}
	
	@GetMapping("posts/subtitle/{part}")
	public List<PostDTO> getBySubTitlePart(@PathVariable (name="part") String part)
	{
		return pService.getBySubTitlePart(part);
	}
	
	@GetMapping("posts/text/{part}")
	public List<PostDTO> getByTextPart(@PathVariable (name="part") String part)
	{
		return pService.getByTextPart(part);
	}
	
	@GetMapping("posts/date/{date}")
	public List<PostDTO> getByDate(@PathVariable (name="date") LocalDate date)
	{
		return pService.getByInsertionDate(date);
	}
	
	@PostMapping("posts/{username}")
	public Post add (@RequestBody PostDTO post, @PathVariable (name="username") String username)
	{
		return pService.save(post, username);
	}
	
	@DeleteMapping("posts/{id}")
	public void delete(@PathVariable (name="id") Integer id)
	{
		pService.delete(id);
	}
}
