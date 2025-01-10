package com.example.educards;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyProfile extends AppCompatActivity {

    private ImageButton back_btn;
    private EditText editTextName;
    private Button btnSave;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        hideSystemUI();

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MyProfile.this, MainActivity.class);
                //startActivity(intent);
                finish();
            }
        });
        
        editTextName = findViewById(R.id.editTextName);
        btnSave = findViewById(R.id.btnSave);

        // Инициализируем SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Восстанавливаем сохраненное имя, если оно есть
        String savedName = sharedPreferences.getString("name", "");
        editTextName.setText(savedName);

        // Логика для сохранения данных
        btnSave.setOnClickListener(v -> {
            String name = editTextName.getText().toString();

            Toast Toast = null;
            if (!name.isEmpty()) {
                // Сохраняем введённое имя
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.apply();

                // Уведомляем пользователя, что имя сохранено
                android.widget.Toast.makeText(MyProfile.this, "Ник сохранён", android.widget.Toast.LENGTH_SHORT).show();
            } else {
                // Сообщаем, что имя не введено
                android.widget.Toast.makeText(MyProfile.this, "Введите ник", android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            hideSystemUI();
        }
    }
}