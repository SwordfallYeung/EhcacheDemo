package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author y15079
 * @create 2017-10-24 10:31
 * @desc
 **/
@Controller
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("")
	public String testUser(Model model){
		User user=userService.findUser("3d2y");
		model.addAttribute("user",user);
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/count",method = RequestMethod.POST)
	public Object count(){
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		int count=userService.count();
		map.put("hello",count);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public Object insert(){

		HashMap<String,Boolean> map=new HashMap<String,Boolean>();
		try {
			User user=new User("3y2d","hello","14");
			userService.insert(user);
			map.put("flag",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
