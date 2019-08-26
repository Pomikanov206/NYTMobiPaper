package com.example.pomik.nytmobipaper;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pomik.nytmobipaper.adapter.PagerAdapter;
import com.example.pomik.nytmobipaper.model.ImageSaver;
import com.example.pomik.nytmobipaper.model.database.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    public static ViewPager viewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager1 = viewPager;
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(0);

        DatabaseHandler.getInstance(getApplicationContext());
        ImageSaver.getInstance(getApplicationContext());
    }
}
