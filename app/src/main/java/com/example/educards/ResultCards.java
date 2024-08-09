package com.example.educards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultCards extends AppCompatActivity {

    private ImageButton account;
    private ImageButton messages;
    private LinearLayout tests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_cards);

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultCards.this, MyProfile.class);
                startActivity(intent);
            }
        });
        messages = findViewById(R.id.messages);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultCards.this, MainActivity.class);
                startActivity(intent);
            }
        });
        tests = findViewById(R.id.tests);
        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultCards.this, Tests.class);
                startActivity(intent);
            }
        });
    }
}

