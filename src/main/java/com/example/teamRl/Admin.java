//lead auth:JacobFarrow(20007972)
package com.example.teamRl;

import java.util.ArrayList;

public class Admin {
    //auth:SadiyahZafhar(UB:22001015)
    private ArrayList<User> members;
    private Activity myActivity;

    public Admin() {
        members = new ArrayList<>();
    }

    public ArrayList<User> getMembers() {
        return this.members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public User getMember(int index) {
        return this.members.get(index);
    }
    public User getMember(String surname) {
        for(int i =0; i < this.members.size(); i++)
        {
            User u = this.members.get(i);
            String s = u.getSurname();
            if(s.equals(surname))
            {
                return this.members.get(i);
            }

        }
        return null;
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

    public String toString()
    {
        return  "[\"activity\":" + String.format("\"%s\"", activityToJSON()) + "\n" +
                ",\"members\":" + membersToJSON() +
                "}]";
    }

    private String membersToJSON()
    {
        String s="";
        for(int i = 0; i<this.members.size(); i++)
        {
            if(i == this.members.size()-1){s+= this.members.get(i).toJSON() + "\n"; break;}
            s+= this.members.get(i).toJSON() + "," + "\n";
        }
        return s;
    }

    private String activityToJSON()
    {

        return this.myActivity.toString();
    }
}
