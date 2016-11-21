package com.ningjiahao.phhcomic.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.ningjiahao.phhcomic.adapter.TieZiPlRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.TieZiPlBean;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.decoration.DividerItemDecoration;
import com.ningjiahao.phhcomic.helper.TimeHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TieZiActivity extends BaseActivity implements View.OnClickListener{
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
    private TieZiPlRecyclerAdapter adapter;
    private List<TieZiPlBean.CBean> cBeanList = new ArrayList<>();

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
        imageView_head_tiezi.setOnClickListener(this);
       /* imageView_quanzi_photo0.setOnClickListener(this);
        imageView_quanzi_photo1.setOnClickListener(this);
        imageView_quanzi_photo2.setOnClickListener(this);
        imageView_quanzi_photo3.setOnClickListener(this);
        imageView_quanzi_photo4.setOnClickListener(this);
        imageView_quanzi_photo5.setOnClickListener(this);
        imageView_quanzi_photo6.setOnClickListener(this);
        imageView_quanzi_photo7.setOnClickListener(this);
        imageView_quanzi_photo8.setOnClickListener(this);*/
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
        String subid = cBean.getId();
        //获得时间
        Date date = new Date();
        Long time =date.getTime();
        //获得评论的数据
        Map<String,String> map=new HashMap<>();
        map.put("proid","1");
        map.put("subno","9");
        map.put("subid",subid);
        map.put("usert","");
        map.put("start",""+time/1000);
        map.put("count","10");
        map.put("from","4");
        myRetrofitApi.getTieZiPlBean(URLConstants.TIEZIPL_URL,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TieZiPlBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TieZiActivity","获取帖子评论的Bean出错");
                    }

                    @Override
                    public void onNext(TieZiPlBean tieZiPlBean) {
                        //Log.e("TieZiActivity",tieZiPlBean.getC().get(0).getContent());
                        cBeanList.addAll(tieZiPlBean.getC());
                        LinearLayoutManager manager =new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
                        adapter = new TieZiPlRecyclerAdapter(mContext,cBeanList);
                        recyclerView_tiezi.setAdapter(adapter);
                        recyclerView_tiezi.setLayoutManager(manager);
                        DividerItemDecoration itemDecoration=new DividerItemDecoration(mContext,1);
                        recyclerView_tiezi.addItemDecoration(itemDecoration);
                    }
                });
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar_tiezi);
        mToolbar.setTitle("帖子");
        mToolbar.setTitleTextAppearance(this,R.style.MyToolBar);
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

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        List<String> attach = cBean.getAttach();
        switch (v.getId()) {
            case R.id.imageView_head_tiezi:
                intent.setClass(mContext, UserActivity.class);
                intent.putExtra("oid", cBean.getUserext().getOid());
                intent.putExtra("ct", cBean.getUserext().getCt());
                break;
        }
        startActivity(intent);
    }
}
