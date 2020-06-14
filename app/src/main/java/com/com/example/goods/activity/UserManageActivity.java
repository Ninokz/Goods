package com.com.example.goods.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.com.example.goods.BaseActivity;
import com.com.example.goods.R;
import com.com.example.goods.adapter.UserManageAdapter;
import com.com.example.goods.entity.User;
import com.com.example.goods.utils.JsonUtils;
import com.xuexiang.xui.widget.toast.XToast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserManageActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ImageView back;
    private ListView userList;
    private List<User> list;
    private EditText ED_search;
    private Button BT_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manage);
        initView();
        init();
        initEvent();
    }

    @Override
    public void init() {
        User user = new User(1, "小李", 1);
        User user2 = new User(2, "小张", 2);
        User user3 = new User(3, "小红", 3);
        User user4 = new User(234, "万麻子", 2);
        User user5 = new User(520, "耙耳朵", 1);
        list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        UserManageAdapter userManageAdapter = new UserManageAdapter(UserManageActivity.this, list);
        userList.setAdapter(userManageAdapter);
    }

    @Override
    public void initView() {
        userList = findViewById(R.id.userlist);
        ED_search = findViewById(R.id.ED_search);
        BT_search = findViewById(R.id.BT_search);
        back = findViewById(R.id.back);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        userList.setOnItemClickListener(this);
        BT_search.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        UserManageAdapter adapter = (UserManageAdapter) userList.getAdapter();
        final User user = adapter.getData().get(position);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("人员操作").setIcon(R.drawable.person)
                .setMessage(user.getName())
                .setPositiveButton("删除", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(UserManageActivity.this, "待完善", Toast.LENGTH_SHORT).show();
                    }
                })
                //进入修改页面  将user传过去
                .setNeutralButton("修改", new DialogInterface.OnClickListener() {//添加普通按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(UserManageActivity.this, UserUpdateActivity.class);
                        intent.putExtra("msg", JsonUtils.object2String(user));  // 传递参数，根据需要填写
                        startActivity(intent);
                    }
                })
                .create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //实现list列表过滤
            case R.id.BT_search:
                List<User> listtmp = new ArrayList<>();
                for (User user : list) {
                    listtmp.add(user);
                }
                String text = ED_search.getText().toString();
                Iterator<User> iterator = listtmp.iterator();
                while (iterator.hasNext()) {
                    User a = iterator.next();
                    if (!a.toString().contains(text)) {
                        iterator.remove();
                    }
                }
                UserManageAdapter adapter = (UserManageAdapter) userList.getAdapter();
                adapter.setData(listtmp);
                userList.setAdapter(adapter);
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}