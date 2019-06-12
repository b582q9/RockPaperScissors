package com.mycompany;

import java.util.Scanner;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsTest{

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
        String userInput="ROCK";
        String AIturn="ROCK";
        RockPaperScissors instance=new RockPaperScissors();
        boolean expResult=false;
        boolean result=instance.processResults(userInput,AIturn);
        assertEquals(expResult,result);
    }

    /**
     * Test of main method, of class RockPaperScissors.
     */
    @Test
    public void testMain(){
        System.out.println("main");
        String[] args=null;
        RockPaperScissors.main(args);
    }
}
