package com.example.democs895.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.democs895.model.Calculator;


@Controller
public class CalculatorController {
	
	@GetMapping("/calculator")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}
	
	@PostMapping("/calc")
	public String index(
			@RequestParam String leftOperand,
			@RequestParam String operator,
			@RequestParam String rightOperand,
			Model model
	) {
		double leftNumber;
		double rightNumber;

		try {
			leftNumber = Double.parseDouble(leftOperand);
		}
		catch (NumberFormatException ex) {
			leftNumber = 0;
		}

		try {
			rightNumber = Double.parseDouble(rightOperand);
		}
		catch (NumberFormatException ex) {
			rightNumber = 0;
		}
		
		Calculator calculator = new Calculator(
				leftNumber,
				rightNumber,
				operator
		);
		
		double result = calculator.calculateResult();
		model.addAttribute("leftOperand", leftNumber);
		model.addAttribute("operator", operator);
		model.addAttribute("rightOperand", rightNumber);
		model.addAttribute("result", result);
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}
}
