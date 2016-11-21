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
import com.ningjiahao.phhcomic.bean.HotRankBean;
import com.ningjiahao.phhcomic.bean.OverRankBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-18.
 */

public class RankFragmentRecyclerAdapter extends RecyclerViewAdapterHelper<Object>{
    public RankFragmentRecyclerAdapter(Context context, List<Object> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.rank_fragment_item,parent,false);
        return new MyRankViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        if(holder instanceof MyRankViewHolder) {
            if (mList.get(position) instanceof HotRankBean.CBean.SBean) {
                HotRankBean.CBean.SBean HCS= (HotRankBean.CBean.SBean) mList.get(position);
                Glide.with(mContext)
                        .load(URLConstants.IMAGE_BASE_URL +HCS.getAppicons())
                        .placeholder(R.drawable.ticai_placeimage)
                        .into(((MyRankViewHolder) holder).rank_item_image_pic);
                ((MyRankViewHolder) holder).rank_item_text_author.setText(HCS.getAuthor());
                ((MyRankViewHolder) holder).rank_item_text_name.setText(HCS.getName());
                ((MyRankViewHolder) holder).rank_item_text_cfyname.setText(HCS.getCfyname());
                ((MyRankViewHolder) holder).rank_item_text_partname.setText("更新到"+HCS.getPartname());
                ((MyRankViewHolder) holder).rank_item_text_score.setText(HCS.getScore());
                ((MyRankViewHolder) holder).rank_item_text_tname.setText(HCS.getTname());
                ((MyRankViewHolder) holder).rank_item_text_update.setText(HCS.getTh());
                switch (position){
                    case 0:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_1));
                        break;
                    case 1:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_2));
                        break;
                    case 2:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_3));
                        break;
                    case 3:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_4));
                        break;
                    default:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setText(""+(position+1));
                        ((MyRankViewHolder) holder).rank_item_text_rank.setTextColor(mContext.getResources().getColor(R.color.grey));
                        break;
                }

            } else if (mList.get(position) instanceof OverRankBean.CBean.SBean) {
                OverRankBean.CBean.SBean OCS= (OverRankBean.CBean.SBean) mList.get(position);
                Glide.with(mContext)
                        .load(URLConstants.IMAGE_BASE_URL +OCS.getAppicons())
                        .placeholder(R.drawable.ticai_placeimage)
                        .into(((MyRankViewHolder) holder).rank_item_image_pic);
                ((MyRankViewHolder) holder).rank_item_text_author.setText(OCS.getAuthor());
                ((MyRankViewHolder) holder).rank_item_text_name.setText(OCS.getName());
                ((MyRankViewHolder) holder).rank_item_text_cfyname.setText(OCS.getCfyname());
                ((MyRankViewHolder) holder).rank_item_text_partname.setText("已完结");
                ((MyRankViewHolder) holder).rank_item_text_score.setText(OCS.getScore());
                ((MyRankViewHolder) holder).rank_item_text_tname.setText(OCS.getTname());
                ((MyRankViewHolder) holder).rank_item_image_updateground.setImageResource(R.drawable.home_daily_red_over);
                switch (position){
                    case 0:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_1));
                        break;
                    case 1:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_2));
                        break;
                    case 2:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_3));
                        break;
                    case 3:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setBackground(mContext.getResources().getDrawable(R.drawable.crown_4));
                        break;
                    default:
                        ((MyRankViewHolder) holder).rank_item_text_rank.setText(""+(position+1));
                        ((MyRankViewHolder) holder).rank_item_text_rank.setTextColor(mContext.getResources().getColor(R.color.grey));
                        break;
                }


            }
        }

    }
    class MyRankViewHolder extends RecyclerView.ViewHolder{
        TextView rank_item_text_rank,rank_item_text_name,rank_item_text_tname,rank_item_text_cfyname,rank_item_text_author,
                rank_item_text_partname,rank_item_text_update,rank_item_text_score;
        ImageView rank_item_image_updateground,rank_item_image_pic;

        public MyRankViewHolder(View itemView) {
            super(itemView);
            rank_item_text_rank= (TextView) itemView.findViewById(R.id.rank_item_text_rank);
            rank_item_text_name= (TextView) itemView.findViewById(R.id.rank_item_text_name);
            rank_item_text_tname= (TextView) itemView.findViewById(R.id.rank_item_text_tname);
            rank_item_text_cfyname= (TextView) itemView.findViewById(R.id.rank_item_text_cfyname);
            rank_item_text_author= (TextView) itemView.findViewById(R.id.rank_item_text_author);
            rank_item_text_partname= (TextView) itemView.findViewById(R.id.rank_item_text_partname);
            rank_item_text_update= (TextView) itemView.findViewById(R.id.rank_item_text_update);
            rank_item_text_score= (TextView) itemView.findViewById(R.id.rank_item_text_score);
            rank_item_image_updateground= (ImageView) itemView.findViewById(R.id.rank_item_image_updateground);
            rank_item_image_pic= (ImageView) itemView.findViewById(R.id.rank_item_image_pic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, ManHuaDetailActivity.class);
                    if(mList.get(getPosition()) instanceof HotRankBean.CBean.SBean){
                        intent.putExtra("key",Integer.valueOf(((HotRankBean.CBean.SBean) mList.get(getPosition())).getId()));
                    }else if(mList.get(getPosition()) instanceof OverRankBean.CBean.SBean){
                        intent.putExtra("key",Integer.valueOf(((OverRankBean.CBean.SBean) mList.get(getPosition())).getId()));
                    }
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
