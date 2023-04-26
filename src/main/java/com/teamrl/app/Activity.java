package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import java.util.ArrayList;


public class Activity {
   // auth:JacobFarrow(20007972)
    private String name;
    private ArrayList<String> description;
    private String mainContact;
    private String location;
    private double costPerSemester;
    private double costPerYear;
    private ArrayList<String> externalLinks;

    //tracking activities/execs is something we need to discuss
    private ArrayList<String> execsList;

    public Activity(){}

    public Activity(String nom, ArrayList<String> desc,String contact, String loc, double cps, double cpy, ArrayList<String> links){
        this.name=nom;
        this.description=desc;
        this.mainContact=contact;
        this.location=loc;
        this.costPerSemester=cps;
        this.costPerYear=cpy;
        this.externalLinks=links;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCostPerSemester() {
        return costPerSemester;
    }

    public void setCostPerSemester(double costPerSemester) {
        this.costPerSemester = costPerSemester;
    }

    public double getCostPerYear() {
        return costPerYear;
    }

    public void setCostPerYear(double costPerYear) {
        this.costPerYear = costPerYear;
    }

    public ArrayList<String> getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(ArrayList<String> externalLinks) {
        this.externalLinks = externalLinks;
    }

    @Override
    public String toString(){
        return  "{\"name\":" + String.format("\"%s\"", name) +
                ", \"description\": " + String.format("\"%s\"", description) +
                ", \"mainContact\":" + String.format("\"%s\"", mainContact) +
                ", \"location\":" + String.format("\"%s\"", location) +
                ", \"costPerSemester\":" + String.format("\"%s\"", costPerSemester) +
                ", \"costPerYear\":" + String.format("\"%s\"", costPerYear) +
                ", \"extrenalLinks\":" + String.format("\"%s\"", externalLinks) +
                "}";
    }
}
