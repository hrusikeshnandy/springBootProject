package com.paychex.springMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paychex.springMVCProject.model.Alien;

@Controller
@ResponseBody
public class AlienController {

	@Autowired
	AlienRepo repo;
	@GetMapping("/alien")
	public List<Alien> getAliens() {
		List<Alien> alienList = repo.findAll();
		
		return alienList;
	}
}
