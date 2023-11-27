package io3;

import java.io.PrintWriter;

public class App2 {
    public static void main(String[] args) throws Exception
    
    {

        /*
         * PrintWriter
         * -
         */
        PrintWriter writer = new PrintWriter("src/io3/data2.csv");

        writer.println("김유신,100,100,100");
        writer.println("김유신,100,100,100");
        writer.println("김유신,100,100,100");

        writer.flush();

        writer.close();
    }
}
