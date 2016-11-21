package com.ningjiahao.phhcomic.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.ChapterListAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.ManHuaChapterBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.interfaces.GetPartId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChapterListFragment extends BaseFragment {
    private RecyclerView ChapterListFragment_recycler;
    private ChapterListAdapter chapterListAdapter;
    private int id;
    private int PartId;
    public ChapterListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_chapter_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ChapterListFragment_recycler= (RecyclerView) view.findViewById(R.id.ChapterListFragment_recycler);
        id=getArguments().getInt("key");
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("size",100);
        map.put("from",4);
        map.put("comicid",id);
        mRetrofitApi.getManHuaChapterBean(URLConstants.URL_CHAPTERLIST,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ManHuaChapterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ManHuaChapterBean manHuaChapterBean) {
                        List<ManHuaChapterBean.CBean> cList = manHuaChapterBean.getC();
                        chapterListAdapter=new ChapterListAdapter(mContext,cList);
                        ChapterListFragment_recycler.setAdapter(chapterListAdapter);
                        ChapterListFragment_recycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.VERTICAL,false));
                        PartId=Integer.valueOf(cList.get(cList.size()).getId());
                    }
                });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
