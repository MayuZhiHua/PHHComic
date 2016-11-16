package com.ningjiahao.phhcomic.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.FindPagerAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment implements View.OnClickListener{
    private ViewPager mViewPager;

    private List<Fragment>mList;

    private FindPagerAdapter mFindPagerAdapter;

    private TextView textView_theme,textView_content;

    private ImageView imageView_theme,imageView_content;



    public FindFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
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
                imageView_theme.setVisibility(View.VISIBLE);
                imageView_content.setVisibility(View.INVISIBLE);
                textView_content.setTextColor(Color.parseColor("#000000"));
                textView_theme.setTextColor(Color.parseColor("#ff4500"));
                mViewPager.setCurrentItem(0);
                break;

            case R.id.textview_content:
                imageView_theme.setVisibility(View.INVISIBLE);
                imageView_content.setVisibility(View.VISIBLE);
                textView_theme.setTextColor(Color.parseColor("#000000"));
                textView_content.setTextColor(Color.parseColor("#ff4500"));
                mViewPager.setCurrentItem(1);

                break;
        }
    }
}
