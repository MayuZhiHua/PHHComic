package com.ningjiahao.phhcomic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.DetailTitleBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailActivity extends BaseActivity {

    private String id;
    private ImageView imageview_title;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData();
        initView();
        initNetData();
    }




    private void initData() {
        Intent intent=getIntent();
        id=intent.getStringExtra(URLConstants.KEY_DETAIL_ID);
    }
    private void initView() {
        imageview_title= (ImageView) findViewById(R.id.imageview_detail_title);
    }
    private void initNetData() {
        url=String.format(URLConstants.DETAIL_TITLE_URL,id);
        Observable<DetailTitleBean>observable=myRetrofitApi.getDetailTitle(url);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<DetailTitleBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DetailTitleBean detailTitleBean) {
                        Glide.with(DetailActivity.this)
                                .load(URLConstants.BASE_IMAGE_URL+detailTitleBean.getC().getAppicono())
                                .into(imageview_title);

                    }
                });


    }


}
