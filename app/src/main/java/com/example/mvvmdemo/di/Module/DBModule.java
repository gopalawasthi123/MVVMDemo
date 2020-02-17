package com.example.mvvmdemo.di.Module;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.mvvmdemo.data.dao.UsersDao;
import com.example.mvvmdemo.data.local.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@NonNull Application application){
        return Room.databaseBuilder(application,AppDatabase.class,"MyApp_db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    UsersDao provideUsersDao (@NonNull AppDatabase appDatabase){
        return appDatabase.usersDao();
    }
}
