package com.utilities;

import org.testng.annotations.*;

import java.io.*;

public class ReadTextFile {
    @Test
    public void readFile() throws IOException {
    //Establish Connection
        File f=new File("/Users/qed42/eclipse-workspace/SELENIUMBASICS/src/main/resources/WriteCSVfile.csv");
        FileReader fr=new FileReader(f);
        BufferedReader reader=new BufferedReader(fr);
    //Read file
        String line="";
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
    }
}
