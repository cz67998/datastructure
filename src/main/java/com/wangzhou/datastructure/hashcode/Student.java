package com.wangzhou.datastructure.hashcode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/13
 * Time:20:56
 **/
public class Student {
    int grade;
    int cls;
    String name;

    Student(int grade,
            int cls,
            String name) {
        this.grade = grade;
        this.cls = cls;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + name.toUpperCase().hashCode();
        return hash;
    }

    /**
     * 判断对象的属性是否一致
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        Student student=(Student) obj;
        return student.name.toUpperCase().equals(this.name.toUpperCase())&&student.cls==this.cls&&student.grade==this.grade;
    }
}
