package vn.edu.usth.wikipediaclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FullArticlelActivity extends AppCompatActivity {

    private TextView articleTitle;
    private TextView articleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);

        // khởi tạo UI
        articleTitle = findViewById(R.id.articleTitle);
        articleContent = findViewById(R.id.articleContent);

        //  dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");

            //  gán dữ liệu vào  TextView
            if (title != null && !title.isEmpty()) {
                articleTitle.setText(title);
            }


            if (content != null && !content.isEmpty()) {
                articleContent.setText(content);
            }

        }
        else {

            Toast.makeText(this, "Không có dữ liệu để hiển thị", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
