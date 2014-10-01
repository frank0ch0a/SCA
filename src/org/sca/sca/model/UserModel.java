package org.sca.sca.model;

public class UserModel {
	
	private String mName =null;
	private String mLastName = null;
	private String mEmail = null;
	private String mPassword = null;
	private String mTokenA = null;
	private String mTokenB= null;
	private String mSession= null;
	public UserModel(String name, String lastName, String email,
			String password, String tokenA, String tokenB, String session) {
		super();
		mName = name;
		mLastName = lastName;
		mEmail = email;
		mPassword = password;
		mTokenA = tokenA;
		mTokenB = tokenB;
		mSession = session;
	}
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public String getLastName() {
		return mLastName;
	}
	public void setLastName(String lastName) {
		mLastName = lastName;
	}
	public String getEmail() {
		return mEmail;
	}
	public void setEmail(String email) {
		mEmail = email;
	}
	public String getPassword() {
		return mPassword;
	}
	public void setPassword(String password) {
		mPassword = password;
	}
	public String getTokenA() {
		return mTokenA;
	}
	public void setTokenA(String tokenA) {
		mTokenA = tokenA;
	}
	public String getTokenB() {
		return mTokenB;
	}
	public void setTokenB(String tokenB) {
		mTokenB = tokenB;
	}
	public String getSession() {
		return mSession;
	}
	public void setSession(String session) {
		mSession = session;
	}
	
	
	
	
	

}
