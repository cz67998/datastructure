package com.wangzhou.datastructure.comparator;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:17:13
 **/
public class Person implements Comparable<Person>{

    private String name;

    private int age;

    public Person(String name,int age){

        this.name=name;

        this.age=age;

    }

    public String toString(){

        return "姓名："+this.name+" 年龄："+this.age;

    }

    public int compareTo(Person per){

        if(this.age>per.age){

            return 1;

        }else if(this.age==per.age){

            return 0;

        }else{

            return -1;

        }

    }

}

 class SetDemo03{

    public static void main(String args[]){

        Set<Person> allSet=new TreeSet<Person>();

        allSet.add(new Person("张三",22));

        allSet.add(new Person("李四",23));

        allSet.add(new Person("王五",21));

        allSet.add(new Person("王五",21));

        allSet.add(new Person("王五",21));

        allSet.add(new Person("赵六",32));

        allSet.add(new Person("孙七",11));

        System.out.println(allSet);

    }

}
