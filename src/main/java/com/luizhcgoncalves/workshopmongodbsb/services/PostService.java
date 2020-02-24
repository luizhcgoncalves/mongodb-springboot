package com.luizhcgoncalves.workshopmongodbsb.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String txt){
		return repo.findByTitle(txt);
	}
	
	public List<Post> fullSearch(String txt, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(txt, minDate, maxDate);
	}
}
