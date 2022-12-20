package com.test.suite.junit5;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class InsuranceProgramTest {

    private static Parameters parameters = new Parameters();

    private InsuranceProgramTest(TestInfo testInfo) {
        System.out.println("Starting the test: " + testInfo.getDisplayName());
    }

    @BeforeAll
    static void initialize() {
        System.out.println("@BeforeAll: initializing the parameters with empty object");
        parameters = new Parameters();
    }

    @BeforeEach
    void setParameters() {
        System.out.println("@BeforeEach: setting up the parameters");
        parameters.setAge(25);
        parameters.setAccidents(2);
    }

    @Test
    void testAgeNotLessThan25() {
        System.out.println("======testAgeNotLessThan25 EXECUTED=======");
        Assertions.assertEquals(600, InsuranceProgram.getInsurance(parameters));
    }

    @ParameterizedTest
    @MethodSource("setupParameters")
    void parameterizedTestAgeNotLessThan25(Parameters parameters) {
        System.out.println("======parameterizedTestAgeNotLessThan25 EXECUTED=======");
        Assertions.assertEquals(parameters.getInsurance(), InsuranceProgram.getInsurance(parameters));
    }

    @Test
    void testAgeLessThan25() {
        System.out.println("======testAgeNotLessThan25 EXECUTED=======");
        parameters = new Parameters(20, 1);
        Assertions.assertEquals(600, InsuranceProgram.getInsurance(parameters));
    }

    @AfterEach
    void clearParameters() {
        System.out.println("@AfterEach: clearing up(initializing with 0) the set parameters");
        parameters.setAge(0);
        parameters.setAccidents(0);
        parameters.setInsurance(0);
    }

    @AfterAll
    static void destroy() {
        System.out.println("@AfterAll: finally set the parameters object to null");
        parameters = null;
    }

    // timed out after 10 seconds
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testTimeout() {
        System.out.println("======testTimeout EXECUTED=======");
        System.out.println("Timeout will happen after 10 seconds");
    }

    private static Stream<Parameters> setupParameters() {
        return Stream.of(
                new Parameters(44, 1, 600),
                new Parameters(38, 6, 600),
                new Parameters(23, 2, 700));
    }
}
