package com.revature.dao;

import com.revature.data.UserData;

public interface UserDAO {

	public void saveUser(UserData u);
	
	public UserData getUser(String userName);
}
