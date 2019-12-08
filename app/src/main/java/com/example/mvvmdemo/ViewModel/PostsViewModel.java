package com.example.mvvmdemo.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mvvmdemo.Interface.ApiClient;
import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;

import java.util.List;

public class PostsViewModel  extends ViewModel {

    private MutableLiveData<List<Posts>> posts = new MutableLiveData<>();

    private final  MutableLiveData<User> user = new MutableLiveData<User>();



   public LiveData<List<Posts>> getPosts() {

       posts = ApiClient.GetINSTANCE().getPosts();
    return  posts;
   }
}
