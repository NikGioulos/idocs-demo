package com.idocs.exam.gioulos.tests;

import com.idocs.demo.gioulos.DemoMain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DemoTest {

    @Test
    public void demoMain_Test(){
        String i1 = "C:\\playground\\i1.txt";
        String i2 = "C:\\playground\\i2.txt";
        String o = "C:\\playground\\o.txt";
        String[] args = new String[]{i1,i2,o};
        try {
            DemoMain.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
