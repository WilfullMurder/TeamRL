package com.example.teamrl;
//lead auth:JacobFarrow(20007972)
import java.util.ArrayList;

public class SuperUser {
    //auth:AbuMughal(22036538)
    private String myUoB;
    private ArrayList<String> adminList;
    private ArrayList<String> activitiesList;

    public SuperUser(){}

    public SuperUser(ArrayList<String> admins, ArrayList<String> activities){
        this.adminList=admins;
        this.activitiesList=activities;
    }
    public SuperUser(String uob, ArrayList<String> admins, ArrayList<String> activities){
        this.myUoB = uob;
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
        return String.format("\"%s\"", myUoB) +
                ":{" +
                "\"adminList\":" + String.format("\"%s\"", adminList) +
                ", \"activitiesList\":" + String.format("\"%s\"", activitiesList)
                +"}";
    }
    public String getMyUoB() {
        return myUoB;
    }
}
