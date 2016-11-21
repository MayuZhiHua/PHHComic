package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.ningjiahao.phhcomic.activity.ManHuaDetailActivity;
import com.ningjiahao.phhcomic.activity.WebActivity;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-16.
 */

public class ManHuaKuViewPagerAdapter extends PagerAdapter {
    private List<View> list;
    private List<ManHuaKuBean.CBean.CarouselBean> pagerData;
    private Context mContext;

    public ManHuaKuViewPagerAdapter(List<View> list,List<ManHuaKuBean.CBean.CarouselBean> pagerData,Context mContext) {
        this.list = list;
        this.pagerData=pagerData;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = list.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        if(pagerData.get(position).getLink().contains("chapter/comicid")){
                            intent.setClass(mContext,ManHuaDetailActivity.class);
                            intent.putExtra("key",Integer.valueOf(pagerData.get(position).getSubid()));
                            mContext.startActivity(intent);
                        }else if(pagerData.get(position).getLink().contains("special/specialid")){
                            intent.setClass(mContext,WebActivity.class);
                            intent.putExtra("key",Integer.valueOf(pagerData.get(position).getSubid()));
                            mContext.startActivity(intent);
                        }

            }
        });
            container.addView(view);
            return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
