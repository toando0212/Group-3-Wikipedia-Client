package vn.edu.usth.wikipediaclient;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonRegister;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        db = new DatabaseHelper(this);

        buttonRegister.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (db.insertUser(username, password)) {
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Registration failed. Try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
