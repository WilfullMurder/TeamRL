//lead auth:JacobFarrow(20007972)
package com.example.teamRl;

import java.util.ArrayList;

public class SuperUser {
    //auth:AbuMughal(22036538)
    private ArrayList<User> adminList;
    private ArrayList<Activity> activityList;

    public SuperUser() {
    }

    public ArrayList<User> getAdminList() {
        return this.adminList;
    }

    public void setAdminList(ArrayList<User> adminList)
    {
        this.adminList = adminList;
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

    public String toString()
    {
        return  "[\"activities\": {" + String.format("\"%s\"", activitiesToJson()) + "\n" +
                ",\"admins\": {" + String.format("\"%s\"", adminsToJson()) + "\n" +
                "}]";
    }


    private String activitiesToJson()
    {
        String s = "";
        for(int i = 0; i< this.activityList.size(); i++)
         {
             s+= this.activityList.get(i).toString();
         }
        return s;
    }

    private String adminsToJson()
    {
        String s = "";
        for(int i = 0; i< this.adminList.size(); i++)
        {
            s+= this.adminList.get(i).toString();
        }
        return s;
    }
}
