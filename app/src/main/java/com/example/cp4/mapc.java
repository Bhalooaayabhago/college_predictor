package com.example.cp4;

import com.google.gson.annotations.SerializedName;

class mapc
{
    @SerializedName("college_name")
    String college;
    String state;
    mapc(String college,String state)
    {
        this.college=college;
        this.state=state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "ho{" +
                "college='" + college + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollege() {
        return college;
    }
}
