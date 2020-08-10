package com.bksx.mvvmforjetpack.db;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bksx.mvvmforjetpack.model.User;

import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

/**
 * @Author JoneChen
 * @Date 2020\8\5 0005-14:02
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User users);

    @Query("SELECT * FROM USER WHERE name = :name")
    LiveData<User> getUserByName(String name);

}
