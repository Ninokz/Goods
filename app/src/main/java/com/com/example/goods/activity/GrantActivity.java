package com.com.example.goods.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.com.example.goods.BaseActivity;
import com.com.example.goods.R;

public class GrantActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout home;
    private LinearLayout grant;
    private LinearLayout my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant);
        initView();
        initEvent();
    }

    @Override
    public void init() {

    }

    @Override
    public void initView() {
        home = findViewById(R.id.llhome);
        grant = findViewById(R.id.llgrant);
        my = findViewById(R.id.llmy);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        home.setOnClickListener(this);
        grant.setOnClickListener(this);
        my.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llhome:
                Intent intent = new Intent(GrantActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.llgrant:
                Intent intent1 = new Intent(GrantActivity.this, GrantActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.llmy:
                Intent intent2 = new Intent(GrantActivity.this, MyActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
