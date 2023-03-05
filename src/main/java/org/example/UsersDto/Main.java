package org.example.UsersDto;

import org.example.UsersDto.Models.User;
import java.io.IOException;
import static org.example.UsersDto.Servise.HttpUtilUser.getUserByName;
import static org.example.UsersDto.Servise.HttpUtilUser.updateUser;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        User user11 = new User();
        user11.setId("5");

        //createUser(user11);
        //updateUser(user11);
       // deleteUser(user11);
        //infoAllUsers();
       // getUserById("4");
        getUserByName("Ervin Howell");
       // showAllOpenTasks("3");
       // showAllCommentsToPost("2");





    }
}
