package com.yjk.dao;

import java.util.List;

import com.yjk.pojo.User;
import com.yjk.pojo.Wan;

public interface UserDao {
	//在GiyHub页面修改的内容
	//查询全部
	public List<User> getlist();
	
	public List<User> get();
	//删除玩家
	public int delUser(int id);
	//添加玩家
	public int addUser(User user);
	//修改玩家
	public int upUser(User user);
	//修改回显
	public User getUserId(int id);
	//查询所有大区回显下拉框
	public List<Wan> getWan();
}
