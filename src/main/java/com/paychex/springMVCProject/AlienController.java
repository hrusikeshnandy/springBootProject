package com.paychex.springMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paychex.springMVCProject.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@GetMapping("/aliens")
	public List<Alien> getAliens() {
		List<Alien> alienList = repo.findAll();
		
		return alienList;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable("aid") int aid) {
		
		Alien a = repo.findById(aid).orElse(new Alien(0, ""));
		return a;
	}
	
	
}
