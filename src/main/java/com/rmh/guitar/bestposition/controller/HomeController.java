package com.rmh.guitar.bestposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String home(@RequestParam(value="name", required=false, defaultValue="The Guitarist") String name, Model model) {
		model.addAttribute("name", name);
        
        return "index";
    }

}
