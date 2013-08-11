package com.raistudies.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raistudies.domain.JsonResponse;
import com.raistudies.domain.User;
import com.raistudies.service.UserService;

@Controller
public class UserController {
	private List<User> userList = new ArrayList<User>();
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.GET)
	public String showForm() {
		System.out.println("addUser Get Method");
		return "AddUser";
	}
	
	@RequestMapping(value = "/RestUser.htm/{name}", method = RequestMethod.GET)
	public @ResponseBody
	String restTest(@PathVariable String name) {
		String returnText;
		System.out.println("name");
		returnText = "User has been added to the list. Total number of users are "
				+ name;
		return returnText;
	}

	
	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.POST)
	public 	String addUser(Model model,@ModelAttribute(value = "user") User user,
			BindingResult result) {
		JsonResponse res = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "name", "Name can not be empty.");
		ValidationUtils.rejectIfEmpty(result, "education",
				"Educatioan not be empty");
		if (!result.hasErrors()) {
			System.out.println("In Post Method : adding user" + user.getName());
			userList.add(user);
			res.setStatus("SUCCESS");
			res.setResult(userList);
			userService.save(user);
			model.addAttribute("Users",userList);
			return "ShowUsers";
		} else {
			System.out.println("validation failed");
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
			return "AddUser";
		}
		
	}
	@RequestMapping(value = "/AAddUser.htm", method = RequestMethod.POST)
	public String jsonUser(Model model,@ModelAttribute(value = "user") User jsonuser) {
		JsonResponse res = new JsonResponse();
		System.out.println("In Post Method :" + jsonuser.getName());

		/*System.out.println("In Post Method : adding user");
		userList.add(jsonuser);
		res.setStatus("SUCCESS");
		res.setResult(userList);
		model.addAttribute("Users", userList);
		System.out.println(userList);*/
		return "ShowUsers";
	}

	@RequestMapping(value = "/ShowUsers.htm")
	public String showUsers(ModelMap model,HttpServletRequest request) {
		model.addAttribute("Users", userList);
		request.setAttribute("Users", userList);
		return "ShowUsers";
	}
	/*
	 * @RequestMapping(value="/AddUser.htm",method=RequestMethod.POST) public
	 * 
	 * @ResponseBody String addUser(@ModelAttribute(value="user") User
	 * user,BindingResult result ){ String returnText;
	 * 
	 * if(!result.hasErrors()){ userList.add(user); returnText =
	 * "User has been added to the list. Total number of users are " +
	 * userList.size(); }else{ returnText =
	 * "Sorry, an error has occur. User has not been added to list."; } return
	 * returnText; }
	 */
	/*
	 * @RequestMapping(value = "/AddUser.htm", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse addUser(@ModelAttribute(value = "user") User user,
			BindingResult result) {
		JsonResponse res = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "name", "Name can not be empty.");
		ValidationUtils.rejectIfEmpty(result, "education",
				"Educatioan not be empty");
		if (!result.hasErrors()) {
			System.out.println("In Post Method : adding user" + user.getName());
			userList.add(user);
			res.setStatus("SUCCESS");
			res.setResult(userList);
		} else {
			System.out.println("validation failed");
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}
		System.out.println(userList);
		return res;
	}
	 * */

	
}
