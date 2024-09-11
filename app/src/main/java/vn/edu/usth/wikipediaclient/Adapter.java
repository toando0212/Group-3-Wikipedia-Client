package vn.edu.usth.wikipediaclient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ExploreViewHolder> {

    private List<Article> articleList;
    private Context context;

    public Adapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new ExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewHolder holder, int position) {
        Article article = articleList.get(position);

        holder.titleTextView.setText(article.getTitle());
        holder.descriptionTextView.setText(article.getDescription());
        holder.thumbnailImageView.setImageResource(article.getImageResourceId());


        holder.detailButton.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        holder.detailButton.setOnClickListener(v -> {
            // khi bấm nút "Full Articles, mở ArticleDetailActivity
            Intent intent = new Intent(context, ArticleDetailActivity.class);
            intent.putExtra("title", article.getTitle());
            intent.putExtra("content", article.getContent()); // Truyền nội dung chi tiết
            intent.putExtra("image", article.getImageResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class ExploreViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnailImageView;
        TextView titleTextView;
        TextView descriptionTextView;
        Button detailButton;

        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.articleThumbnail);
            titleTextView = itemView.findViewById(R.id.articleTitle);
            descriptionTextView = itemView.findViewById(R.id.articleDescription);
            detailButton = itemView.findViewById(R.id.articleButton);
        }
    }
}
