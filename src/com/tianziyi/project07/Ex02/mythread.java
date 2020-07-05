package com.tianziyi.project07.Ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class mythread extends Thread{
    Socket socket,socket2;
    JTextArea text_receiver;
    String name;
    public mythread(Socket socket,JTextArea text_receiver,String name,Socket socket2) {
        this.socket=socket;
        this.text_receiver=text_receiver;
        this.name=name;
        this.socket2=socket2;
    }
    public void run () {
        BufferedReader br;
        PrintWriter cout;
        String line;
        try {
            cout=new PrintWriter(socket2.getOutputStream(),true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            line = "连接"+br.readLine()+"成功";
            while (line!=null && !line.endsWith("bye")) {
                text_receiver.append(line+"\r\n");
                //显示对方发来的内容
                // line=name+"说："+line;
                cout.println(line);
                line=br.readLine();                            //从输入流接收对方发来的字符串
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }               //接收到对方网名
    }
}
