//lead auth:JacobFarrow(20007972)
package com.example.teamRl;
import java.util.ArrayList;

//auth:HasanaynDad(22007018)
public class User {

    private String surname;
    private String forename;
    private String uobNumber;
    private String email;
    private String DOB;
    private String startYear;
    private String endYear;

    private Admin admin;
    private SuperUser superUser;
    private boolean adminFlag;
    private boolean superFlag;

    public User() {

    }

    public User(String s, String f, String u, String e, String d) {
        this.surname = s;
        this.forename = f;
        this.uobNumber = u;
        this.email = e;
        this.DOB = d;
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
     *
     * @return formatted JSON string
     */
    public String toJSON() {
        return String.format("\"%s\"", surname) +
                " :{" + "\"forename\": " + String.format("\"%s\"", forename) +
                ", \"uobNumber\":" + String.format("\"%s\"", uobNumber) +
                ", \"email\":" + String.format("\"%s\"", email) +
                ", \"DOB\":" + String.format("\"%s\"", DOB) +
                ", \"startYear\":" + String.format("\"%s\"", startYear) +
                ", \"endYear\":" + String.format("\"%s\"", endYear) +
                "}";

    }

    /**
     * converts the class into csv format
     *
     * @return formatted csv string
     */
    public String toCSV() {
        return surname +
                "," + forename +
                "," + uobNumber;
    }

    public void requestAdminRights() {
        //some sort of message sent to the super?
        //observer-listener?
        //out to email?
        //message String variable?
    }


    private static class Admin {
        //auth:SadiyahZafhar(UB:22001015)
        private ArrayList<User> members;
        private Activity myActivity;

        public Admin() {
            members = new ArrayList<>();
        }

        public ArrayList<User> getMembers() {
            return this.members;
        }

        public User getMember(int index) {
            return this.members.get(index);
        }

        public void addMember(User newMember) {
            this.members.add(newMember);
        }

        public Activity getMyActivity() {
            return myActivity;
        }

        public void setMyActivity(Activity a) {
            myActivity = a;
        }
    }

    private static class SuperUser {
        //auth:AbuMughal(22036538)
        private ArrayList<User> adminList;
        private ArrayList<Activity> activityList;

        public SuperUser() {
        }

        public ArrayList<User> getAdminList() {
            return this.adminList;
        }

        public User getAdmin(int index) {
            return this.adminList.get(index);
        }

        public void addNewAdmin(User u) {
            //We can make this private and call from grantAdminRights?
            if (u.getAdmin() != null && !this.adminList.contains(u)) {
                this.adminList.add(u);
            }
        }

        public void removeAdmin(User u) {
            if (u.getAdmin() != null && this.adminList.contains(u)) {
                this.adminList.remove(u);
            }
        }

        public void grantAdminRights(User u) {
            //We can make this private and call from addNewAdmin?
            if (u.getAdmin() == null) {
                //load admin info
                u.setAdmin(new Admin());
                addNewAdmin(u);
            }
        }
    }
}