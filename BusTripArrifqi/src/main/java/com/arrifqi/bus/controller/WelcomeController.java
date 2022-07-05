package com.arrifqi.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indexr")
public class WelcomeController {

	@GetMapping("/")
	public String main() {
		return "index"; //view
	}
}
