package com.codingdojo.dojooverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OverflowController {
	@RequestMapping("")
	public String index() {
		return "redirect:/questions";
	}
}
