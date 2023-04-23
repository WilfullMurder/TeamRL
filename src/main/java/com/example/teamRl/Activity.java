package com.example.teamRl;

// activity class is a POJO for activity data
public class Activity {

    private String name;
    private String category;
    private String[] description;
    private String email;
    private String startTime;
    private String endTime;
    private String lastMeetingDate;
    private String nextMeetingDate;
    private String meetingLocation;
    private String[] external_links;
    private String costPerSemester;
    private String costPerYear;

    //should we just track execs through String name?
    private User president;



    public Activity(){

    }

    public Activity(String name, String cat, String[] desc, String mail, String s, String e, String lmd, String[] links, String cps, String cpy)
    {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLastMeetingDate() {
        return lastMeetingDate;
    }

    public void setLastMeetingDate(String lastMeetingDate) {
        this.lastMeetingDate = lastMeetingDate;
    }

    public String getNextMeetingDate() {
        return nextMeetingDate;
    }

    public void setNextMeetingDate(String nextMeetingDate) {
        this.nextMeetingDate = nextMeetingDate;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    public String[] getExternal_links() {
        return external_links;
    }

    public void setExternal_links(String[] external_links) {
        this.external_links = external_links;
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

    public User getPresident() {
        return president;
    }

    public void setPresident(User president) {
        this.president = president;
    }
}
