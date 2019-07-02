package com.wangzhou.datastructure.comparator;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:16:34
 **/
@Data
public class Employeee {
    private String name;
    private double salary;

    public Employeee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public static void main(String[] args) {
        Employeee[] staff = new Employeee[3];
        staff[0] = new Employeee("Pig Bajie", 130000);
        staff[1] = new Employeee("Pig Bajie", 11000);
        staff[2] = new Employeee("Pig Bajie", 12000);
        Arrays.sort(staff,Comparator.comparing(Employeee::getName).thenComparing(Employeee::getSalary));
        for(Employeee employee:staff){
            System.out.println(employee.name+"::"+employee.salary);
        }
    }
}
