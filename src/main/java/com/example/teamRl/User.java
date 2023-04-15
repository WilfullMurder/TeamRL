//lead auth:JacobFarrow(20007972)
package com.example.teamRl;
//auth:HasanaynDad(22007018)

/**
 * User class acts as a POJO for data storage
 */
public class User {

    //sort out the password
        //add to constructor
        //generate encryption
        //change password method

    //sort out methods
        //login //logout
        //sign up //join activity
        //Leave activity //view activity

    private String surname;
    private String forename;
    private String uobNumber;
    private String email;
    private String DOB;
    private String startYear;
    private String endYear;

    private String password;

    private Admin admin;
    private SuperUser superUser;
    private boolean adminFlag;
    private boolean superFlag;

    public User() {
        //java beans must have a default constructor
    }

    public User(String e, String p) {
        this.email = e;
        //check password and load User
    }

    /**
     * overridden constructor
     *
     * @param surname   ~ target User surname
     * @param forename  ~ target User forename
     * @param uobNumber ~ target User UOB Number
     * @param email     ~ target User email
     * @param DOB       ~ target User Date of Birth (dd/mm/yyyy)
     * @param startYear ~ target User start year
     * @param endYear   ~ target User end year (if valid)
     */
    public User(String surname, String forename, String uobNumber, String email, String DOB, String startYear, String endYear) {
        this.surname = surname;
        this.forename = forename;
        this.uobNumber = uobNumber;
        this.email = email;
        this.DOB = DOB;
        this.startYear = startYear;
        this.endYear = endYear;
        checkForStaff();
    }

    //we might want to get rid of this check
    //and/or write a flag to file
    private void checkForStaff() {
        String s = this.uobNumber.substring(0, 2);
        if (s.equals("900") && endYear.equals("")) {
            //load super info from file?
            //i.e. activitieslist, adminlist?
            this.superUser = new SuperUser();
        }
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

    public String getUobNumber()
    {
        return this.uobNumber;
    }

    public void setUobNumber(String ub)
    {
        this.uobNumber = ub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public SuperUser getSuperUser() {
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }

    //we might not need these flags but, we might not want to save the Admin/Super class into the user class data??
    public boolean getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(boolean flag) {
        this.adminFlag = flag;
    }

    public boolean getSuperFlag() {
        return superFlag;
    }

    public void setSuperFlag(boolean superFlag) {
        this.superFlag = superFlag;
    }
    //we might not need these flags but, we might not want to save the Admin/Super class into the user class data??


    /**
     * converts the class into JSON format
     * @return formatted JSON string
     */
    public String toJSON() {
        return  "{\"surname\":" + String.format("\"%s\"", surname) +
                ", \"forename\": " + String.format("\"%s\"", forename) +
                ", \"uobNumber\":" + String.format("\"%s\"", uobNumber) +
                ", \"email\":" + String.format("\"%s\"", email) +
                ", \"DOB\":" + String.format("\"%s\"", DOB) +
                ", \"startYear\":" + String.format("\"%s\"", startYear) +
                ", \"endYear\":" + String.format("\"%s\"", endYear) +
                "}";

    }

    /**
     * converts the class into csv format
     * @return formatted csv string
     */
    public String toCSV() {
        return surname +
                "," + forename +
                "," + uobNumber +
                "," + email +
                "," + DOB +
                "," + startYear +
                "," + endYear;
    }

    public void requestAdminRights() {
        //some sort of message sent to the super?
        //observer-listener?
        //out to email?
        //message String variable?
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}