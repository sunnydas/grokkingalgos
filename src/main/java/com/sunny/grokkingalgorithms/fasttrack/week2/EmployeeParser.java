package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Employee{

  private int id;
  private String name;
  private int managerId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    if (getId() != employee.getId()) return false;
    if (getManagerId() != employee.getManagerId()) return false;
    return !(getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null);

  }

  @Override
  public int hashCode() {
    int result = getId();
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + getManagerId();
    return result;
  }

  @Override
  public String toString() {

    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", managerId=" + managerId +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }
}
/**
 * Created by sundas on 6/24/2018.
 */
public class EmployeeParser {

  /*
  A flat file with a specific format containing employee details has arrived.
                a) How do you load the file
                b) Implement Employee getEmployee(int empId)
                c) Implement Employee getManager(int empId)
                d) Implement List<Employee> getReportees(int empId)
   */


   private Map<Integer,Employee> employeeMap;

   private Map<Integer,List<Employee>> managerMap;

   private boolean initialized;

  public EmployeeParser(String employeeDataFile) {
    this.employeeDataFile = employeeDataFile;
  }

  private String employeeDataFile;

  private void initialize(){
    employeeMap = new HashMap<>();
    managerMap = new HashMap<>();
    try {
      File file = new File(employeeDataFile);
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader =
          new BufferedReader(fileReader);
      String line = null;
      int lineNum = 0;
      while((line
          = bufferedReader.readLine())
          != null){
        if(lineNum == 0){
          lineNum++;
          continue;
        }
        String[] empData = line.split(",");
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(empData[0]));
        employee.setName(empData[1]);
        employee.setManagerId(Integer.parseInt(empData[2]));
        employeeMap.put(employee.getId(),employee);
        lineNum++;
      }
      /*
      Populate manager map
       */
      Iterator<Map.Entry<Integer,Employee>> iterator =
          employeeMap.entrySet().iterator();
      while(iterator.hasNext()){
        Map.Entry<Integer,Employee> entry = iterator.next();
        List<Employee> reportees = new ArrayList<>();
        Iterator<Map.Entry<Integer,Employee>> iterator2 =
            employeeMap.entrySet().iterator();
        while(iterator2.hasNext()){
          Map.Entry<Integer,Employee> entry1 = iterator2.next();
          Employee employee = entry1.getValue();
          if(employee.getManagerId() == entry.getKey()){
            reportees.add(entry1.getValue());
          }
        }
        managerMap.put(entry.getKey(),reportees);
      }
    } catch (IOException e){
      e.printStackTrace();
    }
    initialized = true;
  }

  /**
   *
   * @param empId
   * @return
   */
  public Employee getEmployee(int empId){
    if(!initialized){
      initialize();
    }
    return employeeMap.get(empId);
  }

  /**
   *
   * @param empId
   * @return
   */
  public Employee getManager(int empId){
    if(!initialized){
      initialize();
    }
    Employee manager = null;
    if(employeeMap.containsKey(empId)){
      manager = employeeMap.get(employeeMap.
          get(empId).getManagerId());
    }
    return manager;
  }


  /**
   *
   * @param managerId
   * @return
   */
  public List<Employee> getReportees(int managerId){
    if(!initialized){
      initialize();
    }
    return managerMap.get(managerId);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String filename = "Employees";
    EmployeeParser employeeParser = new EmployeeParser(filename);
    System.out.println(employeeParser.getEmployee(1));
    System.out.println(employeeParser.getEmployee(2));
    System.out.println(employeeParser.getEmployee(3));
    System.out.println(employeeParser.getManager(1));
    System.out.println(employeeParser.getManager(2));
    System.out.println(employeeParser.getManager(3));
    System.out.println(employeeParser.getReportees(1));
    System.out.println(employeeParser.getReportees(2));
    System.out.println(employeeParser.getReportees(3));
  }

}
