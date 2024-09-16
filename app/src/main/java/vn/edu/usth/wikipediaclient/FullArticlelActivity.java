package vn.edu.usth.wikipediaclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class FullArticlelActivity extends AppCompatActivity {

    private ImageView articleImageView;
    private TextView articleTitle;
    private TextView articleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_article_detail);


        //init view
        articleImageView = findViewById(R.id.articleImage);
        articleTitle = findViewById(R.id.articleTitle);
        articleContent = findViewById(R.id.articleContent);

        //import data from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            int imageResourceId = intent.getIntExtra("image", -1);

            //assgign data to view
            articleTitle.setText(title);
            articleContent.setText(content);
            if (imageResourceId != -1) {
                articleImageView.setImageResource(imageResourceId);
            }
        }


    }
}