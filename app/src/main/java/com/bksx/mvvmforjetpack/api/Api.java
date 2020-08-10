package com.bksx.mvvmforjetpack.api;

import com.bksx.mvvmforjetpack.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Author JoneChen
 * @Date 2020\8\6 0006-9:56
 */
public interface Api {
    @GET("users/{userId}")
    Call<User> getUser(
            @Path("userId") String userId
    );
}
