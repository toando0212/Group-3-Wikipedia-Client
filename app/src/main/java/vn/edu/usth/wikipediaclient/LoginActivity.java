package vn.edu.usth.wikipediaclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        EditText usernameEditText = findViewById(R.id.loginUsername);
        EditText passwordEditText = findViewById(R.id.loginPassword);
        Button loginButton = findViewById(R.id.buttonLogin);

        UserDataBase dbHelper = new UserDataBase(this);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Tên đăng nhập và mật khẩu không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }

            if (dbHelper.loginUser(username, password)) {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                // Chuyển sang màn hình khác hoặc xử lý logic sau khi đăng nhập
                Intent intent = new Intent(LoginActivity.this, MainActivity.class); // MainActivity là màn hình chính của bạn
                startActivity(intent);
                finish(); // Đóng LoginActivity
            } else {
                Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
