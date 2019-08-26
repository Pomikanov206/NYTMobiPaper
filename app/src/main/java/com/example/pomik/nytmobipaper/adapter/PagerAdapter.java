package com.example.pomik.nytmobipaper.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.pomik.nytmobipaper.view.FavoritesFragment;
import com.example.pomik.nytmobipaper.view.MostEmailedFragment;
import com.example.pomik.nytmobipaper.view.MostSharedFragment;
import com.example.pomik.nytmobipaper.view.MostViewedFragment;

/*
Адаптер отвечающий за переключение табов
 */
public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MostEmailedFragment();
            case 1:
                return new MostSharedFragment();
            case 2:
                return new MostViewedFragment();
            case 3:
                return new FavoritesFragment();

                default:
                    return new MostEmailedFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

}
