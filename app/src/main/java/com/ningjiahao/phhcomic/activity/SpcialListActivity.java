package com.ningjiahao.phhcomic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.SpecialListRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.SpecialListBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SpcialListActivity extends BaseActivity {
    private Toolbar speciallist_tool;
    private RecyclerView speciallist_recycler;
    private SpecialListRecyclerAdapter SLRAdapter;
    private List<SpecialListBean.CBean.SBean> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spcial_list);
        initView();
        initData();
    }

    private void initData() {
        myRetrofitApi.getSpecialListBean(URLConstants.URL_SPECIAL_DATA)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SpecialListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SpecialListBean specialListBean) {
                        List<SpecialListBean.CBean.SBean> s = specialListBean.getC().getS();
                        SLRAdapter.reloadRecyclerView(s,true);
                    }
                });
    }

    private void initView() {
        speciallist_tool= (Toolbar) findViewById(R.id.speciallist_tool);
        speciallist_recycler= (RecyclerView) findViewById(R.id.speciallist_recycler);
        SLRAdapter=new SpecialListRecyclerAdapter(mContext,list);
        speciallist_recycler.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        speciallist_recycler.setAdapter(SLRAdapter);
        speciallist_tool.setNavigationIcon(R.mipmap.navi_back_h);
        speciallist_tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
