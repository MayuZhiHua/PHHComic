package com.ningjiahao.phhcomic.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.helper.TimeHelper;

import java.io.Serializable;

public class TieZiActivity extends AppCompatActivity {
    private Context mContext = this;
    private TuiJianBean.CBean cBean;
    private Toolbar mToolbar ;
    private TextView textView_username_tiezi,textView_time_tiezi,textView_title_tiezi,
            textView_content_tiezi,textView_dianzan_tiezi,textView_pinglun_tiezi;
    private ImageView imageView_head_tiezi,imageView_quanzi_photo0,imageView_quanzi_photo1,
            imageView_quanzi_photo2,imageView_quanzi_photo3,imageView_quanzi_photo4,
            imageView_quanzi_photo5,imageView_quanzi_photo6,imageView_quanzi_photo7,
            imageView_quanzi_photo8;
    private LinearLayout linearLayout_tupian,linearLayout_item0,linearLayout_item1,linearLayout_item2;
    private RecyclerView recyclerView_tiezi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie_zi);
        initToolbar();
        initData();
        initView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView_tiezi = (RecyclerView) findViewById(R.id.recyclerView_tiezi);

    }

    private void initView() {
        textView_username_tiezi = (TextView) findViewById(R.id.textView_username_tiezi);
        textView_time_tiezi = (TextView) findViewById(R.id.textView_time_tiezi);
        textView_title_tiezi = (TextView) findViewById(R.id.textView_title_tiezi);
        textView_content_tiezi = (TextView) findViewById(R.id.textView_content_tiezi);
        textView_dianzan_tiezi = (TextView) findViewById(R.id.textView_dianzan_tiezi);
        textView_pinglun_tiezi = (TextView) findViewById(R.id.textView_pinglun_tiezi);
        imageView_head_tiezi = (ImageView) findViewById(R.id.imageView_head_tiezi);
        imageView_quanzi_photo0 = (ImageView) findViewById(R.id.imageView_quanzi_photo0);
        imageView_quanzi_photo1 = (ImageView) findViewById(R.id.imageView_quanzi_photo1);
        imageView_quanzi_photo2 = (ImageView) findViewById(R.id.imageView_quanzi_photo2);
        imageView_quanzi_photo3 = (ImageView) findViewById(R.id.imageView_quanzi_photo3);
        imageView_quanzi_photo4 = (ImageView) findViewById(R.id.imageView_quanzi_photo4);
        imageView_quanzi_photo5 = (ImageView) findViewById(R.id.imageView_quanzi_photo5);
        imageView_quanzi_photo6 = (ImageView) findViewById(R.id.imageView_quanzi_photo6);
        imageView_quanzi_photo7 = (ImageView) findViewById(R.id.imageView_quanzi_photo7);
        imageView_quanzi_photo8 = (ImageView) findViewById(R.id.imageView_quanzi_photo8);
        linearLayout_tupian = (LinearLayout) findViewById(R.id.linearLayout_tupian);
        linearLayout_item1 = (LinearLayout) findViewById(R.id.linearLayout_item1);
        linearLayout_item2 = (LinearLayout) findViewById(R.id.linearLayout_item2);
        linearLayout_item0 = (LinearLayout) findViewById(R.id.linearLayout_item0);
        operateView();

    }

    //对View进行赋值
    private void operateView() {
        String headURL = cBean.getUserext().getFace();
        Glide.with(mContext).load(Uri.parse(headURL)).centerCrop().into(imageView_head_tiezi);
        //用户名
        String username = cBean.getUserext().getNick();
        textView_username_tiezi.setText(username);
        //时间
        String time = TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
        textView_time_tiezi.setText(time);
        //标题
        String title = cBean.getTitle();
        textView_title_tiezi.setText(title);
        //content(可能为空)
        if ((cBean.getContent().isEmpty())){
            textView_content_tiezi.setVisibility(View.GONE);
        }else {
            textView_content_tiezi.setText(cBean.getContent());
        }
        //图片 ,判断数组长度
        int attachLength=cBean.getAttach().size();
        String photo0,photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8;
        switch (attachLength){
            case 0:
                linearLayout_tupian.setVisibility(View.GONE);
                break;
            case 1:
                photo0 = cBean.getAttach().get(0);
                useGlide(photo0,imageView_quanzi_photo0);
                imageView_quanzi_photo1.setVisibility(View.INVISIBLE);
                imageView_quanzi_photo2.setVisibility(View.INVISIBLE);
                linearLayout_item1.setVisibility(View.GONE);
                linearLayout_item2.setVisibility(View.GONE);
                break;
            case 2:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                imageView_quanzi_photo2.setVisibility(View.INVISIBLE);
                linearLayout_item1.setVisibility(View.GONE);
                linearLayout_item2.setVisibility(View.GONE);
                break;
            case 3:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                linearLayout_item1.setVisibility(View.GONE);
                linearLayout_item2.setVisibility(View.GONE);
                break;
            case 4:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                photo3 = cBean.getAttach().get(3);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                useGlide(photo3,imageView_quanzi_photo3);
                imageView_quanzi_photo4.setVisibility(View.INVISIBLE);
                imageView_quanzi_photo5.setVisibility(View.INVISIBLE);
                linearLayout_item2.setVisibility(View.GONE);
                break;
            case 5:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                photo3 = cBean.getAttach().get(3);
                photo4 = cBean.getAttach().get(4);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                useGlide(photo3,imageView_quanzi_photo3);
                useGlide(photo4,imageView_quanzi_photo4);
                imageView_quanzi_photo5.setVisibility(View.INVISIBLE);
                linearLayout_item2.setVisibility(View.GONE);
                break;
            case 6:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                photo3 = cBean.getAttach().get(3);
                photo4 = cBean.getAttach().get(4);
                photo5 = cBean.getAttach().get(5);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                useGlide(photo3,imageView_quanzi_photo3);
                useGlide(photo4,imageView_quanzi_photo4);
                useGlide(photo5,imageView_quanzi_photo5);
                linearLayout_item2.setVisibility(View.GONE);
                break;
            case 7:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                photo3 = cBean.getAttach().get(3);
                photo4 = cBean.getAttach().get(4);
                photo5 = cBean.getAttach().get(5);
                photo6 = cBean.getAttach().get(6);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                useGlide(photo3,imageView_quanzi_photo3);
                useGlide(photo4,imageView_quanzi_photo4);
                useGlide(photo5,imageView_quanzi_photo5);
                useGlide(photo6,imageView_quanzi_photo6);
                imageView_quanzi_photo7.setVisibility(View.INVISIBLE);
                imageView_quanzi_photo8.setVisibility(View.INVISIBLE);
                break;
            case 8:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                photo3 = cBean.getAttach().get(3);
                photo4 = cBean.getAttach().get(4);
                photo5 = cBean.getAttach().get(5);
                photo6 = cBean.getAttach().get(6);
                photo7 = cBean.getAttach().get(7);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                useGlide(photo3,imageView_quanzi_photo3);
                useGlide(photo4,imageView_quanzi_photo4);
                useGlide(photo5,imageView_quanzi_photo5);
                useGlide(photo6,imageView_quanzi_photo6);
                useGlide(photo7,imageView_quanzi_photo7);
                imageView_quanzi_photo8.setVisibility(View.INVISIBLE);
                break;
            case 9:
                photo0 = cBean.getAttach().get(0);
                photo1 = cBean.getAttach().get(1);
                photo2 = cBean.getAttach().get(2);
                photo3 = cBean.getAttach().get(3);
                photo4 = cBean.getAttach().get(4);
                photo5 = cBean.getAttach().get(5);
                photo6 = cBean.getAttach().get(6);
                photo7 = cBean.getAttach().get(7);
                photo8 = cBean.getAttach().get(8);
                useGlide(photo0,imageView_quanzi_photo0);
                useGlide(photo1,imageView_quanzi_photo1);
                useGlide(photo2,imageView_quanzi_photo2);
                useGlide(photo3,imageView_quanzi_photo3);
                useGlide(photo4,imageView_quanzi_photo4);
                useGlide(photo5,imageView_quanzi_photo5);
                useGlide(photo6,imageView_quanzi_photo6);
                useGlide(photo7,imageView_quanzi_photo7);
                useGlide(photo8,imageView_quanzi_photo8);
                break;
        }
        int dianzan = cBean.getZanCount();
        textView_dianzan_tiezi.setText(String.valueOf(dianzan));
        //评论数
        int pinglun = cBean.getDiscussCount();
        textView_pinglun_tiezi.setText(String.valueOf(pinglun));
    }
    private void useGlide(String url,ImageView imageView){
        Glide.with(mContext).load(Uri.parse(url))
                .placeholder(R.drawable.imageloading)
                //.transform(new GlideRoundTransform(mContext,10)) //加载圆角图片
                .into(imageView);

    }
    private void initData() {
        Intent intent = getIntent();
        cBean = (TuiJianBean.CBean) intent.getSerializableExtra("CBean");
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar_tiezi);
        mToolbar.setTitle("帖子");
        setSupportActionBar(mToolbar);
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
