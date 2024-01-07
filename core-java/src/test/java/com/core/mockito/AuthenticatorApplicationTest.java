package com.core.mockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;


public class AuthenticatorApplicationTest {

    @Mock
    private IAuthenticator authenticatorMock;

    @InjectMocks
    private AuthenticatorApplication application;

//    @Test
//    public void testAuthenticate() throws EmptyCredentialsException {
//        String userName = "JavaCodeGeeks";
//        String password = "sshhh";
//
//        when(this.authenticatorMock.authenticateUsers(userName, password)).thenReturn(true);
//        boolean authenticateUser = this.application.authenticateUser(userName, password);
//        assertTrue(authenticateUser);
//    }
	
	/*
	@Test
	public void testAuthenticate() {
		
		IAuthenticator authenticatorMock;
		AuthenticatorApplication application;
		String userName = "JavaCodeGeeks";
		String password = "sshhh";
		
		authenticatorMock = Mockito.mock(IAuthenticator.class);
		application = new AuthenticatorApplication(authenticatorMock);
		
		//adding the behavior
		when(authenticatorMock.authenticateUsers(userName, password)).thenReturn(false);
		
		boolean actual = false;
		
		try {
			actual = application.authenticateUser(userName, password);
		} catch (EmptyCredentialsException e) {
			e.printStackTrace();
		}
		
		assertFalse(actual);
		
		
		//---------------------------------------------
		//checks atleast happens once
		verify(authenticatorMock).authenticateUsers(userName, password);
		
		//will fail since password is not matching
		//verify(authenticatorMock).authenticateUsers(userName, "not the original password"); 
		
		verify(authenticatorMock, times(1)).authenticateUsers(userName, password);
		verify(authenticatorMock, atLeastOnce()).authenticateUsers(userName, password);
		verify(authenticatorMock, atLeast(1)).authenticateUsers(userName, password);
		verify(authenticatorMock, atMost(1)).authenticateUsers(userName, password);
		//verify(authenticatorMock, never()).authenticateUsers(userName, password);
		//---------------------------------------------
		
		
		//verifies order of execution
		InOrder inOrder = inOrder(authenticatorMock);
		inOrder.verify(authenticatorMock).foo();
		inOrder.verify(authenticatorMock).authenticateUsers(userName, password);
		
		//verification with timeout
		verify(authenticatorMock, timeout(0)).authenticateUsers(userName, password);
		
		verify(authenticatorMock, timeout(0).times(1)).authenticateUsers(userName, password);
	}
	*/

//    @Test
//    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
//
//        IAuthenticator authenticatorMock;
//        AuthenticatorApplication application;
//
//        authenticatorMock = Mockito.mock(IAuthenticator.class);
//        application = new AuthenticatorApplication(authenticatorMock);
//
//        when(authenticatorMock.authenticateUsers("", "")).thenThrow(new EmptyCredentialsException());
//
//        application.authenticateUser("", "");
//    }

}