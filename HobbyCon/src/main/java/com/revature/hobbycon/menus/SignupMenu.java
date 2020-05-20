package com.revature.hobbycon.menus;

import java.util.Scanner;

import com.revature.hobbycon.app.MenuLogic;
import com.revature.hobbycon.dao.UserDAO;
import com.revature.hobbycon.dao.UserDAOPostgres;

import com.revature.hobbycon.data.HobbyData;
import com.revature.hobbycon.data.UserData;


    

	public class SignupMenu extends UserData {	
		
		private static UserDAO userDao = new UserDAOPostgres();
		private static UserData user = new UserData();
		
		private Scanner scan = new Scanner(System.in);
		private static final long serialVersionUID = 1L;
        //LoginMenu lm = new LoginMenu();
	    HobbyMenu hm = new HobbyMenu();
		public void signup() {
			System.out.println("Signup Menu");
			System.out.println("\nUser Name?");
			userName = scan.nextLine();
			System.out.println("Password?");
			userPW = scan.nextLine();
			user = new UserData(userName, userPW, hobbyName);
			userDao.saveUser(user);
			System.out.println("Welcome " + userName + "\nPick a hobby!");
			
			hm.runHobbyList();
			
			
			
		}
		
	
		
		
}
