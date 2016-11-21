package com.ningjiahao.phhcomic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.ManHuaKuRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        myRetrofitApi.getManHuaKuBean(URLConstants.URL_MAIN_MANHUAKU)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ManHuaKuBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "网络出错了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ManHuaKuBean manHuaKuBean) {
                        Intent intent=new Intent(mContext,MainActivity.class);
                        intent.putExtra("key",manHuaKuBean);
                        mContext.startActivity(intent);
                        SplashActivity.this.finish();
                    }
                });
    }
}
