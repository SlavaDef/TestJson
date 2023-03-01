import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

    public static void main(String[] args) {
        Person person = new Person("Bill", 30, true, 1.78);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person);

        System.out.println(json);
    }
}

class Person {
    private String name;
    private int age;
    private boolean married;
    private double height;

    public Person(String name, int age, boolean married, double height) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public double getHeight() {
        return height;
    }


}
