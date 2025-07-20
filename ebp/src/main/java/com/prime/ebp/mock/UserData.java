package com.prime.ebp.mock;


import java.util.HashMap;
import java.util.Map;

public class UserData {

    public static final Map<String, String> userData = new HashMap<>();

    static {
        userData.put("user", "user");
        userData.put("admin", "admin123");
    }

    public static boolean isValidUser(String username, String password) {
        return userData.containsKey(username) && userData.get(username).equals(password);
    }

}
