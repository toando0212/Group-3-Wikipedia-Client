package vn.edu.usth.wikipediaclient;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
//        SQLiteDatabase db = databaseHelper.getWritableDatabase();

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

                // Lưu vào cơ sở dữ liệu cục bộ
                if (databaseHelper.insertArticle(title, description, content) != -1) {
                    Toast.makeText(getContext(), "Lưu bài viết thành công", Toast.LENGTH_SHORT).show();
                    addArticleTitle.setText("");
                    addArticleDescription.setText("");
                    addArticleContent.setText("");

                    // Gọi API để gửi bài viết lên server
                    ApiService apiService = ApiClient.getApiService();
                    Call<Void> call = apiService.addArticle(new Article(title, description, content, 0));
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getContext(), "Đã gửi bài viết lên server thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Lỗi khi gửi bài viết lên server", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(getContext(), "Lỗi kết nối đến server", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(getContext(), "Có lỗi xảy ra khi lưu bài viết", Toast.LENGTH_SHORT).show();
                }
            }

        });

        return view;
    }
}
