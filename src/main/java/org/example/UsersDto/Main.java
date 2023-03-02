package org.example.UsersDto;

import org.example.UsersDto.Models.User;
import org.example.UsersDto.Servise.HttpUtilUser;

import java.io.IOException;

import static org.example.UsersDto.Servise.HttpUtilUser.*;
import static org.example.UsersDto.Servise.HttpUtilUser.getUserByName;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        User user11 = new User();

        //createUser(user11);
       // updateUser(user11);
       // deleteUser(user11);
        infoAllUsers();
       // getUserById("4");
       // getUserByName("Patricia Lebsack");
       // showAllOpenTasks("3");
       // showAllCommentsToPost("2");





    }
}
