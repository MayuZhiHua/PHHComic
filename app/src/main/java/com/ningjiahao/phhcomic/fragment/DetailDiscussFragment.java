package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.DetailDiscussAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.ManHuaDiscussBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDiscussFragment extends BaseFragment {
    private RecyclerView manhuadetail_discuss_recylerview;
    private DetailDiscussAdapter detailDiscussAdapter;
    private int id;


    public DetailDiscussFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_discuss, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        manhuadetail_discuss_recylerview= (RecyclerView) view.findViewById(R.id.manhuadetail_discuss_recylerview);
        id=getArguments().getInt("key");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Map<String,Object> map=new HashMap<>();
        map.put("proid",1);
        map.put("subno",3);
        map.put("subid",id);
        Date date=new Date();
        long time = date.getTime()/1000;
        map.put("start",time);
        map.put("count",25);
        map.put("from",4);
        mRetrofitApi.getManHuaDiscussBean(URLConstants.URL_MANHUADISCUSS,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ManHuaDiscussBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ManHuaDiscussBean manHuaDiscussBean) {
                        List<ManHuaDiscussBean.CBean> c = manHuaDiscussBean.getC();
                        detailDiscussAdapter=new DetailDiscussAdapter(mContext,c);
                        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
                        manhuadetail_discuss_recylerview.setLayoutManager(layoutManager);
                        manhuadetail_discuss_recylerview.setAdapter(detailDiscussAdapter);
                    }
                });
    }
}
