package com.core.mockito;

public class AuthenticatorApplication {
	
	private IAuthenticator authenticator;
	
	public AuthenticatorApplication(IAuthenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	public boolean authenticateUser(String userName, String password) throws EmptyCredentialsException {
		this.authenticator.foo();
		return this.authenticator.authenticateUsers(userName, password);
	}
	
}
