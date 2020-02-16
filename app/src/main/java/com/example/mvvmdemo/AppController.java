package com.example.mvvmdemo;

import android.app.Application;

import com.example.mvvmdemo.di.Component.ApplicationComponent;
import com.example.mvvmdemo.di.Component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class AppController extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    ApplicationComponent applicationComponent = DaggerApplicationComponent.factory().create(this);
}
