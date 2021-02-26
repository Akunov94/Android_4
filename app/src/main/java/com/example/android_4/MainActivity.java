package com.example.android_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.android_4.databinding.ActivityMainBinding;
import com.example.android_4.ui.adapter.MainViewPagerAdapter;
import com.example.android_4.ui.main.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private MainViewModel viewModel;
    private ActivityMainBinding ui;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        ui.mainPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
        ui.mainPager.setOffscreenPageLimit(3);
        ui.mainPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        //ui.mainPager.setPagingEnabled(false);
//        viewModel = new MainViewModel();
//        viewModel.nameData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                ui.tvName.setText(s);
//            }
//        });
//        setName();
    }

//    private void setName() {
//        ui.btnSetName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewModel.getName();
//            }
//        });
//        ui.btnSetName.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                viewModel.getName2();
//                return true;
//            }
//        });
//    }
}