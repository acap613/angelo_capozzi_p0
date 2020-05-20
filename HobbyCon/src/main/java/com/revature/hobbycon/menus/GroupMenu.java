package com.revature.hobbycon.menus;

import java.util.Scanner;

import com.revature.hobbycon.app.MenuLogic;

public class GroupMenu {
	boolean exit;
	Scanner userInput = new Scanner(System.in);
	MenuLogic ml = new MenuLogic();
	HobbyMenu hm = new HobbyMenu();
	
	//Menu menu = new Menu();
	public void runUserMenu() {
		
		while(!exit) {
			printUserMenu();
			int choice = ml.getInput();
			userMenuSelection(choice);
			
		}
	}
	
	public void runHobbyGroup() {
		
		System.out.println("Here are some other Users.");
		
	}
	
    public void userMenuSelection(int action) {
		
		action = userInput.nextInt();
		switch(action) {
		
		case 1:
			//change hobby method
			//hm.runHobbyList();
			break;
		case 2:
			//return to main menu
			//menu.runMenu();
			break;
		case 3:
			System.out.println("Thanks for using HobbyCon, see you next time :)");
			System.exit(0);
			break;
		default:
			System.out.println("An unknown error occurred");
		}
	}
	
	private void printUserMenu() {
		System.out.println("1.) Change Hobbies: ");
		System.out.println("2.) Return to Login/Signup");
		System.out.println("3.) Exit");
	};
}
