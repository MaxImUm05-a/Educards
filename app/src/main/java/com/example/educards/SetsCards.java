package com.example.educards;

import static com.example.educards.R.id.black_tests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SetsCards extends AppCompatActivity {

    private ImageButton starButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sets_cards);

        hideSystemUI();

        ImageButton account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetsCards.this, MyProfile.class);
                startActivity(intent);
            }
        });

        ImageButton messages = findViewById(R.id.messages);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Cards.this, MainActivity.class);
                //startActivity(intent);
                finish(); // має повертати на попередній екран :)
            }
        });

        ImageButton tests = findViewById(black_tests);
        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetsCards.this, Tests.class);
                startActivity(intent);
            }
        });

        ConstraintLayout selectionr1c1 = findViewById(R.id.card_tap);
        selectionr1c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetsCards.this, MenuCards.class);
                startActivity(intent);
            }
        });

        ImageButton plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetsCards.this, CreateSetCards.class);
                startActivity(intent);
            }
        });


        starButton = findViewById(R.id.button_star);
        final boolean[] isFavorite = {false};

        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFavorite[0]) {
                    starButton.setImageResource(R.drawable.ic_active_favorite);
                    Toast.makeText(SetsCards.this, "Видалено з вибраних", Toast.LENGTH_SHORT).show();
                    isFavorite[0] = false;
                } else {
                    starButton.setImageResource(R.drawable.ic_yellow_star);
                    Toast.makeText(SetsCards.this, "Додано у вибране", Toast.LENGTH_SHORT).show();
                    isFavorite[0] = true;
                }
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