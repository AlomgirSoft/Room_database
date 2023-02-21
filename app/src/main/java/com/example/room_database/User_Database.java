package com.example.room_database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {User_Entity.class}, version = 1)
public abstract class User_Database extends RoomDatabase {



    public abstract User_DAO getUserDAO();


    static User_Database database=null;

    public static User_Database getDatabase(Context context){


        if (database==null){

            database = Room.databaseBuilder(context,
                    User_Database.class,
                    "user table")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;

    }




}
