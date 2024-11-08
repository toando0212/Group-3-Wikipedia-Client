package vn.edu.usth.wikipediaclient;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        EditText usernameEditText = findViewById(R.id.registerUsername);
        EditText passwordEditText = findViewById(R.id.registerPassword);
        EditText confirmPasswordEditText = findViewById(R.id.registerConfirmPassword);
        Button registerButton = findViewById(R.id.registerButton);

        UserDataBase userDataBase = new UserDataBase(this);

        registerButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Tên đăng nhập và mật khẩu không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Mật khẩu và xác nhận mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            if (userDataBase.registerUser(username, password)) {
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                finish(); // Quay lại màn hình trước
            } else {
                Toast.makeText(this, "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
