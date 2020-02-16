package com.example.mvvmdemo.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvmdemo.Model.User;

import java.util.List;

import retrofit2.http.GET;

@Dao
public interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertusers(List<User> users);

    @Query("SELECT * FROM user")
    List<User> getAllUsersDb();

}
