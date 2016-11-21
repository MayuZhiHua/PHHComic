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
import com.ningjiahao.phhcomic.activity.ManHuaDetailActivity;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.bean.UpdateBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-18.
 */

public class UpdateRecyclerAdapter extends RecyclerViewAdapterHelper<UpdateBean.CBean.SBean>{

    public UpdateRecyclerAdapter(Context context, List<UpdateBean.CBean.SBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.manhuaku_item_showinfo,parent,false);
        return new UpdateViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof UpdateViewHolder){
            Glide.with(mContext)
                    .load(URLConstants.IMAGE_BASE_URL + mList.get(position).getAppiconu())
                    .placeholder(R.drawable.ticai_placeimage)
                    .into(((UpdateRecyclerAdapter.UpdateViewHolder) holder).manhuaku_image_main);
            if (mList.get(position).getSicon() != null && !mList.get(position).getSicon().equals("")) {
                Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + mList.get(position).getSicon()).into(((UpdateRecyclerAdapter.UpdateViewHolder) holder).manhuaku_image_mark);
            }
            ((UpdateRecyclerAdapter.UpdateViewHolder) holder).manhuaku_txt_score.setText(mList.get(position).getScore());
            ((UpdateRecyclerAdapter.UpdateViewHolder) holder).manhuaku_txt_latestchapter.setText(mList.get(position).getPartname().substring(1, 5));
            ((UpdateRecyclerAdapter.UpdateViewHolder) holder).manhuaku_txt_manhuaname.setText(mList.get(position).getName());

        }
    }
    class UpdateViewHolder extends RecyclerView.ViewHolder{
        ImageView manhuaku_image_main, manhuaku_image_mark;
        TextView manhuaku_txt_score, manhuaku_txt_latestchapter, manhuaku_txt_manhuaname;
        public UpdateViewHolder(View itemView) {
            super(itemView);
            manhuaku_image_main = (ImageView) itemView.findViewById(R.id.manhuaku_image_main);
            manhuaku_image_mark = (ImageView) itemView.findViewById(R.id.manhuaku_image_mark);
            manhuaku_txt_score = (TextView) itemView.findViewById(R.id.manhuaku_txt_score);
            manhuaku_txt_latestchapter = (TextView) itemView.findViewById(R.id.manhuaku_txt_latestchapter);
            manhuaku_txt_manhuaname = (TextView) itemView.findViewById(R.id.manhuaku_txt_manhuaname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ManHuaDetailActivity.class);
                    int id = Integer.valueOf(((UpdateBean.CBean.SBean) mList.get(getPosition())).getId());
                    intent.putExtra("key", id);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
