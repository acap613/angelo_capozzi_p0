package com.revature.hobbycon.dao;


import com.revature.hobbycon.data.UserData;

public interface UserDAO {

	
	
	public UserData getUser(String userName, String userPW);
	
	public void createNewUser(UserData nu);
	
	public UserData getHobbyName(String hobbyName);
	
	public UserData setHobbyName();
	
	public void setNewHobby(UserData nh);
}
