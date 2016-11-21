package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.ManHuaKuRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManHuaKuFragment extends BaseFragment {
    private RecyclerView recyclerView_manhuaku;
    private List<Object> manhuaku_list = new ArrayList<>();
    private String zuire = "最热漫画";
    private String zuixin = "最新漫画";
    private String meiri = "每日更新";
    private String ticai = "漫画题材";
    private String zhuanti = "专题";
    private int justone = 1;
    private boolean flag = true;
    private ManHuaKuRecyclerAdapter mManHuaKuRecyclerAdapter;

    public ManHuaKuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_man_hua_ku, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView_manhuaku = (RecyclerView) view.findViewById(R.id.recyclerView_manhuaku);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initData() {
        ManHuaKuBean manHuaKuBean= (ManHuaKuBean) getArguments().getSerializable("key");
        List<ManHuaKuBean.CBean.CarouselBean> carousel = manHuaKuBean.getC().getCarousel();//Viewpager数据
        List<ManHuaKuBean.CBean.NewcomicBean> newcomic = manHuaKuBean.getC().getNewcomic();//最新漫画数据
        List<ManHuaKuBean.CBean.RecommendcomicBean> recommendcomic = manHuaKuBean.getC().getRecommendcomic();//编辑推荐数据
        List<ManHuaKuBean.CBean.RedcomicBean> redcomic = manHuaKuBean.getC().getRedcomic();//最热漫画数据
        List<ManHuaKuBean.CBean.SpecialBean> special = manHuaKuBean.getC().getSpecial();//专题数据
        List<ManHuaKuBean.CBean.TopicBean> topic = manHuaKuBean.getC().getTopic();//漫画题材数据
        List<ManHuaKuBean.CBean.WeekBean> week = manHuaKuBean.getC().getWeek();//每日更新数据
        manhuaku_list.addAll(carousel);
        manhuaku_list.add(zuire);
        manhuaku_list.addAll(redcomic);
        manhuaku_list.add(justone);
        manhuaku_list.addAll(recommendcomic);
        manhuaku_list.add(zuixin);
        manhuaku_list.addAll(newcomic);
        manhuaku_list.add(meiri);
        manhuaku_list.addAll(week);
        manhuaku_list.add(ticai);
        manhuaku_list.add(flag);
        manhuaku_list.addAll(topic);
        manhuaku_list.add(zhuanti);
        manhuaku_list.addAll(special);
        mManHuaKuRecyclerAdapter = new ManHuaKuRecyclerAdapter(mContext, manhuaku_list, carousel, topic, special);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE1
                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE2
                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE4
                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE5
                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE6) {
                    return 3;
                }
                return 1;
            }
        });
        recyclerView_manhuaku.setLayoutManager(layoutManager);
        recyclerView_manhuaku.setAdapter(mManHuaKuRecyclerAdapter);
        /*mRetrofitApi.getManHuaKuBean(URLConstants.URL_MAIN_MANHUAKU)
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
                        List<ManHuaKuBean.CBean.CarouselBean> carousel = manHuaKuBean.getC().getCarousel();//Viewpager数据
                        List<ManHuaKuBean.CBean.NewcomicBean> newcomic = manHuaKuBean.getC().getNewcomic();//最新漫画数据
                        List<ManHuaKuBean.CBean.RecommendcomicBean> recommendcomic = manHuaKuBean.getC().getRecommendcomic();//编辑推荐数据
                        List<ManHuaKuBean.CBean.RedcomicBean> redcomic = manHuaKuBean.getC().getRedcomic();//最热漫画数据
                        List<ManHuaKuBean.CBean.SpecialBean> special = manHuaKuBean.getC().getSpecial();//专题数据
                        List<ManHuaKuBean.CBean.TopicBean> topic = manHuaKuBean.getC().getTopic();//漫画题材数据
                        List<ManHuaKuBean.CBean.WeekBean> week = manHuaKuBean.getC().getWeek();//每日更新数据
                        manhuaku_list.addAll(carousel);
                        manhuaku_list.add(zuire);
                        manhuaku_list.addAll(redcomic);
                        manhuaku_list.add(justone);
                        manhuaku_list.addAll(recommendcomic);
                        manhuaku_list.add(zuixin);
                        manhuaku_list.addAll(newcomic);
                        manhuaku_list.add(meiri);
                        manhuaku_list.addAll(week);
                        manhuaku_list.add(ticai);
                        manhuaku_list.add(flag);
                        manhuaku_list.addAll(topic);
                        manhuaku_list.add(zhuanti);
                        manhuaku_list.addAll(special);
                        mManHuaKuRecyclerAdapter = new ManHuaKuRecyclerAdapter(mContext, manhuaku_list, carousel, topic, special);
                        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
                        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {
                                if (mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE1
                                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE2
                                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE4
                                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE5
                                        || mManHuaKuRecyclerAdapter.getItemViewType(position) == mManHuaKuRecyclerAdapter.TYPE6) {
                                    return 3;
                                }
                                return 1;
                            }
                        });
                        recyclerView_manhuaku.setLayoutManager(layoutManager);
                        recyclerView_manhuaku.setAdapter(mManHuaKuRecyclerAdapter);
                    }
                });*/
    }
}
