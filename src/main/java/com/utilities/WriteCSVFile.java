package com.utilities;

import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    @Test
    public void writeDataInTextFile() throws IOException {//Stream Connectivity
    File f=new File("/Users/qed42/eclipse-workspace/SELENIUMBASICS/src/main/resources/WriteCSVfile.csv");
    FileWriter fw=new FileWriter(f,true);
    BufferedWriter writer=new BufferedWriter(fw);
    //Writing inside file
        for (int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                int count=(int) Math.random() *100;
                writer.write(count+",");
            }
            writer.newLine();
        }
        writer.close();
}
}
