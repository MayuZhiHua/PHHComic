package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.CollectionBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by HP on 2016/11/21.
 */

public class CollectionAdapter extends BaseAdapter {
    private Context mContext;
    private List<CollectionBean> mlist ;

    public CollectionAdapter(Context mContext, List<CollectionBean> mlist) {
        this.mContext = mContext;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_collect,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textView_title_collect);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView_picture_collect);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        String name = mlist.get(position).getName();
        String imageURL = mlist.get(position).getImageURL();
        viewHolder.textView.setText(name);
        Glide.with(mContext).load(Uri.parse(imageURL)).into(viewHolder.imageView);
        return convertView;
    }



    class ViewHolder{
        private TextView textView;
        private ImageView imageView;
    }
}
