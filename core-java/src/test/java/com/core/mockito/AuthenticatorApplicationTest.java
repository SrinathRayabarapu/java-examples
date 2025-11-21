package com.core.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest {

    @Mock
    private IAuthenticator authenticatorMock;

    @InjectMocks
    private AuthenticatorApplication application;

    @Test
    public void testAuthenticate() throws EmptyCredentialsException {
        String userName = "JavaCodeGeeks";
        String password = "sshhh";

        when(this.authenticatorMock.authenticateUsers(userName, password)).thenReturn(true);
        boolean authenticateUser = this.application.authenticateUser(userName, password);
        assertTrue(authenticateUser);
    }

    @Test(expected = EmptyCredentialsException.class)
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {

        IAuthenticator authenticatorMock;
        AuthenticatorApplication application;

        authenticatorMock = Mockito.mock(IAuthenticator.class);
        application = new AuthenticatorApplication(authenticatorMock);

        when(authenticatorMock.authenticateUsers("", "")).thenThrow(new EmptyCredentialsException());

        application.authenticateUser("", "");
    }

}