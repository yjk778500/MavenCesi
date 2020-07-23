package com.yjk.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yjk.pojo.User;
import com.yjk.pojo.Wan;
import com.yjk.service.impl.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class Testgetlist {

	@Autowired
	UserService userservice;
	//查询所有信息
	@Test
	public void testa() {
		
		List<User> lsit=userservice.getlist();
		for (User user : lsit) {
			System.out.println("编号:--"+user.getId()+"游戏名:--"+user.getUser_name()+"玩家住址:--"+user.getUser_address()+"联系方式:--"+user.getUser_tel()+"玩家大区:--"+user.getWana().getZname());
			
		}
		
	}
	//测试修改回显
	@Test
	public void getid() {
		int id=3;
		User user=userservice.getUserId(id);
		System.out.println(user.getUser_name());
		
	}
	//查询所有大区信息回显下拉框
	@Test
	public void getwan() {
		List<Wan>getWan=userservice.getWan();
		for (Wan wan : getWan) {
			System.out.println(wan.getZname());
		}
		
	}
	//删除信息
	@Test
	public void del() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入需要删除的ID:");
		int id=input.nextInt();
		int a=userservice.delUser(id);
		if (a>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	//添加测试
	@Test
	public void add() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入需要添加的姓名:");
		String name=input.next();
		System.out.println("请输入需要添加的住址:");
		String address=input.next();
		System.out.println("请输入需要添加的电话:");
		String tel=input.next();
		System.out.println("请输入需要添加的大区ID:1~~5之间的一位数:");
		int id=input.nextInt();
		
		User user=new User();
		user.setUser_name(name);
		user.setUser_address(address);
		user.setUser_tel(tel);
		user.setZu_id(id);
		
		int a=userservice.addUser(user);

		if (a>0) {
			System.out.println("添加成功!");
		}else {
			System.out.println("添加失败!");
		}
	}
	//测试修改
	@Test
	public void update(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入根据修改的ID:");
		int id=input.nextInt();
		
		System.out.println("请输入修改的姓名:");
		String name=input.next();
		System.out.println("请输入需要添加的住址:");
		String address=input.next();
		System.out.println("请输入需要添加的电话:");
		String tel=input.next();
		System.out.println("请输入需要添加的大区ID:1~~5之间的一位数:");
		int zid=input.nextInt();
		
		User user=new User();
		user.setId(id);
		user.setUser_name(name);
		user.setUser_address(address);
		user.setUser_tel(tel);
		user.setZu_id(zid);
		int a=userservice.upUser(user);
		if (a>0) {
			System.out.println("修改成功!");
		}else {
			System.out.println("修改失败!");
		}
	}
}
