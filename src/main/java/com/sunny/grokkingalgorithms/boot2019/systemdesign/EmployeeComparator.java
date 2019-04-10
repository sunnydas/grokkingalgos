package com.sunny.grokkingalgorithms.boot2019.systemdesign;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1 != null && o2 != null){
            int val = o1.getId() - o2.getId();
            if(val == 0){
                val = o1.getName().compareTo(o2.getName());
            }
            return val;
        }
        else if(o1 != null && o2 == null){
            return 1;
        }
        else if(o1 == null && o2 != null){
            return -1;
        }
        return 0;
    }
}
