package org.example.Module10Examples.LinkToMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreemDemo {

private static List<Employee> emp = new ArrayList<>(Arrays.asList(
        new Employee(5,"Jason",UserStatus.ACTIVE),
        new Employee(1,"Sidni",UserStatus.ACTIVE),
        new Employee(3,"Macha",UserStatus.NOT_ACTIVE),
        new Employee(2,"Semen",UserStatus.NOT_ACTIVE),
        new Employee(40,"April",UserStatus.ACTIVE),
        new Employee(18,"Bob",UserStatus.NOT_ACTIVE),
        new Employee(11,"Djeck",UserStatus.NOT_ACTIVE),
        new Employee(99,"Kate",UserStatus.ACTIVE),
        new Employee(47,"Niga",UserStatus.NOT_ACTIVE),
        new Employee(8,"Jei",UserStatus.NOT_ACTIVE)));


    public static void main(String[] args) {

// задача отсортировать сотрудников по статусу, отсортировать по id + получить только имена

        // до появления стримов

        List<Employee> sortByStatys = new ArrayList<>();
        for(Employee employee : emp) {
            if(employee.getStatus().name().equals(UserStatus.ACTIVE.name())){
                sortByStatys.add(employee);
            }
        }
          System.out.println(sortByStatys);

        sortByStatys.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getId(),o2.getId());
            }
        });

        List<String> empNames = new ArrayList<>();
        for(Employee employee : sortByStatys){
            empNames.add(employee.getName());
        }

        System.out.println(empNames);

        List<String> empWithStream = emp.stream()
                .filter(employee -> employee.getStatus().name().equals(UserStatus.ACTIVE.name()))
                //.sorted((o1, o2) -> Integer.compare(o1.getId(),o2.getId()))
                .sorted(Comparator.comparingInt(Employee::getId)) // вариант короче
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(empWithStream);
    }
}
