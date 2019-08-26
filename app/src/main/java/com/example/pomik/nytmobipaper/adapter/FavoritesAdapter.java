package com.example.pomik.nytmobipaper.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pomik.nytmobipaper.R;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.presenter.FavoritePresenter;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoriteHolder>{
    private List<Favorite> results;
    private FavoritePresenter presenter;

    public FavoritesAdapter(List<Favorite> results,FavoritePresenter presenter) {
        this.results = results;
        this.presenter = presenter;
    }

    public static class FavoriteHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView favorite;
        ImageView articleIcon;
        TextView title;
        TextView articleAbstract;
        TextView emailedDate;
        TextView articleDetails;

        public FavoriteHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            favorite = itemView.findViewById(R.id.favorite);
            articleIcon = itemView.findViewById(R.id.article_icon);
            title = itemView.findViewById(R.id.title);
            articleAbstract = itemView.findViewById(R.id.article_abstract);
            emailedDate = itemView.findViewById(R.id.emailed_date);
            articleDetails = itemView.findViewById(R.id.article_details);
        }
    }

    @NonNull
    @Override
    public FavoritesAdapter.FavoriteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.most_popular_card,viewGroup,false);
        FavoritesAdapter.FavoriteHolder mevh = new FavoritesAdapter.FavoriteHolder(v);
        return mevh;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.FavoriteHolder favoriteHolder, int i) {
        favoriteHolder.favorite.setImageResource(R.drawable.favorite);
        favoriteHolder.articleIcon.setImageBitmap(presenter.loadImage(results.get(i).getArticleIconAddres()));
        favoriteHolder.title.setText(results.get(i).getTitle());
        favoriteHolder.articleAbstract.setText(results.get(i).getArticleAbstract());
        favoriteHolder.emailedDate.setText(results.get(i).getPublishedDate());
        favoriteHolder.articleDetails.setText("More...");
        // <-----------
        favoriteHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Favorite favorite = new Favorite();
                favorite.setId(results.get(i).getId());
                favorite.setTitle(results.get(i).getTitle());
                favorite.setArticleAbstract(results.get(i).getArticleAbstract());
                favorite.setPublishedDate(results.get(i).getPublishedDate());
                favorite.setArticleIconAddres("");

                presenter.deleteFavorite(favorite);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}