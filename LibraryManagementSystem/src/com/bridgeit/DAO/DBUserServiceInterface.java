package com.bridgeit.DAO;

import java.sql.SQLException;
import com.bridgeit.DTO.*;

/**
 * @author Ajit Shikalgar
 * The basic interface to be implemented
 *
 */
public interface DBUserServiceInterface {
	
	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * in order to authenticate a user, compare his.her email password if it exists in DB
	 * if useremail and password is proper, return true otherwise false
	 * 
	 */
	public boolean authenticateUser(String email, String password) throws ClassNotFoundException, SQLException;

	/**
	 * @param user
	 * @param conf_password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * Set of validations needed to be carried out in order to validate user credentials.
	 * if proper credentials, then register user else notify user.
	 */
	public String basicValidation(User user, String conf_password) throws ClassNotFoundException, SQLException;

	/**
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * registers user into database only if basic validation and already registered functions are cleared
	 * inserts user data into 2 tables names userlist(registration table) and appuser(login table)
	 */
	public void registerUser(User user) throws ClassNotFoundException, SQLException;

	/**
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLExcepton
	 * returns true if user already exists
	 */
	public boolean alreadyRegistered(User user) throws ClassNotFoundException, SQLException;

}