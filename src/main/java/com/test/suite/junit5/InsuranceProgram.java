package com.test.suite.junit5;

public class InsuranceProgram {

    private static int basicInsurance = 500;
    private final static int surcharge = 100; // under 25 years

    /**
     * Get the insurance
     * @param parameters
     * @return insurance
     */
    public static int getInsurance(Parameters parameters) {
        basicInsurance = 500;
        int age = parameters.getAge();
        int accidents = parameters.getAccidents();

        System.out.println("Your age: " + String.valueOf(age));
        System.out.println("Accidents did you have are: " + String.valueOf(accidents));

        if(accidents > 6) {
            System.out.println("No insurance");
            return 0;
        }

        if(age < 25) {
            basicInsurance += surcharge; 
            System.out.println("Additional surcharge " + surcharge);
        }

        return calculateInsurance(accidents, basicInsurance);
    }

    /**
     * Calculate insurance
     * @param accidents
     * @param basicInsurance
     * @return insurance
     */
    private static int calculateInsurance(int accidents, int basicInsurance) {
        int additionalSurcharge = 0;
        switch (accidents) {
            case 0:
                break;
            case 1: 
                additionalSurcharge = 50; // Pay 650 
                break;
            case 2:
                additionalSurcharge = 125; // Pay 725 
                break; 
            case 3:
                additionalSurcharge = 225; // Pay 825
                break;
            case 4:
                additionalSurcharge = 375; // Pay 975
                break;
            case 5:
                additionalSurcharge = 575; // Pay 1175
                break;
        }
        
        if (additionalSurcharge == 0) {
            System.out.println("No surcharge");
        } else {
            System.out.println("Additional surcharge for accident: " + additionalSurcharge);
            basicInsurance += additionalSurcharge;
        }
        
        System.out.println("Total amount to pay: " + basicInsurance);
        return basicInsurance;
    }
}