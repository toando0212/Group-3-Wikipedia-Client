package vn.edu.usth.wikipediaclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class AddArticleFragment extends Fragment {

    private EditText addArticleTitle, addArticleDescription, addArticleContent;
    private Button buttonSubmit;
    private DatabaseHelper databaseHelper;

    public AddArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_article, container, false);

        // Khởi tạo các thành phần UI
        addArticleTitle = view.findViewById(R.id.articleTitleEditText);
        addArticleDescription = view.findViewById(R.id.articleDesptionEditText);
        addArticleContent = view.findViewById(R.id.articleContentEditText);
        buttonSubmit = view.findViewById(R.id.saveArticleButton);

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(getContext());

        // Xử lý sự kiện nhấn nút Submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = addArticleTitle.getText().toString().trim();
                String description = addArticleDescription.getText().toString().trim();
                String content = addArticleContent.getText().toString().trim();

                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(getContext(), "Title và Content không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (databaseHelper.insertArticle(title, description, content) != -1) {
                    Toast.makeText(getContext(), "Lưu bài viết thành công", Toast.LENGTH_SHORT).show();
                    addArticleTitle.setText("");
                    addArticleDescription.setText("");
                    addArticleContent.setText("");
                } else {
                    Toast.makeText(getContext(), "Có lỗi xảy ra khi lưu bài viết", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
