package com.com.example.goods.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.com.example.goods.R;
import com.com.example.goods.entity.User;

import java.util.List;

public class UserManageAdapter extends BaseAdapter {
    //数据源
    List<User> data;
    //放射器
    LayoutInflater inflater;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public UserManageAdapter(Context context, List<User> data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.useritem, null);
        TextView usrmsg = view.findViewById(R.id.usrmsg);
        User user = data.get(position);
        if (user.getDepartmentid() == 1) {
            usrmsg.setText("人事部-" + user.getName());
        } else if (user.getDepartmentid() == 2) {
            usrmsg.setText("财务部-" + user.getName());
        } else {
            usrmsg.setText("无业游民-" + user.getName());
        }
        return view;
    }
}
