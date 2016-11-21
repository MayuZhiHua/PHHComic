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
import com.ningjiahao.phhcomic.bean.FindContentTitleBean;
import com.ningjiahao.phhcomic.bean.FindSearchTitleBean;
import com.ningjiahao.phhcomic.bean.SearchDefaultBean;
import com.ningjiahao.phhcomic.bean.SearchResultBean;
import com.ningjiahao.phhcomic.bean.ThemeBean;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.bean.UpdateBean;
import com.ningjiahao.phhcomic.bean.WebBean;
import com.ningjiahao.phhcomic.bean.ZanNumBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by 甯宁寧 on 2016-11-14.
 */

public interface MyRetrofitApi {

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
}
