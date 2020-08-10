package com.bksx.mvvmforjetpack.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bksx.mvvmforjetpack.model.User;

/**
 * @Author JoneChen
 * @Date 2020\8\5 0005-13:49
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "user_db";
    private static UserDataBase userDataBase;

    public static synchronized UserDataBase getInstance(Context context) {
        if (userDataBase == null) {
            userDataBase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDataBase.class,
                    DATABASE_NAME)
                    .build();
        }
        return userDataBase;
    }

    public abstract UserDao userDao();
}
