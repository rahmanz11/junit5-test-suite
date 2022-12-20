package com.test.suite.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(InsuranceProgramTest.class)
public class InsuranceProgramTestSuite {

    public static Parameters parameters = new Parameters();

    /**
     * Test @BeforeAll
     */
    @BeforeAll
    static void initialize() {
        System.out.println("@BeforeAll: initializing the parameters with empty object");
        parameters = new Parameters();
    }

    /**
     * Test @BeforeEach
     */
    @BeforeEach
    void setParameters() {
        System.out.println("@BeforeEach: setting up the parameters");
        parameters.setAge(25);
        parameters.setAccidents(2);
    }

    
    /**
     * Test @AfterEach
     * This will be executed after each individual test
     */
    @AfterEach
    void clearParameters() {
        System.out.println("@AfterEach: clearing up(initializing with 0) the set parameters");
        parameters.setAge(0);
        parameters.setAccidents(0);
        parameters.setInsurance(0);
    }

    /**
     * Test @AfterAll
     * This will be executed finally after all tests are executed
     */
    @AfterAll
    static void destroy() {
        System.out.println("@AfterAll: finally set the parameters object to null");
        parameters = null;
    }
}
