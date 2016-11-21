package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.MainActivity;
import com.ningjiahao.phhcomic.activity.ManHuaDetailActivity;
import com.ningjiahao.phhcomic.activity.ManHuaRankActivity;
import com.ningjiahao.phhcomic.activity.RedNewManHuaActivity;
import com.ningjiahao.phhcomic.activity.SpcialListActivity;
import com.ningjiahao.phhcomic.activity.UpdateActivity;
import com.ningjiahao.phhcomic.activity.WebActivity;
import com.ningjiahao.phhcomic.bean.ManHuaKuBean;
import com.ningjiahao.phhcomic.bean.RedNewBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.helper.RecyclerViewAdapterHelper;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;

import static com.ningjiahao.phhcomic.R.drawable.dot;

/**
 * Created by 甯宁寧 on 2016-11-15.
 */

public class ManHuaKuRecyclerAdapter extends RecyclerViewAdapterHelper<Object> {
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;
    public static final int TYPE3 = 2;
    public static final int TYPE4 = 3;
    public static final int TYPE5 = 4;
    public static final int TYPE6 = 5;
    public static final int TYPE7 = 6;
    private int count = 0;
    private int dotNum = 0;
    private int recycler = 0;
    private int count2 = 0;
    private int count3 = 0;
    private ManHuaKuViewPagerAdapter mManHuaKuPagerAdapter;
    private List<ManHuaKuBean.CBean.CarouselBean> pagerData;
    private List<ManHuaKuBean.CBean.TopicBean> itemRecycler;
    private LinearLayout adDotLayout;
    private ViewPager manhuaku_viewpager;
    private Handler adHandler = new Handler();
    private ADRunnable adrun = new ADRunnable();
    private List<ManHuaKuBean.CBean.SpecialBean> specialData;
    public static int j;

    public ManHuaKuRecyclerAdapter(Context context, List<Object> list, List<ManHuaKuBean.CBean.CarouselBean> pagerData,
                                   List<ManHuaKuBean.CBean.TopicBean> itemRecycler, List<ManHuaKuBean.CBean.SpecialBean> specialData) {

        super(context, list);
        this.specialData = specialData;
        this.pagerData = pagerData;
        this.itemRecycler = itemRecycler;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof ManHuaKuBean.CBean.CarouselBean) {
            return TYPE1;
        } else if (mList.get(position) instanceof String) {
            return TYPE2;
        } else if (mList.get(position) instanceof ManHuaKuBean.CBean.RedcomicBean ||
                mList.get(position) instanceof ManHuaKuBean.CBean.NewcomicBean ||
                mList.get(position) instanceof ManHuaKuBean.CBean.RecommendcomicBean ||
                mList.get(position) instanceof ManHuaKuBean.CBean.WeekBean) {
            return TYPE3;
        } else if (mList.get(position) instanceof Integer) {
            return TYPE4;
        } else if (mList.get(position) instanceof Boolean) {
            return TYPE5;
        } else if (mList.get(position) instanceof ManHuaKuBean.CBean.SpecialBean) {
            return TYPE6;
        } else if (mList.get(position) instanceof ManHuaKuBean.CBean.TopicBean) {
            return TYPE7;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE1:
                if (count > 0) {
                    view = mInflater.inflate(R.layout.manhuaku_item_empty, parent, false);
                    return new ViewHolder7(view);
                }
                count++;
                view = mInflater.inflate(R.layout.manhuaku_item_head, parent, false);
                return new ViewHolder1(view);
            case TYPE2:
                view = mInflater.inflate(R.layout.manhuaku_item_clickabletitle, parent, false);
                return new ViewHolder2(view);
            case TYPE3:
                view = mInflater.inflate(R.layout.manhuaku_item_showinfo, parent, false);
                return new ViewHolder3(view);
            case TYPE4:
                view = mInflater.inflate(R.layout.manhuaku_item_text, parent, false);
                return new ViewHolder4(view);
            case TYPE5:
                if (count2 > 0) {
                    view = mInflater.inflate(R.layout.manhuaku_item_empty, parent, false);
                    return new ViewHolder7(view);
                }
                count2++;
                view = mInflater.inflate(R.layout.manhuaku_item_recyclerview, parent, false);
                return new ViewHolder5(view);
            case TYPE6:
                if (count3 > 0) {
                    view = mInflater.inflate(R.layout.manhuaku_item_empty, parent, false);
                    return new ViewHolder7(view);
                }
                count3++;
                view = mInflater.inflate(R.layout.manhuaku_item_special, parent, false);
                return new ViewHolder6(view);
            case TYPE7:
                view = mInflater.inflate(R.layout.manhuaku_item_empty, parent, false);
                return new ViewHolder7(view);
        }
        return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            dotNum++;
            if (dotNum == 1) {
                List<View> viewList = new ArrayList<>();
                for (int i = 0; i < pagerData.size(); i++) {
                    ImageView iv = new ImageView(mContext);
                    iv.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                    ));
                    iv.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + pagerData.get(i).getSrc()).into(iv);
                    viewList.add(iv);
                }
                mManHuaKuPagerAdapter = new ManHuaKuViewPagerAdapter(viewList,pagerData,mContext);
                manhuaku_viewpager.setAdapter(mManHuaKuPagerAdapter);
                initDot();
                setPager();
                adHandler.postDelayed(adrun, 2000);
            }
        } else if (holder instanceof ViewHolder2) {
            ((ViewHolder2) holder).manhuaku_txt_clicktitle.setText((String) mList.get(position));
        } else if (holder instanceof ViewHolder3) {
            if (mList.get(position) instanceof ManHuaKuBean.CBean.RedcomicBean) {
                ManHuaKuBean.CBean.RedcomicBean redcomicBean = (ManHuaKuBean.CBean.RedcomicBean) mList.get(position);
                Glide.with(mContext)
                        .load(URLConstants.IMAGE_BASE_URL + redcomicBean.getAppiconu())
                        .placeholder(R.drawable.ticai_placeimage)
                        .into(((ViewHolder3) holder).manhuaku_image_main);
                if (redcomicBean.getSicon() != null && !redcomicBean.getSicon().equals("")) {
                    Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + redcomicBean.getSicon()).into(((ViewHolder3) holder).manhuaku_image_mark);
                }
                ((ViewHolder3) holder).manhuaku_txt_score.setText(redcomicBean.getScore());
                ((ViewHolder3) holder).manhuaku_txt_latestchapter.setText(redcomicBean.getPartname().substring(1, 5));
                ((ViewHolder3) holder).manhuaku_txt_manhuaname.setText(redcomicBean.getName());
            }
            if (mList.get(position) instanceof ManHuaKuBean.CBean.NewcomicBean) {
                ManHuaKuBean.CBean.NewcomicBean newcomicBean = (ManHuaKuBean.CBean.NewcomicBean) mList.get(position);
                Glide.with(mContext)
                        .load(URLConstants.IMAGE_BASE_URL + newcomicBean.getAppiconu())
                        .placeholder(R.drawable.ticai_placeimage)
                        .into(((ViewHolder3) holder).manhuaku_image_main);
                if (newcomicBean.getSicon() != null && !newcomicBean.getSicon().equals("")) {
                    Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + newcomicBean.getSicon()).into(((ViewHolder3) holder).manhuaku_image_mark);
                }
                ((ViewHolder3) holder).manhuaku_txt_score.setText(newcomicBean.getScore());
                ((ViewHolder3) holder).manhuaku_txt_latestchapter.setText(newcomicBean.getPartname().substring(1, 5));
                ((ViewHolder3) holder).manhuaku_txt_manhuaname.setText(newcomicBean.getName());
            }
            if (mList.get(position) instanceof ManHuaKuBean.CBean.RecommendcomicBean) {
                ManHuaKuBean.CBean.RecommendcomicBean recommendcomicBean = (ManHuaKuBean.CBean.RecommendcomicBean) mList.get(position);
                Glide.with(mContext)
                        .load(URLConstants.IMAGE_BASE_URL + recommendcomicBean.getAppiconu())
                        .placeholder(R.drawable.ticai_placeimage)
                        .into(((ViewHolder3) holder).manhuaku_image_main);
                if (recommendcomicBean.getSicon() != null && !recommendcomicBean.getSicon().equals("")) {
                    Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + recommendcomicBean.getSicon()).into(((ViewHolder3) holder).manhuaku_image_mark);
                }
                ((ViewHolder3) holder).manhuaku_txt_score.setText(recommendcomicBean.getScore());
                ((ViewHolder3) holder).manhuaku_txt_latestchapter.setText(recommendcomicBean.getPartname().substring(1, 5));
                ((ViewHolder3) holder).manhuaku_txt_manhuaname.setText(recommendcomicBean.getName());
            }
            if (mList.get(position) instanceof ManHuaKuBean.CBean.WeekBean) {
                ManHuaKuBean.CBean.WeekBean weekBean = (ManHuaKuBean.CBean.WeekBean) mList.get(position);
                Glide.with(mContext)
                        .load(URLConstants.IMAGE_BASE_URL + weekBean.getAppiconu())
                        .placeholder(R.drawable.ticai_placeimage)
                        .into(((ViewHolder3) holder).manhuaku_image_main);
                if (weekBean.getSicon() != null && !weekBean.getSicon().equals("")) {
                    Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + weekBean.getSicon()).into(((ViewHolder3) holder).manhuaku_image_mark);
                }
                ((ViewHolder3) holder).manhuaku_txt_score.setText(weekBean.getScore());
                ((ViewHolder3) holder).manhuaku_txt_latestchapter.setText(weekBean.getPartname().substring(1, 5));
                ((ViewHolder3) holder).manhuaku_txt_manhuaname.setText(weekBean.getName());
            }

        } else if (holder instanceof ViewHolder4) {

        } else if (holder instanceof ViewHolder5) {
            recycler++;
            if (recycler == 1) {
                itemRecyclerAdapter iradapter = new itemRecyclerAdapter(itemRecycler, mContext);
                ((ViewHolder5) holder).manhuaku_recyclerview_item.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false));
                ((ViewHolder5) holder).manhuaku_recyclerview_item.setAdapter(iradapter);
            }

        } else if (holder instanceof ViewHolder6) {
            Glide.with(mContext).load(URLConstants.IMAGE_BASE_URL + specialData.get(0).getBanner()).into(((ViewHolder6) holder).manhuaku_item_specialimage);
            ((ViewHolder6) holder).manhuaku_item_specialname.setText(specialData.get(0).getName());
            ((ViewHolder6) holder).manhuaku_item_specialsmallname.setText(specialData.get(0).getSmallname());
            ((ViewHolder6) holder).manhuaku_item_specialstnum.setText("作品:" + specialData.get(0).getStnum());
            ((ViewHolder6) holder).manhuaku_item_special2name.setText(specialData.get(1).getName());

        } else if (holder == null) {

        }

    }

    private void setPager() {
        manhuaku_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {
                //处理圆点
                int itemCount = adDotLayout.getChildCount(); //获得Layout中子View的数量
                for (int i = 0; i < itemCount; i++) {
                    View view = adDotLayout.getChildAt(i);//提取子View
                    if (i == position) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        });
        manhuaku_viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction(); //获得动作
                switch (action) {
                    case MotionEvent.ACTION_DOWN: //按下
                        adHandler.removeCallbacks(adrun);
                        break;
                    case MotionEvent.ACTION_UP: //提前
                        adHandler.postDelayed(adrun, 2000);
                        break;
                }
                return false;
            }
        });
    }

    private void initDot() {
        for (int i = 0; i < pagerData.size(); i++) {
            ImageView image = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            if (i < pagerData.size() - 1) {
                params.rightMargin = 15;
            }
            if (i == 0) {
                image.setSelected(true);
            }
            image.setLayoutParams(params); //设置布局
            image.setImageResource(dot); //设置图片资源
            image.setScaleType(ImageView.ScaleType.FIT_XY); //设置填充属性
            adDotLayout.addView(image);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        RadioButton manhuaku_radio_project, manhuaku_radio_rank, manhuaku_radio_update;

        public ViewHolder1(View itemView) {
            super(itemView);
            manhuaku_viewpager = (ViewPager) itemView.findViewById(R.id.manhuaku_viewpager);
            manhuaku_radio_project = (RadioButton) itemView.findViewById(R.id.manhuaku_radio_project);
            manhuaku_radio_rank = (RadioButton) itemView.findViewById(R.id.manhuaku_radio_rank);
            manhuaku_radio_update = (RadioButton) itemView.findViewById(R.id.manhuaku_radio_update);
            adDotLayout = (LinearLayout) itemView.findViewById(R.id.dot_layout);
            manhuaku_radio_project.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, SpcialListActivity.class);
                    mContext.startActivity(intent);
                }
            });
            manhuaku_radio_rank.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, ManHuaRankActivity.class);
                    mContext.startActivity(intent);
                }
            });
            manhuaku_radio_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, UpdateActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView manhuaku_txt_clicktitle;

        public ViewHolder2(View itemView) {
            super(itemView);
            manhuaku_txt_clicktitle = (TextView) itemView.findViewById(R.id.manhuaku_txt_clicktitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    switch ((String)mList.get(getPosition())){
                        case "最热漫画":
                            intent.putExtra("key","最热漫画");
                            intent.setClass(mContext,RedNewManHuaActivity.class);
                            break;
                        case "最新漫画":
                            intent.putExtra("key","最新漫画");
                            intent.setClass(mContext,RedNewManHuaActivity.class);
                            break;
                        case "每日更新":
                            intent.setClass(mContext,UpdateActivity.class);
                            break;
                        case "漫画题材":
                            break;
                        case "专题":
                            intent.setClass(mContext,SpcialListActivity.class);
                            break;
                    }
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView manhuaku_image_main, manhuaku_image_mark;
        TextView manhuaku_txt_score, manhuaku_txt_latestchapter, manhuaku_txt_manhuaname;

        public ViewHolder3(View itemView) {
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
                    int id = 0;
                    if (mList.get(getPosition()) instanceof ManHuaKuBean.CBean.WeekBean) {
                        id = Integer.valueOf(((ManHuaKuBean.CBean.WeekBean) mList.get(getPosition())).getId());
                        intent.putExtra("key", id);
                    }
                    if (mList.get(getPosition()) instanceof ManHuaKuBean.CBean.NewcomicBean) {
                        id = Integer.valueOf(((ManHuaKuBean.CBean.NewcomicBean) mList.get(getPosition())).getId());
                        intent.putExtra("key", id);
                    }
                    if (mList.get(getPosition()) instanceof ManHuaKuBean.CBean.RedcomicBean) {
                        id = Integer.valueOf(((ManHuaKuBean.CBean.RedcomicBean) mList.get(getPosition())).getId());
                        intent.putExtra("key", id);
                    }
                    if (mList.get(getPosition()) instanceof ManHuaKuBean.CBean.RecommendcomicBean) {
                        id = Integer.valueOf(((ManHuaKuBean.CBean.RecommendcomicBean) mList.get(getPosition())).getId());
                        intent.putExtra("key", id);
                    }
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {
        TextView manhuaku_txt_text;

        public ViewHolder4(View itemView) {
            super(itemView);
            manhuaku_txt_text = (TextView) itemView.findViewById(R.id.manhuaku_txt_text);
        }
    }

    class ViewHolder5 extends RecyclerView.ViewHolder {
        RecyclerView manhuaku_recyclerview_item;

        public ViewHolder5(View itemView) {
            super(itemView);
            manhuaku_recyclerview_item = (RecyclerView) itemView.findViewById(R.id.manhuaku_recyclerview_item);
        }
    }

    class ViewHolder6 extends RecyclerView.ViewHolder {
        ImageView manhuaku_item_specialimage;
        TextView manhuaku_item_specialname, manhuaku_item_specialsmallname, manhuaku_item_specialstnum, manhuaku_item_special2name;

        public ViewHolder6(View itemView) {
            super(itemView);
            manhuaku_item_specialimage = (ImageView) itemView.findViewById(R.id.manhuaku_item_specialimage);
            manhuaku_item_specialname = (TextView) itemView.findViewById(R.id.manhuaku_item_specialname);
            manhuaku_item_specialsmallname = (TextView) itemView.findViewById(R.id.manhuaku_item_specialsmallname);
            manhuaku_item_specialstnum = (TextView) itemView.findViewById(R.id.manhuaku_item_specialstnum);
            manhuaku_item_special2name = (TextView) itemView.findViewById(R.id.manhuaku_item_special2name);
            manhuaku_item_special2name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, WebActivity.class);
                    ManHuaKuBean.CBean.SpecialBean MCS=specialData.get(1);
                    int id=Integer.valueOf(MCS.getId());
                    intent.putExtra("key",id);
                    mContext.startActivity(intent);
                }
            });
            manhuaku_item_specialimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, WebActivity.class);
                    ManHuaKuBean.CBean.SpecialBean MCS= specialData.get(0);
                    int id=Integer.valueOf(MCS.getId());
                    intent.putExtra("key",id);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class ViewHolder7 extends RecyclerView.ViewHolder {

        public ViewHolder7(View itemView) {
            super(itemView);
        }
    }

    class ADRunnable implements Runnable {
        @Override
        public void run() {
            int currentPosition = manhuaku_viewpager.getCurrentItem(); //获得当前的位置
            currentPosition++;
            if (currentPosition > pagerData.size()-1) {
                currentPosition = 0;
            }
            manhuaku_viewpager.setCurrentItem(currentPosition);//重新设置位置
            //            adRunnable = new ADRunnable();
            adHandler.postDelayed(adrun, 2000);
        }
    }

}
