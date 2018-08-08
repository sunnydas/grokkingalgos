package com.sunny.grokkingalgorithms.fasttrack.week9.util;

/**
 * Created by sundas on 8/7/2018.
 */
public class Employee {

  /*
  id,name,age,salary,dep
1,ramesh s,32,600000,a1
2,guru ram,30,500000,a2
3,kamlesh t,27,400000,a1
4,amish t,42,900000,a3
5,taresh l,29,400000,a2
   */

  @Override
  public String toString() {
    return "Employee{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        ", dep='" + dep + '\'' +
        '}';
  }

  private String id;

  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    if (getAge() != employee.getAge()) return false;
    if (getSalary() != employee.getSalary()) return false;
    if (getId() != null ? !getId().equals(employee.getId()) : employee.getId() != null) return false;
    if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
    return !(getDep() != null ? !getDep().equals(employee.getDep()) : employee.getDep() != null);

  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + getAge();
    result = 31 * result + (int) (getSalary() ^ (getSalary() >>> 32));
    result = 31 * result + (getDep() != null ? getDep().hashCode() : 0);
    return result;
  }

  private int age;

  private long salary;

  private String dep;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }
}
