package com.revature.hobbycon.menus;

import java.sql.Connection;
import java.util.Scanner;

import com.revature.hobbycon.connection.JDBCConnection;
import com.revature.hobbycon.dao.UserDAO;
import com.revature.hobbycon.dao.UserDAOPostgres;

import com.revature.hobbycon.data.UserData;



public class LoginMenu extends UserData {
/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
//	Menu menu = new Menu();
	private Scanner scan = new Scanner(System.in);
	private static UserDAOPostgres userDao = new UserDAOPostgres();
	private static UserData user = new UserData();
	private String userName;
	private String userHobby;
	protected String userPW;
	UserMenu um = new UserMenu();
	public void login() {
		Connection conn = JDBCConnection.getRemoteConnection();
		System.out.println("Login Menu");
		System.out.println("User Name?");
		user.userName = scan.nextLine();
		System.out.println("Password??");
		userPW = scan.nextLine();
		//check and see if user has an account
		user = userDao.getUser(userName, userPW);
		if(user == null) {
			System.out.println("Record not found, please try again or create an account");
			return;
		} else {
		System.out.println("================================================");
		System.out.println("|    Welcome " + userName + " to HobbyCon      |");	
		System.out.println("================================================\n");
		
		um.runUserMenu(um);
		}
	}
}
