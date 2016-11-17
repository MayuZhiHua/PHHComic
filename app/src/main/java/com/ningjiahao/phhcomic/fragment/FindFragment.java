package com.ningjiahao.phhcomic.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.SearchActivity;
import com.ningjiahao.phhcomic.adapter.FindPagerAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.FindSearchTitleBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment implements View.OnClickListener{
    private ViewPager mViewPager;

    private List<Fragment>mList;

    private FindPagerAdapter mFindPagerAdapter;

    private TextView textView_theme,textView_content;

    private ImageView imageView_theme,imageView_content,imageView_search;

    private GridLayout mGridLayout;

    private FindSearchTitleBean mSearchBean;

    private LayoutInflater mInflater;

    private EditText mEditText;



    public FindFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化大家都在搜标题
        initNetData();
        //
        initData();
    }

    private void initNetData() {
        Observable<FindSearchTitleBean>observable=mRetrofitApi.getFindSearchTitle(URLConstants.FIND_SEARCH_TITLE_URL);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<FindSearchTitleBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FindSearchTitleBean findSearchTitleBean) {
                        mSearchBean=findSearchTitleBean;


                        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        for (int i=0;i<mSearchBean.getC().size();i++){
                            View itemview=mInflater.inflate(R.layout.item_search_title,null,false);
                            TextView tv= (TextView) itemview.findViewById(R.id.textview_search_title);
                            tv.setText(mSearchBean.getC().get(i));

                            mGridLayout.addView(itemview);
                        }

                    }
                });

    }

    private void initData() {
        ThemeFragment themeFragment=new ThemeFragment();
        ContentFragment contentFragment=new ContentFragment();
        mList=new ArrayList<>();
        mList.add(themeFragment);
        mList.add(contentFragment);
        mFindPagerAdapter=new FindPagerAdapter(getActivity().getSupportFragmentManager(),mList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
         mEditText= (EditText) view.findViewById(R.id.edittext_find_fragment);
        imageView_search= (ImageView) view.findViewById(R.id.imageview_find_search);
        imageView_search.setOnClickListener(this);
        mGridLayout= (GridLayout) view.findViewById(R.id.find_gridlayout_search);
        textView_theme= (TextView) view.findViewById(R.id.textview_theme);
        textView_content= (TextView) view.findViewById(R.id.textview_content);
        textView_theme.setOnClickListener(this);
        textView_content.setOnClickListener(this);
        imageView_theme= (ImageView) view.findViewById(R.id.imageview_line_rad_theme);
        imageView_content= (ImageView) view.findViewById(R.id.imageview_line_red_content);
        mViewPager= (ViewPager) view.findViewById(R.id.viewpager_find);
        mViewPager.setAdapter(mFindPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    title1();
                }else {
                    title2();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textview_theme:
                title1();
                break;
            case R.id.textview_content:
                title2();
                break;
            case R.id.imageview_find_search:
                Intent intent=new Intent();
                intent.setClass(getActivity(), SearchActivity.class);
                String search=mEditText.getEditableText().toString();
                intent.putExtra(URLConstants.KEY_SEARCH,search);
                startActivity(intent);
                break;
        }
    }

    private void title2() {
        imageView_theme.setVisibility(View.INVISIBLE);
        imageView_content.setVisibility(View.VISIBLE);
        textView_theme.setTextColor(Color.parseColor("#000000"));
        textView_content.setTextColor(Color.parseColor("#ff4500"));
        mViewPager.setCurrentItem(1);
    }

    private void title1() {
        imageView_theme.setVisibility(View.VISIBLE);
        imageView_content.setVisibility(View.INVISIBLE);
        textView_content.setTextColor(Color.parseColor("#000000"));
        textView_theme.setTextColor(Color.parseColor("#ff4500"));
        mViewPager.setCurrentItem(0);
    }

}
