package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.ManHuaBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

import static com.ningjiahao.phhcomic.R.id.readmanhua_photoview;

/**
 * Created by 甯宁寧 on 2016-11-17.
 */

public class ReadManHuaAdapter extends RecyclerViewAdapterHelper<String>{
    private List<ManHuaBean.CBean.SizeBean> Sizelist;
    public ReadManHuaAdapter(Context context, List<String> list, List<ManHuaBean.CBean.SizeBean> Sizelist) {
        super(context, list);
        this.Sizelist=Sizelist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.readmanhua_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ReadManHuaAdapter.MyViewHolder){
            ManHuaBean.CBean.SizeBean sizeBean = Sizelist.get(position);
            ((MyViewHolder) holder).readmanhua_photoview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(mContext)
                    .load(URLConstants.IMAGE_BASE_URL+mList.get(position))
                    .into(((MyViewHolder) holder).readmanhua_photoview);
        }

    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        PhotoView readmanhua_photoview;

        public MyViewHolder(View itemView) {
            super(itemView);
            readmanhua_photoview= (PhotoView) itemView.findViewById(R.id.readmanhua_photoview);
        }
    }
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
