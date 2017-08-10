package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;

@Controller
@RequestMapping({ "/maths" })
public class MathsController {
	
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, 
			@RequestParam(name="right") double second, Model model) {
		
		Adder adder = new Adder(first, second);
		model.addAttribute("sum", adder.calculate());
		return "helloworld/sum-result";
	}
	
	@GetMapping("adder")
	public String handleGetForAdder() {
		
		return "helloworld/sum-nothing";
	}

}
