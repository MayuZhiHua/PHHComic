package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.UserActivity;
import com.ningjiahao.phhcomic.bean.TieZiPlBean;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;
import com.ningjiahao.phhcomic.helper.TimeHelper;

import java.util.List;

/**
 * Created by HP on 2016/11/17.
 */

public class TieZiPlRecyclerAdapter extends RecyclerViewAdapterHelper<TieZiPlBean.CBean>{


    public TieZiPlRecyclerAdapter(Context context, List<TieZiPlBean.CBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.quanzipl_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        TieZiPlBean.CBean cBean=mList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder)holder;
        //头像
        String headURL = cBean.getUserextEe().getFace();
        Glide.with(mContext).load(Uri.parse(headURL)).centerCrop().into( myViewHolder.imageView_head_tzpl);
        //用户名
        String username = cBean.getUserextEe().getNick();
        myViewHolder.textView_username_tzpl.setText(username);
        //时间
        String time= TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
        myViewHolder.textView_time_tzpl.setText(time);
        //评论内容
        String pinglun = cBean.getContent();
        //Log.e("TieZiPlRecyclerAdapter","TieZiPlRecyclerAdapter"+pinglun);
        myViewHolder.textView_pinglun_tzpl.setText(pinglun);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView_head_tzpl;
        private TextView textView_username_tzpl,textView_time_tzpl,textView_pinglun_tzpl;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView_head_tzpl = (ImageView) itemView.findViewById(R.id.imageView_head_tzpl);
            textView_username_tzpl = (TextView) itemView.findViewById(R.id.textView_username_tzpl);
            textView_time_tzpl = (TextView) itemView.findViewById(R.id.textView_time_tzpl);
            textView_pinglun_tzpl = (TextView) itemView.findViewById(R.id.textView_pinglun_tzpl);
            imageView_head_tzpl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, UserActivity.class);
                    intent.putExtra("oid",mList.get(getAdapterPosition()).getOid());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
