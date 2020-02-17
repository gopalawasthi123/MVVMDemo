package com.example.mvvmdemo.di.Component;
import android.content.Context;

import com.example.mvvmdemo.di.Module.DBModule;
import com.example.mvvmdemo.di.Module.NetworkModule;
import com.example.mvvmdemo.di.Module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {DBModule.class, NetworkModule.class, ViewModelModule.class})
public interface ApplicationComponent {

    @Component.Factory
    interface factory{
        ApplicationComponent create(@BindsInstance Context context);
    }

}
