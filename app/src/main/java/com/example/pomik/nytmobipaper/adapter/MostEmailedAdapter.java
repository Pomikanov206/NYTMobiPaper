package com.example.pomik.nytmobipaper.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.presenter.MostEmailedPresenter;

import java.util.List;

public class MostEmailedAdapter extends RecyclerView.Adapter<MostEmailedAdapter.MostEmailedViewHolder>{
    private List<MostEmailedResult> results;
    private MostEmailedPresenter presenter;

    public MostEmailedAdapter(List<MostEmailedResult> results,MostEmailedPresenter presenter) {
        this.results = results;
        this.presenter = presenter;
    }

    public static class MostEmailedViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView favorite;
        ImageView articleIcon;
        TextView title;
        TextView articleAbstract;
        TextView emailedDate;
        TextView articleDetails;

        public MostEmailedViewHolder(View itemView) {
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
    public MostEmailedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.most_popular_card,viewGroup,false);
        MostEmailedViewHolder mevh = new MostEmailedViewHolder(v);
        return mevh;
    }

    @Override
    public void onBindViewHolder(@NonNull MostEmailedViewHolder mostEmailedViewHolder, int i) {
        mostEmailedViewHolder.favorite.setImageResource(R.drawable.favorite);
        new DownloadImageTask(mostEmailedViewHolder.articleIcon)
                .execute(results.get(i).getMedia().get(0).getMediaMetadata().get(1).getUrl());
        mostEmailedViewHolder.title.setText(results.get(i).getTitle());
        mostEmailedViewHolder.articleAbstract.setText(results.get(i).getAbstract());
        mostEmailedViewHolder.emailedDate.setText(results.get(i).getPublishedDate());
        mostEmailedViewHolder.articleDetails.setText("More...");
         // <-----------
        mostEmailedViewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imagePath = presenter.saveImage(mostEmailedViewHolder.articleIcon);

                Favorite favorite = new Favorite();
                favorite.setId(results.get(i).getId());
                favorite.setTitle(results.get(i).getTitle());
                favorite.setArticleAbstract(results.get(i).getAbstract());
                favorite.setPublishedDate(results.get(i).getPublishedDate());
                favorite.setArticleIconAddres(imagePath);

                presenter.addToFavorite(favorite);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
