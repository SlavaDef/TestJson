package org.example.UsersDto;

import org.example.UsersDto.Servise.HttpUtilUser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        new HttpUtilUser().showAllCommentsToPost("2");


    }
}
