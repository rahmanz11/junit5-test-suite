package com.test.suite.junit5;

import static org.junit.Assert.assertThrows;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class InsuranceProgramTest {

    private InsuranceProgramTest(TestInfo testInfo) {
        System.out.println("Starting the test: " + testInfo.getDisplayName());
    }

    /**
     * Test for age less than 25
     */
    @Test
    void testAgeNotLessThan25() {
        System.out.println("======testAgeNotLessThan25 EXECUTED=======");
        InsuranceProgramTestSuite.parameters.setInsurance(650);
        assertEquals(InsuranceProgramTestSuite.parameters);
    }

    /**
     * Parameterized Test 
     * @param parameters
     */
    @ParameterizedTest
    @MethodSource("setupParameters")
    void parameterizedTestAgeNotLessThan25(Parameters parameters) {
        System.out.println("======parameterizedTestAgeNotLessThan25 EXECUTED=======");
        assertEquals(parameters);
    }

    /**
     * Test for age more than or equal 25
     */
    @Test
    void testAgeLessThan25() {
        System.out.println("======testAgeLessThan25 EXECUTED=======");
        InsuranceProgramTestSuite.parameters = new Parameters(20, 1, 650);
        assertEquals(InsuranceProgramTestSuite.parameters);
    }

    /**
     * Test timeout
     */
    // timed out after 10 seconds
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testTimeout() {
        System.out.println("======testTimeout EXECUTED=======");
        System.out.println("Timeout will happen after 10 seconds");
    }

    /**
     * Test Numberformat exception
     */
    @Test
    void testNumberFormatException() {
        System.out.println("======testNumberFormatException EXECUTED=======");
        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        }, "NumberFormatException was expected");

        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());
    }

    /**
     * Test Nullpoint exception
     */
    @Test
    public void testNullPointerException() {
        System.out.println("======testNullPointerException EXECUTED=======");
        assertThrows(NullPointerException.class, () -> {
            String test = null;
            test.length();
        });
    }

    /**
     * Assert equals
     * @param parameters
     */
    private void assertEquals(Parameters parameters) {
        Assertions.assertEquals(parameters.getInsurance(), InsuranceProgram.getInsurance(parameters));
    }

    /**
     * Prepare parameter for Patameterized Test
     * @return
     */
    private static Stream<Parameters> setupParameters() {
        return Stream.of(
                new Parameters(23, 2, 725));
    }
}
