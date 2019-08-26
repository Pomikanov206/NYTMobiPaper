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
import com.example.pomik.nytmobipaper.adapter.FavoritesAdapter;
import com.example.pomik.nytmobipaper.adapter.MostEmailedAdapter;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.presenter.FavoritePresenter;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment implements MostPopularDisplayed.FavoritesDisplayed{
    private FavoritePresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Favorite> results = new ArrayList<>();

    public FavoritesFragment() {
        presenter = new FavoritePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorites, container, false);

        recyclerView = view.findViewById(R.id.favirires_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        results = presenter.getAllFavorites();

        mAdapter = new FavoritesAdapter(results,presenter);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void showFavorites() {

    }


}
