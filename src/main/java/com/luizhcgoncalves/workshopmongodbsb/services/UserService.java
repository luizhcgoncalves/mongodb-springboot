package com.luizhcgoncalves.workshopmongodbsb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizhcgoncalves.workshopmongodbsb.domain.User;
import com.luizhcgoncalves.workshopmongodbsb.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll(); 
	}

}
