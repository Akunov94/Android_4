package com.example.android_4.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android_4.ui.history.HistoryFragment;
import com.example.android_4.ui.main.MainFragment;
import com.example.android_4.ui.settings.SettingsFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainFragment();
            case 1:
                return new HistoryFragment();
            default:
                return new SettingsFragment();
        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}
