package com.example.androidroomadvance.Room.Table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudentDeatils {

    @PrimaryKey(autoGenerate = true)
    int detailID;

    int stuId;

    String homeAddress;
    String phoneNumber;

    public StudentDeatils(int stuId, String homeAddress, String phoneNumber) {
        this.stuId = stuId;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
