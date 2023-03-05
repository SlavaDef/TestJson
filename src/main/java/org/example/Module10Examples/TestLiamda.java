package org.example.Module10Examples;

import java.util.*;
import java.util.function.Predicate;

public class TestLiamda {

    private static List<String> emails = Arrays.asList("one.com.ua", "two@gmail.com", "three@gmail.com", "four@ukr.net",
            "five@gmail.com", "six@org.ua", "seven@gmail.com");

    public static void main(String[] args) {

        Predicate<String> emailFunction = email -> email.contains("@gmail.com");

        // тут передаем лист и emailFunction с лямдой предикатом
        System.out.println(checkEmail(emails, emailFunction));

        // тут передаем лист и лямду
        System.out.println(checkEmail(emails, email -> email.contains("@gmail.com")));



       // Collections.sort(emails, (o1,o2) -> o1.length()-o2.length());
       // System.out.println(emails);

    }
    // создавать свои функциональные интерфейсы не дело, лутче использовать существующие Predicate for example
    private static List<String> checkEmail(List<String> emails, Predicate<String> function){
// метод добавляет в новый лист  email.contains("@gmail.com") которое выполняеться в лямде
        List<String> res = new ArrayList<>();

        for(String email: emails){
            if(function.test(email)){
                res.add(email);
            }
        }
              return res;
    }
}
