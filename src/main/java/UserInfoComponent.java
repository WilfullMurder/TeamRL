package com.teamrl.app;
//lead auth:JacobFarrow(20007972)

import java.util.ArrayList;

/**
 * userinfocomp is a POJO for user data
 * It essentially holds the state of the user
 */


public class UserInfoComponent {
    //auth:HasanaynDad(22007018)

    private String surname;
    private String forename;
    private String fullname;
    private String uobNumber;
    private String email;
    private String password;
    private String DOB;
    private String startYear;
    private String endYear;

    private boolean adminFlag;
    private boolean superFlag;

    private ArrayList<String> myActivities;

    private final String NAME_DELIMITER = " "; //we can change this to whatever...

    public UserInfoComponent(){}

    public UserInfoComponent(String surname, String forename, String uobNumber, String email, String password, String dob, String startYear, String endYear)
    {
        this.forename = forename;
        this.surname = surname;
        this.fullname = forename + NAME_DELIMITER + surname;
        this.uobNumber = uobNumber;
        this.email = email;
        this.password = password;
        this.DOB = dob;
        this.startYear = startYear;
        this.endYear = endYear;
        this.superFlag = staff();

        this.myActivities = new ArrayList<>();
    }

    public UserInfoComponent(String surname, String forename, String uobNumber, String email, String password, String dob, String startYear, String endYear, boolean admin, boolean staff)
    {
        this.forename = forename;
        this.surname = surname;
        this.fullname = forename + NAME_DELIMITER + surname;
        this.uobNumber = uobNumber;
        this.email = email;
        this.password = password;
        this.DOB = dob;
        this.startYear = startYear;
        this.endYear = endYear;
        this.adminFlag = admin;
        this.superFlag = staff;
        this.myActivities = new ArrayList<>();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getFullname() {
        return fullname;
    }


    public String getUobNumber() {
        return uobNumber;
    }

    public void setUobNumber(String uobNumber) {
        this.uobNumber = uobNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public boolean isAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(boolean adminFlag) {
        this.adminFlag = adminFlag;
    }

    public boolean isSuperFlag() {
        return superFlag;
    }

    public void setSuperFlag(boolean superFlag) {
        this.superFlag = superFlag;
    }


    public String toString() {
        //needs password adding in after hash
        return  "{\"surname\":" + String.format("\"%s\"", surname) +
                ", \"forename\": " + String.format("\"%s\"", forename) +
                ", \"uobNumber\":" + String.format("\"%s\"", uobNumber) +
                ", \"email\":" + String.format("\"%s\"", email) +
                ", \"password\":" + String.format("\"%s\"", password) +
                ", \"DOB\":" + String.format("\"%s\"", DOB) +
                ", \"startYear\":" + String.format("\"%s\"", startYear) +
                ", \"endYear\":" + String.format("\"%s\"", endYear) +
                ", \"adminFlag\":" + String.format("\"%s\"", adminFlag) +
                ", \"superFlag\":" + String.format("\"%s\"", superFlag) +
                ", \"myActivities\":" + String.format("\"%s\"", myActivities) +
                "}";
    }


    @Deprecated
    public String toCSV() {
        //needs updating, but we will probably move away from csv.
        return surname +
                "," + forename +
                "," + uobNumber +
                "," + email +
                "," + DOB +
                "," + startYear +
                "," + endYear;
    }

    private boolean staff(){
        if(this.uobNumber.substring(0,3).equals("900") && (this.endYear.equals("") || this.endYear.isEmpty())){
            return true;
        }
        return false;
    }


    public ArrayList<String> getMyActivities() {
        return myActivities;
    }

    public void setMyActivities(ArrayList<String> myActivities) {
        this.myActivities = myActivities;
    }
}

//Comment your name under this here if you familiarized yourself with the codebase the first time Jacob asked:
//Jacob did