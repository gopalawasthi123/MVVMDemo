package com.example.mvvmdemo.Repositary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mvvmdemo.Interface.PostsService;
import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient apiClient;

    private PostsService service;

    private  ApiClient() {
        Gson gson  = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(PostsService.class);
    }

    public  static ApiClient GetINSTANCE(){
        if(apiClient == null){
            apiClient =  new ApiClient();
        }
        return  apiClient;
    }

    public  PostsService  getPostsInstance(){

        return  service;
    }


    // getting the posts from the json place holders api


        public MutableLiveData<List<Posts>> getPosts(){
            //   final MutableLiveData<List<Posts>> postsMutableLiveData =new MutableLiveData<>();
            final MutableLiveData<List<Posts>> postsMutableLiveData =new MutableLiveData<>();


            service.getPosts().enqueue(new Callback<List<Posts>>() {
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

        // getting the users from the api json place holder api

    public MutableLiveData<List<User>> getUsers(){
        final MutableLiveData<List<User>> userMutableLiveData = new MutableLiveData<>();
        service.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                userMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
        return userMutableLiveData;
    }


    }
