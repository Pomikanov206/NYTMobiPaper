package com.example.pomik.nytmobipaper.presenter;

import android.widget.ImageView;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.model.ImageSaver;
import com.example.pomik.nytmobipaper.model.database.DatabaseHandler;
import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import com.example.pomik.nytmobipaper.view.MostViewedFragment;

public class MostViewedPresenter implements MostViewedRequester{
    private MostViewedFragment view;
    private RetrofitController model;
    private DatabaseHandler databaseModel;
    private ImageSaver imageSaver;

    public MostViewedPresenter(MostViewedFragment view) {
        this.view = view;
        model = RetrofitController.getInstance();
        databaseModel = DatabaseHandler.getInstance(view.getContext());
        imageSaver = ImageSaver.getInstance();
    }

    public void showMostViewed(MostViewed mostViewed) {
        view.showMostViewed(mostViewed);
    }

    public void requestMostViewed(){
        model.requestMostViewed(this);
    }
    public void addFavoriteToDatabase(Favorite favorite) {
        databaseModel.addFavorite(favorite);
    }

    public String saveImage(ImageView imageView) {
        return imageSaver.saveImage(imageView);
    }

    public boolean isContainsInDatabase(String id) {
        return databaseModel.isContainsInDatabase(id);
    }
}
