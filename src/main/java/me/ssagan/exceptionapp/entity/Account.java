package me.ssagan.exceptionapp.entity;

import me.ssagan.exceptionapp.exception.WrongLoginException;
import me.ssagan.exceptionapp.exception.WrongLoginOrPasswordException;
import me.ssagan.exceptionapp.exception.WrongPasswordException;

import java.util.HashMap;

public class Account {
    private String login;
    private String password;
    private HashMap<String, String> loginMap = new HashMap<>();

    {
        loginMap.put("svetlana", "123456789");
        loginMap.put("sergei", "987654321");
    }

    public String getLogin() {
        return login;
    }

    public boolean checkLogin(String login) {
        boolean result = false;
        try {
            if (!(login != null && login.length() > 5 && login.length() < 20)) {
                System.out.println("Incorrect login");
                throw new WrongLoginException();
            }
            this.login = login;
            result = true;
        } catch (WrongLoginException e) {
            System.out.println("Исключение: " + e);
        }
        return result;
    }

    public boolean checkPassword(String password, String confirmation) {
        boolean result = false;
        try {
            if (!(password != null && password.length() > 8 && password.length() < 20 && password.equals(confirmation))) {
                System.out.println("Incorrect password");
                throw new WrongPasswordException();
            }
            this.password = password;
            result = true;
        } catch (WrongPasswordException e) {
            System.out.println("Исключение: " + e);
        }
        return result;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        boolean result = false;
        try {
            if (!(loginMap.containsKey(login) && loginMap.get(login).equals(password))) {
                System.out.println("Incorrect login or password");
                throw new WrongLoginOrPasswordException();
            }
            this.login = login;
            this.password = password;
            result = true;
        } catch (WrongLoginOrPasswordException e) {
            System.out.println("Исключение: " + e);
        }
        return result;
    }
}
