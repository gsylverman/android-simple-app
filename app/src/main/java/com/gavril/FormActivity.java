package com.gavril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FormActivity extends AppCompatActivity {

    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private EditText ageEditText;
    private EditText inchesEditText;
    private EditText feetEditText;
    private EditText weightEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        findViews();
        setupButtonClickListener();
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(v -> {

            calculateBmi();
        });
    }

    private void calculateBmi() {

        String ageText = ageEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String weightText = weightEditText.getText().toString();
        if (ageText.equals("") || inchesText.equals("") || feetText.equals("") || weightText.equals("")) {
            Toast.makeText(FormActivity.this, "ALl fields must be completed!", Toast.LENGTH_LONG).show();
            return;
        }
        int age = Integer.parseInt(ageText);
        int inches = Integer.parseInt(inchesText);
        int feet = Integer.parseInt(feetText);
        int weight = Integer.parseInt(weightText);

        double result = age * inches * feet / weight * 0.254;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        numberFormat.format(result);
        boolean male = maleRadioButton.isChecked();
        boolean female = femaleRadioButton.isChecked();

        if (male) {
            resultTextView.setText(String.valueOf(numberFormat.format(result)) + " You are a male");
        } else if (female) {
            resultTextView.setText(String.valueOf(numberFormat.format(result)) + " You are a female");
        } else {
            resultTextView.setText(String.valueOf(numberFormat.format(result)) + " Gender not selected");
        }

    }

    private void findViews() {
        maleRadioButton = findViewById(R.id.radio_button_male);
        femaleRadioButton = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edit_text_age);
        inchesEditText = findViewById(R.id.edit_text_inches);
        feetEditText = findViewById(R.id.edit_text_feet);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }
}