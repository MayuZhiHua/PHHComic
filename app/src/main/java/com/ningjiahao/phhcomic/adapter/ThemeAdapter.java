package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.SearchActivity;
import com.ningjiahao.phhcomic.bean.ThemeBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by My on 2016/11/15.
 */

public class ThemeAdapter extends RecyclerViewAdapterHelper<ThemeBean.CBean.SBean>{


    public ThemeAdapter(Context context, List<ThemeBean.CBean.SBean> list) {
        super(context, list);
        mList=list;
        mContext=context;
        mInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {

        View view=mInflater.inflate(R.layout.item_theme,parent,false);

        return new ThemeHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.e("tag",mList.get(0).getName());
        final String name=mList.get(position).getName();
        ((ThemeHolder)holder).textView_name.setText(name);
        ((ThemeHolder)holder).textView_part.setText(mList.get(position).getComicnum()+"部");
        Glide.with(mContext).load(URLConstants.BASE_IMAGE_URL+mList.get(position).getIconr())
                .placeholder(R.drawable.ticai_placeimage)
                .into(((ThemeHolder)holder).imageView_theme);

        ((ThemeHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(mContext, SearchActivity.class);
                intent.putExtra(URLConstants.KEY_SEARCH_TYPE,"theme");
                intent.putExtra(URLConstants.KEY_SEARCH,name);
                intent.putExtra(URLConstants.KEY_SEARCH_PAGE,mList.get(position).getId());
                mContext.startActivity(intent);

            }

        });



    }


class ThemeHolder extends RecyclerView.ViewHolder{
    private TextView textView_name,textView_part;
    private ImageView imageView_theme;
    public ThemeHolder(View itemView) {
        super(itemView);
        imageView_theme= (ImageView) itemView.findViewById(R.id.imageview_theme);
        textView_name= (TextView) itemView.findViewById(R.id.textview_theme_name);
        textView_part= (TextView) itemView.findViewById(R.id.textview_theme_part);

    }
}
}
