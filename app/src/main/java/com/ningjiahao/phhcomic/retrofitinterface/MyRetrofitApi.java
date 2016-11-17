package com.ningjiahao.phhcomic.retrofitinterface;

import com.ningjiahao.phhcomic.bean.ManHuaChapterBean;
import com.ningjiahao.phhcomic.bean.ManHuaDetailBean;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.bean.ZanNumBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by 甯宁寧 on 2016-11-14.
 */

public interface MyRetrofitApi {
    @POST
    Observable<ManHuaKuBean> getManHuaKuBean(@Url String url);
    @GET
    Observable<ManHuaDetailBean> getManHuaDetailBean(@Url String url, @Query("comicid") int id, @Query("from") int from);
    @POST
    Observable<ZanNumBean> getZanNumBean(@Url String url, @QueryMap Map<String,Object> map);
    @GET
    Observable<ManHuaChapterBean> getManHuaChapterBean(@Url String url, @QueryMap Map<String,Object> map);


    //获得TuiJianBean对象
   @GET
    Observable<TuiJianBean> getTuiJianBean(@Url String url, @QueryMap() Map<String,String> map);
}
