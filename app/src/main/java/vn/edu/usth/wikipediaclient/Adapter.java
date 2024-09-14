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

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Article> articleList;
    private Context context;

    public Adapter(List<Article> articleList) {
        this.articleList = articleList;
        this.context = context;
    }

    public int getItemViewType(int position) {
        // Giả sử bài viết đầu tiên là tin nổi bật
        if (position == 0) {
            return 0;       //featured
        } else {
            return 1;       //article
        }
    }

//    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
////        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
////        return new ViewHolder(view);

        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_featured, parent, false);
            return new FeaturedViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
            return  new ArticleViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);

//        holder.titleTextView.setText(article.getTitle());
//        holder.descriptionTextView.setText(article.getDescription());
//        holder.imageImageView.setImageResource(article.getImageResourceId());

        //gán dữ liệu cho bài viết nổi bật
        if (holder.getItemViewType() == 0) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;

            featuredViewHolder.title.setText(article.getTitle());
            featuredViewHolder.description.setText(article.getDescription());
            featuredViewHolder.image.setImageResource(article.getImageResourceId());
        }
        // gán cho bài viết thường
        else {
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;

            articleViewHolder.title.setText(article.getTitle());
            articleViewHolder.description.setText(article.getDescription());
            articleViewHolder.image.setImageResource(article.getImageResourceId());
        }

        // Đổi màu nút thành màu xám
        Button detailButton = holder.itemView.findViewById(R.id.articleButton);
        detailButton.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        detailButton.setOnClickListener(v -> {
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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageImageView;
        TextView titleTextView;
        TextView descriptionTextView;
        Button detailButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageImageView = itemView.findViewById(R.id.articleImage);
            titleTextView = itemView.findViewById(R.id.articleTitle);
            descriptionTextView = itemView.findViewById(R.id.articleDescription);
            detailButton = itemView.findViewById(R.id.articleButton);
        }
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, date, category;
        ImageView image;
        public FeaturedViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.featuredTitle);
            description = itemView.findViewById(R.id.featuredDescription);
            image = itemView.findViewById(R.id.featuredImage);
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
