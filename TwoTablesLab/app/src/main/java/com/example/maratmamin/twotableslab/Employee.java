package com.example.maratmamin.twotableslab;

/**
 * Created by maratmamin on 3/24/16.
 */
public class Employee {
    private String mSSN;
    private String mFirst;
    private String mLast;
    private String mYear;
    private String mCity;

    public Employee(String SSN, String firstName, String lastName, String yearOfBirth, String city) {
        this.mSSN = SSN;
        this.mFirst = firstName;
        this.mLast = lastName;
        this.mYear = yearOfBirth;
        this.mCity = city;
    }

    public String getmSSN() {
        return mSSN;
    }

    public void setmSSN(String mSSN) {
        this.mSSN = mSSN;
    }

    public String getmFirst() {
        return mFirst;
    }

    public void setmFirst(String mFirst) {
        this.mFirst = mFirst;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    public String getmLast() {
        return mLast;
    }

    public void setmLast(String mLast) {
        this.mLast = mLast;
    }
}
