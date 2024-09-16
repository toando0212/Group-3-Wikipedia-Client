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

public class MyArticleAdapter extends RecyclerView.Adapter {
    private List<Article> articleList;
    private Context context;

    public MyArticleAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);

        //assign data for article
        ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
        articleViewHolder.title.setText(article.getTitle());
        articleViewHolder.description.setText(article.getDescription());
        articleViewHolder.image.setImageResource(article.getImageResourceId());


        Button fullArticleButton = holder.itemView.findViewById(R.id.buttonFullArticle);
        fullArticleButton.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        fullArticleButton.setOnClickListener(v -> {
            //handle click button Full Article event
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



