package org.example.Module10Examples;


import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// данный интерфейс принимает два параметра в качестве обьекта в виде Т
public class BinaryOperatorTest {

    public static void main(String[] args) {

        Supplier<Integer> rendomGit = () -> new Random().nextInt(100)*10;

        BinaryOperator<Integer> multuply = (x,y) -> x * y; // логика в лямде

        final Integer result = multuply.apply(10,4); // вызов методом apply()


        System.out.println(result);
// совместил два интерфейса два рендома передаються в качестве х и у
        final Integer result2 = multuply.apply(rendomGit.get(),rendomGit.get());
        System.out.println(result2);

        // унарный оператор принимает один параметр и производит с ним вычесления

        UnaryOperator<Integer> unaryOperator = x -> x * x;
        final Integer resalt3 = unaryOperator.apply(5);
        System.out.println(resalt3);


    }
}
