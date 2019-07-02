package com.wangzhou.datastructure.comparator;

import lombok.Data;

import java.util.Arrays;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:16:34
 **/
@Data
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return name.length()-other.name.length();
    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Sun Wukong", 130000);
        staff[1] = new Employee("Pig Bajie", 11000);
        staff[2] = new Employee("Sha Wujing", 12000);
        Arrays.sort(staff);
        for(Employee employee:staff){
            System.out.println(employee.name+"::"+employee.salary);
        }
    }
}
