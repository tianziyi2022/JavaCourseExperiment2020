package com.tianziyi.project07;

import java.net.*;
import java.io.*;

public class Ex01{
    public static void main (String[] args) {
        try{
            String str;
            int i=0;
            ServerSocket serverSocket = new ServerSocket(712);
            Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Verifying Server!");
            while((str=in.readLine())!=null){
                System.out.print("Input PassWord:"+str+"\n");
                if(i==2) {
                    out.println("Illegal User!");
                    System.out.println("Illegal User!");
                }else if(str.equals("123456")) {
                    out.println("Registration Successful!");
                    System.out.println("Registration Successful!");
                }else {
                    out.println("PassWord Wrong!");
                    System.out.println("PassWord Wrong!");
                }

                i++;
            }
            in.close();
            bufferedReader.close();
            out.close();
            socket.close();
        } catch(SocketException e){
            System.exit(0);
        } catch(IOException e){
            System.exit(0);
        }
    }

}

class MyClientA {
    public static void main (String args[]){
        try {
            String str=" ";
            Socket socket=new Socket("127.0.0.1",712);
            if(socket.isConnected() == true) System.out.println("Connect Success!");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
            while((str=bufferedReader.readLine())!=null) {
                if (str.equals("Verifying Server!")) break;
                else System.out.print("Server Wrong!");
            }
            System.out.print("Input PassWord:");
            str = bufferedReader1.readLine();
            printStream.println(str);
            str = bufferedReader.readLine();
            while(str!=null){
                if(str.equals("PassWord Wrong!")) {
                    System.out.println("PassWord Wrong!");
                    System.out.print("Input PassWord:");
                    str=bufferedReader1.readLine();
                    printStream.println(str);
                    str = bufferedReader.readLine();
                }
                else if(str.equals("Illegal User!")) {
                    System.out.println("Illegal User!");
                    System.exit(0);
                }else if(str.equals("Registration Successful!")) {
                    System.out.println("Registration Successful!");
                    System.exit(0);
                }
            }
            bufferedReader.close();
            bufferedReader1.close();
            printStream.close();
            socket.close();
        }catch(IOException e){
//            e.printStackTrace();
            System.exit(0);
        }
    }
}
