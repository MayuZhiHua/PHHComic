package com.ningjiahao.phhcomic.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningjiahao.phhcomic.activity.LoginActivity;
import com.ningjiahao.phhcomic.adapter.QuanZiFragmentAdapter;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuanZiFragment extends BaseFragment {

    private TabLayout mTabLayout_quanzi;
    private NoScrollViewPager mViewPager_quanzi;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] mTabs = {"推荐","最新","我的关注"};
    private QuanZiFragmentAdapter adapter;
    private AlertDialog alertDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quan_zi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout_quanzi = (TabLayout) view.findViewById(R.id.tabLayout_quanzi);
        //让TabLayout字体充满宽
        mTabLayout_quanzi.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout_quanzi.setTabMode(TabLayout.MODE_FIXED);
        mViewPager_quanzi = (NoScrollViewPager) view.findViewById(R.id.viewPager_quanzi);
        //设置ViewPager不能滑动
        mViewPager_quanzi.setNoScroll(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("撸卡漫画")  //设置标题
                .setMessage("请前往登录")  //设置内容
                .setCancelable(true) //设置点击对话框之外区域取消或关闭
                //设置确定按钮
                .setPositiveButton("前往", new DialogInterface.OnClickListener() {
                    //添加按钮1
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //调到登录页面
                        Intent intent = new Intent(mContext, LoginActivity.class);
                        startActivity(intent);
                    }
                })
                //设置取消按钮
                .setNegativeButton("取消", null);
        alertDialog=builder.create();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        TuiJianFragment tuiJianFragment=new TuiJianFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("QuanZiFragment",0);
        tuiJianFragment.setArguments(bundle);
        ZuiXinFragment zuiXinFragment = new ZuiXinFragment();
        MyAttentionFragment myAttentionFragment = new MyAttentionFragment();
        fragmentList.add(tuiJianFragment);
        fragmentList.add(zuiXinFragment);
        fragmentList.add(myAttentionFragment);
        adapter = new QuanZiFragmentAdapter(getChildFragmentManager(),fragmentList,mTabs);
        mViewPager_quanzi.setAdapter(adapter);
        mTabLayout_quanzi.setupWithViewPager(mViewPager_quanzi);
        mTabLayout_quanzi.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Log.e("QuanZiFragment",tab.getPosition()+"");
                switch (tab.getPosition()){
                    case 2:
                        alertDialog.show();
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
