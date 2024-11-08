package vn.edu.usth.wikipediaclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FullArticlelActivity extends AppCompatActivity {

    private TextView articleTitle;
    private TextView articleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);

        // Initialize views
        articleTitle = findViewById(R.id.articleTitle);
        articleContent = findViewById(R.id.articleContent);

        // Import data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        // Assign data to views
        articleTitle.setText(title);
        articleContent.setText(content);
    }
}
