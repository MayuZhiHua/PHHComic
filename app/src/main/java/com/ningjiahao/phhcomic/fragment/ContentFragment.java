package com.ningjiahao.phhcomic.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {

    private LayoutInflater mInflater;

    private GridLayout mGridLayout;

    public static final String []LOVE={"恋爱","日常","搞笑","动作","剧情","悬疑","萌系","插画"
            ,"腐向","奇幻","武侠"};
    public static final String []SHUZI={"76","103","179","43","66","20","14","22","43","60","4"};



    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGridLayout= (GridLayout) view.findViewById(R.id.gridlayout_fragment_content);
        for (int i=0;i<11;i++){
            View itemView=mInflater.inflate(R.layout.item_content,null,false);
            TextView textView= (TextView) itemView.findViewById(R.id.textview_love);
            textView.setText(LOVE[i]);
            textView.setTextColor(Color.parseColor("#ff4500"));

            TextView textView1= (TextView) itemView.findViewById(R.id.textview_shuzi);
            textView1.setText(SHUZI[i]);

            mGridLayout.addView(itemView);

        }
    }
}
