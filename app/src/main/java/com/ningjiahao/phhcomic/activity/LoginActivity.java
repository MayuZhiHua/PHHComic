package com.ningjiahao.phhcomic.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.YonghuBean;

import cn.bmob.v3.BmobQuery;

public class LoginActivity extends BaseActivity {
    private Context mContext = this;
    private Toolbar toolbar_login;
    private ImageView  imageView__logo_login;
    private EditText editText_zhanghao_login,editText_pasword_login;
    private ImageView imageView_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolbar();
        initView();
    }

    private void initView() {
        imageView__logo_login = (ImageView) findViewById(R.id.imageView__logo_login);
        Glide.with(mContext).load(R.drawable.logingif).asGif().placeholder(R.drawable.imageloading).into(imageView__logo_login);
        editText_zhanghao_login = (EditText) findViewById(R.id.editText_zhanghao_login);
        editText_pasword_login = (EditText) findViewById(R.id.editText_pasword_login);
        imageView_login = (ImageView) findViewById(R.id.imageView_login);
        imageView_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    private void initToolbar() {
        toolbar_login = (Toolbar) findViewById(R.id.toolBar_login);
        toolbar_login.setTitleTextAppearance(this,R.style.MyToolBar);
        setSupportActionBar(toolbar_login);
        ActionBar actionBar=getSupportActionBar();
        //给左上角图标的左边加上一个返回的图标
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 自定义返回按钮（默认是返回箭头）
        actionBar.setHomeAsUpIndicator(R.mipmap.common_back_n);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //点击ToolBar按钮返回上一界面
            case android.R.id.home:
                finish();
                break;
            case R.id.zhuce://收藏按钮的监听
                Intent intent = new Intent(mContext,ZhuCeActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载menu资源
        getMenuInflater().inflate(R.menu.login, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
