package com.company.core;

import java.util.Scanner;

public class Main {
    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_BLACK = "\u001B[30m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {
                case "register": {
                    if(!validateArguments(commandArgs)) break;
                    RegisterUser(commandArgs, usersData);
                    break;
                }
                case "delete": {
                    if(!validateArguments(commandArgs))break;
                    DeleteAccount(commandArgs, usersData);
                    break;
                }
            }

            // read next command
            command = scanner.nextLine();
        }
    }

    private static void DeleteAccount(String[] commandArgs, String[][] users) {
        // handles deletion

        Integer[] deleteUserDataIndex = new Integer[1];

        if(DeleteUsernameIndex(commandArgs, users, deleteUserDataIndex)){
            users[deleteUserDataIndex[0]][0] = null;
            users[deleteUserDataIndex[0]][1] = null;

            System.out.println(ANSI_GREEN + "Deleted account." + ANSI_RESET);
        }
    }
    private static void RegisterUser(String[] commandArgs, String[][] users) {
        // handles registration

        if(checkUsernameExist(commandArgs, users)) return;

        Integer[] freeSlotIndex = new Integer[1];

        if (!Find(users,freeSlotIndex)) return;

        String username = commandArgs[1];
        String password = commandArgs[2];
        int freeSlot = freeSlotIndex[0];

        // save user
        users[freeSlot][0] = username;
        users[freeSlot][1] = password;

        System.out.println(ANSI_GREEN + "Registered user." + ANSI_RESET);
    }
    private static boolean Find(String[][] users, Integer[] freeSlotIndex){

        // finds and returns free slot and true; if there are no free slots returns false
        freeSlotIndex[0] = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i][0] == null) {
                freeSlotIndex[0] = i;
            }
        }

        // no free slots
        if (freeSlotIndex[0] == -1) {
            System.out.println(ANSI_RED + "The system supports a maximum number of 4 users." + ANSI_RESET);
           return false;
        }
        return true;
    }
    private static boolean Find(String[][] users, String username,String password, Integer[] userIndex){

        for (int i = 0; i < users.length; i++) {
            if (username.equals(users[i][0]) && password.equals(users[i][1])) {
                userIndex[0] = i;
            }
        }
        if (userIndex[0] == null) {
            System.out.println(ANSI_RED + "Invalid account/password." + ANSI_RESET);
            return false;
        }
        return true;
    }
    private static boolean DeleteUsernameIndex(String[] commandArgs, String[][] users,Integer[] deleteUserDataIndex){
        //returns the index of the user for deletion and checks if they can be deleted
        Integer[] accountIndex = new Integer[1];
        String username = commandArgs[1];
        String password = commandArgs[2];

        if(!Find(users, username, password, accountIndex))return false;


        deleteUserDataIndex[0] = accountIndex[0];
        return true;
    }
    private static boolean checkUsernameExist(String[] commandArgs, String[][] users) {
        //checks if the username exists
        for (String[] user : users) {
            if (commandArgs[1].equals(user[0])) {
                System.out.println(ANSI_RED + "Username already exists." + ANSI_RESET);
                return true;
            }
        }
        return false;
    }

    private static boolean validateArguments(String[] commandArgs) {
        //validates arguments
        if (commandArgs.length < 3) {
            System.out.println(ANSI_RED + "Too few parameters." + ANSI_RESET);
            return false;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (username.length() < 3) {
            System.out.println(ANSI_RED + "Username must be at least 3 characters long." + ANSI_RESET);
            return false;
        }

        // validate password
        if (password.length() < 3) {
            System.out.println(ANSI_RED + "Password must be at least 3 characters long." + ANSI_RESET);
            return false;
        }
        return true;
    }
}
