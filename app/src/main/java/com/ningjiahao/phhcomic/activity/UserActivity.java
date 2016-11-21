package com.ningjiahao.phhcomic.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.QuanZiFragmentAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.bean.UserBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.fragment.FabuFragment;
import com.ningjiahao.phhcomic.fragment.FansFragment;
import com.ningjiahao.phhcomic.fragment.TuiJianFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.http.PUT;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserActivity extends BaseActivity {
    private Context mContext = this;
    private String oid;
    private Toolbar toolbar_user;
    private TextView textView_username_user,textView_qianming_user,textView_zanshu_user;
    private ImageView imageView_head_user;
    private TabLayout tabLayout_user;
    private ViewPager viewPager_user;
    private QuanZiFragmentAdapter adapter;
    private String[] mTabs = {"发布","粉丝","我的关注"};
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initIntent();
    }

    private void initIntent() {
        Intent intent= getIntent();
        oid=intent.getStringExtra("oid");
        initData();
    }

    private void initData() {
        //http://common.moyougames.com/User/hisinfo?proid=1&hisoid=146849325256980&usert=&from=4
        Map<String,String> map = new HashMap<>();
        map.put("proid","1");
        map.put("hisoid",oid);
        map.put("usert","");
        map.put("from","4");
        myRetrofitApi.getUserBean(URLConstants.USER_URL,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("UserActivity","UserActivity网络访问出错了");
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        initView(userBean);
                    }
                });
        /*Map<String,String> map = new HashMap<>();
        Date date =new Date();
        Long time = date.getTime();
        //Log.e("UserActivity",oid);
        map.put("proid","1");
        map.put("hisoid",oid);
        map.put("usert","");
        map.put("start",String.valueOf(time/1000));
        //Log.e("UserActivity",String.valueOf(time/1000));
        map.put("count","50");
        map.put("from","4");
        Log.e("UserActivity",URLConstants.FABU_URL+"?"+"proid=1&hisoid="+oid+"&usert=&start&"+String.valueOf(time/1000)+"&coun=50&from=4");
        myRetrofitApi.getTuiJianBean(URLConstants.FABU_URL,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TuiJianBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("UserActivity","UserActivity网络访问出错了");
                    }

                    @Override
                    public void onNext(TuiJianBean tuiJianBean) {
                    initView(tuiJianBean);
                    }
                });*/
    }

    private void initView(UserBean userBean) {

        String name = userBean.getC().getNick();
        //Toolbar
        toolbar_user = (Toolbar) findViewById(R.id.toolBar_user);
        toolbar_user.setTitle(name+"的主页");
        toolbar_user.setTitleTextAppearance(this,R.style.MyToolBar);
        setSupportActionBar(toolbar_user);
        ActionBar actionBar=getSupportActionBar();
        //给左上角图标的左边加上一个返回的图标
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 自定义返回按钮（默认是返回箭头）
        actionBar.setHomeAsUpIndicator(R.mipmap.common_back_n);
        //头像
        String headURL = userBean.getC().getFace();
        imageView_head_user= (ImageView) findViewById(R.id.imageView_head_user);
        Glide.with(mContext).load(Uri.parse(headURL)).centerCrop().into(imageView_head_user);
        //用户名
        textView_username_user = (TextView) findViewById(R.id.textView_username_user);
        textView_username_user.setText(name);
        //个性签名
        textView_qianming_user = (TextView) findViewById(R.id.textView_qianming_user);
        String gxQianMing = userBean.getC().getMotto();
        textView_qianming_user.setText(gxQianMing);
        //关注
        textView_zanshu_user= (TextView) findViewById(R.id.textView_zanshu_user);
        String guanzhu = String.valueOf(userBean.getC().getZanCount());
        textView_zanshu_user.setText(guanzhu);
        //TabLayout
        tabLayout_user = (TabLayout) findViewById(R.id.tabLayout_user);
        //让TabLayout字体充满宽
        tabLayout_user.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout_user.setTabMode(TabLayout.MODE_FIXED);
        viewPager_user = (ViewPager) findViewById(R.id.viewPager_user);
        //传递oid获得个人数据
        FabuFragment fabuFragment = new FabuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("oid",oid);
        fabuFragment.setArguments(bundle);
        //粉丝页面是100，关注页面是200
        FansFragment fansFragment = new FansFragment();
        Bundle bundle1 =new Bundle();
        bundle1.putString("oid",oid);
        bundle1.putInt("type",100);
        fansFragment.setArguments(bundle1);
        FansFragment guanzhuFragment = new FansFragment();
        Bundle bundle2 =new Bundle();
        bundle2.putString("oid",oid);
        bundle2.putInt("type",200);
        guanzhuFragment.setArguments(bundle2);

        fragmentList.add(fabuFragment);
        fragmentList.add(fansFragment);
        fragmentList.add(guanzhuFragment);
        adapter = new QuanZiFragmentAdapter(getSupportFragmentManager(),fragmentList,mTabs);
        viewPager_user.setAdapter(adapter);
        tabLayout_user.setupWithViewPager(viewPager_user);
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
