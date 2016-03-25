package com.example.maratmamin.twotableslab;

/**
 * Created by maratmamin on 3/24/16.
 */
public class Job {
    private String mSSN;
    private String mCompany;
    private String mSalary;
    private String mExperience;

    public Job(String mSSN, String mCompany, String mSalary, String mExperience) {
        this.mSSN = mSSN;
        this.mCompany = mCompany;
        this.mSalary = mSalary;
        this.mExperience = mExperience;
    }

    public String getmSSN() {
        return mSSN;
    }

    public void setmSSN(String mSSN) {
        this.mSSN = mSSN;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getmSalary() {
        return mSalary;
    }

    public void setmSalary(String mSalary) {
        this.mSalary = mSalary;
    }

    public String getmExperience() {
        return mExperience;
    }

    public void setmExperience(String mExperience) {
        this.mExperience = mExperience;
    }
}
