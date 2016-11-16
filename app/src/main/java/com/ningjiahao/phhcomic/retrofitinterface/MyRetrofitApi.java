package com.ningjiahao.phhcomic.retrofitinterface;

import com.ningjiahao.phhcomic.bean.ThemeBean;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by 甯宁寧 on 2016-11-14.
 */

public interface MyRetrofitApi {

    @GET
    Observable<ThemeBean>getThemeData(@Url String url);
}
