package com.teamrl.app;
//lead auth:JacobFarrow(20007972)

import java.util.ArrayList;


public class User {
    //auth:HasanaynDad(22007018)

    //sort out methods
    //login //logout
    //sign up //join activity
    //Leave activity //view activity

    private UserInfoComponent myInfo;

    private ArrayList<String> myActivities;
    private Admin admin;
    private SuperUser superUser;


    public User() {
        //POJO/beans must have a default constructor
    }

    //overloaded constructor for testing
    public User(String e, String p) {
        this.myInfo = new UserInfoComponent();
        this.myInfo.setEmail(e);
        this.myInfo.setPassword(p);
    }

    /**
     * overridden info constructor
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

    /**
     * overridden info constructor
     * @param surname   ~ target User surname
     * @param forename  ~ target User forename
     * @param uobNumber ~ target User UOB Number
     * @param email     ~ target User email
     * @param dob       ~ target User Date of Birth (dd/mm/yyyy)
     * @param password  ~ target User password
     * @param startYear ~ target User start year
     * @param endYear   ~ target User end year (if valid)
     * @param admin     ~ target User admin status
     * @param staff     ~ target User super status
     */
    public User(String surname, String forename, String uobNumber, String email, String password, String dob, String startYear, String endYear, boolean admin, boolean staff) {

        if (admin) {
            //read admin from file
            //search by own name? uob?
            //ReadComponent call
            //this.admin=new Admin();
        }
        if (staff && checkForStaff(uobNumber, endYear)) {
            //read super from file
            //search by own name? uob?
            //ReadComponent call
            //this.admin=new Admin();
            this.superUser = new SuperUser();
        }
        this.myInfo = new UserInfoComponent(surname, forename, uobNumber, email, password, dob, startYear, endYear, admin, staff);
    }

    /**
     * overridden info constructor
     * @param userInfoComponent ~ the component of information belonging to this user
     */
    public User(UserInfoComponent userInfoComponent) {
        this.myInfo = userInfoComponent;
    }

    public UserInfoComponent getMyInfo() {
        return myInfo;
    }

    public void setMyInfo(UserInfoComponent myInfo) {
        this.myInfo = myInfo;
    }

    public String getSurname(){return getMyInfo().getSurname();}
    public void setSurname(String s){getMyInfo().setSurname(s);}
    public String getForename(){return getMyInfo().getForename();}
    public void setForename(String s){getMyInfo().setForename(s);}
    public String getFullname(){return getMyInfo().getFullname();}
    public void setFullname(String s){getMyInfo().setFullname(s);}
    public String getUobNumber(){return getMyInfo().getUobNumber();}
    public void setUobNumber(String s){getMyInfo().setUobNumber(s);}
    public String getEmail(){return getMyInfo().getEmail();}
    public void setEmail(String s){getMyInfo().setEmail(s);}
    public String getPassword(){return getMyInfo().getPassword();}
    public void setPassword(String s){getMyInfo().setPassword(s);}
    public String getDob(){return getMyInfo().getDOB();}
    public void setDob(String s){getMyInfo().setDOB(s);}
    public String getStartYear(){return getMyInfo().getStartYear();}
    public void setStartYear(String s){getMyInfo().setStartYear(s);}
    public String getEndYear(){return getMyInfo().getEndYear();}
    public void setEndYear(String s){getMyInfo().setEndYear(s);}
    public boolean isAdminFlag(){return getMyInfo().isAdminFlag();}
    public void setAdminFlag(boolean f){getMyInfo().setAdminFlag(f);}
    public boolean isSuperFlag(){return getMyInfo().isSuperFlag();}
    public void setSuperFlag(boolean f){getMyInfo().setSuperFlag(f);}
    public ArrayList<String> getMyActivities() {
        return myActivities;
    }

    public void setMyActivities(ArrayList<String> myActivities) {
        this.myActivities = myActivities;
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



    //we might want to get rid of this check
    //and/or write a flag to file
    private boolean checkForStaff(String ub, String ey) {
        String s = ub.substring(0, 2);
        if (s.equals("900") && ey.equals("")) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        //needs password adding in after hash
        return this.myInfo.toString();
    }


    /**
     * !!DEPRECATED!! use toString instead
     * converts the class into JSON format
     * @return formatted JSON string
     */
    @Deprecated
    public String toJSON() {
        return toString();
    }


    /**
     *!!DEPRECATED!! use toString instead
     * converts the class into csv format
     * @return formatted csv string
     */
    @Deprecated
    public String toCSV() {
        return this.myInfo.toCSV();
    }



}


