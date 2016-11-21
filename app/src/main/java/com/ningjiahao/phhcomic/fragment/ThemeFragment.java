package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.ThemeAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.ThemeBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    private ThemeAdapter mThemeAdapter;

    private List<ThemeBean.CBean.SBean>mList=new ArrayList<>();


    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Observable<ThemeBean> observable = mRetrofitApi.getThemeData(URLConstants.FIND_THEME_URL);
        observable.map(new Func1<ThemeBean, List<ThemeBean.CBean.SBean>>() {
            @Override
            public List<ThemeBean.CBean.SBean> call(ThemeBean themeBean) {


                return themeBean.getC().getS();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<List<ThemeBean.CBean.SBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ThemeBean.CBean.SBean> sBeen) {
                        mList.addAll(sBeen);

                        mThemeAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_theme, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerview_theme);

        mThemeAdapter = new ThemeAdapter(getActivity(), mList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mThemeAdapter);



    }
}
