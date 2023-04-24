package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.User;
import model.User.UserBuilder;
import model.UserRole;
import service.card.CardService;
import service.card.CardServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static controller.UserUI.userMenu;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

     static  Gson gson = new GsonBuilder().setPrettyPrinting().create();
     static UserService userService = UserServiceImpl.getInstance();
     static CardServiceImpl cardService = CardServiceImpl.getInstance();

     static Scanner scanStr = new Scanner(System.in);
     static Scanner scanNum = new Scanner(System.in);



    public static void main(String[] args) {


        int cm = 0;

        while (true) {
            System.out.println("1. Sign in\t2. Sign up\t0. Exit");
            cm = scanNum.nextInt();
            switch (cm) {
                case 1 -> {
                    signIn();
                }
                case 2 -> {
                    signUp();
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Wrong input");
                    return;
                }
            }
        }


    }

    private static void signUp() {
        System.out.print("Enter name: ");
        String name = scanStr.nextLine();

        System.out.print("Enter username: ");
        String username = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();
        User user = new User(name,username,password,UserRole.USER);


        if (userService.add(user) == 1) {
            System.out.println("✔✔✔✔✔");
        }else {
            System.out.println("Bunaqa user oldindan bor");
        }


    }
    private static void signIn() {
        System.out.print("Enter username: ");
        String username = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        User user = userService.signIn(username,password);
        if (user == null) {
            System.out.println("Bunaqa user topilmadi");
        }else {
            switch (user.getRole()){
                case USER -> {
                    userMenu(user);
                }
            }
        }



    }



}


