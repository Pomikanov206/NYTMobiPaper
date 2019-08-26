package com.example.pomik.nytmobipaper.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.pomik.nytmobipaper.R;
import com.example.pomik.nytmobipaper.adapter.MostSharedAdapter;
import com.example.pomik.nytmobipaper.adapter.MostViewedAdapter;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.example.pomik.nytmobipaper.presenter.MostViewedPresenter;

import java.util.ArrayList;
import java.util.List;

public class MostViewedFragment extends Fragment implements MostPopularDisplayed.MostViewdDisplayed {
    private MostViewedPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<MostViewedResult> results = new ArrayList<>();

    public MostViewedFragment() {
        presenter = new MostViewedPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.most_viewed, container, false);

        TextView title = view.findViewById(R.id.viewed_copyrigh);
        title.setText("Most Viewed");

        recyclerView = view.findViewById(R.id.mostviewed_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MostViewedAdapter(results, presenter);
        recyclerView.setAdapter(mAdapter);

        presenter.requestMostViewed();
        return view;
    }

    @Override
    public void showMostViewed(MostViewed mostViewed) {
        results = mostViewed.getResults();

        mAdapter = new MostViewedAdapter(results, presenter);
        recyclerView.setAdapter(mAdapter);
    }
}
