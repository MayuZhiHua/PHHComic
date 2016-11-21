package com.ningjiahao.phhcomic.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.RankViewPagerAdapter;
import com.ningjiahao.phhcomic.fragment.RankFragment;

import java.util.ArrayList;
import java.util.List;

public class ManHuaRankActivity extends AppCompatActivity {
    private Toolbar rank_tool;
    private TextView rank_text,rank_hot,rank_over;
    private ImageView rank_over_bottomline,rank_bottomlone;
    private ViewPager rank_viewpager;
    private List<Fragment> list=new ArrayList<>();
    private RankViewPagerAdapter rankViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hua_rank);
        initView();
        initFragment();
        initViewPager();
    }

    private void initViewPager() {
        rankViewPagerAdapter=new RankViewPagerAdapter(getSupportFragmentManager(),list);
        rank_viewpager.setAdapter(rankViewPagerAdapter);
        rank_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    private void initFragment(){
        for(int i=0;i<2;i++){
            RankFragment rankFragment=new RankFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("key",i);
            rankFragment.setArguments(bundle);
            list.add(rankFragment);
        }
    }

    private void initView() {
        rank_tool= (Toolbar) findViewById(R.id.rank_tool);
        rank_text= (TextView) findViewById(R.id.rank_text);
        rank_hot= (TextView) findViewById(R.id.rank_hot);
        rank_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title1();
            }
        });
        rank_over= (TextView) findViewById(R.id.rank_over);
        rank_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title2();
            }
        });
        rank_over_bottomline= (ImageView) findViewById(R.id.rank_over_bottomline);
        rank_bottomlone= (ImageView) findViewById(R.id.rank_bottomlone);
        rank_viewpager= (ViewPager) findViewById(R.id.rank_viewpager);
        rank_tool.setNavigationIcon(R.mipmap.navi_back_h);
        rank_text.setText("排行榜");
        rank_tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void title2() {
        rank_bottomlone.setVisibility(View.INVISIBLE);
        rank_over_bottomline.setVisibility(View.VISIBLE);
        rank_over.setTextColor(Color.parseColor("#ff4500"));
        rank_hot.setTextColor(Color.parseColor("#000000"));
        rank_viewpager.setCurrentItem(1);
    }

    private void title1() {
        rank_bottomlone.setVisibility(View.VISIBLE);
        rank_over_bottomline.setVisibility(View.INVISIBLE);
        rank_over.setTextColor(Color.parseColor("#000000"));
        rank_hot.setTextColor(Color.parseColor("#ff4500"));
        rank_viewpager.setCurrentItem(0);
    }
}
