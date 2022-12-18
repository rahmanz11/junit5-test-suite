package com.test.suite.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
 
public class InsuranceProgramTest {
	
	private InsuranceProgramTest(TestInfo testInfo) {
	    System.out.println("Working on test " + testInfo.getDisplayName());
	}
     
    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }
     
    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }
    
    @Test
    void testCalAdd()
    {
        System.out.println("======testCalAdd EXECUTED=======");
        Assertions.assertEquals( 4 , InsuranceProgram.printInsuranceInformation(2, 2));
    }
         
    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }
     
    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
}
