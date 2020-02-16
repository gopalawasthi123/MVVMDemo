package com.example.mvvmdemo.di.Module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmdemo.ViewModel.UserViewModel;
import com.example.mvvmdemo.factory.ViewModelFactory;

import dagger.Binds;
import dagger.multibindings.IntoMap;

public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

}
