package com.example.sportinformation;

public class EPLTeamModel {
    private String teamname;
    private String date;
    private String stadiun;
    private String strTeamBadge;

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getStadiun() {
        return stadiun;
    }

    public void setStadiun(String stadiun) {
        this.stadiun = stadiun;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}