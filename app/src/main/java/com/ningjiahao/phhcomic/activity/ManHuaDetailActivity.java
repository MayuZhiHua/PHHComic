package com.ningjiahao.phhcomic.activity;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.ManHuaDetailBean;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.bean.ZanNumBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.fragment.ChapterListFragment;
import com.ningjiahao.phhcomic.retrofitinterface.MyRetrofitApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.ningjiahao.phhcomic.config.URLConstants.URL_ZANNUM;

public class ManHuaDetailActivity extends BaseActivity {
    private ImageView manhuadetail_image, manhuadetail_state;
    private Button manhuadetail_back, manhuadetail_share, manhuadetail_startread, manhuadetail_download, manhuadetail_collection;
    private TextView manhuadetail_name, manhuadetail_type, manhuadetail_author, manhuadetail_jianjie, manhuadetail_score, manhuadetail_zanNum;
    private TabLayout manhuadetail_tablayout;
    private ViewPager manhuadetail_viewpager;
    private int id;
    private ChapterListFragment chapterListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hua_detail);
        Intent intent = getIntent();
        id = intent.getIntExtra("key", 0);
        initView();
        getData();
        initFragment();
        /*String result = formatData("yyyy-MM-dd", 1478275200);*/

    }

    private void initFragment() {
        chapterListFragment=new ChapterListFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("key",id);
        chapterListFragment.setArguments(bundle);
    }

    private void initView() {
        manhuadetail_image = (ImageView) findViewById(R.id.manhuadetail_image);
        manhuadetail_state = (ImageView) findViewById(R.id.manhuadetail_state);
        manhuadetail_back = (Button) findViewById(R.id.manhuadetail_back);
        manhuadetail_share = (Button) findViewById(R.id.manhuadetail_share);
        manhuadetail_startread = (Button) findViewById(R.id.manhuadetail_startread);
        manhuadetail_download = (Button) findViewById(R.id.manhuadetail_download);
        manhuadetail_collection = (Button) findViewById(R.id.manhuadetail_collection);
        manhuadetail_name = (TextView) findViewById(R.id.manhuadetail_name);
        manhuadetail_type = (TextView) findViewById(R.id.manhuadetail_type);
        manhuadetail_author = (TextView) findViewById(R.id.manhuadetail_author);
        manhuadetail_jianjie = (TextView) findViewById(R.id.manhuadetail_jianjie);
        manhuadetail_score = (TextView) findViewById(R.id.manhuadetail_score);
        manhuadetail_zanNum = (TextView) findViewById(R.id.manhuadetail_zanNum);
        manhuadetail_tablayout = (TabLayout) findViewById(R.id.manhuadetail_tablayout);
        manhuadetail_viewpager = (ViewPager) findViewById(R.id.manhuadetail_viewpager);
    }

    public void clickView(View v) {
        switch (v.getId()) {
            case R.id.manhuadetail_back:
                finish();
                break;
            case R.id.manhuadetail_share:
                break;
            case R.id.manhuadetail_startread:
                break;
            case R.id.manhuadetail_download:
                break;
            case R.id.manhuadetail_collection:
                break;
        }

    }


    public void getData() {

        myRetrofitApi.getManHuaDetailBean(URLConstants.URL_DETAIL_MANHUA, id, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ManHuaDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "获取数据网络错误" + id, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ManHuaDetailBean manHuaDetailBean) {
                        Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + manHuaDetailBean.getC().getAppicono()).into(manhuadetail_image);
                        if (manHuaDetailBean.getC().getUpdatestate().equals("0")) {
                            manhuadetail_state.setImageResource(R.drawable.common_state_end);
                        } else {
                            manhuadetail_state.setImageResource(R.drawable.common_state_serial);
                        }
                        manhuadetail_name.setText(manHuaDetailBean.getC().getName());
                        manhuadetail_type.setText(manHuaDetailBean.getC().getTname() + "|" + manHuaDetailBean.getC().getCfyname());
                        manhuadetail_author.setText("作者" + manHuaDetailBean.getC().getAuthor());
                        manhuadetail_jianjie.setText(manHuaDetailBean.getC().getDescr());
                        manhuadetail_score.setText(manHuaDetailBean.getC().getScore());
                        manhuadetail_zanNum.setText("1000");
                    }
                });
        Map<String, Object> map = new HashMap<>();
        map.put("proid", 1);
        map.put("usert", "5c294581a1cf38da887cd5404c997092");
        map.put("subid", id);
        map.put("from", "4");
        myRetrofitApi.getZanNumBean(URL_ZANNUM, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZanNumBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "获取点赞数据错误"+id, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ZanNumBean zanNumBean) {
                        manhuadetail_zanNum.setText(zanNumBean.getC().getZanNum());
                    }
                });

    }

}

