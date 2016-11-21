package com.ningjiahao.phhcomic.activity;


import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.ChapterListAdapter;
import com.ningjiahao.phhcomic.adapter.ManHuaDetailAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.CollectionBean;
import com.ningjiahao.phhcomic.bean.ManHuaChapterBean;
import com.ningjiahao.phhcomic.bean.ManHuaDetailBean;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.bean.ZanNumBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.fragment.ChapterListFragment;
import com.ningjiahao.phhcomic.fragment.DetailDiscussFragment;
import com.ningjiahao.phhcomic.interfaces.GetPartId;
import com.ningjiahao.phhcomic.retrofitinterface.MyRetrofitApi;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import retrofit2.http.Url;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.ningjiahao.phhcomic.config.URLConstants.URL_ZANNUM;

public class ManHuaDetailActivity extends BaseActivity{
    private ImageView manhuadetail_image, manhuadetail_state,imageview_line_rad_detail,imageview_line_red_discussdetail;
    private Button manhuadetail_back, manhuadetail_share, manhuadetail_startread, manhuadetail_download, manhuadetail_collection;
    private TextView manhuadetail_name, manhuadetail_type,manhuadetail_chapter, manhuadetail_author, manhuadetail_discuss,manhuadetail_jianjie, manhuadetail_score, manhuadetail_zanNum;
    private ViewPager manhuadetail_viewpager;
    private int id;
    private ChapterListFragment chapterListFragment;
    private DetailDiscussFragment detailDiscussFragment;
    private List<Fragment> fragmentList=new ArrayList<>();
    private ManHuaDetailAdapter manHuaDetailAdapter;
    private ManHuaDetailBean manHuaDetailBean;
    private int PartId;
    private String yzhid;

    private String name;
    private String imageURL;
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
        detailDiscussFragment=new DetailDiscussFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("key",id);
        chapterListFragment.setArguments(bundle);
        detailDiscussFragment.setArguments(bundle);
        fragmentList.add(chapterListFragment);
        fragmentList.add(detailDiscussFragment);
        manHuaDetailAdapter=new ManHuaDetailAdapter(getSupportFragmentManager(),fragmentList);
        manhuadetail_viewpager.setAdapter(manHuaDetailAdapter);
        manhuadetail_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        manhuadetail_chapter= (TextView) findViewById(R.id.manhuadetail_chapter);
        manhuadetail_discuss= (TextView) findViewById(R.id.manhuadetail_discuss);
        imageview_line_rad_detail= (ImageView) findViewById(R.id.imageview_line_rad_detail);
        imageview_line_red_discussdetail= (ImageView) findViewById(R.id.imageview_line_red_discussdetail);
        manhuadetail_viewpager = (ViewPager) findViewById(R.id.manhuadetail_viewpager);
        manhuadetail_chapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title1();
            }
        });
        manhuadetail_discuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title2();
            }
        });

    }

    public void clickView(View v) {
        switch (v.getId()) {
            case R.id.manhuadetail_back:
                finish();
                break;
            case R.id.manhuadetail_share:
                new ShareAction(ManHuaDetailActivity.this).withText("看漫画啦")
                        .withTargetUrl(URLConstants.IMAGE_BASE_URL+manHuaDetailBean.getC().getAppicons())
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                break;
            case R.id.manhuadetail_startread:
                Toast.makeText(mContext, "点击了开始阅读", Toast.LENGTH_SHORT).show();
                goReadFirst();
                break;
            case R.id.manhuadetail_download:
                Toast.makeText(mContext, "点击了下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.manhuadetail_collection:
                //Toast.makeText(mContext, "点击了收藏", Toast.LENGTH_SHORT).show();
                CollectionBean collectionBean = new CollectionBean();
                collectionBean.setYzhid(yzhid);
                collectionBean.setName(name);
                collectionBean.setImageURL(imageURL);
                collectionBean.save(new SaveListener<String>(){
                    @Override
                    public void done(String s, BmobException e) {
                        if(e==null){
                            Toast.makeText(mContext, "收藏数据成功，", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext, "收藏数据失败，", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
                        ManHuaDetailActivity.this.manHuaDetailBean=manHuaDetailBean;
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
                        manhuadetail_zanNum.setText(manHuaDetailBean.getC().getId());
                        //获得收藏的数据
                        name = manHuaDetailBean.getC().getName();
                        imageURL =URLConstants.BASE_IMAGE_URL+ manHuaDetailBean.getC().getAppicons();
                        yzhid = manHuaDetailBean.getC().getId();

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
                    }

                    @Override
                    public void onNext(ZanNumBean zanNumBean) {

                    }
                });


    }
    private void title2() {
        imageview_line_rad_detail.setVisibility(View.INVISIBLE);
        imageview_line_red_discussdetail.setVisibility(View.VISIBLE);
        manhuadetail_discuss.setTextColor(Color.parseColor("#ff4500"));
        manhuadetail_chapter.setTextColor(Color.parseColor("#000000"));
        manhuadetail_viewpager.setCurrentItem(1);
    }

    private void title1() {
        imageview_line_rad_detail.setVisibility(View.VISIBLE);
        imageview_line_red_discussdetail.setVisibility(View.INVISIBLE);
        manhuadetail_discuss.setTextColor(Color.parseColor("#000000"));
        manhuadetail_chapter.setTextColor(Color.parseColor("#ff4500"));
        manhuadetail_viewpager.setCurrentItem(0);
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(mContext, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(mContext,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mContext,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
    private void goReadFirst(){
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("size",100);
        map.put("from",4);
        map.put("comicid",id);
        myRetrofitApi.getManHuaChapterBean(URLConstants.URL_CHAPTERLIST,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ManHuaChapterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, id + " 分享成功啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ManHuaChapterBean manHuaChapterBean) {
                        List<ManHuaChapterBean.CBean> cList = manHuaChapterBean.getC();
                        ManHuaDetailActivity.this.PartId=Integer.valueOf(cList.get(cList.size()).getId());
                        Intent intent=new Intent(mContext,ReadManHuaActivity.class);
                        intent.putExtra("key",id);
                        mContext.startActivity(intent);
                    }
                });
    }


}

