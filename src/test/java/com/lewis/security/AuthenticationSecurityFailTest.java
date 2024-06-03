package com.lewis.security;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AuthenticationSecurityFailTest {

    @Test
    public void test1(){
        Assertions.assertFalse(AuthenticationSecurity.isValid("smith@"));
    }

    @Test
    public void test2(){
        Assertions.assertFalse(AuthenticationSecurity.isValid("*joseph"));
    }

    @Test
    public void test3(){
        Assertions.assertFalse(AuthenticationSecurity.isValid("wint$ers"));
    }

}
