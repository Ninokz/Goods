package com.com.example.goods.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.com.example.goods.BaseActivity;
import com.com.example.goods.R;

public class UserUpdateActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private String usermsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);
        init();
        initView();
        initEvent();
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        usermsg = intent.getStringExtra("msg");
    }

    @Override
    public void initView() {
        back = findViewById(R.id.back);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}