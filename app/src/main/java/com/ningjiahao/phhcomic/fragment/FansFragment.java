package com.ningjiahao.phhcomic.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.FansAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.FansBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.decoration.DividerItemDecoration;
import com.ningjiahao.phhcomic.widget.RecyclerViewEmptySupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class FansFragment extends BaseFragment {
    private String url;
    private String oid;
    private RecyclerViewEmptySupport recyclerView_fans;
    private FansAdapter adapter;
    private List<FansBean.CBean> cBeanList = new ArrayList<>();
    private Map<String,String> map = new HashMap<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fans, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView_fans = (RecyclerViewEmptySupport) view.findViewById(R.id.recyclerView_fans);
        adapter = new FansAdapter(mContext,cBeanList);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        recyclerView_fans.setAdapter(adapter);
        recyclerView_fans.setEmptyView(inflater.inflate(R.layout.fans_empty,null));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView_fans.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration=new DividerItemDecoration(mContext,1);
        recyclerView_fans.addItemDecoration(itemDecoration);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        //根据intent类型判断
        Bundle bundle = getArguments();
        int type = bundle.getInt("type");
        oid = bundle.getString("oid");
        if (type ==100){
            url = URLConstants.FANS_URL;
        }else if(type == 200){
            url = URLConstants.FOLLOW_URL;
        }
        //proid=1&hisoid=146673837337441&usert=&start=1479379914&count=50&from=4
        //proid=1&hisoid=146675784289172&usert=&start=1479380859&count=50&from=4
        //下载数据源

        Date date = new Date();
        long time = date.getTime();
        map.put("proid","1");
        map.put("hisoid",oid);
        map.put("usert","");
        map.put("start",String.valueOf(time));
        map.put("count","50");
        map.put("from","4");
        mRetrofitApi.getFansBean(url,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FansBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("FansFragment","数据加载出错了");
                    }

                    @Override
                    public void onNext(FansBean fansBean) {
                        cBeanList.clear();
                        cBeanList.addAll(fansBean.getC());
                        adapter.notifyDataSetChanged();

                    }
                });
    }
}
