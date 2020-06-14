package com.com.example.goods.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.com.example.goods.BaseActivity;
import com.com.example.goods.R;
import com.com.example.goods.adapter.CompanyManageAdapter;
import com.com.example.goods.adapter.DepartmentManageAdapter;
import com.com.example.goods.entity.Company;
import com.com.example.goods.entity.Department;
import com.com.example.goods.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyManageActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ImageView back;
    private ListView companylist;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_manage);
        initView();
        init();
        initEvent();
    }

    @Override
    public void init() {
        Company company = new Company();
        company.setName("Company-1");
        Company company2 = new Company();
        company2.setName("Company-2");
        Company company3 = new Company();
        company3.setName("Company-3");
        List<Company> list = new ArrayList<>();
        list.add(company);
        list.add(company2);
        list.add(company3);
        CompanyManageAdapter userManageAdapter = new CompanyManageAdapter(CompanyManageActivity.this, list);
        companylist.setAdapter(userManageAdapter);
    }

    @Override
    public void initView() {
        companylist = findViewById(R.id.companylist);
        add = findViewById(R.id.add);
        back = findViewById(R.id.back);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        companylist.setOnItemClickListener(this);
        add.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CompanyManageAdapter adapter = (CompanyManageAdapter) companylist.getAdapter();
        final Company company = adapter.getData().get(position);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("单位操作").setIcon(R.drawable.department1)
                .setMessage(company.getName())
                .setPositiveButton("部门管理", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CompanyManageActivity.this, DepartmentManageActivity.class);
                        intent.putExtra("msg", JsonUtils.object2String(company));  // 传递参数，根据需要填写
                        startActivity(intent);
                    }
                })
                //进入修改页面  将user传过去
                .setNeutralButton("修改", new DialogInterface.OnClickListener() {//添加普通按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CompanyManageActivity.this, CompanyUpdateActivity.class);
                        intent.putExtra("msg", JsonUtils.object2String(company));  // 传递参数，根据需要填写
                        startActivity(intent);
                    }
                })
                .create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                Intent intent = new Intent(CompanyManageActivity.this, addCompanyActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                Intent intent2 = new Intent(CompanyManageActivity.this, HomeActivity.class);
                startActivity(intent2);
                break;
        }
    }
}