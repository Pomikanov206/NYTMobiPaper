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
import com.example.pomik.nytmobipaper.R;
import com.example.pomik.nytmobipaper.adapter.MostEmailedAdapter;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.presenter.MostEmailedPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostEmailedFragment extends Fragment implements MostPopularDisplayed.MostEmailedDisplayed{
    private MostEmailedPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<MostEmailedResult> results = new ArrayList<>();

    public MostEmailedFragment() {
        presenter = new MostEmailedPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.most_emailed, container, false);

        recyclerView = view.findViewById(R.id.mostemailed_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MostEmailedAdapter(results);
        recyclerView.setAdapter(mAdapter);

        presenter.requestMostEmailed();
        return view;
    }

    @Override
    public void showMostEmailed(MostEmailed mostEmailed) {
        results = new ArrayList<>(Arrays.asList(mostEmailed.getResults()));

        mAdapter = new MostEmailedAdapter(results);
        recyclerView.setAdapter(mAdapter);
    }
}
