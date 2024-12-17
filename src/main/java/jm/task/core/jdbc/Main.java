package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("John","Doe", (byte) 25);
        userService.saveUser("Gill","Robinson", (byte) 41);
        userService.saveUser("Jane","Lindell", (byte) 32);
        userService.saveUser("Bobby","Fisher", (byte) 55);
        userService.saveUser("John","Doe", (byte) 25);

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        




    }
}
