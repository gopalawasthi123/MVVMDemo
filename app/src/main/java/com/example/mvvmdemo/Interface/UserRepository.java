package com.example.mvvmdemo.Interface;

import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.Model.User;
import com.example.mvvmdemo.Model.UserWrapper;
import com.example.mvvmdemo.data.NetworkBoundResource;
import com.example.mvvmdemo.data.Repository.UserApiService;
import com.example.mvvmdemo.data.Resource;
import com.example.mvvmdemo.data.dao.UsersDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class UserRepository {

    private UsersDao dao;
    private UserApiService apiService;

    public UserRepository(UsersDao dao, UserApiService service){
        this.dao = dao;
        this.apiService = service;
    }

  public Observable<Resource<List<User>>> FetchAllUsers() {

      return new NetworkBoundResource<List<User>, User>() {

          @Override
          protected void saveCallResult(@NonNull User item) {
            List<User> userList = new ArrayList<>();

                userList.add(item);
              dao.insertusers(userList);
            }

          @Override
          protected boolean shouldFetch() {
              return false;
          }

          @NonNull
          @Override
          protected Flowable<List<User>> loadFromDb() {
              List<User> userList = dao.getAllUsersDb();
              if(userList == null || userList.isEmpty()){
                  return Flowable.empty();
              }

              return Flowable.just(dao.getAllUsersDb());
          }

          @NonNull
          @Override
          protected Observable<Resource<User>> createCall() {
              return apiService.getUsers()
                      .flatMap(user -> Observable.just(user == null ?
                              Resource.error("error",new User()):
                              Resource.success(user)));
          }


      }.getAsObservable();
  }
}
