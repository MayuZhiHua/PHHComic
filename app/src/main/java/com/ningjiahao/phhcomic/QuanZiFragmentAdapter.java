package com.ningjiahao.phhcomic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by HP on 2016/11/15.
 */

public class QuanZiFragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] tabs;

    public QuanZiFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] tabs) {
        super(fm);
        this.fragmentList=fragmentList;
        this.tabs=tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //绑定Tab的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
