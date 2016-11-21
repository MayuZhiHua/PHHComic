package com.ningjiahao.phhcomic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;

import java.util.List;

/**
 * Created by My on 2016/11/17.
 */

public class HistoryAdapter extends BaseAdapter{

    private List<String>mList;

    private LayoutInflater mInflater;


    private Context mContext;

    public HistoryAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view=mInflater.inflate(R.layout.item_search_history,null,false);

        TextView textView= (TextView) view.findViewById(R.id.textview_search_hitory);

        textView.setText(mList.get(i));



        return view;
    }




}
