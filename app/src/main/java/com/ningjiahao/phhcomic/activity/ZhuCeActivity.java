package com.ningjiahao.phhcomic.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.YonghuBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class ZhuCeActivity extends BaseActivity {

    private Context mContext = this;
    private ImageView imageView__logo_zhuce,imageView_queren_zhuce;
    private Toolbar toolBar_zhuce;
    private EditText editText_zhanghao_zhuce,editText_pasword_zhuce,editText_querenpasword_zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initToolbar();
        initView();
    }

    private void initView() {
        imageView__logo_zhuce = (ImageView) findViewById(R.id.imageView__logo_zhuce);
        imageView_queren_zhuce = (ImageView) findViewById(R.id.imageView_queren_zhuce);
        Glide.with(mContext).load(R.drawable.logingif).asGif().placeholder(R.drawable.imageloading).into(imageView__logo_zhuce);
        editText_zhanghao_zhuce = (EditText) findViewById(R.id.editText_zhanghao_zhuce);
        editText_pasword_zhuce = (EditText) findViewById(R.id.editText_pasword_zhuce);
        editText_querenpasword_zhuce = (EditText) findViewById(R.id.editText_querenpasword_zhuce);
        imageView_queren_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ZhuCeActivity","点击");
                String username = editText_zhanghao_zhuce.getText().toString();
                String password = editText_pasword_zhuce.getText().toString();
                String password1 = editText_querenpasword_zhuce.getText().toString();
                if (password.equals(password1)){
                    Toast.makeText(mContext, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                }else {
                    YonghuBean yonghuBean = new YonghuBean();
                    yonghuBean.setUsername(username);
                    yonghuBean.setPassword(password);
                    yonghuBean.save(new SaveListener<String>(){
                        @Override
                        public void done(String s, BmobException e) {
                            if(e==null){
                                Toast.makeText(mContext, "添加数据成功，", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(mContext, "创建数据失败，", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    private void initToolbar() {
        toolBar_zhuce = (Toolbar) findViewById(R.id.toolBar_zhuce);
        toolBar_zhuce.setTitleTextAppearance(this,R.style.MyToolBar);
        setSupportActionBar(toolBar_zhuce);
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
        }
        return super.onOptionsItemSelected(item);
    }
}
