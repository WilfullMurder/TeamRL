package com.example.teamrl;
//lead auth:JacobFarrow(20007972)
import java.util.ArrayList;


public class Admin {
    //auth:SadiyahZafhar(UB:22001015)
    private String myName;
    private String myActivity;
    private String role;
    private ArrayList<String> myActivityMembers; //just the full names of members for searching db
    private ArrayList<String> bannedList; //just in case

    public Admin(){
        this.myActivityMembers=new ArrayList<>();
        this.bannedList=new ArrayList<>();
        this.myActivity="";
    }

    public Admin(String a, ArrayList<String>data){
        this.myActivity=a;
        this.myActivityMembers=data;
        this.bannedList=new ArrayList<>();
    }
    public Admin(String a, ArrayList<String>data, ArrayList<String> banned){
        this.myActivity=a;
        this.myActivityMembers=data;
        this.bannedList=banned;
    }
    public Admin(String a, String r, ArrayList<String>data, ArrayList<String> banned){
        this.myActivity=a;
        this.role=r;
        this.myActivityMembers=data;
        this.bannedList=banned;
    }

    public Admin(String n, String a, String r, ArrayList<String>data, ArrayList<String> banned){
        this.myName=n;
        this.myActivity=a;
        this.role=r;
        this.myActivityMembers=data;
        this.bannedList=banned;
    }
    public String getMyActivity() {
        return myActivity;
    }

    public void setMyActivity(String myActivity) {
        this.myActivity = myActivity;
    }

    public ArrayList<String> getMyActivityMembers() {
        return myActivityMembers;
    }

    public void setMyActivityMembers(ArrayList<String> myActivityMembers) {
        this.myActivityMembers = myActivityMembers;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public void addNewMember(String m){
        if(!this.myActivityMembers.contains(m)){
            this.myActivityMembers.add(m);
        }
    }

    public ArrayList<String> getBannedList() {
        return bannedList;
    }

    public void setBannedList(ArrayList<String> bannedList) {
        this.bannedList = bannedList;
    }

    public void removeMember(String m, boolean banned){
        if(this.myActivityMembers.contains(m)){
            this.myActivityMembers.remove(m);
        }
        if(banned){
            this.bannedList.add(m);
        }
    }

    @Override
    public String toString() {
        return  String.format("\"%s\"", myName)+
                ": {\"myActivity\":" + String.format("\"%s\"", myActivity) +
                ", \"myActivityMembers\":" + String.format("\"%s\"", myActivityMembers) +
                ", \"bannedList\":" + String.format("\"%s\"",bannedList) +
                '}';
    }
}