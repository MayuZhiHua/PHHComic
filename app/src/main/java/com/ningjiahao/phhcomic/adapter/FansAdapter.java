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
import com.ningjiahao.phhcomic.bean.FansBean;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by HP on 2016/11/18.
 */

public class FansAdapter extends RecyclerViewAdapterHelper<FansBean.CBean> {


    public FansAdapter(Context context, List<FansBean.CBean> list) {
        super(context, list);
    }



    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.fans_full,parent,false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder1 myViewHolder = (MyViewHolder1)holder;
        //获得当前的Cbean
        FansBean.CBean cBean = mList.get(position);
        //头像
        String headURL = cBean.getFace();
        Glide.with(mContext).load(Uri.parse(headURL)).centerCrop().into(myViewHolder.imageView_head_fans_full);
        //username
        String username = cBean.getNick();
        myViewHolder.textView_username_fans_full.setText(username);
        //签名
        String qianming = cBean.getMotto();
        myViewHolder.textView_qianming_fans_full.setText(qianming);


    }

    //有数据的ViewHolder
    class MyViewHolder1 extends RecyclerView.ViewHolder{
        private ImageView imageView_head_fans_full;
        private TextView textView_username_fans_full,textView_qianming_fans_full;
        public MyViewHolder1(View itemView) {
            super(itemView);
            imageView_head_fans_full = (ImageView) itemView.findViewById(R.id.imageView_head_fans_full);
            textView_username_fans_full = (TextView) itemView.findViewById(R.id.textView_username_fans_full);
            textView_qianming_fans_full = (TextView) itemView.findViewById(R.id.textView_qianming_fans_full);
            imageView_head_fans_full.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.e("FansAdapter", String.valueOf(mList.get(getAdapterPosition()).getOid()));
                    Intent intent = new Intent(mContext, UserActivity.class);
                    intent.putExtra("oid",String.valueOf(mList.get(getAdapterPosition()).getOid()));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
