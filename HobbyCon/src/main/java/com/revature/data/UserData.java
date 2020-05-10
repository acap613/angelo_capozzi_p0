package com.revature.data;

//import java.util.Scanner;

public class UserData {
	//user variables
	protected String firstName;
	protected String lastName;	
	protected String userName;	
	protected int userId;
	protected String userPW;
	protected String hobbyName;
	protected int hobbyID;
	
	
	//=======get set first name==========
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		//=========get set last name===============
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
	//============get/set user name=============
	public String getUserName() {
		return firstName + " " + lastName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//============get/set user ID===================
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//============get/set user PW===================
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	//===========get set hobby name================
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	//===========get set hobby ID================
	public int getHobbyID() {
		return hobbyID;
	}
	public void setHobbyID(int hobbyID) {
		this.hobbyID = hobbyID;
	}
}
