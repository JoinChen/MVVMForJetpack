package com.bksx.mvvmforjetpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bksx.mvvmforjetpack.R;
import com.bksx.mvvmforjetpack.databinding.ActivityMainBinding;
import com.bksx.mvvmforjetpack.model.User;
import com.bksx.mvvmforjetpack.viewmodel.UserViewModel;

import java.lang.reflect.Constructor;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Class<?> retrofit = Class.forName("Retrofit");
            Constructor con[] = retrofit.getConstructors();
            for (int i = 0; i < con.length; i++) {
                System.out.println(con[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    activityMainBinding.setUser(user);
                    activityMainBinding.setAvatar(user.avatar);
                    activityMainBinding.setDefaultRes(R.drawable.ic_launcher_foreground);
                }
            }
        });

    }
}
