package com.example.mvvmdemo.data.Repository;

import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiService {

    @GET("posts")
    Observable<Posts> getPosts();

    @GET("users")
    Observable<User> getUsers();
}
