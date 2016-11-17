package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningjiahao.phhcomic.QuanZiFragmentAdapter;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiaoWoFragment extends BaseFragment {
    private TabLayout mTabLayout_xiaowo;
    private NoScrollViewPager mViewPager_xiaowo;
    private QuanZiFragmentAdapter adapter;
    private String[] mTabs = {"我的帖子","收藏","下载"};
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_xiao_wo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout_xiaowo= (TabLayout) view.findViewById(R.id.tabLayout_xiaowo);
        mTabLayout_xiaowo.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout_xiaowo.setTabMode(TabLayout.MODE_FIXED);
        mViewPager_xiaowo = (NoScrollViewPager)view.findViewById(R.id.viewPager_xiaowo);
        //设置ViewPager不能滑动
        mViewPager_xiaowo.setNoScroll(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        WoDeTieZiFragment woDeTieZiFragment = new WoDeTieZiFragment();
        ShouCangFragment shouCangFragment = new ShouCangFragment();
        XiaZaiFragment xiaZaiFragment = new XiaZaiFragment();
        fragmentList.add(woDeTieZiFragment);
        fragmentList.add(shouCangFragment);
        fragmentList.add(xiaZaiFragment);
        adapter = new QuanZiFragmentAdapter(getChildFragmentManager(),fragmentList,mTabs);
        mViewPager_xiaowo.setAdapter(adapter);
        mTabLayout_xiaowo.setupWithViewPager(mViewPager_xiaowo);
    }
}
