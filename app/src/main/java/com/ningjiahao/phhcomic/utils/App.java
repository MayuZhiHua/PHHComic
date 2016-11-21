package com.ningjiahao.phhcomic.utils;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.ningjiahao.phhcomic.helper.OkHttpClientHelper;

import java.io.InputStream;

import cn.bmob.v3.Bmob;

/**
 * Created by 甯宁寧 on 2016-11-14.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "534a1d02f84c3852ea5b40198348b772");
        Glide.get(this).register(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(OkHttpClientHelper.getOkHttpSingletonInstance()));
    }
}
