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

import com.ningjiahao.phhcomic.adapter.QuanZiRecyclerAdapter;
import com.ningjiahao.phhcomic.R;
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
 * A simple {@link Fragment} subclass.
 */
public class TuiJianFragment extends BaseFragment {

    private RecyclerView recyclerView_tuijian;
    private SwipeRefreshLayout swipeRefreshLayout_tuijian;
    private List<TuiJianBean.CBean> cBeanList = new ArrayList<>();
    private QuanZiRecyclerAdapter quanZiRecyclerAdapter;
    private int page =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tui_jian, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView_tuijian = (RecyclerView) view.findViewById(R.id.recyclerView_tuijian);
        quanZiRecyclerAdapter = new QuanZiRecyclerAdapter(mContext,cBeanList);
        recyclerView_tuijian.setAdapter(quanZiRecyclerAdapter);
        final LinearLayoutManager manager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView_tuijian.setLayoutManager(manager);


        //Recycler滑动到底部加载更多的监听
        recyclerView_tuijian.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE){//RecyclerView滑动到底部了
                    page++;
                    int lastVisiblePosition = manager.findLastVisibleItemPosition();
                    if(lastVisiblePosition >= manager.getItemCount() - 1){
                        Map<String,String> map = new HashMap<>();
                        map.put("proid","1");
                        map.put("usert","1");
                        map.put("page",page+"");
                        map.put("count","15");
                        map.put("from","4");
                        mRetrofitApi.getTuiJianBean(URLConstants.TUIJIAN_URL,map)
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<TuiJianBean>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(TuiJianBean tuiJianBean) {
                                        cBeanList.addAll(tuiJianBean.getC());
                                        //刷新适配器
                                        quanZiRecyclerAdapter.reloadRecyclerView(cBeanList,true);
                                    }
                                });
                    }
                }
            }
        });

        swipeRefreshLayout_tuijian = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout_tuijian);
        //设置进度条北京颜色
        swipeRefreshLayout_tuijian.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.whitesmoke));
        //设置进度条变化颜色
        swipeRefreshLayout_tuijian.setColorSchemeColors(getResources().getColor(R.color.darkgray),getResources().getColor(R.color.whitesmoke));
        //设置进度圈的大小
        swipeRefreshLayout_tuijian.setSize(SwipeRefreshLayout.DEFAULT);
        //设置刷新
        swipeRefreshLayout_tuijian.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Map<String,String> map = new HashMap<>();
                map.put("proid","1");
                map.put("usert","1");
                map.put("page","0");
                map.put("count","15");
                map.put("from","4");
                mRetrofitApi.getTuiJianBean(URLConstants.TUIJIAN_URL,map)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<TuiJianBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                //Log.e("TuiJianFragment","初始化数据出错了");
                            }

                            @Override
                            public void onNext(TuiJianBean tuiJianBean) {
                                //Log.e("TuiJianFragment",tuiJianBean.getC().get(0).getTitle());
                                cBeanList = tuiJianBean.getC();
                                //刷新适配器
                                quanZiRecyclerAdapter.reloadRecyclerView(cBeanList,true);
                                //停止刷新
                                swipeRefreshLayout_tuijian.setRefreshing(false);
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
        //proid=1&usert=&page=0&count=15&from=4
        Map<String,String> map = new HashMap<>();
        map.put("proid","1");
        map.put("usert","1");
        map.put("page","0");
        map.put("count","15");
        map.put("from","4");

        mRetrofitApi.getTuiJianBean(URLConstants.TUIJIAN_URL,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TuiJianBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //Log.e("TuiJianFragment","初始化数据出错了");
                    }

                    @Override
                    public void onNext(TuiJianBean tuiJianBean) {
                        //Log.e("TuiJianFragment",tuiJianBean.getC().get(0).getTitle());
                        cBeanList = tuiJianBean.getC();
                        //刷新适配器
                        quanZiRecyclerAdapter.reloadRecyclerView(cBeanList,true);
                    }
                });
    }
}
