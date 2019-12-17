package com.example.mvvmdemo.Repositary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mvvmdemo.Interface.PostsService;
import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository {
 private PostsService postclient;

    public LiveData<List<Posts>> getPosts(){
     //   final MutableLiveData<List<Posts>> postsMutableLiveData =new MutableLiveData<>();
        final MutableLiveData<List<Posts>> postsMutableLiveData =new MutableLiveData<>();


        postclient.getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                postsMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }


        });
        return postsMutableLiveData;
    }



}
