package com.sunny.grokkingalgorithms.fasttrack.week9.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 8/7/2018.
 */
public class EmployeeLoader {


  /**
   *
   * @param fileName
   * @return
   * @throws Exception
   */
  public static List<Employee> loadEmployees(String fileName) throws Exception{
    File file = new File(fileName);
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line = null;
    List<Employee> employees = new ArrayList<>();
    while((line = bufferedReader.readLine()) != null){
      String[] empAtts = line.trim().split(",");
      if(line.startsWith("id")){
        continue;
      }
      else{
        Employee employee = new Employee();
        employee.setId(empAtts[0].trim());
        employee.setName(empAtts[1].trim());
        employee.setAge(Integer.parseInt(empAtts[2].trim()));
        employee.setSalary(Long.parseLong(empAtts[3].trim()));
        employee.setDep(empAtts[4]);
        employees.add(employee);
      }
    }
    return employees;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {

  }


}
