package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.ManHuaDiscussBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-17.
 */

public class DetailDiscussAdapter extends RecyclerViewAdapterHelper<ManHuaDiscussBean.CBean>{

    public DetailDiscussAdapter(Context context, List<ManHuaDiscussBean.CBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.manhuadiscuss_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DetailDiscussAdapter.MyViewHolder){
            Glide.with(mContext)
                    .load(mList.get(position).getUserextEe().getFace())
                    .placeholder(R.drawable.personal_head_portrait_h)
                    .into(((MyViewHolder) holder).imageView_discussHead);
            String time=ChapterListAdapter.formatData("yyyy-MM-dd",Long.valueOf(mList.get(position).getCt()));
            ((MyViewHolder) holder).time_detaildiscuss.setText(time);
            ((MyViewHolder) holder).username_detaildiscuss.setText(mList.get(position).getUserextEe().getNick());
            ((MyViewHolder) holder).pinglun_detaildiscuss.setText(mList.get(position).getContent());
        }

    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_discussHead;
        TextView username_detaildiscuss,time_detaildiscuss,pinglun_detaildiscuss;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView_discussHead= (ImageView) itemView.findViewById(R.id.imageView_discussHead);
            username_detaildiscuss= (TextView) itemView.findViewById(R.id.username_detaildiscuss);
            time_detaildiscuss= (TextView) itemView.findViewById(R.id.time_detaildiscuss);
            pinglun_detaildiscuss= (TextView) itemView.findViewById(R.id.pinglun_detaildiscuss);
            imageView_discussHead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "id是"+mList.get(getPosition()).getOid(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
