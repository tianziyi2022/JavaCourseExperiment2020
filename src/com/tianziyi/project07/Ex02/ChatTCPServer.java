package com.tianziyi.project07.Ex02;

import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ChatTCPServer extends JFrame implements ActionListener {
    private String name,name2;                                   //网名
    private JTextArea text_receiver;                       //显示对话内容的文本区
    private JTextField text_sender;                        //输入发送内容的文本行
    private PrintWriter cout,cout2;                              //格式化字符输出流
    private JButton[] buttons;                             //按钮数组

    public ChatTCPServer(String name, Socket socket,String name2,Socket socket2) throws IOException{  //指定端口和网名                               super("聊天室  "+name+"  "+InetAddress.getLocalHost()+" : "+socket.getLocalPort());
        this.setBounds(320,240,400,240);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.text_receiver = new JTextArea();
        this.text_receiver.setEditable(false);             //文本区不可编辑
        this.getContentPane().add(new JScrollPane(this.text_receiver));
        JToolBar toolbar = new JToolBar();                 //工具栏
        this.getContentPane().add(toolbar,"South");
        toolbar.add(this.text_sender=new JTextField(30));
        String[] buttonstr={"发送","离线"};
        buttons=new JButton[buttonstr.length];
        for (int i=0; i<buttonstr.length; i++){
            toolbar.add(buttons[i]=new JButton(buttonstr[i]));
            buttons[i].addActionListener(this);
        }
        this.setVisible(true);

        this.name = name;
        this.name2 = name2;
        this.cout = new PrintWriter(socket.getOutputStream(),true);//获得Socket的输出流，立即flush
        this.cout2 = new PrintWriter(socket2.getOutputStream(),true);
        this.cout.println(name);                           //发送自己网名给对方
        this.cout2.println(name);
        mythread s1 = new mythread(socket, text_receiver,"清泉。",socket2);
        mythread s2 = new mythread(socket2, text_receiver,"田梓毅",socket);
        s1.start();
        s2.start();
    }

    public static void main(String args[]) throws IOException{
        ServerSocket ss=new ServerSocket(2001);
        ServerSocket ss2=new ServerSocket(2002);
        Socket s=ss.accept();
        Socket s2=ss2.accept();
        new ChatTCPServer("服务器", s, "服务器", s2);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getActionCommand().equals("发送"))
        {
            this.cout.println(name+" ："+text_sender.getText()); //通过输出流发送给对方
            this.cout2.println(name+" ："+text_sender.getText()); //通过输出流发送给对方
            text_receiver.append("我："+text_sender.getText()+"\n");
            text_sender.setText("");
        }
        if (ev.getActionCommand().equals("离线"))
        {
            text_receiver.append("我离线\n");
            this.cout.println(name+"离线\n"+"bye\n");
            this.cout2.println(name+"离线\n"+"bye\n"); //发送给对方离线约定
            buttons[0].setEnabled(false);
            buttons[1].setEnabled(false);
        }
    }
}

