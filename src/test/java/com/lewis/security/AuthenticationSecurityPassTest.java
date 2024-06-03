package com.lewis.security;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AuthenticationSecurityPassTest {

    @Test
    public void test1(){
        Assertions.assertTrue(AuthenticationSecurity.isValid("smith"));
    }

    @Test
    public void test2(){
        Assertions.assertTrue(AuthenticationSecurity.isValid("joseph"));
    }

    @Test
    public void test3(){
        Assertions.assertTrue(AuthenticationSecurity.isValid("winters"));
    }
}
