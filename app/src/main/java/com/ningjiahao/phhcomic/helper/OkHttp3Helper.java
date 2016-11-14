package com.ningjiahao.phhcomic.helper;


import android.content.Context;

import okhttp3.OkHttpClient;


/**
 * Created by Steven
 * on 16-1-7.
 */
public class OkHttp3Helper {
    private static OkHttpClient mOkHttpClient = null;
    private static OkHttp3Helper mOkHttp3Helper = null;

    private OkHttp3Helper(Context context) {
        mOkHttpClient = getOkHttpSingletonInstance();
    }

    public static OkHttp3Helper getOkHttpClientHelper(Context context) {
        if (mOkHttp3Helper == null) {
            synchronized (OkHttp3Helper.class) {
                if (mOkHttp3Helper == null) {
                    mOkHttp3Helper = new OkHttp3Helper(context);
                }
            }
        }
        return mOkHttp3Helper;
    }

    public static OkHttpClient getOkHttpSingletonInstance() {
        if (mOkHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient();
                }
            }
        }
        return mOkHttpClient;
    }

}