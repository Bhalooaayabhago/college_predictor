package com.example.cp4;

import com.google.gson.annotations.SerializedName;

class ctop
{
    @SerializedName("College")
    String college;
    @SerializedName("Median Package (LPA)")
    String pay;
    @SerializedName("Website Link")
    String link;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "ctop{" +
                "college='" + college + '\'' +
                ", pay='" + pay + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public String getLink() {
        return link;
    }

    public String getPay() {
        return pay;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}