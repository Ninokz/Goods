package com.com.example.goods.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.com.example.goods.BaseActivity;
import com.com.example.goods.R;
import com.com.example.goods.adapter.DepartmentManageAdapter;
import com.com.example.goods.adapter.UserManageAdapter;
import com.com.example.goods.entity.Department;
import com.com.example.goods.entity.User;
import com.com.example.goods.utils.HttpUtil;
import com.com.example.goods.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManageActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ImageView back;
    private ListView departmentlist;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_manage);
        initView();
        init();
        initEvent();
    }

    @Override
    public void init() {
        Department department = new Department();
        department.setName("department-1");
        Department department2 = new Department();
        department2.setName("department-2");
        Department department3 = new Department();
        department3.setName("department-3");
        List<Department> list = new ArrayList<>();
        list.add(department);
        list.add(department2);
        list.add(department3);
        DepartmentManageAdapter userManageAdapter = new DepartmentManageAdapter(DepartmentManageActivity.this, list);
        departmentlist.setAdapter(userManageAdapter);
    }

    @Override
    public void initView() {
        departmentlist = findViewById(R.id.departmentlist);
        add = findViewById(R.id.add);
        back = findViewById(R.id.back);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        add.setOnClickListener(this);
        back.setOnClickListener(this);
        departmentlist.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                Intent intent=new Intent(DepartmentManageActivity.this,AdddePartmentActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DepartmentManageAdapter adapter = (DepartmentManageAdapter) departmentlist.getAdapter();
        final Department department = adapter.getData().get(position);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("部门操作").setIcon(R.drawable.department1)
                .setMessage(department.getName())
                .setPositiveButton("删除", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DepartmentManageActivity.this, "待完善", Toast.LENGTH_SHORT).show();
                    }
                })
                //进入修改页面  将user传过去
                .setNeutralButton("修改", new DialogInterface.OnClickListener() {//添加普通按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(DepartmentManageActivity.this, DepartmentUpdateActivity.class);
                        intent.putExtra("msg", JsonUtils.object2String(department));  // 传递参数，根据需要填写
                        startActivity(intent);
                    }
                })
                .create();
        alertDialog.show();
    }
}