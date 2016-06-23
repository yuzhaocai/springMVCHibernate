package com.class8.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.class8.entity.Employee;
import com.class8.validator.EmployeeValidator;
/**
 * Validator验证不通过是会自动生成4个key，且该4个key的优先级要高于自定义的key的优先级，都高于默认的defaultMessage,优先级高即先查找，如果查找到则直接返回
 * @author moon
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new EmployeeValidator());
	}
	
	@RequestMapping(value="/newEmployee",method=RequestMethod.GET)
	public String showCreateForm(Model model){
		model.addAttribute("employee", new Employee());
		return "employee/employeeForm";
	}
	
	/**
	 * 注意：此处为@Validated注解，而非@Valid注解
	 * @param employee
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public String createEmployee(@Validated Employee employee,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			logger.info("returning employee form page");
			return "employee/employeeForm";
		}
		logger.info("redirect to success");
		return "redirect:/employee/success";
	}
	
	@RequestMapping("/success")
	public String success(@ModelAttribute("message")String message){
		return "employee/success";
	}
}
