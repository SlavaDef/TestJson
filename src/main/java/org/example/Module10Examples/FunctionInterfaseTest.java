package org.example.Module10Examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

class FunctionInterfaceTest {
    // задача посчитать сколько букв в каждом ємейле

    private static List<String> emails = Arrays.asList("one.com.ua", "two@gmail.com", "three@gmail.com", "four@ukr.net",
            "five@gmail.com", "six@org.ua", "seven@gmail.com");

    public static void main(String[] args) {

        //  Function интерфейс принимающий один тип данных i конвертирующий его в другой
System.out.println("Before");
        Function<Integer,Double> function = value -> value * 0.2; // лямда приходит значение инт умножено на 0.2
// лямді як би отложенні дії

        System.out.println("After");
        final double aply = function.apply(100);
        System.out.println(aply);


        // в мейне нужно реализовать лямда выражения для того чтобы функционал интерфейс заработал
        Function<String,Integer> function2 = value -> value.length();

        // далее в наш метод передаем список и этот интерфейс
        //System.out.println(calculateLetters(emails,function2));
        // можно передати одразу в метод лямду
        System.out.println(calculateLetters(emails, value -> value.length()));
        //System.out.println(calculateLetters2(emails));

        // Consumer Example меняем вид вывода

        Consumer<Map<String,Integer>> consumer = map -> {

            for(Map.Entry<String,Integer> entery : map.entrySet()){
System.out.println("Email: "+ entery.getKey() + " have " + entery.getValue() + " letters");
            }
        };

consumer.accept(calculateLetters(emails, value -> value.length()));

    }

    //  робимо метод мапу для підрахунку

    private static Map<String,Integer> calculateLetters(List<String> emails, Function<String,Integer> function){
        Map<String,Integer> res = new HashMap<>();
       for (String email : emails){
      // res.put(email, email.length());
       res.put(email, function.apply(email));
}


return  res;
    }

    private static Map<String,Integer> calculateLetters2(List<String> emails){
        Map<String,Integer> res = new HashMap<>();
        for (String email : emails) {
            res.put(email, email.length());
        }


        return  res;
    }
}

