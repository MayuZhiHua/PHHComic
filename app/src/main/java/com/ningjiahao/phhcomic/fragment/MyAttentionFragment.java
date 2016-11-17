package com.ningjiahao.phhcomic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAttentionFragment extends BaseFragment {

    private ImageView imageView_myattention;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_attention, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView_myattention = (ImageView) view.findViewById(R.id.imageView_myattention);
        Glide.with(mContext).load(R.drawable.logingif).asGif().placeholder(R.drawable.imageloading).into(imageView_myattention);
    }
}
