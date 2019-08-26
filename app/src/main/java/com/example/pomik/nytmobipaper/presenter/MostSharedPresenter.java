package com.example.pomik.nytmobipaper.presenter;

import android.widget.ImageView;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.model.ImageSaver;
import com.example.pomik.nytmobipaper.model.database.DatabaseHandler;
import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.view.MostSharedFragment;

public class MostSharedPresenter implements MostSharedRequester{
    private MostSharedFragment view;
    private RetrofitController model;
    private DatabaseHandler databaseModel;
    private ImageSaver imageSaver;

    public MostSharedPresenter(MostSharedFragment view) {
        this.view = view;
        model = RetrofitController.getInstance();
        databaseModel = DatabaseHandler.getInstance(view.getContext());
        imageSaver = ImageSaver.getInstance();
    }

    public void showMostShared(MostShared mostShared) {
        view.showMostShared(mostShared);
    }
    public void requestMostShared(){
        model.requestMostShared(this);
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
