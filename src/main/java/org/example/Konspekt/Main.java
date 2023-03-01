package org.example.Konspekt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.UsersDto.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args) {

        List<User> users = new ArrayList<>();
       // users.add(new User("Alis", 20));
      //  users.add(new User("Bob", 25));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println(json);
    }
}