package com.example.mvvmdemo.di.Module;

import com.example.mvvmdemo.AppConstants;
import com.example.mvvmdemo.data.Repository.UserApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
   static Gson providesGson(){
        GsonBuilder builder = new GsonBuilder();
       return builder.create();
    }

    @Provides
    @Singleton
    static Retrofit ProvidesRetrofit(Gson gson){
        return new Retrofit
                .Builder()
                .baseUrl(AppConstants.BASURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Singleton
    @Provides
    static UserApiService provideRetrofitService(Retrofit retrofit){
        return retrofit.create(UserApiService.class);
    }


}
