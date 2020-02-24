package com.luizhcgoncalves.workshopmongodbsb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luizhcgoncalves.workshopmongodbsb.domain.Post;
import com.luizhcgoncalves.workshopmongodbsb.resources.util.URL;
import com.luizhcgoncalves.workshopmongodbsb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String txt) {
		txt = URL.decodeParam(txt);
		List<Post> list = service.findByTitle(txt);
		return ResponseEntity.ok().body(list);
	}
}
