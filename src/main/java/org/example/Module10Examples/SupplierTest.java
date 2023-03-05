package org.example.Module10Examples;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

// интерфейс Supplier возвращает обьект, пример хотим получить рендом число

        Supplier<Integer> rendomGit = () -> new Random().nextInt(100)*50;

// теперь будем получать какоето рендомное число + вызов метода get()

        System.out.println(rendomGit.get());
        System.out.println(rendomGit.get());
        System.out.println(rendomGit.get());
        System.out.println(rendomGit.get());
        System.out.println(rendomGit.get());
    }
}
