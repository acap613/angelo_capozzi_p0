package com.revature.hobbycon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.hobbycon.app.ConnectionFactory;
import com.revature.hobbycon.connection.JDBCConnection;
import com.revature.hobbycon.data.UserData;

public class UserDAOPostgres implements UserDAO {
	
	
	private static final String SAVE_HOBBY_GROUP = "update user set user_hobby_group =-? where user_profile_name = ? ";
	private static final String GET_HOBBY_GROUP = "select * from userprofile where userprofile_hobbies = ? ";
	private static final String SAVE_USER_NAME = "select * from user_hobbies where user_hobby_group = ? ";
	private static final String GET_USER_NAME = "select * from userprofile where userprofile_name = ? ";
	private static final String GET_USER_PASSWORD = "select * from userprofile where userprofile_password = ? ";
	private Connection conn = JDBCConnection.getRemoteConnection();
	
	@Override
	
	
	public void saveUser(UserData ud) {		
		
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(SAVE_HOBBY_GROUP);
			pstmt.setString(1, ud.getUserName());
			pstmt.setString(2, ud.getHobbyName());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public UserData getUser(String userName, String userHobby, String pw) {
		PreparedStatement pstmt;
		UserData user = new UserData();
		try {
			pstmt = conn.prepareStatement(GET_USER_NAME);
			pstmt = conn.prepareStatement(GET_HOBBY_GROUP);
			pstmt = conn.prepareStatement(GET_USER_PASSWORD);
			pstmt.setString(1, userName);
			pstmt.setString(1, userHobby);
			pstmt.setString(1, pw);
			
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				user.setHobbyName(res.getString("userprofile_name"));
				user.setHobbyName(res.getString("userprofile_hobbies"));
				user.setHobbyName(res.getString("userprofile_password"));
				System.out.println("Name: " + userName);
				System.out.println("Hobby: " + userHobby);
				System.out.println("Secret code: " + pw);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//			finally {
//			try {
//				conn.close();
//			} catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		return null;
	}

	@Override
	public boolean playerLog(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

}
