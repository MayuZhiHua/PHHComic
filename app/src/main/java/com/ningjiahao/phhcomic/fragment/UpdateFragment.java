package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.UpdateAdapter;
import com.ningjiahao.phhcomic.adapter.UpdateRecyclerAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.base.BaseFragment;
import com.ningjiahao.phhcomic.bean.UpdateBean;
import com.ningjiahao.phhcomic.config.URLConstants;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends BaseFragment {
    private RecyclerView update_fragment_recycler;
    int flag;
    private UpdateRecyclerAdapter updateRecyclerAdapter;
    int page=1;
    private List<UpdateBean.CBean.SBean> list=new ArrayList<>();

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        flag=getArguments().getInt("key",0);
        update_fragment_recycler= (RecyclerView) view.findViewById(R.id.update_fragment_recycler);
        updateRecyclerAdapter=new UpdateRecyclerAdapter(mContext,list);
        update_fragment_recycler.setLayoutManager(new GridLayoutManager(mContext,3));
        update_fragment_recycler.setAdapter(updateRecyclerAdapter);
        loadData(getUrl(flag),true);
        update_fragment_recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    page++;
                    loadData(getUrl(flag),false);
                }
            }
        });
    }
    public String getUrl(int i){
        if(i<8){
            return String.format(URLConstants.URL_UPDATE_WEEK,page,i);
        }else{
            return String.format(URLConstants.URL_UPDATE_OVER,page);
        }

    }
    public void loadData(String url, final boolean confirm){
        mRetrofitApi.getUpdateBean(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UpdateBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "网络访问错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(UpdateBean updateBean) {
                        List<UpdateBean.CBean.SBean> s = updateBean.getC().getS();
                        updateRecyclerAdapter.reloadRecyclerView(s,confirm);
                    }
                });
    }

}
