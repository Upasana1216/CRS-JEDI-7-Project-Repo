/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author Abhinav
 *
 */
public class UserIdAlreadyInUseException extends Exception{
	private String userId;
	
	
	public UserIdAlreadyInUseException(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setProfessorId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String getMessage() {
		return "userId: " + userId + " is already in use.";
	}

}
