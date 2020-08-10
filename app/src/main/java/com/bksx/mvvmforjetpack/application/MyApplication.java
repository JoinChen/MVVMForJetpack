package com.bksx.mvvmforjetpack.application;

import android.app.Application;

import com.bksx.mvvmforjetpack.api.Api;
import com.bksx.mvvmforjetpack.api.RetrofitClient;
import com.bksx.mvvmforjetpack.db.UserDataBase;
import com.bksx.mvvmforjetpack.utils.Constants;

/**
 * @Author JoneChen
 * @Date 2020\8\6 0006-10:11
 */
public class MyApplication extends Application {
    private static UserDataBase userDataBase;
    private static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        userDataBase = UserDataBase.getInstance(this);
        api = RetrofitClient.getInstance().getApi();
    }

    public static Api getApi(){
        return api;
    }

    public static UserDataBase getUserDataBase(){
        return userDataBase;
    }
}
