package com.ningjiahao.phhcomic.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.fragment.FindFragment;
import com.ningjiahao.phhcomic.fragment.ManHuaKuFragment;
import com.ningjiahao.phhcomic.fragment.QuanZiFragment;
import com.ningjiahao.phhcomic.fragment.XiaoWoFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ManHuaKuFragment manHuaKuFragment;
    private QuanZiFragment quanZiFragment;
    private XiaoWoFragment xiaoWoFragment;
    private FindFragment findFragment;
    private RadioButton mainactivity_xiaoxu,mainactivity_faxian,mainactivity_manhuaku,mainactivity_quanzi;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        manHuaKuFragment=new ManHuaKuFragment();
        quanZiFragment=new QuanZiFragment();
        xiaoWoFragment=new XiaoWoFragment();
        findFragment=new FindFragment();
        FragmentTransaction fragmentTransation=fragmentManager.beginTransaction();
        fragmentTransation.add(R.id.Framelayout_manhuaku,manHuaKuFragment,"manHuaKuFragment");
        fragmentTransation.show(manHuaKuFragment);
        fragmentTransation.add(R.id.Framelayout_manhuaku,quanZiFragment,"quanZiFragment");
        fragmentTransation.hide(quanZiFragment);
        fragmentTransation.add(R.id.Framelayout_manhuaku,xiaoWoFragment,"xiaoWoFragment");
        fragmentTransation.hide(xiaoWoFragment);
        fragmentTransation.add(R.id.Framelayout_manhuaku,findFragment,"findFragment");
        fragmentTransation.hide(findFragment);
        fragmentTransation.commit();
    }

    private void initView() {
        mainactivity_xiaoxu= (RadioButton) findViewById(R.id.mainactivity_xiaoxu);
        mainactivity_xiaoxu.setOnClickListener(this);
        mainactivity_faxian= (RadioButton) findViewById(R.id.mainactivity_faxian);
        mainactivity_faxian.setOnClickListener(this);
        mainactivity_manhuaku= (RadioButton) findViewById(R.id.mainactivity_manhuaku);
        mainactivity_manhuaku.setOnClickListener(this);
        mainactivity_quanzi= (RadioButton) findViewById(R.id.mainactivity_quanzi);
        mainactivity_quanzi.setOnClickListener(this);
        fragmentManager=getSupportFragmentManager();

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransation=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.mainactivity_xiaoxu:
                //fragmentTransation.replace(R.id.Framelayout_manhuaku,xiaoWoFragment);
                fragmentTransation.hide(manHuaKuFragment);
                fragmentTransation.hide(quanZiFragment);
                fragmentTransation.show(xiaoWoFragment);
                fragmentTransation.hide(findFragment);
                break;
            case R.id.mainactivity_faxian:
                fragmentTransation.hide(xiaoWoFragment);
                fragmentTransation.hide(manHuaKuFragment);
                fragmentTransation.show(findFragment);
                fragmentTransation.hide(quanZiFragment);
                break;
            case R.id.mainactivity_manhuaku:
                fragmentTransation.hide(xiaoWoFragment);
                fragmentTransation.hide(quanZiFragment);
                fragmentTransation.show(manHuaKuFragment);
                fragmentTransation.hide(findFragment);
                break;
            case R.id.mainactivity_quanzi:
                fragmentTransation.hide(xiaoWoFragment);
                fragmentTransation.hide(manHuaKuFragment);
                fragmentTransation.show(quanZiFragment);
                fragmentTransation.hide(findFragment);
                break;
        }
        fragmentTransation.commit();
    }
}
