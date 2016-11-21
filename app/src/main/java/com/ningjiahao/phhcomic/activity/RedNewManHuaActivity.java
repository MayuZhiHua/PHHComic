package com.ningjiahao.phhcomic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.RedNewAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.RedNewBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RedNewManHuaActivity extends BaseActivity {
    private Toolbar RedNew_tool;
    private RecyclerView RedNew_recycler;
    private RedNewAdapter redNewAdapter;
    private TextView tool_text;
    private List<RedNewBean.CBean.SBean> list=new ArrayList<>();
    String title;
    int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_new_man_hua);
        initView();
        initData();
    }

    private void initData() {
        loadData(getUrl(),true);
        RedNew_recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    page++;
                    loadData(getUrl(),false);
                }
            }
        });
    }

    private void initView() {
        title=getIntent().getStringExtra("key");
        RedNew_tool= (Toolbar) findViewById(R.id.RedNew_tool);
        RedNew_tool.setNavigationIcon(R.mipmap.navi_back_h);
        RedNew_recycler= (RecyclerView) findViewById(R.id.RedNew_recycler);
        redNewAdapter=new RedNewAdapter(mContext,list);
        tool_text= (TextView) findViewById(R.id.tool_text);
        tool_text.setText(title);
        RedNew_recycler.setLayoutManager(new GridLayoutManager(mContext,3));
        RedNew_recycler.setAdapter(redNewAdapter);
        RedNew_tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public String getUrl(){
        if(title.equals("最热漫画")){
            return String.format(URLConstants.URL_RED_DATA,page);
        }else if(title.equals("最新漫画")){
            return String.format(URLConstants.URL_NEW_DATA,page);
        }
        return null;
    }
    public void loadData(String url,final boolean flag){
        myRetrofitApi.getRedNewBean(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RedNewBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RedNewBean redNewBean) {
                        List<RedNewBean.CBean.SBean> s = redNewBean.getC().getS();
                        redNewAdapter.reloadRecyclerView(s,flag);
                    }
                });
    }
}
