package com.inv.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.inv.util.InvProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	@Autowired
	private InvProperties neoPro;

	@RequestMapping("/hi")
	public String hello(Locale locale, Model model) {
		model.addAttribute("greeting", "Hello!");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);
 		model.addAttribute("title",neoPro.getTitle());
		model.addAttribute("description", neoPro.getDescription());
		System.out.println("neoPro.getTitle()"+neoPro.getTitle());
		System.out.println("neoPro.getTitle()"+neoPro.getDescription());
		System.out.println("neoPro.getUrl()"+neoPro.getUrl());
		return "hello";
	}

}