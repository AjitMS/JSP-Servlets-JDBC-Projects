package com.LoginApp;

import java.util.HashMap;
import java.util.Map;

import com.LoginApp.User.*;

public class LoginService {
	
	
	Map<String, String> users = new HashMap<>();
	
	
	public LoginService(){
		
		users.put("robbstark", "Robb Stark");
		users.put("tyrionlannister","Tyrion Lannister");
		users.put("danaerystargaryen", "Danaerys Targaryen");
		
	}
	
	public boolean authenticate(String userId, String password) {
		
		if(password==null || password.trim() == "")
			return false;
		return true;
		
	}
	
	public User getUserDetails(String userId) {
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
		  
	}
	
}
