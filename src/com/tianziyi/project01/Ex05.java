package com.tianziyi.project01;

public class Ex05 {
    public static void main(String[] args) {
        for(int x=1;x<10;x++)
            for(int y=1;y<10;y++)
                for(int z=0;z<10;z++)
                    if(100*x+10*y+z+100*y+11*z==532){
                        System.out.println("x="+x);
                        System.out.println("y="+y);
                        System.out.println("z="+z);
                    }
    }
}
