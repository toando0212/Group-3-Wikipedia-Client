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

public class ExploreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Article> articleList;
    private Context context;

    public ExploreAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    public int getItemViewType(int position) {
        // first article is featured
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

        // assign layout for featured
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

        //assign data for featured
        if (holder.getItemViewType() == 0) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder; //force type of holder from Recycler.ViewHolder to FeaturedViewHolder

            featuredViewHolder.title.setText(article.getTitle());
            featuredViewHolder.description.setText(article.getDescription());
            featuredViewHolder.image.setImageResource(article.getImageResourceId());
        }
        // assign data for article
        else {
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder; //force type of holder from Recycler.ViewHolder to ArticleViewHolder

            articleViewHolder.title.setText(article.getTitle());
            articleViewHolder.description.setText(article.getDescription());
            articleViewHolder.image.setImageResource(article.getImageResourceId());
        }

        Button fullArticleButton = holder.itemView.findViewById(R.id.buttonFullArticle);
        fullArticleButton.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        //handle click button Full Article event
        fullArticleButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, FullArticlelActivity.class);
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


    //create view holder for featured
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

    //create view holder for article
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
