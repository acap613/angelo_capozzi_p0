package com.revature.hobbycon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


import com.revature.hobbycon.connection.JDBCConnection;

import com.revature.hobbycon.data.UserData;
import com.revature.hobbycon.exceptions.NonLetterCharacterAdded;

public class UserDAOPostgres implements UserDAO {
	
	
//	private static final String SAVE_HOBBY_GROUP = "update user set user_hobby_group =-? where user_profile_name = ? ";
//	private static final String SAVE_USER_NAME = "insert into userprofile set userprofile_name = ? ";
//	private static final String GET_USER_NAME = "select * from userprofile where userprofile_name = ? ";
//	private static final String GET_USER_PASSWORD = "select * from userprofile where userprofile_password = ? ";
	
	private static final String CREATE_NEW_USER = "insert into userprofile (userprofile_name, userprofile_password) values(?,?)";
	private static final String GET_USER_INFO = "select * from userprofile u where u.userprofile_name = ? and u.userprofile_password = ?";
	private static final String GET_HOBBY = "select * from userprofile where userprofile_hobbies = ? ";
	private static final String SET_NEW_HOBBY = "insert into userprofile (userprofile_hobbies) values(?)";

	private static Logger log = Logger.getRootLogger();
	
	
	
	public void createNewUser(UserData nu) {
		Connection conn = JDBCConnection.getRemoteConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(CREATE_NEW_USER);
			pstmt.setString(1, nu.getUserName());
			pstmt.setString(2, nu.getUserPW());
			//pstmt.setString(3, nu.getHobbyName());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			log.error("UserDAOPostgres:createNewUser: failed to create new user");
			
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

	public UserData getUser(String userName, String userPW) {
		Connection conn = JDBCConnection.getRemoteConnection();
		PreparedStatement pstmt;
		UserData user = null;
		try {
			user = new UserData();
			pstmt = conn.prepareStatement(GET_USER_INFO);		
			pstmt.setString(1, userName);
			pstmt.setString(2, userPW);			
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				user.setUserName(res.getString("userprofile_name"));
				user.setUserPW(res.getString("userprofile_password"));
				//System.out.println("user name = " + user.getUserName() + user.getUserPW());
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}  catch (NonLetterCharacterAdded e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			finally {
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
			}
		}
		
		
		
		return user;
	}	
	
	@Override
	public UserData getHobbyName(String hobbyName) {
		Connection conn = JDBCConnection.getRemoteConnection();
		PreparedStatement pstmt;
		UserData hob = null;
		try {
			hob = new UserData();
			pstmt = conn.prepareStatement(GET_HOBBY);		
			pstmt.setString(1, hobbyName);
					
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				hob.setHobbyName(res.getString("userprofile_hobbies"));
				
				System.out.println("user hobby = " + hob.getHobbyName());
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
			finally {
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
			}
		}
		
		
		
		return hob;
	}

	@Override
	public UserData setHobbyName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNewHobby(UserData nh) {
		Connection conn = JDBCConnection.getRemoteConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(SET_NEW_HOBBY);
			pstmt.setString(1, nh.getHobbyName());
			
			//pstmt.setString(3, nu.getHobbyName());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			log.error("UserDAOPostgres:createNewUser: failed to create new user");
			
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
