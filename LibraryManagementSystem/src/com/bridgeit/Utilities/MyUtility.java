package com.bridgeit.Utilities;

import com.bridgeit.DTO.User;

import java.sql.SQLException;

public class MyUtility {

	public boolean noErrorExists(String errorString) {
		if (errorString.equals("Error/s: "))
			return true;
		return false;
	}

	public String basicValidation(User user, String conf_password) throws ClassNotFoundException, SQLException {
		String errorString = "Error/s: ";
		if (user.getPhone().length() != 0) {
			if (user.getPhone().length() != 10)
				errorString = errorString.concat(" invalidphone ");
		} else {
			errorString = errorString.concat(" emptyphone ");
		}

		if (!(user.getPassword().equals(conf_password)))
			errorString = errorString.concat(" passwordunmatch ");

		if (user.getFullname().length() == 0)
			errorString = errorString.concat(" fullnameempty ");

		if (user.getEmail().length() == 0)
			errorString = errorString.concat(" emailempty ");

		if (user.getGender().length() == 0)
			errorString = errorString.concat(" genderempty ");

		if (user.getPassword().length() == 0)
			errorString = errorString.concat(" passwordempty ");
		if (conf_password == null)
			errorString = errorString.concat(" confpasswordempty ");

		if (user.getFullname().matches(".*\\d.*"))
			errorString = errorString.concat(" fullnamedigit ");

		if (user.getPhone().matches(".*\\D.*"))
			errorString = errorString.concat(" phonechar ");

		if (user.getPassword().length() < 4)
			errorString = errorString.concat(" passwordshort ");

		System.out.println("username: " + user.getFullname() + " phone: " + user.getPhone() + " password: "
				+ user.getPassword() + " conf_password: " + conf_password + " gender: " + user.getGender());
		System.out.println("some sysntax incorrect !!");

		System.out.println("error is in " + errorString);
		return errorString;
	}

}
