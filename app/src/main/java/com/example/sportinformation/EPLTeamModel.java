package com.example.sportinformation;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class EPLTeamModel  implements Parcelable {
    private String teamname;
    private String date;
    private String stadiun;
    private String strTeamBadge;
    private String teamdescription;

    protected EPLTeamModel(Parcel in) {
        teamname = in.readString();
        date = in.readString();
        stadiun = in.readString();
        strTeamBadge = in.readString();
        teamdescription = in.readString();
    }
    EPLTeamModel(){

    }

    public static final Creator<EPLTeamModel> CREATOR = new Creator<EPLTeamModel>() {
        @Override
        public EPLTeamModel createFromParcel(Parcel in) {
            return new EPLTeamModel(in);
        }

        @Override
        public EPLTeamModel[] newArray(int size) {
            return new EPLTeamModel[size];
        }
    };
    public String getDate() {
        return date;
    }

    public String getTeamdescription() {
        return teamdescription;
    }

    public void setTeamdescription(String teamdescription) {
        this.teamdescription = teamdescription;
    }


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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(teamname);
        dest.writeString(date);
        dest.writeString(stadiun);
        dest.writeString(strTeamBadge);
        dest.writeString(teamdescription);
    }
}