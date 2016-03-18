package com.sioslife.capitan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sioslife.capitan.databinding.ContentProfileBinding;

import models.User;

public class ProfileActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getIntent().hasExtra("user")){
            user = (User)getIntent().getSerializableExtra("user");
            ContentProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.content_profile);
            binding.setUser(user);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
