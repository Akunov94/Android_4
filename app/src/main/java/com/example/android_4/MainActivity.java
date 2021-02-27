package com.example.android_4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
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
        setEnableSwipeVP();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        ui.bottomNavView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.main_nav:
                    ui.mainPager.setCurrentItem(0);
                    break;
                case R.id.history_nav:
                    ui.mainPager.setCurrentItem(1);
                    break;
                case R.id.settings_nav:
                    ui.mainPager.setCurrentItem(2);
                    break;
            }
            return true;
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

    @SuppressLint("ClickableViewAccessibility")
    private void setEnableSwipeVP() {
        ui.mainPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        ui.mainPager.setOffscreenPageLimit(3);
        ui.mainPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        ui.mainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: ui.bottomNavView.getMenu().findItem(R.id.main_nav).setChecked(true);
                    break;
                    case 1: ui.bottomNavView.getMenu().findItem(R.id.history_nav).setChecked(true);
                        break;
                    case 2: ui.bottomNavView.getMenu().findItem(R.id.settings_nav).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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