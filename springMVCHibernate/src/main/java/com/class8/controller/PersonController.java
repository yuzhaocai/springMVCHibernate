package com.class8.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.class8.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	private static final String CREATE = "person/add";
	private static final String UPDATE = "person/edit";
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String showCreateForm(){
		return CREATE;
	}
	
	/**
	 * @Validated:使用spring validator校验时使用该注解
	 * @Valid:使用jsr-303校验时，使用该注解
	 * @param person
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createPerson(@Validated @ModelAttribute("person") Person person,BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return CREATE;
		}
		redirectAttributes.addFlashAttribute("message", "用户创建成功.");
		return "redirect:/person/success";
	}
	
}
