package com.revature.hobbycon.tests;

import java.util.Scanner;

import org.junit.Before;

//import static org.junit.Assert.*;

import org.junit.Test;

//import com.revature.hobbycon.app.ConnectionFactory;

import com.revature.hobbycon.connection.JDBCConnection;
import com.revature.hobbycon.dao.UserDAOPostgres;
import com.revature.hobbycon.data.UserData;

public class ConnectionTest {

	UserDAOPostgres udp = new UserDAOPostgres();
	UserData user = new UserData();
	private static final String NEW_NAME = "Pepper";
	private static final String NEW_PW = "iloveliver";
	private static final String NEW_HOBBY = "art";
	Scanner scan = new Scanner(System.in);
	String input = scan.nextLine();
	@Before
	public void setup() {
		user.userName = NEW_NAME;
		user.userPW = NEW_PW;
		user.hobbyName = NEW_HOBBY;
	}
	@Test
	public void test() {
		//ConnectionFactory.getConnection();
		JDBCConnection.getRemoteConnection();
	}
	@Test
	public void getUserTest() {
		udp.getUser("Ben", "DemBonez");
		user.getHobbyName();
		
	} 
	@Test
	public void setNewUser() {
		udp.saveUserName(input);
	}

}
