package com.practice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entity.LoginData;

@Controller
public class MyController {
	
		@GetMapping("/form")
		public String openForm(Model model)
		{
			System.out.println("Opening Form");
			model.addAttribute("loginData", new LoginData());
			return  "form";
		}
		
		@PostMapping("/process")
		public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result)
		{
			if(result.hasErrors())
			{
				
				System.out.println("RRRRRRR"+result);
				return "form";
			}
				System.out.println(loginData);
				return "success";
			
		}
		
		
}
