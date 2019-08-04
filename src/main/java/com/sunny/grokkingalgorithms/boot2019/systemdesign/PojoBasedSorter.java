package com.sunny.grokkingalgorithms.boot2019.systemdesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PojoBasedSorter {

    /*
    Given an employee object sort based on Id and then name
     */

     public static void sort(List<Employee> employees){
         Comparator<Employee> employeeComparator = new EmployeeComparator();
         Collections.sort(employees,employeeComparator);
     }


    public static void main(String[] args) {
        Employee emp1 = new Employee(123,"sunny","b2b");
        Employee emp2 = new Employee(100,"jagmohan","b2b");
        Employee emp3 = new Employee(99,"ramesh","b2b");
        Employee emp4 = new Employee(25,"suresh","b2b");
        Employee emp5 = new Employee(11,"kamlesh","b2b");
        Employee emp6 = new Employee(11,"arbaaz","b2b");
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
        System.out.println("before sorting " + employees);
        sort(employees);
        System.out.println("after sorting " + employees);

    }

}
