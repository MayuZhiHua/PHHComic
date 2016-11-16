package com.ningjiahao.phhcomic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by My on 2016/11/15.
 */

public class FindPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment>mList;



    public FindPagerAdapter(FragmentManager fm,List<Fragment>list) {
        super(fm);
        mList=list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }




}
