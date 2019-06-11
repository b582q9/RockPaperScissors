package com.mycompany;

import java.util.Scanner;
import java.util.regex.Pattern;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RockPaperScissorsNGTest{

    public RockPaperScissorsNGTest(){
    }

    @BeforeClass
    public static void setUpClass() throws Exception{
    }

    @AfterClass
    public static void tearDownClass() throws Exception{
    }

    @BeforeMethod
    public void setUpMethod() throws Exception{
    }

    @AfterMethod
    public void tearDownMethod() throws Exception{
    }

    /**
     * Test of processInput method, of class RockPaperScissors.
     */
    @Test
    public void testProcessInput(){
        System.out.println("processInput");
        Pattern p=Pattern.compile("[rRpPsSvVhH_1-5]");
        Scanner in=new Scanner(System.in);
        RockPaperScissors instance=new RockPaperScissors();
        instance.processInput(p,in);
    }

    /**
     * Test of processResults method, of class RockPaperScissors.
     */
    @Test
    public void testProcessResults(){
        System.out.println("processResults");
        String userInput="r";
        String AIturn="r";
        RockPaperScissors instance=new RockPaperScissors();
        boolean expResult=true;
        boolean result=instance.processResults(userInput,AIturn);
        assertEquals(result,expResult);
    }

    /**
     * Test of main method, of class RockPaperScissors.
     */
    @Test
    public void testMain(){
        System.out.println("main");
        String[] args={"r"};
        RockPaperScissors.main(args);
    }
}
