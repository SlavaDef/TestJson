package org.example.Module10Examples.LinkToMethod;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReferenses {

    private static List employees = Arrays.asList(
            new Employee(2,"Bob",UserStatus.ACTIVE),
            new Employee(3,"Sem",UserStatus.ACTIVE),
            new Employee(4,"Nigan",UserStatus.NOT_ACTIVE),
            new Employee(5,"Arni",UserStatus.NOT_ACTIVE));


    public static void main(String[] args) {

// интерфейс Consumer -> равен лямде вызов класа и его метода и передача в метод переменной лямды
        // если обольше методов в лямде то первій вариант

        Consumer<Employee> printEmployee = employee -> EmployeeUtil.printEmployee(employee);

        // Enother construction
        Consumer<Employee> printEmployeeWithReferance = EmployeeUtil::printEmployee;

        printEmployeeWithReferance.accept(new Employee(5,"Olga",UserStatus.ACTIVE));

        // если же методы не статические то логика другая но так же можна с ними работать как с сылкой на метод

            EmployeeUtil employeeUtil = new EmployeeUtil();

            Consumer<String> printNonStatMethod = name -> employeeUtil.printName(name);
            Consumer<String> printNonStatMethod2 = name -> new EmployeeUtil().printName(name);
            Consumer<String> printNonStatMethod3 = employeeUtil::printName;

            printNonStatMethod.accept(new Employee(7,"Helga",UserStatus.ACTIVE).getName());
            printNonStatMethod3.accept(new Employee("Jon").getName());
            printNonStatMethod2.accept("u");

            // non static method without class instanse
        BiConsumer<EmployeeUtil, String> printing = (emp, name) -> emp.printName(name);

        // with method referance

        BiConsumer<EmployeeUtil, String> printingWithReferanse = EmployeeUtil::printName;
        printingWithReferanse.accept(new EmployeeUtil(), "Messi");

        // constructor, creator instanse

        final Supplier<Employee> getEmplotee = () -> new Employee();

        // with method referance

        final Supplier<Employee> getEmplotee2WithotRef = Employee::new;
        getEmplotee2WithotRef.get();



    }
}
