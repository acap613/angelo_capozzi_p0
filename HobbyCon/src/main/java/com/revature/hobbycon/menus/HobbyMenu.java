package com.revature.hobbycon.menus;

import java.util.Scanner;


import com.revature.hobbycon.data.UserData;

public class HobbyMenu {
	boolean exit;
	//LoginMenu lm = new LoginMenu();
	
	private UserData ud;
	private UserMenu um;
	public String hobbyChoice;
	public void runHobbyList(UserData ud) {
		this.ud = ud;
		this.um = new UserMenu();
		runMenuOpt();
	}
	public void runHobbyList() {
		this.um = new UserMenu();
		runMenuOpt();
	}
	

	public void runMenuOpt() {
		while(!exit) {
			printHobbyList();
			int choice = getInput();
			hobbyList(choice);
			System.out.println("Welcome to HobbyConn!\n");
			//lm.login();
			this.ud.setHobbyName(hobbyChoice);
			this.um.runUserMenu(ud);

	   }
	}
	
	public String hobbyList(int hob) {
		hobbyChoice = "";
		switch(hob) {
		case 1:
			System.out.println("You chose Sports!");
			//hd.setHobbyAs(Sports);
			hobbyChoice = "Sports";
			break;
		case 2:
			System.out.println("You chose Movies!");
			//hd.setHobbyAs(Movies);
			hobbyChoice = "Movies";
			break;
		case 3:
			System.out.println("You chose Arts!");
			//hd.setHobbyAs(Arts);
			hobbyChoice = "Arts";
			break;
		case 4:
			System.out.println("You chose Games!");
			//hd.setHobbyAs(Games);
			hobbyChoice = "Games";
			break;
		case 5:
			System.out.println("You chose Cooking!");
			//hd.setHobbyAs(Cooking);
			hobbyChoice = "Cooking";
			break;
		case 6:
			System.out.println("You chose Music!");
			//hd.setHobbyAs(Music);
			hobbyChoice = "Music";
			break;
		case 7:
			System.out.println("You chose Other...");
			//hd.setHobbyAs(Programming);
			hobbyChoice = "Other";
			break;
		default:
			System.out.println("unknown error...");
			
			
		}
		return hobbyChoice;
		
		
	}
	
	private void printHobbyList() {
		System.out.println("1.) Sports");
		System.out.println("2.) Movies");
		System.out.println("3.) Art");
		System.out.println("4.) Games");
		System.out.println("5.) Cooking");
		System.out.println("6.) Music");
		System.out.println("7.) Other");
	}
	
	private int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice = -1;
		while(choice < 1 ||choice > 7) {
			try {
				System.out.println("\nEnter a number 1-7.");
				choice = Integer.parseInt(kb.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Invalid selection, please enter a number 1-7");
			}
		}
		
		return choice;
	}
}
