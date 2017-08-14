package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Calculator;

@Controller
@RequestMapping({ "/maths" })
public class MathsController 
{
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) 
	{
		Adder adder = new Adder(first, second);
		model.addAttribute("sum", adder.calculate());
		return "helloworld/sum-result";
	}

	@GetMapping("adder")
	public String handleGetForAdder() 
	{

		return "helloworld/sum-nothing";
	}
	
	@GetMapping("calculator")
	public String index() {
		return "helloworld/calculator";
	}

	@GetMapping("start-calculator")
	public String handleGetForCalculator() 
	{
		return "helloworld/calculator";
	}

	@PostMapping("calculator")
	public String calculateTwoNumbers(@RequestParam(name = "left") double first,
			@RequestParam(name = "right") double second, String whatMathWeDoing, Model model) 
	{		
		Calculator calculate = new Calculator(first, second);
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		
		if (whatMathWeDoing.equals("adding")) 
		{
			model.addAttribute("operator", " + ");
			model.addAttribute("answer", calculate.addTwoNumbers());
		} 
		else if (whatMathWeDoing.equals("subtraction")) 
		{
			model.addAttribute("operator", " - ");
			model.addAttribute("answer", calculate.subtractTwoNumbers());
		} 
		else if (whatMathWeDoing.equals("division")) 
		{
			model.addAttribute("operator", " / ");
			if (second == 0) model.addAttribute("answer", "Can't divide by zero silly human; try again!");
			else model.addAttribute("answer", calculate.divideTwoNumbers());
		} 
		else if (whatMathWeDoing.equals("multiply")) 
		{
			model.addAttribute("operator", " * ");
			model.addAttribute("answer", calculate.multipyTwoNumbers());
		} 
		else if (whatMathWeDoing.equals("mod")) 
		{
			model.addAttribute("operator", " % ");
			if (second == 0) model.addAttribute("answer", "Can't mod by zero silly human; try again!"); 
			else model.addAttribute("answer", calculate.modTwoNumbers());
		} 
		else 
		{
			model.addAttribute("operator", " to the power of ");
			model.addAttribute("answer", calculate.powerTwoNumbers());
		}
		return "helloworld/calculator-answer";
	}

}
