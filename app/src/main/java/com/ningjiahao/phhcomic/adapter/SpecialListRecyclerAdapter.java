package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.WebActivity;
import com.ningjiahao.phhcomic.bean.SpecialListBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-19.
 */

public class SpecialListRecyclerAdapter extends RecyclerViewAdapterHelper<SpecialListBean.CBean.SBean>{
    public SpecialListRecyclerAdapter(Context context, List<SpecialListBean.CBean.SBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.speciallist_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL+mList.get(position).getBanner())
                    .placeholder(R.drawable.ticai_placeimage)
                    .into(((MyViewHolder) holder).special_item_specialimage);
            ((MyViewHolder) holder).special_item_specialname.setText(mList.get(position).getName());
            ((MyViewHolder) holder).special_item_specialsmallname.setText(mList.get(position).getSmallname());
            if(mList.get(position).getStnum().equals("0")){
                ((MyViewHolder) holder).special_item_specialstnum.setText("已完结");
                ((MyViewHolder) holder).special_item_specialstnum.setBackground(mContext.getResources().getDrawable(R.color.grey));
            }else{
                ((MyViewHolder) holder).special_item_specialstnum.setText("作品:"+mList.get(position).getStnum());
            }
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView special_item_specialimage;
        TextView special_item_specialname,special_item_specialsmallname,special_item_specialstnum;

        public MyViewHolder(View itemView) {
            super(itemView);
            setIsRecyclable(false);
            special_item_specialimage= (ImageView) itemView.findViewById(R.id.special_item_specialimage);
            special_item_specialname= (TextView) itemView.findViewById(R.id.special_item_specialname);
            special_item_specialsmallname= (TextView) itemView.findViewById(R.id.special_item_specialsmallname);
            special_item_specialstnum= (TextView) itemView.findViewById(R.id.special_item_specialstnum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, WebActivity.class);
                    intent.putExtra("key",Integer.valueOf(mList.get(getPosition()).getId()));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
