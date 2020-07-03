package com.tianziyi.project01;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    private String name;
    private Integer age;
    private String birthday;
    private Double score;
    static Double ageAverage;
    static Double ageSum;
    static Double scoreAverage;
    static Double scoreSum;
    public Student(String name, Integer age, String birthday, Double score) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Student.ageSum=0.0;
        Student.scoreSum=0.0;
        System.out.print("请输入要输入的学生信息数量：");
        int count = scanner.nextInt();
        for(int i=0;i<count;i++){
            System.out.print("请输入第"+(i+1)+"个学生姓名：");
            String name = scanner.next();
            System.out.print("请输入第"+(i+1)+"个学生年龄：");
            int age = scanner.nextInt();
            Student.ageSum+=age;
            System.out.print("请输入第"+(i+1)+"个学生生日：");
            String birthday = scanner.next();
            System.out.print("请输入第"+(i+1)+"个学生成绩：");
            Double score = scanner.nextDouble();
            Student.scoreSum+=score;
            Student student = new Student(name,age,birthday,score);
            students.add(student);
        }
        Student.ageAverage=Student.ageSum/count;
        Student.scoreAverage=Student.scoreSum/count;
        System.out.println("学生平均年龄为："+Student.ageAverage);
        System.out.println("学生平均成绩为："+Student.scoreAverage);
    }

}
