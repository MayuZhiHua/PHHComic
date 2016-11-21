package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.RankFragmentRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.HotRankBean;
import com.ningjiahao.phhcomic.bean.OverRankBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankFragment extends BaseFragment {
    private RecyclerView rank_fragment_recycler;
    private int flag;
    private RankFragmentRecyclerAdapter rankFragmentRecyclerAdapter;
    private List<Object> list=new ArrayList<>();

    public RankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("Tag","onCreateView");
        return inflater.inflate(R.layout.fragment_rank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("Tag","onViewCreated");
        flag=getArguments().getInt("key");
        rank_fragment_recycler= (RecyclerView) view.findViewById(R.id.rank_fragment_recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Tag","onActivityCreated");
        rankFragmentRecyclerAdapter=new RankFragmentRecyclerAdapter(mContext,list);
        rank_fragment_recycler.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        rank_fragment_recycler.setAdapter(rankFragmentRecyclerAdapter);
        loadData();
    }
    public void loadData(){
        switch (flag){
            case 0:
                mRetrofitApi.getHotRankBean(URLConstants.URL_HOT_RANK_DATA)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<HotRankBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(mContext,"获取热门数据出错" , Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(HotRankBean hotRankBean) {
                                List<HotRankBean.CBean.SBean> s = hotRankBean.getC().getS();
                                list.addAll(s);
                                rankFragmentRecyclerAdapter.notifyDataSetChanged();
                            }
                        });
                break;
            case 1:
                mRetrofitApi.getOverRankBean(URLConstants.URL_OVER_RANK_DATA)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<OverRankBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(mContext,"获取完结数据出错" , Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(OverRankBean overRankBean) {
                                List<OverRankBean.CBean.SBean> s = overRankBean.getC().getS();
                                list.addAll(s);
                                rankFragmentRecyclerAdapter.notifyDataSetChanged();
                            }
                        });
                break;
        }
    }
}
