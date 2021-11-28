package hu.me.iit.webalk.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hu.me.iit.webalk.demo.Service.LicitService;

@Controller
public class LicitController {
	private final LicitService licitService;
	
	public LicitController(LicitService licitService) {
		super();
		this.licitService = licitService;
	}



	@GetMapping("/licit/highest")
	public int getHighest() {
		return licitService.getHighest();
	}
	
	@GetMapping("/licit/highest/{userId}")
	public int getHighestForUser(@PathVariable int userId) {
		return licitService.getHighestForUser(userId);
	}
	
	@PostMapping
	public void saveNewLicit(@Valid @RequestBody SaveLicitDto savelicitDto) {
		licitService.saveNewLicit(savelicitDto.getLicit(), savelicitDto.getUserId());
	}
	
	
}
