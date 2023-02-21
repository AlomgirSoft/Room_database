package com.example.room_database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User_Entity implements Serializable {

@PrimaryKey(autoGenerate = true)
    private  int id;


@ColumnInfo
    private  String userName;
@ColumnInfo
    private String userEmail;
@ColumnInfo
    private String userCountry;
@ColumnInfo
    private String userPassword;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    @Override
    public String toString() {
        return "User_Entity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userCountry='" + userCountry + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
