package com.teamrl.app.components;
//lead auth:JacobFarrow(20007972)

/**
 * userinfocomp is a POJO for user data
 * It essentially holds the state of the user
 */


public class UserInfoComponent {
    //auth:JacobFarrow(20007972)
    //sort out the password
    //add to constructor
    //generate encryption
    //change password method
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

    public void setFullname(String fullname) {
        this.fullname = fullname;
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


}
