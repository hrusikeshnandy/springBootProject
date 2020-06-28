package com.paychex.springMVCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paychex.springMVCProject.model.Alien;

@Controller
public class HomeController {
	@Autowired
	AlienRepo repo;
	@ModelAttribute
	public void addModelData(Model m) {
		m.addAttribute("name", "alien");
	}
	@RequestMapping("/")
	public String home() {
		System.out.println("calling the home controller");
		return "index";
	}
	@RequestMapping("add")
	public String add(@RequestParam("num1") int num1,@RequestParam("num2") int num2,Model m) {
		
		int sum = num1 + num2;
		
		m.addAttribute("sum", sum);
		return "result";
	}
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute Alien a) {
		return "result";
	}
	
	@GetMapping("/getAliens")
	public String getAlienData(Model m) {
		System.out.println("in the list merthod");
		
		m.addAttribute("alien", repo.findAll());
		return "alienList";
	}
	@PostMapping("/addAliens")
	public String addAliens(Alien a) {
		
		repo.save(a);
		return "result";
	}
	
	@GetMapping("/getAlien")
	public String fetchAlienList(@RequestParam int aid,Model m) {
		System.out.println("in theparticular record");
		m.addAttribute("alien", repo.getOne(aid));
		return "alienList";
	}
	
	@GetMapping("/getAlienbyname")
	public String fetchByName(@RequestParam String aname,Model m) {
	//	m.addAttribute("alien", repo.findByAname(aname));
		m.addAttribute("alien", repo.find(aname));
		return "alienList";
	}
	
	@PostMapping("/deleteAlien")
	public String deleteRecord(@RequestParam int aid, Model m) {
		
		repo.deleteById(aid);
		m.addAttribute("alien", repo.findAll());
		
		return "alienList";
	}
}
