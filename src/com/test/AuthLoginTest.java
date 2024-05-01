package com.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.exception.InvalidCredentialsException;
import com.model.User;
import com.service.AuthService;

public class AuthLoginTest {
    AuthService authService = new AuthService();
    
    @Test
    public void login() {
        String username = "jos cummins";
        String password = "jos123";
        
        try {
            User actualUserLogin = authService.login(username, password);
            User expectedUser = new User(26, "Jos cummins", "jos123", "admin", "Active");
            
            Assert.assertEquals(actualUserLogin, expectedUser);
            
        } catch (InvalidCredentialsException e) {
            fail("InvalidCredentialsException should not be thrown: " + e.getMessage());
        } catch (SQLException e) {
            fail("SQLException should not be thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected Exception occurred: " + e.getMessage());
        }
    }
}
