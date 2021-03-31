package com.tianziyi.project08;

import java.sql.*;

public class Ex01 {
    private Connection con;
    private Statement sta;
    private ResultSet rs;
    public static void main(String[] args) throws Exception {
        Ex01 sq = new Ex01();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=sq.getConnection();
        Statement statement=conn.createStatement();
//        String sql1="create table StudentInformation(Name CHAR(10), Sno CHAR(10) primary key ,Age int, Sex char(2))";
        String sql2="insert into student(Name,Number,Age,Sex) values('田梓毅','185250','20','男')";
        String sql3="select * from student where Age>18";
        String sql4="create table Score(Name char(10),Number char(10),score1 int)";
        String sql5="insert into Score(Name,Number,score1) values('张三','190000','98')";
        String sql9="insert into Score(Name,Number,score1) values('王四','170000','100')";
        String sql6="update Score set score1=59 where score1=100";
        String sql7="delete from Score where score1=99";
        String sql8="select * from Score ";
        statement.executeUpdate(sql2);
        ResultSet rs = statement.executeQuery(sql3);
        System.out.println("学生信息：");
        while(rs.next()) {
            String name=rs.getString("Name");
            String sno=rs.getString("Number");
            int age=rs.getInt("Age");
            String sex=rs.getString("Sex");
            System.out.println("姓名:"+name+"\t"+"学号:"+sno+"\t"+"年龄:"+age+"\t"+"性别:"+sex+"\t");
        }
        statement.execute(sql4);
        statement.executeUpdate(sql5);
        statement.executeUpdate(sql9);
        statement.executeUpdate(sql6);
        statement.executeUpdate(sql7);
        rs=statement.executeQuery(sql8);
        System.out.println("学生成绩：");
        while(rs.next()) {
            String name=rs.getString("Name");
            String sno=rs.getString("Number");
            int score1=rs.getInt("score1");
            System.out.println("姓名:"+name+"\t"+"学号:"+sno+"\t"+"成绩:"+score1+"\t");
        }
    }
    public Connection getConnection(){
        String url = "jdbc:mysql://****************";
        try {
            con = DriverManager.getConnection(url, "****", "**********");
            sta = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return con;
    }

}
