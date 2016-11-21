package com.ningjiahao.phhcomic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.adapter.PopupAdapter;
import com.ningjiahao.phhcomic.adapter.SearchAdapter;
import com.ningjiahao.phhcomic.base.BaseActivity;
import com.ningjiahao.phhcomic.bean.FindContentTitleBean;
import com.ningjiahao.phhcomic.bean.SearchDefaultBean;
import com.ningjiahao.phhcomic.bean.SearchResultBean;
import com.ningjiahao.phhcomic.bean.ThemeBean;
import com.ningjiahao.phhcomic.config.URLConstants;
import com.ningjiahao.phhcomic.decoration.DividerItemDecoration;
import com.ningjiahao.phhcomic.decoration.SpacesItemDecoration;
import com.ningjiahao.phhcomic.intefaces.ILoadSearchData;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SearchActivity extends BaseActivity implements View.OnClickListener ,ILoadSearchData{
    private RecyclerView mRecyclerview;
    private TextView textView_title;
    private ImageView imageView_category;
    private List<Object> mList;
    private SearchAdapter mSearchAdapter;
    private String search=null;
    private TextView textView_back;
    private String type=null;
    private String page;
    private String url;
    private boolean isOpen;
    private PopupWindow mPopupWindow;
    private RecyclerView mRecyclerview_pop;
     private List<ThemeBean.CBean.SBean>mPopupData;
     private WindowManager mWindowManager;
    private PopupAdapter mPopupAdapter;
    private float density;
    private int width;
    private int height;
    private List<FindContentTitleBean.CBean.SBean>mPopupContentData;

    private android.widget.GridLayout mPopupGridlayout;

    private LinearLayout popupLinearlayout;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        initDisplay();
        initView();
        initNetData();

    }

    private void initDisplay() {
        mWindowManager= (WindowManager) getSystemService(WINDOW_SERVICE);
        width=mWindowManager.getDefaultDisplay().getWidth();
        height=mWindowManager.getDefaultDisplay().getHeight();
        density=getResources().getDisplayMetrics().density;
    }

    private void initPopupData() {
        if (type.equals("content")){
            Observable<FindContentTitleBean>observable=myRetrofitApi.getFindContentTitil(URLConstants.FIND_CONTENT_TITLE);
            observable.observeOn(AndroidSchedulers.mainThread())
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
                                  mPopupContentData=findContentTitleBean.getC().getS();
                            for (int i=0;i<mPopupContentData.size();i++){
                                View itemView=mInflater.inflate(R.layout.item_content,null,false);
//                                popupLinearlayout= (LinearLayout) itemView.findViewById(R.id.linearlayout_content);
//                                popupLinearlayout.setBackgroundColor(Color.parseColor("#ffffff"));
                                TextView textView= (TextView) itemView.findViewById(R.id.textview_love);
                                String text=mPopupContentData.get(i).getName();
                                textView.setText(text);
                                textView.setTextColor(Color.parseColor("#ff4500"));
                                TextView textView1= (TextView) itemView.findViewById(R.id.textview_shuzi);
                                textView1.setText(mPopupContentData.get(i).getComicnum());
                              mPopupGridlayout.addView(itemView);

                            }
                        }
                    });
        }else {
        Observable<ThemeBean>observable=myRetrofitApi.getThemeData(URLConstants.FIND_THEME_URL);
        observable.map(new Func1<ThemeBean, List<ThemeBean.CBean.SBean>>(){
            @Override
            public List<ThemeBean.CBean.SBean> call(ThemeBean themeBean) {


                return themeBean.getC().getS();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<List<ThemeBean.CBean.SBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ThemeBean.CBean.SBean> sBeen) {
                       mPopupData=sBeen;
                        mPopupAdapter=new PopupAdapter(mPopupData,SearchActivity.this);
                        GridLayoutManager manager=new GridLayoutManager(SearchActivity.this,4);
                        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {
                                if (mPopupAdapter.getItemViewType(position)==1){
                                    return 4;
                                }else {
                                return 1;
                                }
                            }
                        });
                        mRecyclerview_pop.setLayoutManager(manager);
                        mRecyclerview_pop.setAdapter(mPopupAdapter);


                    }
                });
        }


    }

    private void initData() {
        Intent intent=getIntent();
        search=intent.getStringExtra(URLConstants.KEY_SEARCH);
        type=intent.getStringExtra(URLConstants.KEY_SEARCH_TYPE);
        page=intent.getStringExtra(URLConstants.KEY_SEARCH_PAGE);
    }

    private void initNetData() {
        if (!TextUtils.isEmpty(search)){
            if (type.equals("content")){
                textView_title.setText(search);
                url=String.format(URLConstants.CONTENT_URL,page);
            } else if (type.equals("theme")){
                textView_title.setText(search);
                url=String.format(URLConstants.THEME_URL,page);
            }else {
                url=String.format(URLConstants.FIND_SEARCH_URL,search);
            }
        Observable<SearchResultBean>observable=myRetrofitApi.getSearchResult(url);
            observable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Subscriber<SearchResultBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(SearchResultBean searchResultBean) {
                            if(searchResultBean.getC().getS().size()==0){
                                initDefaultData();
                            }else {
                                initRecyclerView1(searchResultBean.getC().getS());
                            }
                        }
                    });

        }else {
            Toast.makeText(this,"请输入要搜索的内容",Toast.LENGTH_SHORT).show();
            mList=new ArrayList<>();
            mSearchAdapter=new SearchAdapter(mList,this,search,3,this);
            LinearLayoutManager manager=new LinearLayoutManager(this);
            mRecyclerview.setLayoutManager(manager);
            mRecyclerview.setAdapter(mSearchAdapter);
        }
    }

    private void initRecyclerView1(List<SearchResultBean.CBean.SBean> sBean) {
        mList=new ArrayList<>();
        mList.addAll(sBean);

        if (type.equals("content")||type.equals("theme")){
            GridLayoutManager manager=new GridLayoutManager(this,3);
            mRecyclerview.setLayoutManager(manager);
            mSearchAdapter=new SearchAdapter(mList,this,search,4,this);
        }else {
        LinearLayoutManager manager=new LinearLayoutManager(this);
            mRecyclerview.setLayoutManager(manager);
            mRecyclerview.addItemDecoration(new DividerItemDecoration(this,1));
            mSearchAdapter=new SearchAdapter(mList,this,search,2,this);
        }


        mRecyclerview.setAdapter(mSearchAdapter);
    }

    private void initDefaultData() {
     Observable<SearchDefaultBean>observable=myRetrofitApi.getSearchDefaultData(URLConstants.DEFAULT_SEARCH_URL);

        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<SearchDefaultBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchDefaultBean searchDefaultBean) {
                         mList=new ArrayList<Object>();
                        mList.addAll(searchDefaultBean.getC().getS());
                        String s=((SearchDefaultBean.CBean.SBean)(mList.get(0))).getName();
                        mSearchAdapter=new SearchAdapter(mList,SearchActivity.this,search,3,SearchActivity.this);
                        GridLayoutManager manager=new GridLayoutManager(SearchActivity.this,3);
                        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {
                                if (mSearchAdapter.getItemViewType(position)==1){
                                    return 3;
                                }
                                return 1;
                            }
                        });
                        mRecyclerview.setLayoutManager(manager);
                        mRecyclerview.setAdapter(mSearchAdapter);

                    }
                });






    }

    private void initView() {
        mRecyclerview= (RecyclerView) findViewById(R.id.recyclerview_search);
        textView_back= (TextView) findViewById(R.id.textview_search_back);
        textView_back.setOnClickListener(this);
        textView_title= (TextView) findViewById(R.id.textview_search_title);
        textView_title.setOnClickListener(this);
        imageView_category= (ImageView) findViewById(R.id.imageview_search_category);
        if (type.equals("content")){
            View view=mInflater.inflate(R.layout.popupwindow_content,null);
            mPopupGridlayout= (android.widget.GridLayout) view.findViewById(R.id.gridlayout_popupwindow);
            mPopupWindow=new PopupWindow(view,width,800);
            initPopupData();
        }else {
            View view=mInflater.inflate(R.layout.popupwindow,null);
            mRecyclerview_pop= (RecyclerView) view.findViewById(R.id.recyclerview_popupwindow);
            mPopupWindow=new PopupWindow(view, width, height);

            initPopupData();

        }
        mPopupWindow.setFocusable(true);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textview_search_back:
                if (mPopupWindow.isShowing()){
                    mPopupWindow.dismiss();
                }else {
                finish();}
                break;
            case R.id.textview_search_title:
                if (!isOpen){
                    imageView_category.setImageResource(R.drawable.category_orage_up);
                    isOpen=!isOpen;
                    mPopupWindow.showAsDropDown(textView_title);
                }else {
                    imageView_category.setImageResource(R.drawable.category_orage_down);
                    isOpen=!isOpen;
                    mPopupWindow.dismiss();
                }
                break;

        }
    }

    @Override
    public void updata(String search) {
        this.search=search;
      initNetData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mPopupWindow.isShowing()){
            mPopupWindow.dismiss();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){

            if (mPopupWindow.isShowing()){
                mPopupWindow.dismiss();
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
