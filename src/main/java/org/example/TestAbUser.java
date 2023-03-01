package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.HttpUtilUser.getUserById;

public class TestAbUser {

    private static  final String CREATE_USER_URL = " https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {
         User user11 = new User();

       /* final User createdAbuser = HttpUtil.sendPost(URI.create(CREATE_USER_URL),user11);

        System.out.println(createdAbuser); */
      // System.out.println( HttpUtilUser.createUser(user11));
       // System.out.println( HttpUtilUser.updateUser(user11));
        //System.out.println(HttpUtilUser.deleteUser(user11));
        System.out.println(HttpUtilUser.infoAllUsers());
        //HttpUtilUser.getUserById("6");




    }


}
