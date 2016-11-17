package com.ningjiahao.phhcomic.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.ningjiahao.phhcomic.helper.OkHttp3Helper;
import com.ningjiahao.phhcomic.retrofitinterface.MyRetrofitApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 甯宁寧 on 2016-11-16.
 */

public class BaseActivity extends AppCompatActivity {
    private Retrofit mRetrofit;
    public MyRetrofitApi mRetrofitApi;
    public Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRetrofit=new Retrofit.Builder()
                .baseUrl("http://m2.qiushibaike.com/")
                .client(OkHttp3Helper.getOkHttpSingletonInstance())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRetrofitApi=mRetrofit.create(MyRetrofitApi.class);
    }


}
