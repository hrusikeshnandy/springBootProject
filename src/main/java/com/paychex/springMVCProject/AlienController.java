package com.paychex.springMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paychex.springMVCProject.model.Alien;

@Controller

public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@GetMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		List<Alien> alienList = repo.findAll();
		
		return alienList;
	}
	
	@GetMapping("alien/{aid}")
	@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) {
		
		Alien a = repo.findById(aid).orElse(new Alien(0, ""));
		return a;
	}
	
	
}
