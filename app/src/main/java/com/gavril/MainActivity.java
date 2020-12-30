package com.gavril;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView startersCard;
    CardView mainCard;
    CardView formCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainCoursesActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
                startActivity(mainCoursesActivityIntent);
            }
        });

        startersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent starterActivityIntent = new Intent(MainActivity.this, StarterActivity.class);
                startActivity(starterActivityIntent);

            }
        });

        formCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formCardActivityIntent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(formCardActivityIntent);
            }
        });
    }

    private void findViews() {
        startersCard = findViewById(R.id.card_view_starters);
        mainCard = findViewById(R.id.card_view_main);
        formCard = findViewById(R.id.card_view_form);
    }
}