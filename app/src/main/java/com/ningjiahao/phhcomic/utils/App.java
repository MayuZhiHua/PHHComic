package com.ningjiahao.phhcomic.utils;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.ningjiahao.phhcomic.helper.OkHttpClientHelper;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.io.InputStream;

import cn.bmob.v3.Bmob;

/**
 * Created by 甯宁寧 on 2016-11-14.
 */

public class App extends Application {
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");


    }
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "534a1d02f84c3852ea5b40198348b772");
        UMShareAPI.get(this);
        Glide.get(this).register(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(OkHttpClientHelper.getOkHttpSingletonInstance()));
    }
}
