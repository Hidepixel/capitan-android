package com.sioslife.capitan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.sioslife.capitan.adapters.UserListAdapter;

import java.util.List;

import client.ApiService;
import client.UserService;
import models.User;

/**
 * Created by dinom on 18/03/2016.
 */
public class UserListActivity extends AppCompatActivity implements UserService.SuccessCallback, View.OnClickListener {

    ProgressBar progessBar;
    RecyclerView list;
    private LinearLayoutManager layoutManager;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

    }

    @Override
    protected void onStart() {
        super.onStart();
        progessBar = (ProgressBar)findViewById(R.id.progressBar);
        list = (RecyclerView) findViewById(R.id.user_list);
        list.setVisibility(View.GONE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ApiService api = ((CapitanApplication)getApplication()).getApi();
        UserService users = new UserService(api);
        users.getUsers(this);
    }

    @Override
    public void result(boolean status, List<User> users) {
        if(status) {
            this.users = users;
            UserListAdapter adapter = new UserListAdapter(users, getApplicationContext());
            adapter.setOnItemListener(this);
            layoutManager = new LinearLayoutManager(this);
            list.setLayoutManager(layoutManager);
            list.setAdapter(adapter);
            progessBar.setVisibility(View.GONE);
            list.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        int position = list.getChildLayoutPosition(v);
        User user = users.get(position);

        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        Bundle options = new Bundle();
        options.putSerializable("user", user);
        intent.putExtras(options);
        startActivity(intent);
    }
}
