package com.ningjiahao.phhcomic.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.WebRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.WebBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.R.attr.format;

public class WebActivity extends BaseActivity {
    private WebView web_web;
    private int id;
    private RecyclerView web_recycler;
    private WebRecyclerAdapter webAdapter;
    private List<Object> list=new ArrayList<>();
    private Toolbar web_tool;
    private TextView web_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        initData();
}

    private void initData() {
        String format = String.format(URLConstants.URL_WEB_DATA, id);
        myRetrofitApi.getWebBean(format)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WebBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WebBean webBean) {
                        List<WebBean.CBean.ListBean> list = webBean.getC().getList();
                        WebBean.CBean.DetailBean detail = webBean.getC().getDetail();
                        web_text.setText(detail.getName());
                        List<Object> add=new ArrayList<Object>();
                        add.add(detail);
                        add.addAll(list);
                        webAdapter.reloadRecyclerView(add,true);

                    }
                });
    }


    private void initView() {
        web_tool= (Toolbar) findViewById(R.id.web_tool);
        web_tool.setNavigationIcon(R.mipmap.navi_back_h);
        web_tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        web_text= (TextView) findViewById(R.id.web_text);
        web_web= (WebView) findViewById(R.id.web_web);
        web_recycler= (RecyclerView) findViewById(R.id.web_recycler);
        id = getIntent().getIntExtra("key", 0);
        webAdapter=new WebRecyclerAdapter(mContext,list);
        GridLayoutManager grid=new GridLayoutManager(mContext,3);
        grid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(webAdapter.getItemViewType(position)==webAdapter.NUM1){
                    return 3;
                }
                return 1;
            }
        });
        web_recycler.setLayoutManager(grid);
        web_recycler.setAdapter(webAdapter);

    }
}
