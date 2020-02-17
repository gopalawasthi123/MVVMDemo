package com.example.mvvmdemo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Insert;

import com.example.mvvmdemo.Interface.UserRepository;
import com.example.mvvmdemo.Model.User;
import com.example.mvvmdemo.Repositary.ApiClient;
import com.example.mvvmdemo.data.Repository.UserApiService;
import com.example.mvvmdemo.data.dao.UsersDao;

import java.util.List;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();

    private UserRepository userRepository;

    @Inject
    public UserViewModel(UsersDao usersDao , UserApiService apiService){
        userRepository = new UserRepository(usersDao,apiService);
    }


    public LiveData<List<User>> getUsers(){
        return  mutableLiveData;
    }
}
