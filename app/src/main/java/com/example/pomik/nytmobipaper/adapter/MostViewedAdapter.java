package com.example.pomik.nytmobipaper.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pomik.nytmobipaper.MainActivity;
import com.example.pomik.nytmobipaper.R;
import com.example.pomik.nytmobipaper.model.Favorite;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.example.pomik.nytmobipaper.presenter.MostViewedPresenter;

import java.util.List;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {
    private List<MostViewedResult> results;
    private MostViewedPresenter presenter;

    public MostViewedAdapter(List<MostViewedResult> results, MostViewedPresenter presenter) {
        this.results = results;
        this.presenter = presenter;
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView favorite;
        ImageView articleIcon;
        TextView title;
        TextView articleAbstract;
        TextView emailedDate;
        TextView articleDetails;

        public MostViewedViewHolder(View itemView) {
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
    public MostViewedAdapter.MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.most_popular_card,viewGroup,false);
        MostViewedAdapter.MostViewedViewHolder mvvh = new MostViewedAdapter.MostViewedViewHolder(v);
        return mvvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedAdapter.MostViewedViewHolder mostViewedViewHolder, int i) {
        if (presenter.isContainsInDatabase(String.valueOf(results.get(i).getId())))
            mostViewedViewHolder.favorite.setImageResource(R.drawable.favorite_active);
        else
            mostViewedViewHolder.favorite.setImageResource(R.drawable.favorite_not_active);

        new DownloadImageTask(mostViewedViewHolder.articleIcon)
                .execute(results.get(i).getMedia().get(0).getMediaMetadata().get(1).getUrl());
        mostViewedViewHolder.title.setText(results.get(i).getTitle());
        mostViewedViewHolder.articleAbstract.setText(results.get(i).getAbstract());
        mostViewedViewHolder.emailedDate.setText(results.get(i).getPublishedDate());
        mostViewedViewHolder.articleDetails.setText("More...");
        // <-----------
        mostViewedViewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imagePath = presenter.saveImage(mostViewedViewHolder.articleIcon);

                Favorite favorite = new Favorite();
                favorite.setId(results.get(i).getId());
                favorite.setTitle(results.get(i).getTitle());
                favorite.setArticleAbstract(results.get(i).getAbstract());
                favorite.setPublishedDate(results.get(i).getPublishedDate());
                favorite.setArticleIconAddres(imagePath);

                mostViewedViewHolder.favorite.setImageResource(R.drawable.favorite_active);

                presenter.addFavoriteToDatabase(favorite);

                MainActivity.viewPager1.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
