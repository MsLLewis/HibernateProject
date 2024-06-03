package com.lewis;

import com.lewis.model.BookResponse;
import com.lewis.model.Person;
import com.lewis.security.AuthenticationSecurity;
import com.lewis.utility.DBUtility;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        AuthenticationSecurity.login();


    }
}