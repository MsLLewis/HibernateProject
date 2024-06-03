package com.lewis.security;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuthenticationSecurity {

    public static String login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String username = input.nextLine();
        if (isValid(username)) {
            System.out.println("Username is valid.");
        }
        return username;
    }

    public static Boolean isValid(String username){
       String [] invalidCharArray = "!@#$$^&*()".split("");
        List<String> invalidChars = Arrays.asList(invalidCharArray);
        String[] userNameCharArray = username.split("");
        for(String currentChar: userNameCharArray){
            if(invalidChars.contains(currentChar)){
                System.out.println("Invalid Username");
                return false;
            }
        }
        return true;

    }
}
