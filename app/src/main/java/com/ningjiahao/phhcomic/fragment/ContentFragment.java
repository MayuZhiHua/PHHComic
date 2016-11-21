package com.ningjiahao.phhcomic.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.activity.SearchActivity;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.FindContentTitleBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {

    private LayoutInflater mInflater;

    private GridLayout mGridLayout;

   private FindContentTitleBean mContentBean;

    List<FindContentTitleBean.CBean.SBean>mList;



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
        initNetData();
    }

    private void initNetData() {
        Observable<FindContentTitleBean>observable=mRetrofitApi.getFindContentTitil(URLConstants.FIND_CONTENT_TITLE);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<FindContentTitleBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FindContentTitleBean findContentTitleBean) {
                           mList=findContentTitleBean.getC().getS();
                           for ( int i=0;i<11;i++){
                            View itemView=mInflater.inflate(R.layout.item_content,null,false);
                            TextView textView= (TextView) itemView.findViewById(R.id.textview_love);
                               final String text=mList.get(i).getName();
                            textView.setText(text);
                            textView.setTextColor(Color.parseColor("#ff4500"));
                            TextView textView1= (TextView) itemView.findViewById(R.id.textview_shuzi);
                            textView1.setText(mList.get(i).getComicnum());

                               itemView.setTag(String.valueOf(i+1));


                               itemView.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent=new Intent();
                                       intent.setClass(getActivity(), SearchActivity.class);
                                       intent.putExtra(URLConstants.KEY_SEARCH,text);
                                       intent.putExtra(URLConstants.KEY_SEARCH_TYPE,"content");
                                       String page= (String) view.getTag();
                                       intent.putExtra(URLConstants.KEY_SEARCH_PAGE,page);
                                       Log.e("CCC","page="+page);
                                       Log.e("BBB",text);
                                       startActivity(intent);

                                   }
                               });


                            mGridLayout.addView(itemView);
                        }
                    }
                });

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

    }
}
