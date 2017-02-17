package com.sioslife.capitan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sioslife.capitan.R;
import com.sioslife.capitan.UserListActivity;

import java.util.ArrayList;
import java.util.List;

import models.User;


/**
 * Created by sioslife on 04/03/16.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListHolder> {

    private List<User> userList;
    private Context context;
    private View.OnClickListener listener;

    public UserListAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, null);

        if(listener != null){
            view.setOnClickListener(listener);
        }

        return new UserListHolder(view);

    }

    @Override
    public void onBindViewHolder(UserListHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.money.setText(context.getString(R.string.user_money_format, (float) user.getCredit()));
    }

    @Override
    public int getItemCount() {
        if(userList == null)  {
            return 0;
        }
        return userList.size();
    }

    public void setOnItemListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public class UserListHolder extends RecyclerView.ViewHolder {

        protected ImageView image;
        protected TextView name;
        protected TextView money;

        public UserListHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.user_image);
            name = (TextView) itemView.findViewById(R.id.user_name);
            money = (TextView) itemView.findViewById(R.id.user_money);
        }
    }
}
