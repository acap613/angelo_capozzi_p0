package com.revature.hobbycon.tests;

//import static org.junit.Assert.*;

import org.junit.Test;

//import com.revature.hobbycon.app.ConnectionFactory;

import com.revature.hobbycon.connection.JDBCConnection;
import com.revature.hobbycon.dao.UserDAOPostgres;

public class ConnectionTest {

	UserDAOPostgres udp = new UserDAOPostgres();
	
	@Test
	public void test() {
		//ConnectionFactory.getConnection();
		JDBCConnection.getRemoteConnection();
	}
	@Test
	public void getUserTest() {
		udp.getUser("Ben", "Sports", "DemBonez");
	} 
	@Test
	public void setNewUser() {
		udp.setUser();
	}

}
