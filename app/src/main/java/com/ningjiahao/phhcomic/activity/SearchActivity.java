package com.ningjiahao.phhcomic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.SearchAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.SearchDefaultBean;
import com.ningjiahao.phhcomic.bean.SearchResultBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.decoration.DividerItemDecoration;
import com.ningjiahao.phhcomic.decoration.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SearchActivity extends BaseActivity{

    private RecyclerView mRecyclerview;

    private List<Object> mList;

    private SearchAdapter mSearchAdapter;

    private String search=null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
        initNetData();
    }

    private void initNetData() {
        Intent intent=getIntent();
        search=intent.getStringExtra(URLConstants.KEY_SEARCH);
        if (!TextUtils.isEmpty(search)){
        String url=String.format(URLConstants.FIND_SEARCH_URL,search);
        Observable<SearchResultBean>observable=myRetrofitApi.getSearchResult(url);
            observable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Subscriber<SearchResultBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(SearchResultBean searchResultBean) {
                            if(searchResultBean.getC().getS().size()==0){

                                initDefaultData();

                            }else {

                                initRecyclerView1(searchResultBean.getC().getS());
                            }




                        }
                    });

        }else {
            Toast.makeText(this,"请输入要搜索的内容",Toast.LENGTH_SHORT).show();
            mList=new ArrayList<>();
            mSearchAdapter=new SearchAdapter(mList,this,search,3);
            LinearLayoutManager manager=new LinearLayoutManager(this);
            mRecyclerview.setLayoutManager(manager);
            mRecyclerview.setAdapter(mSearchAdapter);
        }


    }

    private void initRecyclerView1(List<SearchResultBean.CBean.SBean> sBean) {
        mList=new ArrayList<>();
        mList.addAll(sBean);
        mSearchAdapter=new SearchAdapter(mList,this,search,2);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this,1));
          mRecyclerview.setLayoutManager(manager);
        mRecyclerview.setAdapter(mSearchAdapter);

    }

    private void initDefaultData() {
     Observable<SearchDefaultBean>observable=myRetrofitApi.getSearchDefaultData(URLConstants.DEFAULT_SEARCH_URL);

        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<SearchDefaultBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchDefaultBean searchDefaultBean) {

                         mList=new ArrayList<Object>();
                        mList.addAll(searchDefaultBean.getC().getS());

                        String s=((SearchDefaultBean.CBean.SBean)(mList.get(0))).getName();
                        Log.e("TTT",s);
                        mSearchAdapter=new SearchAdapter(mList,SearchActivity.this,search,3);
                        GridLayoutManager manager=new GridLayoutManager(SearchActivity.this,3);
                        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {
                                if (mSearchAdapter.getItemViewType(position)==1){
                                    return 3;
                                }
                                return 1;
                            }
                        });
                        mRecyclerview.setLayoutManager(manager);
                        mRecyclerview.setAdapter(mSearchAdapter);


                    }
                });






    }

    private void initView() {
        mRecyclerview= (RecyclerView) findViewById(R.id.recyclerview_search);






    }



}
