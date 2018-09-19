package com.example.android.miwok.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.R;
import com.example.android.miwok.activity.ColorsActivity;
import com.example.android.miwok.activity.FamilyActivity;
import com.example.android.miwok.activity.NumbersActivity;
import com.example.android.miwok.activity.PhrasesActivity;

public class WordFragmentPageAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public WordFragmentPageAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersActivity();
            case 1:
                return new FamilyActivity();
            case 2:
                return new ColorsActivity();
            default:
                return new PhrasesActivity();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getResources().getString(R.string.category_numbers);
            case 1:
                return mContext.getResources().getString(R.string.category_family);
            case 2:
                return mContext.getResources().getString(R.string.category_colors);
            default:
                return mContext.getResources().getString(R.string.category_phrases);
        }
    }
}
