package com.utilities;

import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WrieteTextFIle {
    @Test
    public void writeDataInTextFile() throws IOException {
    //Stream Connectivity
        File f=new File("/Users/qed42/eclipse-workspace/SELENIUMBASICS/src/main/resources/Writefile.txt");
        FileWriter fw=new FileWriter(f,true);
        BufferedWriter writer=new BufferedWriter(fw);
    //Writing inside file
        writer.newLine();
        writer.write("This is new line of the textfile");
        writer.newLine();
        writer.write("My name is Manoj G Ithape");
        writer.close();
    }
}
