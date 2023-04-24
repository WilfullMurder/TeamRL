package com.example.teamRl;

public class UserInfoComponent {

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

    private final String NAME_DELIMITER = " ";

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


    public String toJSON() {
        //needs password adding in after hash
        return  "{\"surname\":" + String.format("\"%s\"", surname) +
                ", \"forename\": " + String.format("\"%s\"", forename) +
                ", \"uobNumber\":" + String.format("\"%s\"", uobNumber) +
                ", \"email\":" + String.format("\"%s\"", email) +
                ", \"password\":" + String.format("\"%s\"", password) +
                ", \"DOB\":" + String.format("\"%s\"", DOB) +
                ", \"startYear\":" + String.format("\"%s\"", startYear) +
                ", \"endYear\":" + String.format("\"%s\"", endYear) +
                "}";
    }

    public String toCSV() {
        return surname +
                "," + forename +
                "," + uobNumber +
                "," + email +
                "," + DOB +
                "," + startYear +
                "," + endYear;
    }
}
