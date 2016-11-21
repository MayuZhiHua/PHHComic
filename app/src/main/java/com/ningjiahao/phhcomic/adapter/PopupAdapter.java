package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.bean.ThemeBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.List;

/**
 * Created by My on 2016/11/18.
 */

public class PopupAdapter extends RecyclerView.Adapter{

      private List<ThemeBean.CBean.SBean>mList;
     private Context mContext;

    private LayoutInflater mInflater;


    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }else {
            return 2;
        }
    }

    public PopupAdapter(List<ThemeBean.CBean.SBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=null;
        if (viewType==1){
            view=mInflater.inflate(R.layout.popupwindow_head,parent,false);
            return new ViewHolderHead(view);
        }else {

         view = mInflater.inflate(R.layout.item_popupwindow,parent,false);
        return new MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
        ((MyViewHolder)holder).textView_name.setText(mList.get(position).getName());
        ((MyViewHolder)holder).textView_partname.setText(mList.get(position).getComicnum()+"部");
        Glide.with(mContext)
                .load(URLConstants.BASE_IMAGE_URL+mList.get(position).getIconr())
                .placeholder(R.drawable.ticai_placeimage)
                .into(((MyViewHolder)holder).imageView);
        }
    }

    @Override

    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView_name,textView_partname;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageview_popup_item);
            textView_name= (TextView) itemView.findViewById(R.id.textview_popupwindow_name);
            textView_partname= (TextView) itemView.findViewById(R.id.textview_popupwindow_partname);

        }
    }
    class ViewHolderHead extends RecyclerView.ViewHolder{
       TextView textView;
        public ViewHolderHead(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textview_popupwindow_head);
        }
    }
}
