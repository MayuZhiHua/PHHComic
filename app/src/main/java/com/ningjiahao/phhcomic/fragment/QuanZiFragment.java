package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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
public class QuanZiFragment extends BaseFragment {

    private TabLayout mTabLayout_quanzi;
    private NoScrollViewPager mViewPager_quanzi;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] mTabs = {"推荐","最新","我的关注"};
    private QuanZiFragmentAdapter adapter;


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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        TuiJianFragment tuiJianFragment=new TuiJianFragment();
        ZuiXinFragment zuiXinFragment = new ZuiXinFragment();
        MyAttentionFragment myAttentionFragment = new MyAttentionFragment();
        fragmentList.add(tuiJianFragment);
        fragmentList.add(zuiXinFragment);
        fragmentList.add(myAttentionFragment);
        adapter = new QuanZiFragmentAdapter(getChildFragmentManager(),fragmentList,mTabs);
        mViewPager_quanzi.setAdapter(adapter);

        mTabLayout_quanzi.setupWithViewPager(mViewPager_quanzi);
    }
}
