package com.core.mockito;

public interface IAuthenticator {
	public boolean authenticateUsers(String userName, String password) throws EmptyCredentialsException;
	public void foo();
}