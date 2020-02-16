package com.example.mvvmdemo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdemo.Repositary.ApiClient;
import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;

import java.util.List;

public class PostsViewModel  extends ViewModel {

    private MutableLiveData<List<Posts>> posts = new MutableLiveData<>();

   // private final  MutableLiveData<User> user = new MutableLiveData<User>();



   public LiveData<List<Posts>> getPosts() {

       posts = ApiClient.GetINSTANCE().getPosts();
    return  posts;
   }
}
