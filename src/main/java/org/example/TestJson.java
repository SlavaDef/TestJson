package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class TestJson {

    public static void main(String[] args) throws IOException {

        Doctor doctor = new Doctor("Toma", 22,"+987456",8);
        Doctor doctor2 = new Doctor("Bob", 24,"+98777456",5);

        Doctor[] doctors = {doctor,doctor2}; // створили масив обьектів
        List<Doctor> doctors1 = List.of(doctor,doctor2); // чи ліст юзерів

        Gson gson = new Gson();
        String toJson = gson.toJson(doctor); // конвертувати у Gson формат
        System.out.println(toJson);

        // так буде мати інший вигляд

        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        String toJson1 = gson1.toJson(doctor);
        System.out.println(toJson1);

        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        String toJson2 = gson2.toJson(doctors); // закинули масив докторів
        String toJson3 = gson2.toJson(doctors1); // закинули лист докторів
        System.out.println(toJson2);
        System.out.println(toJson3);

        // тепер записуємо в файл

        OutputStream fos = new FileOutputStream("Users.json"); // через змінну
        fos.write(toJson1.getBytes());

        new FileOutputStream("Users2.json").write(toJson2.getBytes()); // напряму

        // також можемо записати через FileWriter який непогано оптимізований під json

        FileWriter fw = new FileWriter("Users3.json"); // створюємо записник в файл
        gson2.toJson(doctors,fw); // що записуємо і куди тобто обьект який хо записати і куди
        fw.close(); // не забуваємо закрити бо не запишеться

    }
}
