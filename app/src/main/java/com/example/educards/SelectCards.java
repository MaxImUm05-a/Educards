package com.example.educards;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class SelectCards extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_cards);

        hideSystemUI();

        ImageButton account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCards.this, MyProfile.class);
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

        ImageButton tests = findViewById(R.id.black_tests);
        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCards.this, Tests.class);
                startActivity(intent);
            }
        });
        ImageButton plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCards.this, CreateSetCards.class);
                startActivity(intent);
            }
        });
        ImageButton card = findViewById(R.id.card_tap);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCards.this, MenuCards.class);
                startActivity(intent);
            }
        });
        ConstraintLayout selectionr1c1 = findViewById(R.id.card_tap);
        selectionr1c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCards.this, MenuCards.class);
                startActivity(intent);
            }
        });


//        ImageButton starButton = findViewById(R.id.button_star);
//        final boolean[] isFavorite = {false};
    
//        starButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if (isFavorite[0]) {
//                starButton.setImageResource(R.drawable.ic_active_favorite);
//                Toast.makeText(SelectCards.this, "Видалено з вибраних", Toast.LENGTH_SHORT).show();
//                isFavorite[0] = false;
//            } else {
//                starButton.setImageResource(R.drawable.ic_yellow_star);
//                Toast.makeText(SelectCards.this, "Додано у вибране", Toast.LENGTH_SHORT).show();
//                isFavorite[0] = true;
//            }
//        }
//        });

}
    private void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.systemBars());
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            hideSystemUI();
        }
    }
}
