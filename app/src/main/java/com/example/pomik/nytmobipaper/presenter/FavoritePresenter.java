package com.example.pomik.nytmobipaper.presenter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.model.ImageSaver;
import com.example.pomik.nytmobipaper.model.database.DatabaseHandler;
import com.example.pomik.nytmobipaper.view.FavoritesFragment;

import java.util.List;

public class FavoritePresenter {
    private FavoritesFragment view;
    private DatabaseHandler model;
    private ImageSaver imageSaver;

    public FavoritePresenter(FavoritesFragment view) {
        this.view = view;
        model = DatabaseHandler.getInstance(view.getContext());
        imageSaver = ImageSaver.getInstance();
    }

    public void addFavorite(Favorite favorite) {
        model.addFavorite(favorite);
    }
    public void deleteFavorite(Favorite favorite) {
        model.deleteFavorite(favorite);
    }
    public List<Favorite> getAllFavorites(){
        return model.getAllFavorites();
    }

    public Bitmap loadImage(String imagePath) {
        return imageSaver.loadImage(imagePath);
    }
}
