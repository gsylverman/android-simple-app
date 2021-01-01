package com.gavril;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

public class DessertActivity extends AppCompatActivity {

    ListView listViewDessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        listViewDessert = findViewById(R.id.list_view_dessert);

        Dish[] desserts = {
                new Dish("Cocoa and blackcurrant cake", "Moist cake made with cocoa and fresh blackcurrant", 499),
                new Dish("Mulberry and cardamom crumble", "Fresh mulberry and green cardamom topped with butter crumble", 699),
                new Dish("Lemon scones with chilli jam", "Vegan scones served with chilli jam and fresh coconut cream", 599),
                new Dish("Potato and banana vegan crepes", "Crispy vegan crepes filled with fresh potato and banana", 599),
                new Dish("Cinnamon and treacle buns", "Crumbly buns made with cinnamon and dark treacle", 499)
        };
        ArrayAdapter<Dish> dessertListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, desserts);
        listViewDessert.setAdapter(dessertListAdapter);

        listViewDessert.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            System.out.println(textView.getText());

            Dish dish = desserts[position];
            int price = dish.getPrice();
            String description = dish.getDescription();

            System.out.println("Description: " + description + ", Price: " + price + "$");
        });
    }
}