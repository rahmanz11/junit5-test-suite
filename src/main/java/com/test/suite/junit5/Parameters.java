package com.test.suite.junit5;

import java.io.Serializable;

public class Parameters implements Serializable {
    private int age;
    private int accidents;
    private int insurance;

    public Parameters() {
        super();
    }

    public Parameters(int age, int accidents) {
        super();
        this.age = age;
        this.accidents = accidents;
    }

    public Parameters(int age, int accidents, int insurance) {
        super();
        this.age = age;
        this.accidents = accidents;
        this.insurance = insurance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccidents() {
        return accidents;
    }

    public void setAccidents(int accidents) {
        this.accidents = accidents;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }
    
    
}
