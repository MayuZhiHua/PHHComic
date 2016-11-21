package com.ningjiahao.phhcomic.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.OkHttp3Helper;
import com.ningjiahao.phhcomic.retrofitinterface.MyRetrofitApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    public MyRetrofitApi myRetrofitApi;
    public Context mContext=this;
    public LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mInflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        mRetrofit=new Retrofit.Builder()
                .baseUrl(URLConstants.BASE_IMAGE_URL)
                .client(OkHttp3Helper.getOkHttpSingletonInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        myRetrofitApi=mRetrofit.create(MyRetrofitApi.class);

    }
}
