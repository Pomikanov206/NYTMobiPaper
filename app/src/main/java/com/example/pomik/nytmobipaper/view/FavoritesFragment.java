package com.example.pomik.nytmobipaper.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pomik.nytmobipaper.presenter.FavoritePresenter;

import java.util.List;

public class FavoritesFragment extends Fragment implements MostPopularDisplayed.FavoritesDisplayed{
    private FavoritePresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Object> results;

    public FavoritesFragment() {
        presenter = new FavoritePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showFavorites() {

    }
}
