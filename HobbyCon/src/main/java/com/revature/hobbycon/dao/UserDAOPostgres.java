package com.revature.hobbycon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.hobbycon.app.ConnectionFactory;
import com.revature.hobbycon.connection.JDBCConnection;
import com.revature.hobbycon.data.UserData;
import com.revature.hobbycon.exceptions.NonLetterCharacterAdded;

public class UserDAOPostgres implements UserDAO {
	
	
	private static final String SAVE_HOBBY_GROUP = "update user set user_hobby_group =-? where user_profile_name = ? ";
	private static final String GET_HOBBY_GROUP = "select * from userprofile where userprofile_hobbies = ? ";
	private static final String SAVE_USER_NAME = "select * from user_hobbies where user_hobby_group = ? ";
	private static final String GET_USER_NAME = "select * from userprofile where userprofile_name = ? ";
	private static final String GET_USER_PASSWORD = "select * from userprofile where userprofile_password = ? ";
	private static final String CREATE_NEW_USER = "insert into userprofile (userprofile_name, userprofile_password, userprfile_hobby) values(?,?,?)";
	private static final String GET_USER_INFO = "select userprofile_name, userprofile_hobbies from userprofile u where u.userprofile_name = ? and u.userprofile_password = ?";
	private static Logger log = Logger.getRootLogger();
	@Override
	
	
	public void createNewUser(UserData nu) {
		Connection conn = JDBCConnection.getRemoteConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(CREATE_NEW_USER);
			pstmt.setString(1, nu.getUserName());
			pstmt.setString(2, nu.getUserPW());
			pstmt.setString(3, nu.getHobbyName());
			
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
	
	public void saveUserName(String userName) {	
		Connection conn = JDBCConnection.getRemoteConnection();
		UserData user = new UserData();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(SAVE_USER_NAME);
			pstmt.setString(1, user.setUserName(userName));
			//pstmt.setString(2, ud.getHobbyName());
		} catch (SQLException | NonLetterCharacterAdded e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public UserData getUser(String userName, String userPW) {
		Connection conn = JDBCConnection.getRemoteConnection();
		PreparedStatement pstmt;
		UserData user = new UserData();
		try {
			pstmt = conn.prepareStatement(GET_USER_INFO);
		
			pstmt.setString(1, userName);
			pstmt.setString(2, userPW);
			//pstmt.setString(3, pw);
			
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				user.setUserName(res.getString("userprofile_name"));
				//user.setHobbyName(res.getString("userprofile_hobbies"));
				user.setHobbyName(res.getString("userprofile_hobbies"));
				System.out.println("Name: " + userName);
				//System.out.println("Hobby: " + userHobby);
				//System.out.println("Fav hobby: " + userHobby);
			} else {
				System.out.println("User name/password incorrect. Please check your records");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  catch (NonLetterCharacterAdded e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
			}
		}
		

		
		return null;
	}

	@Override
	public boolean playerLog(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveUser(UserData user) {
		// TODO Auto-generated method stub
		
	}

}
