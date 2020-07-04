package com.tianziyi.project06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter1 = new FileWriter("F:\\程序设计课程\\Java程序设计\\Java程序设计实验\\Source\\src\\com\\tianziyi\\project06\\myfile1.txt");
        FileWriter fileWriter2 = new FileWriter("F:\\程序设计课程\\Java程序设计\\Java程序设计实验\\Source\\src\\com\\tianziyi\\project06\\myfile2.txt");
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入学生学号（输入bye退出）:");
            String number = scanner.nextLine();
            if(number.equals("bye")){
                break;
            }
            else{
                String total = "学号：" + number + "\n";
                System.out.print("请输入学生姓名：");
                total += "姓名：" + scanner.nextLine() + "\n";
                System.out.print("请输入学生专业：");
                total += "专业：" + scanner.nextLine() + "\n";
                System.out.print("请输入学生班级：");
                total += "班级：" + scanner.nextLine() + "\n";
                System.out.print("请输入学生家庭住址：");
                total += "家庭住址：" + scanner.nextLine() + "\n";
                fileWriter1.write(total);
            }
        }
        fileWriter1.close();
        FileReader fileReader = new FileReader("F:\\程序设计课程\\Java程序设计\\Java程序设计实验\\Source\\src\\com\\tianziyi\\project06\\myfile1.txt");
        int ch = 0;
        while((ch = fileReader.read()) != -1){
            fileWriter2.write((char)ch);
        }
        fileReader.close();
        fileWriter2.close();
        System.out.println("Complete!");
    }
}
