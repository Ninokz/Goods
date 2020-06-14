package com.com.example.goods.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.com.example.goods.BaseActivity;
import com.com.example.goods.R;

public class MyActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout home;
    private LinearLayout grant;
    private LinearLayout my;
    private Button logout;
    private TextView tx_MyInfo;
    private TextView tx_AboutUs;
    private TextView tx_userManage;
    private TextView tx_companyManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
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
        logout = findViewById(R.id.logout);
        tx_MyInfo = findViewById(R.id.tx_MyInfo);
        tx_AboutUs = findViewById(R.id.tx_aboutus);
        tx_userManage = findViewById(R.id.userManage);
        tx_companyManage = findViewById(R.id.companymanage);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        home.setOnClickListener(this);
        grant.setOnClickListener(this);
        my.setOnClickListener(this);
        logout.setOnClickListener(this);
        tx_MyInfo.setOnClickListener(this);
        tx_AboutUs.setOnClickListener(this);
        tx_userManage.setOnClickListener(this);
        tx_companyManage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llhome:
                Intent intent = new Intent(MyActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.llgrant:
                Intent intent1 = new Intent(MyActivity.this, GrantActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.llmy:
                Intent intent2 = new Intent(MyActivity.this, MyActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.logout:
                SharedPreferences.Editor phone = getSharedPreferences("phone", MODE_PRIVATE).edit();
                phone.remove("id");
                phone.commit();
                Intent intent3 = new Intent(MyActivity.this, LoginActivity.class);
                startActivity(intent3);
                finish();
                break;
            //跳转个人信息修改页面
            case R.id.tx_MyInfo:
                Intent intent4 = new Intent(MyActivity.this, MyInfoActivity.class);
                startActivity(intent4);
                break;
            //跳转关于我们
            case R.id.tx_aboutus:
                Intent intent5 = new Intent(MyActivity.this, AboutUsActivity.class);
                startActivity(intent5);
                break;
            //跳转人员管理
            case R.id.userManage:
                Intent intent6 = new Intent(MyActivity.this, UserManageActivity.class);
                startActivity(intent6);
                break;
            //跳转单位管理
            case R.id.companymanage:
                Intent intent8 = new Intent(MyActivity.this, CompanyManageActivity.class);
                startActivity(intent8);
                break;
        }
    }
}
