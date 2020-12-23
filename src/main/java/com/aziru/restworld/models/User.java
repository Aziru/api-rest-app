package com.aziru.restworld.models;

public class User {

	private String userName;
	private String nickName;
	private String password;

	/**
	 * Constructor
	 * 
	 * @param userName
	 * @param nickName
	 * @param password
	 */
	public User(String nickName, String userName, String password) {
		super();		
		this.nickName = nickName;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", nickName=" + nickName + ", password=" + password + "]";
	}
}
