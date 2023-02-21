package com.example.room_database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface User_DAO {



    @Insert
    void insertUser(User_Entity user_entity);
    @Update
    void updateUser(User_Entity user_entity);
    @Delete
    void deleteUser(User_Entity user_entity);

    @Query("SELECT * FROM User_Entity")
    List<User_Entity> getAllUser();




}
