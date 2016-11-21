package com.ningjiahao.phhcomic.retrofitinterface;

import com.ningjiahao.phhcomic.bean.FindContentTitleBean;
import com.ningjiahao.phhcomic.bean.FindSearchTitleBean;
import com.ningjiahao.phhcomic.bean.HotRankBean;
import com.ningjiahao.phhcomic.bean.ManHuaBean;
import com.ningjiahao.phhcomic.bean.ManHuaChapterBean;
import com.ningjiahao.phhcomic.bean.ManHuaDetailBean;
import com.ningjiahao.phhcomic.bean.ManHuaDiscussBean;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.bean.OverRankBean;
import com.ningjiahao.phhcomic.bean.RedNewBean;
import com.ningjiahao.phhcomic.bean.SearchDefaultBean;
import com.ningjiahao.phhcomic.bean.SearchResultBean;
import com.ningjiahao.phhcomic.bean.SpecialListBean;
import com.ningjiahao.phhcomic.bean.ThemeBean;
import com.ningjiahao.phhcomic.bean.TieZiPlBean;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.bean.UpdateBean;
import com.ningjiahao.phhcomic.bean.WebBean;
import com.ningjiahao.phhcomic.bean.UserBean;
import com.ningjiahao.phhcomic.bean.ZanNumBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import rx.Observer;
=======
import com.ningjiahao.phhcomic.bean.ThemeBean;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;
>>>>>>> Stashed changes

/**
 * Created by 甯宁寧 on 2016-11-14.
 */

public interface MyRetrofitApi {
<<<<<<< Updated upstream
    @POST
    Observable<ManHuaKuBean> getManHuaKuBean(@Url String url);
    @GET
    Observable<ManHuaDetailBean> getManHuaDetailBean(@Url String url, @Query("comicid") int id, @Query("from") int from);
    @POST
    Observable<ZanNumBean> getZanNumBean(@Url String url, @QueryMap Map<String,Object> map);
    @GET
    Observable<ManHuaChapterBean> getManHuaChapterBean(@Url String url, @QueryMap Map<String,Object> map);
    @GET
    Observable<ManHuaDiscussBean> getManHuaDiscussBean(@Url String url, @QueryMap Map<String,Object> map);
    @GET
    Observable<ManHuaBean> getManHuaBean(@Url String url, @QueryMap Map<String,Object> map);
    @GET
    Observable<UpdateBean> getUpdateBean(@Url String url);
    @GET
    Observable<RedNewBean> getRedNewBean(@Url String url);
    @GET
    Observable<HotRankBean> getHotRankBean(@Url String url);
    @GET
    Observable<OverRankBean> getOverRankBean(@Url String url);
    @GET
    Observable<SpecialListBean> getSpecialListBean(@Url String url);
    @GET
    Observable<WebBean> getWebBean(@Url String url);
    @GET
    Observable<ThemeBean>getThemeData(@Url String url);

    @GET
    Observable<FindSearchTitleBean>getFindSearchTitle(@Url String url);


    @GET
    Observable<FindContentTitleBean>getFindContentTitil(@Url String url);

    @GET
    Observable<SearchResultBean>getSearchResult(@Url String url);

    @GET
    Observable<SearchDefaultBean>getSearchDefaultData(@Url String url);

    //获得TuiJianBean对象
    @GET
    Observable<TuiJianBean> getTuiJianBean(@Url String url, @QueryMap() Map<String,String> map);


    //获得帖子评论的对象
    @GET
    Observable<TieZiPlBean> getTieZiPlBean(@Url String url,@QueryMap() Map<String,String> map);

    //获得FansBean对象
    @GET
    Observable<FansBean> getFansBean(@Url String url,@QueryMap() Map<String,String> map);

    //获得UserBan对象
    @GET
    Observable<UserBean> getUserBean(@Url String url,@QueryMap() Map<String,String> map);
=======

    @GET
    Observable<ThemeBean>getThemeData(@Url String url);
>>>>>>> Stashed changes
}
