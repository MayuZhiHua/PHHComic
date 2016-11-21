package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.ManHuaDetailActivity;
import com.ningjiahao.phhcomic.bean.WebBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-19.
 */

public class WebRecyclerAdapter extends RecyclerViewAdapterHelper<Object>{
    public static final int NUM1=0;
    public static final int NUM2=1;

    public WebRecyclerAdapter(Context context, List<Object> list) {
        super(context, list);
    }

    @Override
    public int getItemViewType(int position) {
        if(mList.get(position) instanceof WebBean.CBean.DetailBean){
            return NUM1;
        }else if(mList.get(position) instanceof WebBean.CBean.ListBean){
            return NUM2;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        switch (viewType){
            case NUM1:
                view=mInflater.inflate(R.layout.web_item_layout,parent,false);
                return new MyWebHolder2(view);
            case NUM2:
                view=mInflater.inflate(R.layout.manhuaku_item_showinfo,parent,false);
                return new MyWebHolder(view);
        }
       return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyWebHolder){
            WebBean.CBean.ListBean WCL= (WebBean.CBean.ListBean) mList.get(position);
            Glide.with(mContext)
                    .load(URLConstants.IMAGE_BASE_URL + WCL.getAppiconu())
                    .placeholder(R.drawable.ticai_placeimage)
                    .into(((MyWebHolder) holder).web_image_main);
            ((MyWebHolder) holder).web_txt_latestchapter.setText(WCL.getPartname());
            ((MyWebHolder) holder).web_txt_manhuaname.setText(WCL.getName());
            ((MyWebHolder) holder).web_txt_score.setText(WCL.getScore());
        }else if(holder instanceof MyWebHolder2){
            WebBean.CBean.DetailBean WCD= (WebBean.CBean.DetailBean) mList.get(position);
            String html=WCD.getContent();
            String html2=html.replace("\\","");
            ((MyWebHolder2) holder).web_web.loadDataWithBaseURL(null,html2
                    ,"text/html","UTF-8",null);

        }

    }
    class MyWebHolder extends RecyclerView.ViewHolder{
        ImageView web_image_main;
        TextView web_txt_score,web_txt_latestchapter,web_txt_manhuaname;

        public MyWebHolder(View itemView) {
            super(itemView);
            web_image_main= (ImageView) itemView.findViewById(R.id.manhuaku_image_main);
            web_txt_score= (TextView) itemView.findViewById(R.id.manhuaku_txt_score);
            web_txt_latestchapter= (TextView) itemView.findViewById(R.id.manhuaku_txt_latestchapter);
            web_txt_manhuaname= (TextView) itemView.findViewById(R.id.manhuaku_txt_manhuaname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebBean.CBean.ListBean WCL=(WebBean.CBean.ListBean)mList.get(getPosition());
                    Intent intent=new Intent(mContext, ManHuaDetailActivity.class);
                    intent.putExtra("key",Integer.valueOf(WCL.getId()));
                    mContext.startActivity(intent);
                }
            });
        }
    }
    class MyWebHolder2 extends RecyclerView.ViewHolder{
        WebView web_web;

        public MyWebHolder2(View itemView) {
            super(itemView);
            web_web= (WebView) itemView.findViewById(R.id.web_web);
            WebSettings webset =web_web.getSettings();
            webset.setJavaScriptEnabled(true);
            web_web.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    web_web.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                }
            });
        }
    }
}
