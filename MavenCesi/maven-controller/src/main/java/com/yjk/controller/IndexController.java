package com.yjk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjk.pojo.User;
import com.yjk.pojo.Wan;
import com.yjk.service.impl.UserService;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	@RequestMapping({"index","/"})
	public String index(Model model) {
		List<User>getlist=userService.getlist();
		model.addAttribute("list",getlist);
		return "index";
		
	}
	//删除方法
	@RequestMapping("deluser")
	@ResponseBody
	public Map<String, String> deluser(int id){
		Map<String, String>map=new HashMap<String, String>();
		int a=userService.delUser(id);
		if (a>0) {
			map.put("type", "success");
			map.put("msg", "删除成功!");
			return map;
		}else {
			map.put("type", "error");
			map.put("msg", "删除失败!");
			return map;
		}
		
	}
	//跳转到添加页面，执行添加方法，携带查询所有大区的参数
	@RequestMapping("/addtiao")
	public String addtiao(Model model) {
		List<Wan>wans=userService.getWan();
		model.addAttribute("wan",wans);
		return "add";
	}
	//跳转到添加页面，执行修改方法
	@RequestMapping("/uptiao")
	public String uptiao(int id,Model model) {
		User user=new User();
		user=userService.getUserId(id);
		List<Wan>wans=userService.getWan();
		model.addAttribute("wan",wans);
		model.addAttribute("user",user);
		return "add";
	}
	
	//添加保存/修改
	@RequestMapping("adduser")
	@ResponseBody
	public Map<String, String> addbaoc(User user,Model model){
		Map<String, String>map=new HashMap<String, String>();
		if (user.getId()==0) {
			int a=userService.addUser(user);
			if (a>0) {
				map.put("type", "success");
				map.put("msg", "添加成功!");
				return map;
			}else {
				map.put("type", "error");
				map.put("msg", "添加失败!");
				return map;
			}
		}else {
			int a=userService.upUser(user);
			if (a>0) {
				map.put("type", "success");
				map.put("msg", "修改成功!");
				return map;
			}else {
				map.put("type", "error");
				map.put("msg", "修改失败!");
				return map;
			}
		}
		
		
	}
	
}
