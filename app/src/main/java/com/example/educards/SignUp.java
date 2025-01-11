package com.example.educards;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Button button_cont = findViewById(R.id.button_cont);
        button_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        String fullText = getString(R.string.data_proces);

        // Определяем, с какого слова начинается выделение
        String highlightText = "обробка персональних";
        int start = fullText.indexOf(highlightText); // Начало выделяемой части

        if (start != -1) { // Проверяем, что слово найдено
            // Создаём SpannableString
            SpannableString spannable = new SpannableString(fullText);

            // Применяем голубой цвет к части текста
            spannable.setSpan(
                    new ForegroundColorSpan(Color.CYAN), // Голубой цвет
                    start, // Начальная позиция выделения
                    fullText.length(), // Конечная позиция (до конца текста)
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Тип выделения
            );

            // Устанавливаем обработанный текст в TextView
            TextView textView = findViewById(R.id.textView);
            textView.setText(spannable);
        }
        Button button_log = findViewById(R.id.button_sign);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });
    }
}