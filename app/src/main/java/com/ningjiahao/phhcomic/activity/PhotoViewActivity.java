package com.ningjiahao.phhcomic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.ningjiahao.phhcomic.R;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

public class PhotoViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        Intent intent = getIntent();
        ArrayList<String> photo = intent.getStringArrayListExtra("photo");
        //Log.e("PhotoViewActivity",photo.size()+"");
        int position = intent.getIntExtra("position",0);
        //Log.e("PhotoViewActivity",position+"");
        String photoURL = photo.get(position);
        if (!photoURL.isEmpty()){
            //Log.e("PhotoViewActivity",photoURL);
            PhotoView photoView = (PhotoView) findViewById(R.id.photoView_photoView);
            Glide.with(this)
                    .load(photoURL)
                    .into(photoView);
        }


    }
}
