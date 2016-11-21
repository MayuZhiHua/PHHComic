package com.ningjiahao.phhcomic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.ReadManHuaAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.ManHuaBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uk.co.senab.photoview.PhotoView;


public class ReadManHuaActivity extends BaseActivity {
    private Toolbar readmanhua_tool;
    private LinearLayout readmanhua_linearlayout;
    //private RecyclerView readmanhua_recycler;
    private ReadManHuaAdapter readManHuaAdapter;
    private int id;
    private DisplayMetrics metric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_man_hua);
        metric = new DisplayMetrics();
        initView();
        initData();
    }

    private void initData() {
        id=getIntent().getIntExtra("key",0);
        Map<String,Object> map=new HashMap<>();
        map.put("comicpartid",id);
        map.put("from",4);
        myRetrofitApi.getManHuaBean(URLConstants.URL_MANHUA,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ManHuaBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "获取漫画数据出错"+id, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNext(ManHuaBean manHuaBean) {
                        List<String> content = manHuaBean.getC().getContent();
                        List<ManHuaBean.CBean.SizeBean> size = manHuaBean.getC().getSize();
                        for(int i=0;i<content.size();i++){
                            PhotoView photoView=new PhotoView(mContext);
                            ManHuaBean.CBean.SizeBean sb=size.get(i);
                            photoView.setScaleType(ImageView.ScaleType.FIT_XY);
                            Glide.with(mContext)
                                    .load(URLConstants.IMAGE_BASE_URL+content.get(i))
                                    .override(sb.getW(),sb.getH())
                                    .skipMemoryCache(true)
                                    .into(photoView);
                            readmanhua_linearlayout.addView(photoView);
                        }
                        readmanhua_tool.setTitle(manHuaBean.getC().getName());
                    }
                });
    }

    private void initView() {
        readmanhua_tool= (Toolbar) findViewById(R.id.readmanhua_tool);
        readmanhua_linearlayout= (LinearLayout) findViewById(R.id.readmanhua_linearlayout);
        //readmanhua_recycler= (RecyclerView) findViewById(R.id.readmanhua_recycler);
        readmanhua_tool.setTitleTextColor(getResources().getColor(R.color.orangered));
        readmanhua_tool.setNavigationIcon(R.mipmap.navi_back_h);
        readmanhua_tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
