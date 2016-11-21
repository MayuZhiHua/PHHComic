package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.QuanZiRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 个人主页中的发布的Fragment
 * A simple {@link Fragment} subclass.
 */
public class FabuFragment extends BaseFragment {

    private RecyclerView recyclerView_fabu;
    private SwipeRefreshLayout swipeRefreshLayout_fabu;
    private List<TuiJianBean.CBean> cBeanList = new ArrayList<>();
    private QuanZiRecyclerAdapter quanZiRecyclerAdapter;
    private String oid;
    private Map<String,String> map=new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fabu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView_fabu = (RecyclerView) view.findViewById(R.id.recyclerView_fabu);
        swipeRefreshLayout_fabu = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout_fabu);
        quanZiRecyclerAdapter = new QuanZiRecyclerAdapter(mContext,cBeanList);
        recyclerView_fabu.setAdapter(quanZiRecyclerAdapter);
        LinearLayoutManager manager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView_fabu.setLayoutManager(manager);
        //设置进度条北京颜色
        swipeRefreshLayout_fabu.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.whitesmoke));
        //设置进度条变化颜色
        swipeRefreshLayout_fabu.setColorSchemeColors(getResources().getColor(R.color.darkgray),getResources().getColor(R.color.whitesmoke));
        //设置进度圈的大小
        swipeRefreshLayout_fabu.setSize(SwipeRefreshLayout.DEFAULT);
        //设置刷新
        swipeRefreshLayout_fabu.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRetrofitApi.getTuiJianBean(URLConstants.FABU_URL,map)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<TuiJianBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("FabuFragment","刷新数据源出错了");
                            }

                            @Override
                            public void onNext(TuiJianBean tuiJianBean) {
                                cBeanList.clear();
                                cBeanList.addAll(tuiJianBean.getC());
                                quanZiRecyclerAdapter.notifyDataSetChanged();
                                swipeRefreshLayout_fabu.setRefreshing(false);
                            }
                        });
            }
        });


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        Bundle bundle = getArguments();
        oid = bundle.getString("oid");
        //proid=1&hisoid=146673837337441&usert=&start=1479379914&count=50&from=4
        Date date = new Date();
        Long time = date.getTime();
        map.put("proid","1");
        map.put("hisoid",oid);
        map.put("usert","");
        map.put("start",String.valueOf(time));
        map.put("count","50");
        map.put("from","4");
        mRetrofitApi.getTuiJianBean(URLConstants.FABU_URL,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TuiJianBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("FabuFragment","加载数据源出错了");
                    }

                    @Override
                    public void onNext(TuiJianBean tuiJianBean) {
                        cBeanList.addAll(tuiJianBean.getC());
                        quanZiRecyclerAdapter.notifyDataSetChanged();

                    }
                });
    }


}
