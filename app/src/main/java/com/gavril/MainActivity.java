package com.gavril;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView startersCard;
    private CardView mainCard;
    private CardView formCard;
    private TextView restaurantEmailTextView;
    private CardView dessertCardView;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        dessertCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDessertActivity = new Intent(MainActivity.this, DessertActivity.class);
                startActivity(goToDessertActivity);
            }
        });

        restaurantEmailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:gsylverman@gmail.com")); // only email apps should handle this
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

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
        restaurantEmailTextView = findViewById(R.id.text_view_restaurant_email);
        dessertCardView = findViewById(R.id.card_view_dessert);
    }
}