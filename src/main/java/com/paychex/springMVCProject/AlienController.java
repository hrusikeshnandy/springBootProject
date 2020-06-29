package com.paychex.springMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paychex.springMVCProject.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="/aliens", produces = {"application/xml"})
	public List<Alien> getAliens() {
		List<Alien> alienList = repo.findAll();
		
		return alienList;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable("aid") int aid) {
		
		Alien a = repo.findById(aid).orElse(new Alien(0, ""));
		return a;
	}
	@PostMapping(path="alien", consumes = {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	
}
