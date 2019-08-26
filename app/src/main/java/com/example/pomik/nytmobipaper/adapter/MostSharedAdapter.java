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
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.presenter.MostSharedPresenter;

import java.util.List;

public class MostSharedAdapter extends RecyclerView.Adapter<MostSharedAdapter.MostSharedViewHolder> {
    private List<MostSharedResult> results;
    private MostSharedPresenter presenter;

    public MostSharedAdapter(List<MostSharedResult> results, MostSharedPresenter presenter) {
        this.results = results;
        this.presenter = presenter;
    }

    public static class MostSharedViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView favorite;
        ImageView articleIcon;
        TextView title;
        TextView articleAbstract;
        TextView emailedDate;
        TextView articleDetails;

        public MostSharedViewHolder(View itemView) {
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
    public MostSharedAdapter.MostSharedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.most_popular_card,viewGroup,false);
        MostSharedAdapter.MostSharedViewHolder msvh = new MostSharedAdapter.MostSharedViewHolder(v);
        return msvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MostSharedAdapter.MostSharedViewHolder mostSharedViewHolder, int i) {
        mostSharedViewHolder.favorite.setImageResource(R.drawable.favorite);
        new DownloadImageTask(mostSharedViewHolder.articleIcon)
                .execute(results.get(i).getMedia().get(0).getMediaMetadata().get(1).getUrl());
        mostSharedViewHolder.title.setText(results.get(i).getTitle());
        mostSharedViewHolder.articleAbstract.setText(results.get(i).getAbstract());
        mostSharedViewHolder.emailedDate.setText(results.get(i).getPublishedDate());
        mostSharedViewHolder.articleDetails.setText("More...");
        // <-----------
        mostSharedViewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imagePath = presenter.saveImage(mostSharedViewHolder.articleIcon);

                Favorite favorite = new Favorite();
                favorite.setId(results.get(i).getId());
                favorite.setTitle(results.get(i).getTitle());
                favorite.setArticleAbstract(results.get(i).getAbstract());
                favorite.setPublishedDate(results.get(i).getPublishedDate());
                favorite.setArticleIconAddres(imagePath);

                presenter.addFavoriteToDatabase(favorite);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
