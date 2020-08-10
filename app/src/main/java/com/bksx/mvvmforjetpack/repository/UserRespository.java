package com.bksx.mvvmforjetpack.repository;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.alibaba.fastjson.JSON;
import com.bksx.mvvmforjetpack.api.Api;
import com.bksx.mvvmforjetpack.db.UserDao;
import com.bksx.mvvmforjetpack.db.UserDataBase;
import com.bksx.mvvmforjetpack.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author JoneChen
 * @Date 2020\8\6 0006-10:32
 * 获取网络数据写在respository层
 */
public class UserRespository {
    private Api api;
    private UserDataBase userDataBase;
    private UserDao userDao;

    public UserRespository(Api api, UserDao userDao) {
        this.api = api;
        this.userDao = userDao;
    }

    public LiveData<User> getUser(String name) {
        refresh(name);
        return userDao.getUserByName(name);
    }

    public void refresh(String name) {
        api.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null) {
                    insertUser(response.body());
                    Log.e("User", JSON.toJSONString(response.body()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                Log.e("User", JSON.toJSONString(t));
            }
        });
    }

    private void insertUser(final User body) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(body);
            }
        });
    }
}
