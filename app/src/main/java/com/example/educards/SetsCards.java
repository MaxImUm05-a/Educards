package com.example.educards;

import static androidx.activity.OnBackPressedDispatcherKt.addCallback;
import static com.example.educards.R.id.black_tests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SetsCards extends AppCompatActivity {

    private ImageButton starButton;
    private GridLayout selelections_layout;

    CardDatabase cardDB;

    List<CardsSelection> selectionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sets_cards);

        hideSystemUI();

        selectionsList = new ArrayList<>();
        selectionsList = cardDB.getCardsSelectionDAO().getAllCardsSelection();
        boolean sList = true;
        if (selectionsList == null) {
            selectionsList = new ArrayList<>();
            sList = false;
        }

        selelections_layout = findViewById(R.id.selections);
        if (selelections_layout == null) {
            throw new IllegalStateException("Selections layout not found in sets_cards.xml");
        }
        LayoutInflater inflater = LayoutInflater.from(this);

        if (sList) {for (int i = 0; i < selectionsList.size(); i++){
            View itemView = inflater.inflate(R.layout.cardset_maket, selelections_layout, false);

            TextView selection_name = itemView.findViewById(R.id.selection_name);
            ImageButton selection_like = itemView.findViewById(R.id.selection_like);

            selection_name.setText(selectionsList.get(i).getName());
            if (selectionsList.get(i).isLike()){selection_like.setImageResource(R.drawable.ic_active_favorite);}
            else {selection_like.setImageResource(R.drawable.ic_passive_favorite);}

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = GridLayout.LayoutParams.WRAP_CONTENT;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.setMargins(8, 8, 8, 8);

            itemView.setLayoutParams(params);
            selelections_layout.addView(itemView);
        }}


        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        cardDB = Room.databaseBuilder(getApplicationContext(), CardDatabase.class,
            "CardDB").addCallback(myCallBack).build();

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

//        ConstraintLayout selectionr1c1 = findViewById(R.id.card_tap);
//        selectionr1c1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SetsCards.this, MenuCards.class);
//                startActivity(intent);
//            }
//        });

        ImageButton plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetsCards.this, CreateSetCards.class);
                startActivity(intent);
            }
        });


//        starButton = findViewById(R.id.selection_like);
//        final boolean[] isFavorite = {false};
//
//        starButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isFavorite[0]) {
//                    starButton.setImageResource(R.drawable.ic_active_favorite);
//                    Toast.makeText(SetsCards.this, "Видалено з вибраних", Toast.LENGTH_SHORT).show();
//                    isFavorite[0] = false;
//                } else {
//                    starButton.setImageResource(R.drawable.ic_yellow_star);
//                    Toast.makeText(SetsCards.this, "Додано у вибране", Toast.LENGTH_SHORT).show();
//                    isFavorite[0] = true;
//                }
//            }
//        });

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