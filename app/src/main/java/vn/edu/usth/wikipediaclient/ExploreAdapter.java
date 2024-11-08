package vn.edu.usth.wikipediaclient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Article> articleList;
    private Context context;

    public ExploreAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int getItemViewType(int position) {
        // first article is featured
        if (position == 0) {
            return 0; // featured
        } else {
            return 1; // article
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_featured, parent, false);
            return new FeaturedViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
            return new ArticleViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);

        if (holder.getItemViewType() == 0) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            featuredViewHolder.title.setText(article.getTitle());
            featuredViewHolder.description.setText(article.getDescription());
        } else {
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
            articleViewHolder.title.setText(article.getTitle());
            articleViewHolder.description.setText(article.getDescription());
        }

        Button fullArticleButton = holder.itemView.findViewById(R.id.buttonFullArticle);
        fullArticleButton.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        // Handle click button Full Article event
        fullArticleButton.setOnClickListener(v -> {
            // Lưu bài báo vào cơ sở dữ liệu lịch sử khi bấm xem chi tiết
            HistoryDatabaseHelper historyDbHelper = new HistoryDatabaseHelper(context);
            String currentDate = java.text.DateFormat.getDateTimeInstance().format(new java.util.Date());
            boolean isInserted = historyDbHelper.addArticle(article.getTitle(), article.getContent(), currentDate);

            if (!isInserted) {
                Log.d("ExploreAdapter", "Bài báo đã tồn tại trong lịch sử hoặc lỗi xảy ra.");
            } else {
                Log.d("ExploreAdapter", "Bài báo đã được thêm vào lịch sử.");
            }

            // Chuyển đến FullArticlelActivity để xem chi tiết bài báo
            Intent intent = new Intent(context, FullArticlelActivity.class);
            intent.putExtra("title", article.getTitle());
            intent.putExtra("content", article.getContent());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, date, category;
        ImageView image;
        public FeaturedViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.featuredTitle);
            description = itemView.findViewById(R.id.featuredDescription);
        }
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView image;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.articleTitle);
            description = itemView.findViewById(R.id.articleDescription);
            image = itemView.findViewById(R.id.articleImage);
        }
    }
}
