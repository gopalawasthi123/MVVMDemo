package com.example.mvvmdemo.di.Component;

import android.content.Context;

import com.example.mvvmdemo.Activities.MainActivity;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface ApplicationComponent {

    @Component.Factory
    interface factory{

        @BindsInstance
        ApplicationComponent create(Context context);

    }

}
