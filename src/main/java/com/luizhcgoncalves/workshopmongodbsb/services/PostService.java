package com.luizhcgoncalves.workshopmongodbsb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizhcgoncalves.workshopmongodbsb.domain.Post;
import com.luizhcgoncalves.workshopmongodbsb.repositories.PostRepository;
import com.luizhcgoncalves.workshopmongodbsb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
