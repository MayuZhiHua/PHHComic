package com.ningjiahao.phhcomic.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< Updated upstream
=======
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
>>>>>>> Stashed changes

import com.ningjiahao.phhcomic.R;
import com.ningjiahao.phhcomic.fragment.FindFragment;

public class TestActivity extends AppCompatActivity {
<<<<<<< Updated upstream
    private FindFragment findFragment;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findFragment=new FindFragment();
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framlayout,findFragment,"1");
        fragmentTransaction.commit();
=======
 private FindFragment findFragment;

    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        findFragment=new FindFragment();
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framlayout,findFragment,"findfragment");
        fragmentTransaction.commit();





>>>>>>> Stashed changes
    }
}
