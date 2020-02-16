package com.example.mvvmdemo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdemo.Model.User;
import com.example.mvvmdemo.Repositary.ApiClient;

import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();



    public LiveData<List<User>> getUsers(){
        mutableLiveData =  ApiClient.GetINSTANCE().getUsers();
        return  mutableLiveData;
    }
}
