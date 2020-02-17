package com.example.mvvmdemo.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmdemo.Model.User;
import com.example.mvvmdemo.data.dao.UsersDao;

@Database(entities = User.class,version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static volatile AppDatabase INSTANCE;

    public abstract UsersDao usersDao();


    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"MyApp_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
