package vn.edu.usth.wikipediaclient;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Initialize register form fields and button
//        EditText createUsername = findViewById(R.id.registerUsername);
//        EditText createPassword = findViewById(R.id.registerPassword);
//        EditText confirmPassword = findViewById(R.id.registerConfirmPassword);
//        Button createAccountButton = findViewById(R.id.registerButton);

    }
}