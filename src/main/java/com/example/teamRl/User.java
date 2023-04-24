//lead auth:JacobFarrow(20007972)
package com.example.teamRl;
//auth:HasanaynDad(22007018)

import java.util.ArrayList;

/**
 * User class acts as a POJO for data storage
 */
public class User {
    //sort out methods
        //login //logout
        //sign up //join activity
        //Leave activity //view activity

    private UserInfoComponent myInfo;

    private ArrayList<String> myActivites;

    private Admin admin;
    private SuperUser superUser;
    private boolean adminFlag;
    private boolean superFlag;

    public User() {
        //POJO/beans must have a default constructor
    }

    //overloaded constructor for testing
    public User(String e, String p)
    {
        this.myInfo = new UserInfoComponent();
        this.myInfo.setEmail(e);
        this.setPassword(p);
    }


    /**
     * overridden info constructor
     *
     * @param surname   ~ target User surname
     * @param forename  ~ target User forename
     * @param uobNumber ~ target User UOB Number
     * @param email     ~ target User email
     * @param dob       ~ target User Date of Birth (dd/mm/yyyy)
     * @param password  ~ target User password
     * @param startYear ~ target User start year
     * @param endYear   ~ target User end year (if valid)
     */
    public User(String surname, String forename, String uobNumber, String email, String password, String dob, String startYear, String endYear) {
        this.myInfo = new UserInfoComponent(surname, forename, uobNumber, email, password, dob, startYear, endYear);
    }

    public UserInfoComponent getMyInfo() {
        return myInfo;
    }

    public void setMyInfo(UserInfoComponent myInfo) {
        this.myInfo = myInfo;
    }

    //we might want to get rid of this check
    //and/or write a flag to file
    private void checkForStaff() {
        String s = this.myInfo.getUobNumber().substring(0, 2);
        if (s.equals("900") && this.myInfo.getEndYear().equals("")) {

            //load super info from file?
            //i.e. activitieslist, adminlist?
            this.superUser = new SuperUser();
        }
    }

    public String getSurname() {
        return this.myInfo.getSurname();
    }
    public void setSurname(String surname) {
        this.myInfo.setSurname(surname);
    }
    public String getForename() {
        return this.myInfo.getForename();
    }
    public void setForename(String forename) {
        this.myInfo.setForename(forename);
    }

    public String getUobNumber()
    {
        return this.myInfo.getUobNumber();
    }

    public void setUobNumber(String ub)
    {
        this.myInfo.setUobNumber(ub);
    }

    public String getEmail() {
        return this.myInfo.getEmail();
    }

    public void setEmail(String email) {
        this.myInfo.setEmail(email);
    }

    public String getDOB() {
        return this.myInfo.getDOB();
    }

    public void setDOB(String dob) {
        this.myInfo.setDOB(dob);
    }

    public String getStartYear() {
        return this.myInfo.getStartYear();
    }

    public void setStartYear(String startYear) {
        this.myInfo.setStartYear(startYear);
    }

    public String getEndYear() { return this.myInfo.getEndYear(); }

    public void setEndYear(String endYear) {
        this.myInfo.setEndYear(endYear);
    }
    public String getPassword() {
        return this.myInfo.getPassword();
    }

    public void setPassword(String password) {
        this.myInfo.setPassword(password);
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




    public ArrayList<String> getMyActivites() {
        return myActivites;
    }

    public void setMyActivites(ArrayList<String> activites) {
        this.myActivites = activites;
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


    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * converts the class into JSON format
     * @return formatted JSON string
     */
    public String toJSON() {
        //needs password adding in after hash
        return  this.myInfo.toJSON();

    }

    /**
     * converts the class into csv format
     * @return formatted csv string
     */
    public String toCSV() {
        return this.myInfo.toCSV();
    }

    public void requestAdminRights() {
        //some sort of message sent to the super?
        //observer-listener?
        //out to email?
        //message String variable?
    }



}