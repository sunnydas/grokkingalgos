package com.sunny.grokkingalgorithms.fasttrack.week9;

import com.sunny.grokkingalgorithms.fasttrack.week9.util.Employee;
import com.sunny.grokkingalgorithms.fasttrack.week9.util.EmployeeLoader;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sundas on 8/7/2018.
 */
public class OrderByImplementation {

  /*
  Implement order by for a given attribute
   */

  /**
   *
   * @param employees
   */
  public static void orderById(List<Employee> employees){
    if(employees != null && employees.size() > 0){
      Comparator<Employee> employeeComparator = (o1, o2) -> Integer.parseInt(o1.getId())
          - Integer.parseInt(o2.getId());
      Collections.sort(employees,employeeComparator);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) throws Exception{
    List<Employee> employees = EmployeeLoader.loadEmployees("employee.csv");
    System.out.println(employees);
    orderById(employees);
    System.out.println(employees);
  }

}
