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
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;

import java.util.List;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {
    private List<MostViewedResult> results;

    public MostViewedAdapter(List<MostViewedResult> results) {
        this.results = results;
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
        mostViewedViewHolder.favorite.setImageResource(R.drawable.favorite);
        new DownloadImageTask(mostViewedViewHolder.articleIcon)
                .execute(results.get(i).getMedia().get(0).getMediaMetadata().get(1).getUrl());
        mostViewedViewHolder.title.setText(results.get(i).getTitle());
        mostViewedViewHolder.articleAbstract.setText(results.get(i).getAbstract());
        mostViewedViewHolder.emailedDate.setText(results.get(i).getPublishedDate());
        mostViewedViewHolder.articleDetails.setText("More...");
        // <-----------
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
