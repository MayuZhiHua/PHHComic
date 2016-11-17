package com.ningjiahao.phhcomic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.fragment.FindFragment;
import com.ningjiahao.phhcomic.fragment.ManHuaKuFragment;

public class MainActivity extends AppCompatActivity {
    private ManHuaKuFragment manHuaKuFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
