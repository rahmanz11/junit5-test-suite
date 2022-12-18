package com.test.suite.junit5;

public class InsuranceProgram {

    private static int basicInsurance = 500;
    private final static int surcharge = 100; // under 25 years

    public static int printInsuranceInformation(int age, int accidents) {
        System.out.print("Your age: " + String.valueOf(age));
        System.out.print("\nAccidents did you have are: " + String.valueOf(accidents));

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

    private static int calculateInsurance(int accidents, int basicInsurance) {
        switch (accidents) {
            case 0: System.out.println("No surcharge");
                    System.out.println("Total amount to pay: " + basicInsurance);
                    break;
            case 1: System.out.println("Additional surcharge for accident: " + 50 + " \ntotal amount to pay: " + (basicInsurance + 50)); // Pay 650
            break;
            case 2: System.out.println("Additional surcharge for accident: " + 125 + " \ntotal amount to pay: " + (basicInsurance + 125)); // Pay 725
            break; 
            case 3: System.out.println("Additional surcharge for accident: " + 225 + " \ntotal amount to pay: " + (basicInsurance + 225)); // Pay 825
            break;
            case 4: System.out.println("Additional surcharge for accident: " + 375 + " \ntotal amount to pay: " + (basicInsurance + 375)); // Pay 975
            break;
            case 5: System.out.println("Additional surcharge for accident: " + 575 + " \ntotal amount to pay: " + (basicInsurance + 575)); // Pay 1175
            break;
        }

        return basicInsurance;
    }
}