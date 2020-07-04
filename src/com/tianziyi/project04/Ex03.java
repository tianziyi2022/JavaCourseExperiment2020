package com.tianziyi.project04;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;
import java.lang.reflect.Array;
import java.util.*;

public class Ex03 {
    public static void main(String[] args){
        JFrame frame = new JFrame("实验4.3");
        JPanel panel = new JPanel();
        JPanel cards = new JPanel(new CardLayout());
        frame.setBounds(500,500,700,510);
        Vector<String> name = new Vector(1);
        Vector<String> date = new Vector(1);
        Vector<String> score = new Vector(1);
        JTextField textField1 = new JTextField("",10);  //name
        JTextField textField2 = new JTextField("",10);  //year
        JTextField textField3 = new JTextField("",10);  //month
        JTextField textField4 = new JTextField("",10);  //day
        JTextField textField5 = new JTextField("",10);  //score
        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(textField4);
        panel.add(textField5);
        textField1.setForeground(Color.GRAY);
        textField1.setText("学生姓名");
        textField2.setForeground(Color.GRAY);
        textField2.setText("学生出生年");
        textField3.setForeground(Color.GRAY);
        textField3.setText("学生出生月");
        textField4.setForeground(Color.GRAY);
        textField4.setText("学生出生日");
        textField5.setForeground(Color.GRAY);
        textField5.setText("学生成绩");
        JButton button1 = new JButton("确定");
        JButton button2 = new JButton("排序");
        panel.add(button1);
        panel.add(button2);
        cards.add(panel,"card1");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a) throws NumberFormatException{
                String year = textField2.getText();
                String month = textField3.getText();
                String day = textField4.getText();
                if(year.length() != 4 | month.length() > 2 | day.length() > 2 ){
                    textField1.setForeground(Color.GRAY);
                    textField1.setText("学生姓名");
                    textField2.setForeground(Color.GRAY);
                    textField2.setText("学生出生年");
                    textField3.setForeground(Color.GRAY);
                    textField3.setText("学生出生月");
                    textField4.setForeground(Color.GRAY);
                    textField4.setText("学生出生日");
                    textField5.setForeground(Color.GRAY);
                    textField5.setText("学生成绩");
                }
                else{
                    JOptionPane.showConfirmDialog(null, "添加成功！", "Successful", JOptionPane.CLOSED_OPTION);
                    name.add(textField1.getText());
                    date.add(textField2.getText() + "年" + textField3.getText() + "月" + textField4.getText() + "日");
                    score.add(textField5.getText());
                }
            }
        });
        CardLayout c = (CardLayout)(cards.getLayout());
        c.show(cards,"card1");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置窗体
                JFrame frame1 = new JFrame("排序输出");
                frame1.setSize(500,200);
                Container contentPane = frame1.getContentPane();
                //获取数据数组
                String[] name1 = null;
                String[] date1 = null;
                String[] score1 = null;
                name1 = name.toArray(new String[0]);
                date1 = date.toArray(new String[0]);
                score1 = score.toArray(new String[0]);
                String[] temp = new String[name1.length];
                String[] name2 = new String[name1.length];
                String[] date2 = new String[name1.length];
                String[] score2 = new String[name1.length];
                String[][] students = new String[name1.length][3];
                temp = score1;
                Arrays.sort(temp);
                for(int i = 0;i < temp.length;i ++){
                    students[i][0] = name1[Arrays.binarySearch(score1,temp[i])];
                    students[i][1] = date1[Arrays.binarySearch(score1,temp[i])];
                    students[i][2] = score1[Arrays.binarySearch(score1,temp[i])];
                }
                //设置索引
                String[] col = new String[3];
                col[0] = "姓名";
                col[1] = "年月日";
                col[2] = "成绩";
                //设置面板
                JTable table=new JTable(students,col);
                contentPane.add(new JScrollPane(table));
                frame1.setVisible(true);
            }
        });
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
