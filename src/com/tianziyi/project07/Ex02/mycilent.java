package com.tianziyi.project07.Ex02;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class mycilent {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket=new Socket("127.0.0.1",2001);
        new ChatTCPSocketJFrame("清泉。",socket);
    }
}
