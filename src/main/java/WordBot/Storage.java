package WordBot;

import java.util.ArrayList;

public class Storage {

    private ArrayList<String> quoteList;

    Storage() {
        quoteList = new ArrayList<>();
        quoteList.add("Чиназес Шева");
        quoteList.add("80% успеха - это появиться в нужном месте в нужное время.\n\nВуди Аллен");
        quoteList.add("Мы должны признать очевидное: понимают лишь те,кто хочет понять.\n\nБернар Вербер");
        quoteList.add("Чина");
        quoteList.add("Шева Спикулянт");
        quoteList.add("Доброго вечора ми з Нівок");
        quoteList.add("Чиназес");
        quoteList.add(" Шева чиназес");
    }

    String getRandQuote()
    {
        //получаем случайное значение в интервале от 0 до самого большого индекса
        int randValue = (int)(Math.random() * quoteList.size());
        //Из коллекции получаем цитату со случайным индексом и возвращаем ее
        return quoteList.get(randValue);
    }
}
