package me.ssagan.exceptionapp._main;

import me.ssagan.exceptionapp.entity.Account;

import java.util.Scanner;

public class _Main {
    public static void main(String[] args) {
        System.out.println("1 - Register account");
        System.out.println("2 - Sign in");

        Scanner scanner = new Scanner(System.in);
        String menuIndex;
        menuIndex = scanner.next();
        switch (menuIndex) {
            case "1":
                registerAccount();
                break;
            case "2":
                signInAccount();
                break;
        }
    }

    public static void registerAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Registration. Enter login:");
        String login = scanner.next();

        if (account.checkLogin(login)) {
            System.out.println("Login: " + account.getLogin());

            System.out.println("Enter password:");
            String password = scanner.next();

            System.out.println("Enter confirmation:");
            String confirmation = scanner.next();

            if (account.checkPassword(password, confirmation)) {
                System.out.println("Password is correct");
            }
        }
    }

    public static void signInAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Sign in. Enter your login:");
        String login = scanner.next();

        System.out.println("Enter your password:");
        String password = scanner.next();

        if (account.checkLoginAndPassword(login, password)) {
            System.out.println("Вы успешно вошли в аккаунт!");
        }
    }
}
