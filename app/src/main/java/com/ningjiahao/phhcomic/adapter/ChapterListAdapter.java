package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.ManHuaChapterBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-17.
 */

public class ChapterListAdapter extends RecyclerViewAdapterHelper<ManHuaChapterBean.CBean>{

    public ChapterListAdapter(Context context, List<ManHuaChapterBean.CBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.chapterlist_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            Glide.with(mContext)
                    .load(URLConstants.IMAGE_BASE_URL+mList.get(position).getIcon())
                    .into(((MyViewHolder) holder).chapterlist_image);
            ((MyViewHolder) holder).chapterlist_chapterName.setText(mList.get(position).getName());
            String time=formatData("yyyy-MM-dd",Long.valueOf(mList.get(position).getAndpubtime()));
            ((MyViewHolder) holder).chapterlist_uptime.setText(time);
        }

    }
    public static String formatData(String dataFormat, long timeStamp) {
        if (timeStamp == 0) {
            return "";
        }
        timeStamp = timeStamp * 1000;
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        result = format.format(new Date(timeStamp));
        return result;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView chapterlist_image;
        TextView chapterlist_chapterName,chapterlist_uptime,chapter_mark;

        public MyViewHolder(View itemView) {
            super(itemView);
            chapterlist_image= (ImageView) itemView.findViewById(R.id.chapterlist_image);
            chapterlist_chapterName= (TextView) itemView.findViewById(R.id.chapterlist_chapterName);
            chapterlist_uptime= (TextView) itemView.findViewById(R.id.chapterlist_uptime);
            chapter_mark= (TextView) itemView.findViewById(R.id.chapter_mark);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
