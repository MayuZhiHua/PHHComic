package com.ningjiahao.phhcomic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.ManHuaDetailActivity;
import com.ningjiahao.phhcomic.adapter.CollectionAdapter;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.CollectionBean;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouCangFragment extends BaseFragment {
    private ListView listView_collect;
    private TextView textView_count_shoucang;
    private CollectionAdapter adapter;
    private List<CollectionBean> mlist = new ArrayList<>();
    private ImageView imageView_empty;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_shou_cang, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView_collect = (ListView) view.findViewById(R.id.listView_collect);
        textView_count_shoucang = (TextView) view.findViewById(R.id.textView_count_shoucang);
        imageView_empty = (ImageView) view.findViewById(R.id.imageView_empty);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        queryData();
        listView_collect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                queryData();
                Intent intent = new Intent(mContext, ManHuaDetailActivity.class);
                String yzhid = mlist.get(position).getYzhid();
                intent.putExtra("key",Integer.valueOf(yzhid));
                mContext.startActivity(intent);
            }
        });
    }

    private void queryData() {
        BmobQuery<CollectionBean> query = new BmobQuery<CollectionBean>();
        //按照时间降序
        query.order("-createdAt");
        //执行查询，第一个参数为上下文，第二个参数为查找的回调
        query.findObjects(new FindListener<CollectionBean>() {
            @Override
            public void done(List<CollectionBean> list, BmobException e) {
                mlist.clear();
                mlist.addAll(list);
                textView_count_shoucang.setText(list.size()+"");
                adapter = new CollectionAdapter(mContext,mlist);
                listView_collect.setEmptyView(imageView_empty);
                listView_collect.setAdapter(adapter);
            }
        });
    }

}
