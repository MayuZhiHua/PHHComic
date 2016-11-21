package com.ningjiahao.phhcomic.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.UpdateAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.fragment.UpdateFragment;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends BaseActivity {
    private TabLayout update_tab;
    private ViewPager update_viewpager;
    private Toolbar update_tool;
    String[] updateTitle={"一","二","三","四","五","六","日","完结"};
    private List<Fragment> FragmentList=new ArrayList<>();
    private UpdateAdapter updateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        initFragment();
    }


    private void initFragment() {
        for (int i = 0; i <updateTitle.length ; i++) {
            UpdateFragment updateFragment=new UpdateFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("key",i+1);
            updateFragment.setArguments(bundle);
            FragmentList.add(updateFragment);
        }
        updateAdapter=new UpdateAdapter(getSupportFragmentManager(),updateTitle,FragmentList);
        update_viewpager.setAdapter(updateAdapter);
        update_tab.setupWithViewPager(update_viewpager);
        update_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initView() {
        update_tab= (TabLayout) findViewById(R.id.update_tab);
        update_viewpager= (ViewPager) findViewById(R.id.update_viewpager);
        update_tool= (Toolbar) findViewById(R.id.update_tool);
        update_tool.setTitle("每日更新");
        update_tool.setTitleTextColor(getResources().getColor(R.color.orangered));
        update_tool.setTitleMarginStart(100);
        update_tool.setNavigationIcon(R.mipmap.navi_back_h);
        update_tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
