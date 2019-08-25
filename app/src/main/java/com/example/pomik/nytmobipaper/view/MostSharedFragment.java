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
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.presenter.MostSharedPresenter;

import java.util.ArrayList;
import java.util.List;

public class MostSharedFragment extends Fragment implements MostPopularDisplayed.MostSharedDisplayed {
    private MostSharedPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<MostSharedResult> results = new ArrayList<>();

    public MostSharedFragment() {
        presenter = new MostSharedPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.most_shared, container, false);

        recyclerView = view.findViewById(R.id.mostshared_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MostSharedAdapter(results);
        recyclerView.setAdapter(mAdapter);

        presenter.requestMostShared();
        return view;
    }

    @Override
    public void showMostShared(MostShared mostShared) {
        results = mostShared.getResults();

        mAdapter = new MostSharedAdapter(results);
        recyclerView.setAdapter(mAdapter);
    }
}
