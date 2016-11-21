package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-16.
 */

public class itemRecyclerAdapter extends RecyclerView.Adapter<itemRecyclerAdapter.MyViewHolder> {
    private List<ManHuaKuBean.CBean.TopicBean> list;
    private Context mContext;

    public itemRecyclerAdapter(List<ManHuaKuBean.CBean.TopicBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_itemrecyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + list.get(position).getIconr()).into(holder.recycler_item_image);
        holder.recycler_item_name.setText(list.get(position).getName());
        holder.recycler_item_numtxt.setText(list.get(position).getComicnum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView recycler_item_image;
        TextView recycler_item_numtxt, recycler_item_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            recycler_item_image = (ImageView) itemView.findViewById(R.id.recycler_item_image);
            recycler_item_numtxt = (TextView) itemView.findViewById(R.id.recycler_item_numtxt);
            recycler_item_name = (TextView) itemView.findViewById(R.id.recycler_item_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了"+list.get(getPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
