package com.luizhcgoncalves.workshopmongodbsb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luizhcgoncalves.workshopmongodbsb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {

	List<Post> findByTitleContainingIgnoreCase(String txt);
}
