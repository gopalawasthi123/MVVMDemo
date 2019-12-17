package com.example.mvvmdemo.Interface;

import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsService {

    @GET("posts")
     Call<List<Posts>> getPosts();

    @GET("users")
    Call<List<User>> getUsers();
}
