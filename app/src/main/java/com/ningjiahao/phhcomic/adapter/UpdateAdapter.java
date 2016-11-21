package com.ningjiahao.phhcomic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-18.
 */

public class UpdateAdapter extends FragmentPagerAdapter{
    private String[] Title;
    private List<Fragment> list;
    public UpdateAdapter(FragmentManager fm,String[] Title,List<Fragment> list) {
        super(fm);
        this.Title=Title;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Title[position];

    }
}
