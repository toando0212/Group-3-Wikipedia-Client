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

        // Khởi tạo các thành phần UI
        articleTitle = findViewById(R.id.articleTitle);
        articleContent = findViewById(R.id.articleContent);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");

            // Kiểm tra và gán dữ liệu vào các TextView
            if (title != null && !title.isEmpty()) {
                articleTitle.setText(title);
            } else {
                articleTitle.setText("Không có tiêu đề");
                Toast.makeText(this, "Tiêu đề không được tìm thấy", Toast.LENGTH_SHORT).show();
            }

            if (content != null && !content.isEmpty()) {
                articleContent.setText(content);
            } else {
                articleContent.setText("Không có nội dung");
                Toast.makeText(this, "Nội dung không được tìm thấy", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Xử lý nếu Intent không có dữ liệu
            Toast.makeText(this, "Không có dữ liệu để hiển thị", Toast.LENGTH_LONG).show();
            finish(); // Kết thúc Activity nếu không có dữ liệu
        }
    }
}
