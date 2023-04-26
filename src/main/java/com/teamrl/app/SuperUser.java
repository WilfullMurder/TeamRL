package com.teamrl.app;

import java.util.ArrayList;

//lead auth:JacobFarrow(20007972)
public class SuperUser {
    //auth:AbuMughal(22036538)

    private ArrayList<String> adminList;
    private ArrayList<String> activitiesList;

    public SuperUser(){}

    public SuperUser(ArrayList<String> admins, ArrayList<String> activities){
        this.adminList=admins;
        this.activitiesList=activities;
    }

    public ArrayList<String> getAdminList() {
        return adminList;
    }

    public void setAdminList(ArrayList<String> adminList) {
        this.adminList = adminList;
    }

    public ArrayList<String> getActivitiesList() {
        return activitiesList;
    }

    public void setActivitiesList(ArrayList<String> activitiesList) {
        this.activitiesList = activitiesList;
    }

    @Override
    public String toString(){
        return
        "\"adminList\":" + String.format("\"%s\"", adminList) +
        ", \"activitiesList\":" + String.format("\"%s\"", activitiesList);
    }
}
