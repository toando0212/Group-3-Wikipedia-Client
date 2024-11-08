package vn.edu.usth.wikipediaclient;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddArticleActivity extends AppCompatActivity {

    private EditText addArticleTitle, addArticleDescription, addArticleContent;
    private Button buttonSubmit;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        // Khởi tạo các thành phần UI
        addArticleTitle = findViewById(R.id.articleTitleEditText);
        addArticleDescription = findViewById(R.id.articleDesptionEditText);
        addArticleContent = findViewById(R.id.articleContentEditText);
        buttonSubmit = findViewById(R.id.saveArticleButton);

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Xử lý sự kiện nhấn nút Submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = addArticleTitle.getText().toString().trim();
                String description = addArticleDescription.getText().toString().trim();
                String content = addArticleContent.getText().toString().trim();

                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(AddArticleActivity.this, "Title và Content không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (databaseHelper.insertArticle(title, description, content) != -1) {
                    Toast.makeText(AddArticleActivity.this, "Lưu bài viết thành công", Toast.LENGTH_SHORT).show();
                    addArticleTitle.setText("");
                    addArticleDescription.setText("");
                    addArticleContent.setText("");
                    finish();
                } else {
                    Toast.makeText(AddArticleActivity.this, "Có lỗi xảy ra khi lưu bài viết", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
