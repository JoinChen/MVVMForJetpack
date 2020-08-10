package com.bksx.mvvmforjetpack.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bksx.mvvmforjetpack.api.Api;
import com.bksx.mvvmforjetpack.application.MyApplication;
import com.bksx.mvvmforjetpack.db.UserDao;
import com.bksx.mvvmforjetpack.db.UserDataBase;
import com.bksx.mvvmforjetpack.model.User;
import com.bksx.mvvmforjetpack.repository.UserRespository;

/**
 * @Author JoneChen
 * @Date 2020\8\6 0006-10:13
 */
public class UserViewModel extends AndroidViewModel {
    private UserRespository userRespository;
    private UserDao userDao;
    private UserDataBase userDataBase;
    private Api api;
    private String userName = "MichaelYe";
    private final LiveData<User> user;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userDataBase = MyApplication.getUserDataBase();
        api = MyApplication.getApi();
        userDao = userDataBase.userDao();
        userRespository = new UserRespository(api,userDao);
        user = userRespository.getUser(userName);
    }

    public LiveData<User> getUser(){
       return user;
    }

    public void refresh(){
        userRespository.refresh(userName);
    }
}
