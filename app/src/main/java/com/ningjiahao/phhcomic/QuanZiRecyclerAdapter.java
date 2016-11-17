package com.ningjiahao.phhcomic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.activity.PhotoViewActivity;
import com.ningjiahao.phhcomic.activity.TieZiActivity;
import com.ningjiahao.phhcomic.bean.TuiJianBean;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;
import com.ningjiahao.phhcomic.helper.TimeHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by HP on 2016/11/15.
 */

public class QuanZiRecyclerAdapter extends RecyclerViewAdapterHelper<TuiJianBean.CBean>{


    public static final int STATE1 = 0, STATE2 = 1,STATE3 = 2, STATE4 = 3,STATE5 = 4;


    public QuanZiRecyclerAdapter(Context context, List<TuiJianBean.CBean> list) {
        super(context, list);
    }

    @Override
    public int getItemViewType(int position) {
        TuiJianBean.CBean cBean = mList.get(position);
        List<String> attach = cBean.getAttach();
        int attachSize = attach.size();
        if (attachSize==0){
            return STATE1;
        }else if (attachSize==1){
            return STATE2;
        }else if (attachSize==2|attachSize==3){
            return STATE3;
        }else if (attachSize==4|attachSize==5|attachSize==6){
            return STATE4;
        }else if (attachSize==7|attachSize==8|attachSize==9){
            return STATE5;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        //多布局的Type分析对应不同的ViewHolder
        View view=null;
        switch (viewType){
            case STATE1:
                view = mInflater.inflate(R.layout.quanzi_item0,parent,false);
                return new MyViewHolder1(view);
            case STATE2:
                view = mInflater.inflate(R.layout.quanzi_item1,parent,false);
                return new MyViewHolder2(view);
            case STATE3:
                view = mInflater.inflate(R.layout.quanzi_item2,parent,false);
                return new MyViewHolder3(view);
            case STATE4:
                view = mInflater.inflate(R.layout.quanzi_item3,parent,false);
                return new MyViewHolder4(view);
            case STATE5:
                view = mInflater.inflate(R.layout.quanzi_item4,parent,false);
                return new MyViewHolder5(view);
        }
        return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyViewHolder1) {//无图片
            MyViewHolder1 myViewHolder = (MyViewHolder1)holder;
            //获得当前cBean对象
            TuiJianBean.CBean cBean = mList.get(position);
            //头像地址
            String headURL = cBean.getUserext().getFace();
            Glide.with(mContext).load(Uri.parse(headURL)) .centerCrop().into(myViewHolder.imageView_quanzi_head_item);
            //用户名
            String username = cBean.getUserext().getNick();
            myViewHolder.textView_username_item.setText(username);
            //时间（不知道如何获得）
            String time = TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
            myViewHolder.textView_time_item.setText(time);
            //Title
            String title = cBean.getTitle();
            myViewHolder.textView_title_item.setText(title);
            //content(可能为空)
            if ((cBean.getContent().isEmpty())){
                myViewHolder.textView_content_item.setVisibility(View.GONE);
            }else {
                myViewHolder.textView_content_item.setText(cBean.getContent());
            }
            //点赞数
            int dianzan = cBean.getZanCount();
            myViewHolder.textView_dianzan_item.setText(String.valueOf(dianzan));
            //评论数
            int pinglun = cBean.getDiscussCount();
            myViewHolder.textView_pinglun_item.setText(String.valueOf(pinglun));
            //点击事件
        }else if (holder instanceof MyViewHolder2){//有一张图片
            MyViewHolder2 myViewHolder =  (MyViewHolder2)holder;
            //获得当前cBean对象
            TuiJianBean.CBean cBean = mList.get(position);
            //头像地址
            String headURL = cBean.getUserext().getFace();
            Glide.with(mContext).load(Uri.parse(headURL)).centerCrop().into(myViewHolder.imageView_quanzi_head_item);
            //用户名
            String username = cBean.getUserext().getNick();
            myViewHolder.textView_username_item.setText(username);
            //时间（不知道如何获得）
            String time = TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
            myViewHolder.textView_time_item.setText(time);
            //Title
            String title = cBean.getTitle();
            myViewHolder.textView_title_item.setText(title);
            //content(可能为空)
            if ((cBean.getContent().isEmpty())){
                myViewHolder.textView_content_item.setVisibility(View.GONE);
            }else {
                myViewHolder.textView_content_item.setText(cBean.getContent());
            }
            //加载图片,一张图片
            List<String> attach = cBean.getAttach();
            String photo0 = attach.get(0);
            useGlide(photo0,myViewHolder.imageView_quanzi_photo0);

            //点赞数
            int dianzan = cBean.getZanCount();
            myViewHolder.textView_dianzan_item.setText(String.valueOf(dianzan));
            //评论数
            int pinglun = cBean.getDiscussCount();
            myViewHolder.textView_pinglun_item.setText(String.valueOf(pinglun));
        }else if (holder instanceof MyViewHolder3){//2.3张图片
            MyViewHolder3 myViewHolder =  (MyViewHolder3)holder;
            //获得当前cBean对象
            TuiJianBean.CBean cBean = mList.get(position);
            //头像地址
            String headURL = cBean.getUserext().getFace();
            Glide.with(mContext).load(Uri.parse(headURL)) .centerCrop().into(myViewHolder.imageView_quanzi_head_item);
            //用户名
            String username = cBean.getUserext().getNick();
            myViewHolder.textView_username_item.setText(username);
            //时间（不知道如何获得）
            String time = TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
            myViewHolder.textView_time_item.setText(time);
            //Title
            String title = cBean.getTitle();
            myViewHolder.textView_title_item.setText(title);
            //content(可能为空)
            if ((cBean.getContent().isEmpty())){
                myViewHolder.textView_content_item.setVisibility(View.GONE);
            }else {
                myViewHolder.textView_content_item.setText(cBean.getContent());
            }
            //加载图片,2.3张图片
            List<String> attach = cBean.getAttach();
            String photo0,photo1,photo2;
            switch (attach.size()) {//图片的个数
                case 2:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    break;
                case 3:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    break;
            }
            //点赞数
            int dianzan = cBean.getZanCount();
            myViewHolder.textView_dianzan_item.setText(String.valueOf(dianzan));
            //评论数
            int pinglun = cBean.getDiscussCount();
            myViewHolder.textView_pinglun_item.setText(String.valueOf(pinglun));
        }else if (holder instanceof MyViewHolder4){//4.5.6张图片
            MyViewHolder4 myViewHolder =  (MyViewHolder4)holder;
            //获得当前cBean对象
            TuiJianBean.CBean cBean = mList.get(position);
            //头像地址
            String headURL = cBean.getUserext().getFace();
            Glide.with(mContext).load(Uri.parse(headURL)) .centerCrop().into(myViewHolder.imageView_quanzi_head_item);
            //用户名
            String username = cBean.getUserext().getNick();
            myViewHolder.textView_username_item.setText(username);
            //时间（不知道如何获得）
            String time = TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
            myViewHolder.textView_time_item.setText(time);
            //Title
            String title = cBean.getTitle();
            myViewHolder.textView_title_item.setText(title);
            //content(可能为空)
            if ((cBean.getContent().isEmpty())){
                myViewHolder.textView_content_item.setVisibility(View.GONE);
            }else {
                myViewHolder.textView_content_item.setText(cBean.getContent());
            }
            //加载图片,4.5.6张图片
            List<String> attach = cBean.getAttach();
            String photo0,photo1,photo2,photo3,photo4,photo5;
            switch (attach.size()){
                case 4:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    photo3 = attach.get(3);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    useGlide(photo3,myViewHolder.imageView_quanzi_photo3);
                    break;
                case 5:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    photo3 = attach.get(3);
                    photo4 = attach.get(4);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    useGlide(photo3,myViewHolder.imageView_quanzi_photo3);
                    useGlide(photo4,myViewHolder.imageView_quanzi_photo4);
                    break;
                case 6:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    photo3 = attach.get(3);
                    photo4 = attach.get(4);
                    photo5 = attach.get(5);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    useGlide(photo3,myViewHolder.imageView_quanzi_photo3);
                    useGlide(photo4,myViewHolder.imageView_quanzi_photo4);
                    useGlide(photo5,myViewHolder.imageView_quanzi_photo5);
                    break;
            }
            //点赞数
            int dianzan = cBean.getZanCount();
            myViewHolder.textView_dianzan_item.setText(String.valueOf(dianzan));
            //评论数
            int pinglun = cBean.getDiscussCount();
            myViewHolder.textView_pinglun_item.setText(String.valueOf(pinglun));
        }else if (holder instanceof MyViewHolder5){
            MyViewHolder5 myViewHolder =  (MyViewHolder5)holder;
            //获得当前cBean对象
            TuiJianBean.CBean cBean = mList.get(position);
            //头像地址
            String headURL = cBean.getUserext().getFace();
            Glide.with(mContext).load(Uri.parse(headURL)) .centerCrop().into(myViewHolder.imageView_quanzi_head_item);
            //用户名
            String username = cBean.getUserext().getNick();
            myViewHolder.textView_username_item.setText(username);
            //时间（不知道如何获得）
            String time = TimeHelper.formatData("yyyy-MM-dd",Long.valueOf(cBean.getCt()));
            myViewHolder.textView_time_item.setText(time);
            //Title
            String title = cBean.getTitle();
            myViewHolder.textView_title_item.setText(title);
            //content(可能为空)
            if ((cBean.getContent().isEmpty())){
                myViewHolder.textView_content_item.setVisibility(View.GONE);
            }else {
                myViewHolder.textView_content_item.setText(cBean.getContent());
            }
            //加载图片,7.8.9张图片
            List<String> attach = cBean.getAttach();
            String photo0,photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8;
            switch (attach.size()){
                case 7:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    photo3 = attach.get(3);
                    photo4 = attach.get(4);
                    photo5 = attach.get(5);
                    photo6 = attach.get(6);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    useGlide(photo3,myViewHolder.imageView_quanzi_photo3);
                    useGlide(photo4,myViewHolder.imageView_quanzi_photo4);
                    useGlide(photo5,myViewHolder.imageView_quanzi_photo5);
                    useGlide(photo6,myViewHolder.imageView_quanzi_photo6);
                    break;
                case 8:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    photo3 = attach.get(3);
                    photo4 = attach.get(4);
                    photo5 = attach.get(5);
                    photo6 = attach.get(6);
                    photo7 = attach.get(7);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    useGlide(photo3,myViewHolder.imageView_quanzi_photo3);
                    useGlide(photo4,myViewHolder.imageView_quanzi_photo4);
                    useGlide(photo5,myViewHolder.imageView_quanzi_photo5);
                    useGlide(photo6,myViewHolder.imageView_quanzi_photo6);
                    useGlide(photo7,myViewHolder.imageView_quanzi_photo7);
                    break;
                case 9:
                    photo0 = attach.get(0);
                    photo1 = attach.get(1);
                    photo2 = attach.get(2);
                    photo3 = attach.get(3);
                    photo4 = attach.get(4);
                    photo5 = attach.get(5);
                    photo6 = attach.get(6);
                    photo7 = attach.get(7);
                    photo8 = attach.get(8);
                    useGlide(photo0,myViewHolder.imageView_quanzi_photo0);
                    useGlide(photo1,myViewHolder.imageView_quanzi_photo1);
                    useGlide(photo2,myViewHolder.imageView_quanzi_photo2);
                    useGlide(photo3,myViewHolder.imageView_quanzi_photo3);
                    useGlide(photo4,myViewHolder.imageView_quanzi_photo4);
                    useGlide(photo5,myViewHolder.imageView_quanzi_photo5);
                    useGlide(photo6,myViewHolder.imageView_quanzi_photo6);
                    useGlide(photo7,myViewHolder.imageView_quanzi_photo7);
                    useGlide(photo8,myViewHolder.imageView_quanzi_photo8);
                    break;
            }
            //点赞数
            int dianzan = cBean.getZanCount();
            myViewHolder.textView_dianzan_item.setText(String.valueOf(dianzan));
            //评论数
            int pinglun = cBean.getDiscussCount();
            myViewHolder.textView_pinglun_item.setText(String.valueOf(pinglun));
        }
    }

    private void useGlide(String url,ImageView imageView){
        Glide.with(mContext).load(Uri.parse(url))
                .placeholder(R.drawable.imageloading)
                //.transform(new GlideRoundTransform(mContext,10)) //加载圆角图片
                .into(imageView);

    }




    //quanzi_item布局
    //无图片的ViewHolder
    class MyViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView imageView_quanzi_head_item;
        private TextView textView_username_item,textView_time_item,
                textView_title_item,textView_content_item,
                textView_dianzan_item,textView_pinglun_item;

        public MyViewHolder1(View itemView) {
            super(itemView);
            imageView_quanzi_head_item = (ImageView) itemView.findViewById(R.id.imageView_quanzi_head_item);
            textView_username_item = (TextView) itemView.findViewById(R.id.textView_username_item);
            textView_time_item = (TextView) itemView.findViewById(R.id.textView_time_item);
            textView_title_item = (TextView) itemView.findViewById(R.id.textView_title_item);
            textView_content_item = (TextView) itemView.findViewById(R.id.textView_content_item);
            textView_dianzan_item = (TextView) itemView.findViewById(R.id.textView_dianzan_item);
            textView_pinglun_item = (TextView) itemView.findViewById(R.id.textView_pinglun_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TieZiActivity.class);
                    intent.putExtra("CBean",mList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });
        }
    }

    //有一张图片的ViewHolder
    class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView_quanzi_head_item;
        private ImageView imageView_quanzi_photo0;
        private TextView textView_username_item,textView_time_item,
                textView_title_item,textView_content_item,
                textView_dianzan_item,textView_pinglun_item;

        public MyViewHolder2(View itemView) {
            super(itemView);
            imageView_quanzi_head_item = (ImageView) itemView.findViewById(R.id.imageView_quanzi_head_item);
            imageView_quanzi_photo0 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo0);
            textView_username_item = (TextView) itemView.findViewById(R.id.textView_username_item);
            textView_time_item = (TextView) itemView.findViewById(R.id.textView_time_item);
            textView_title_item = (TextView) itemView.findViewById(R.id.textView_title_item);
            textView_content_item = (TextView) itemView.findViewById(R.id.textView_content_item);
            textView_dianzan_item = (TextView) itemView.findViewById(R.id.textView_dianzan_item);
            textView_pinglun_item = (TextView) itemView.findViewById(R.id.textView_pinglun_item);
            imageView_quanzi_photo0.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TieZiActivity.class);
                    intent.putExtra("CBean",mList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,PhotoViewActivity.class);
            switch (v.getId()){
                case R.id.imageView_quanzi_photo0:
                    intent.putExtra("position",0);
                    break;
            }
            List<String> attach= mList.get(getAdapterPosition()).getAttach();
            intent.putStringArrayListExtra("photo", (ArrayList<String>) attach);
            mContext.startActivity(intent);

        }
    }

    //有2.3张图片的ViewHolder
    class MyViewHolder3 extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView_quanzi_head_item;
        private ImageView imageView_quanzi_photo0,
                imageView_quanzi_photo1,imageView_quanzi_photo2;
        private TextView textView_username_item,textView_time_item,
                textView_title_item,textView_content_item,
                textView_dianzan_item,textView_pinglun_item;
        public MyViewHolder3(View itemView) {
            super(itemView);
            imageView_quanzi_head_item = (ImageView) itemView.findViewById(R.id.imageView_quanzi_head_item);
            imageView_quanzi_photo0 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo0);
            imageView_quanzi_photo1 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo1);
            imageView_quanzi_photo2 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo2);
            textView_username_item = (TextView) itemView.findViewById(R.id.textView_username_item);
            textView_time_item = (TextView) itemView.findViewById(R.id.textView_time_item);
            textView_title_item = (TextView) itemView.findViewById(R.id.textView_title_item);
            textView_content_item = (TextView) itemView.findViewById(R.id.textView_content_item);
            textView_dianzan_item = (TextView) itemView.findViewById(R.id.textView_dianzan_item);
            textView_pinglun_item = (TextView) itemView.findViewById(R.id.textView_pinglun_item);

            //点击监听
            imageView_quanzi_photo0.setOnClickListener(this);
            imageView_quanzi_photo1.setOnClickListener(this);
            imageView_quanzi_photo2.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TieZiActivity.class);
                    intent.putExtra("CBean",mList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,PhotoViewActivity.class);
            List<String> attach= mList.get(getAdapterPosition()).getAttach();
            switch (v.getId()){
                case R.id.imageView_quanzi_photo0:
                    intent.putExtra("position",0);
                    break;
                case R.id.imageView_quanzi_photo1:
                    intent.putExtra("position",1);
                    break;
                case R.id.imageView_quanzi_photo2:
                    if (attach.size()==3){
                        intent.putExtra("position",2);
                    }else {
                        return;
                    }
            }
            intent.putStringArrayListExtra("photo", (ArrayList<String>) attach);
            mContext.startActivity(intent);
        }
    }

    //有4.5.6张图片的ViewHolder
    class MyViewHolder4 extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView_quanzi_head_item;
        private ImageView imageView_quanzi_photo0,
                imageView_quanzi_photo1,imageView_quanzi_photo2,
                imageView_quanzi_photo3,imageView_quanzi_photo4,
                imageView_quanzi_photo5;
        private TextView textView_username_item,textView_time_item,
                textView_title_item,textView_content_item,
                textView_dianzan_item,textView_pinglun_item;
        public MyViewHolder4(View itemView) {
            super(itemView);
            imageView_quanzi_head_item = (ImageView) itemView.findViewById(R.id.imageView_quanzi_head_item);
            imageView_quanzi_photo0 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo0);
            imageView_quanzi_photo1 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo1);
            imageView_quanzi_photo2 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo2);
            imageView_quanzi_photo3 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo3);
            imageView_quanzi_photo4 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo4);
            imageView_quanzi_photo5 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo5);
            textView_username_item = (TextView) itemView.findViewById(R.id.textView_username_item);
            textView_time_item = (TextView) itemView.findViewById(R.id.textView_time_item);
            textView_title_item = (TextView) itemView.findViewById(R.id.textView_title_item);
            textView_content_item = (TextView) itemView.findViewById(R.id.textView_content_item);
            textView_dianzan_item = (TextView) itemView.findViewById(R.id.textView_dianzan_item);
            textView_pinglun_item = (TextView) itemView.findViewById(R.id.textView_pinglun_item);
            //点击监听
            imageView_quanzi_photo0.setOnClickListener(this);
            imageView_quanzi_photo1.setOnClickListener(this);
            imageView_quanzi_photo2.setOnClickListener(this);
            imageView_quanzi_photo4.setOnClickListener(this);
            imageView_quanzi_photo5.setOnClickListener(this);
            imageView_quanzi_photo3.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TieZiActivity.class);
                    intent.putExtra("CBean",mList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,PhotoViewActivity.class);
            List<String> attach= mList.get(getAdapterPosition()).getAttach();
            switch (v.getId()){
                case R.id.imageView_quanzi_photo0:
                    intent.putExtra("position",0);
                    break;
                case R.id.imageView_quanzi_photo1:
                    intent.putExtra("position",1);
                    break;
                case R.id.imageView_quanzi_photo2:
                    intent.putExtra("position",2);
                    break;
                case R.id.imageView_quanzi_photo3:
                    if (attach.size()>=4){
                        intent.putExtra("position",3);
                    }else {
                        return;
                    }
                    break;
                case R.id.imageView_quanzi_photo4:
                    if (attach.size()>=5){
                        intent.putExtra("position",4);
                    }else {
                        return;
                    }
                    break;
                case R.id.imageView_quanzi_photo5:
                    if (attach.size()>=6){
                        intent.putExtra("position",5);
                    }else {
                        return;
                    }
                    break;
            }
            intent.putStringArrayListExtra("photo", (ArrayList<String>) attach);
            mContext.startActivity(intent);
        }
    }

    //有7.8.9张图片的ViewHolder
    class MyViewHolder5 extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView_quanzi_head_item;
        private ImageView imageView_quanzi_photo0,
                imageView_quanzi_photo1,imageView_quanzi_photo2,
                imageView_quanzi_photo3,imageView_quanzi_photo4,
                imageView_quanzi_photo5,imageView_quanzi_photo6,
                imageView_quanzi_photo7,imageView_quanzi_photo8;
        private TextView textView_username_item,textView_time_item,
                textView_title_item,textView_content_item,
                textView_dianzan_item,textView_pinglun_item;

        public MyViewHolder5(View itemView) {
            super(itemView);
            imageView_quanzi_head_item = (ImageView) itemView.findViewById(R.id.imageView_quanzi_head_item);
            imageView_quanzi_photo0 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo0);
            imageView_quanzi_photo1 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo1);
            imageView_quanzi_photo2 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo2);
            imageView_quanzi_photo3 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo3);
            imageView_quanzi_photo4 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo4);
            imageView_quanzi_photo5 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo5);
            imageView_quanzi_photo6 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo6);
            imageView_quanzi_photo7 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo7);
            imageView_quanzi_photo8 = (ImageView) itemView.findViewById(R.id.imageView_quanzi_photo8);
            textView_username_item = (TextView) itemView.findViewById(R.id.textView_username_item);
            textView_time_item = (TextView) itemView.findViewById(R.id.textView_time_item);
            textView_title_item = (TextView) itemView.findViewById(R.id.textView_title_item);
            textView_content_item = (TextView) itemView.findViewById(R.id.textView_content_item);
            textView_dianzan_item = (TextView) itemView.findViewById(R.id.textView_dianzan_item);
            textView_pinglun_item = (TextView) itemView.findViewById(R.id.textView_pinglun_item);
            //点击监听
            imageView_quanzi_photo0.setOnClickListener(this);
            imageView_quanzi_photo1.setOnClickListener(this);
            imageView_quanzi_photo2.setOnClickListener(this);
            imageView_quanzi_photo4.setOnClickListener(this);
            imageView_quanzi_photo5.setOnClickListener(this);
            imageView_quanzi_photo3.setOnClickListener(this);
            imageView_quanzi_photo6.setOnClickListener(this);
            imageView_quanzi_photo7.setOnClickListener(this);
            imageView_quanzi_photo8.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TieZiActivity.class);
                    intent.putExtra("CBean",mList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,PhotoViewActivity.class);
            List<String> attach= mList.get(getAdapterPosition()).getAttach();
            switch (v.getId()){
                case R.id.imageView_quanzi_photo0:
                    intent.putExtra("position",0);
                    break;
                case R.id.imageView_quanzi_photo1:
                    intent.putExtra("position",1);
                    break;
                case R.id.imageView_quanzi_photo2:
                    intent.putExtra("position",2);
                    break;
                case R.id.imageView_quanzi_photo3:
                    intent.putExtra("position",3);
                    break;
                case R.id.imageView_quanzi_photo4:
                    intent.putExtra("position",4);
                    break;
                case R.id.imageView_quanzi_photo5:
                    intent.putExtra("position",5);
                    break;
                case R.id.imageView_quanzi_photo6:
                    if (attach.size() >= 7){
                        intent.putExtra("position",6);
                    }else {
                        return;
                    }
                    break;
                case R.id.imageView_quanzi_photo7:
                    if (attach.size() >= 8){
                        intent.putExtra("position",7);
                    }else {
                        return;
                    }
                    break;
                case R.id.imageView_quanzi_photo8:
                    if (attach.size() >= 9){
                        intent.putExtra("position",8);
                    }else {
                        return;
                    }
                    break;
            }

            intent.putStringArrayListExtra("photo", (ArrayList<String>) attach);
            mContext.startActivity(intent);
        }
    }
}
