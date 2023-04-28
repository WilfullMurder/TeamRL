package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import java.util.ArrayList;


public class Activity {
   // auth:ZaniahMahmood(22007256)
    private String name;
    private ArrayList<String> description;
    private String mainContact;
    private String location;
    private String costPerSemester;
    private String costPerYear;
    private ArrayList<String> externalLinks;

    //tracking activities/execs is something we need to discuss
    private ArrayList<String> execsList;

    public Activity(){}

    public Activity(String nom, ArrayList<String> desc,String contact, String loc, String cps, String cpy, ArrayList<String> links){
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

    public String getCostPerSemester() {
        return costPerSemester;
    }

    public void setCostPerSemester(String costPerSemester) {
        this.costPerSemester = costPerSemester;
    }

    public String getCostPerYear() {
        return costPerYear;
    }

    public void setCostPerYear(String costPerYear) {
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
        //we use .format to include the quotation marks for data binding
        return  "{\"name\":" + String.format("\"%s\"", name) +
                ", \"description\": " + String.format("\"%s\"", description) +
                ", \"mainContact\":" + String.format("\"%s\"", mainContact) +
                ", \"location\":" + String.format("\"%s\"", location) +
                ", \"costPerSemester\":" + String.format("\"%s\"", costPerSemester) +
                ", \"costPerYear\":" + String.format("\"%s\"", costPerYear) +
                ", \"externalLinks\":" + String.format("\"%s\"", externalLinks) +
                "}";
    }
}
