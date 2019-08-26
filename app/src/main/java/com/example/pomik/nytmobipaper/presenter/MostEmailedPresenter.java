package com.example.pomik.nytmobipaper.presenter;

import android.widget.ImageView;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.model.ImageSaver;
import com.example.pomik.nytmobipaper.model.database.DatabaseHandler;
import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.view.MostEmailedFragment;

public class MostEmailedPresenter implements MostEmailedRequester{
    private MostEmailedFragment view;
    private RetrofitController model;
    private DatabaseHandler databaseModel;
    private ImageSaver imageSaver;

    public MostEmailedPresenter(MostEmailedFragment view) {
        this.view = view;
        model = RetrofitController.getInstance();
        databaseModel = DatabaseHandler.getInstance(view.getContext());
        imageSaver = ImageSaver.getInstance();
    }

    public void showMostEmailed(MostEmailed mostEmailed){
        view.showMostEmailed(mostEmailed);
    }

    public void requestMostEmailed() {
        model.requestMostEmailed(this);
    }

    public void addToFavorite(Favorite favorite) {
        databaseModel.addFavorite(favorite);
    }

    public String saveImage(ImageView imageView) {
        return imageSaver.saveImage(imageView);
    }
}
