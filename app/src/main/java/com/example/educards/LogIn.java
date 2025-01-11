package com.example.educards;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    private Button button_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

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
        Button button_cont = findViewById(R.id.button_cont);
        button_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_sign = findViewById(R.id.button_sign);
        button_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}