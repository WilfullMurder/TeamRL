package com.teamrl.app;
//lead auth:JacobFarrow(20007972)

import java.util.ArrayList;


public class User {
    //auth:HasanaynDad(22007018)
    private UserInfoComponent myInfo;


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
        if (staff) {
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
        if(this.myInfo.isAdminFlag()){

            //@TODO: ReadComponent.getSingleAdmin
            ArrayList<Admin> admins = ReadComponent.readAdminDataFromJSON(FileComponent.ADMIN_FILENAME, FileComponent.MAIN_FOLDER);
            for(int i =0; i < admins.size(); i++){
                if(admins.get(i).getMyName().equals(this.myInfo.getFullname())){
                    this.admin = admins.get(i);
                }
            }
        }
        else if(this.myInfo.isSuperFlag()){
            //@TODO: ReadComponent.getSingleSuper
            ArrayList<SuperUser> supers = ReadComponent.readSuperDataFromJSON(FileComponent.SUPER_FILENAME, FileComponent.MAIN_FOLDER);
            for(int i =0; i < supers.size(); i++){
                if(supers.get(i).getMyUoB().equals(this.myInfo.getUobNumber())){
                    this.superUser = supers.get(i);
                }
            }
        }
    }

    /**
     * GETTERS & SETTERS
     */

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
        return getMyInfo().getMyActivities();
    }

    public void setMyActivities(ArrayList<String> myActivities) {
        getMyInfo().setMyActivities(myActivities);
    }
    public void addActivity(String act){
        if(getMyInfo().getMyActivities() == null){getMyInfo().setMyActivities(new ArrayList<>());}
        getMyInfo().getMyActivities().add(act);
        if(getMyInfo().getMyActivities().size() > 1){
        }

    }
    public void removeActivity(String act){
        getMyInfo().getMyActivities().remove(act);
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
     *!!DEPRECATED!! use json formatting instead!
     * converts the class into csv format
     * @return formatted csv string
     */
    @Deprecated
    public String toCSV() {
        return this.myInfo.toCSV();
    }



}


