package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({ "/", "/HelloWorld" })
public class HelloWorldController {

	private String title;

	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}

	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}

	@GetMapping("message")
	public ModelAndView message(@RequestParam(required = false, defaultValue = "«silence»") String message) {

		Yeller yeller = new Yeller(message);
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", yeller.makeItUpperCase());
		return mv;
	}

	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required = false, defaultValue = "«shhhh»") String message) {

		Whisperer whisperer = new Whisperer(message);
		ModelAndView mv = new ModelAndView("helloworld/lowerMessage");
		mv.addObject("title", title);
		mv.addObject("message", whisperer.makeItLowerCase());
		return mv;
	}
	
	@GetMapping("say-something")
	public String makeAChoice(String speechChoice, String message, Model model) {
		if (speechChoice.equals("yell")) {
			model.addAttribute("output", message.toUpperCase());
		}
		else {
			model.addAttribute("output", message.toLowerCase());
		}
		return "HelloWorld/mixed-messages";
	}

}
