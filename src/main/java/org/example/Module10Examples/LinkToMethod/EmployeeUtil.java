package org.example.Module10Examples.LinkToMethod;

public class EmployeeUtil {

    public static void printEmployee(Employee employee){
        System.out.println("Employee indef is " + employee.getId());
        System.out.println("Employee name is " + employee.getName());
    }

    public void printName(String employee){
        System.out.println("Employee name "+ employee);
    }
}
