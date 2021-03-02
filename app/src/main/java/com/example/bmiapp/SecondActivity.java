package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

// View.OnClickListener - Implementation of the function "onClick"
public class SecondActivity extends AppCompatActivity {

    private TextView tvResultBmi; // Set TextView
    private ImageView ivPersonBmi; // Set Button
    private double height; // Set double
    private int weight; // Set int

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // The design of SecondActivity

        initUI();
        putData();
    }

    private void initUI() {
        // Id of TextView
        tvResultBmi = findViewById(R.id.tvResultBmi);
        // Id of ImageView
        ivPersonBmi = findViewById(R.id.ivPersonBmi);

        // Get data from MainActivity
        height = getIntent().getDoubleExtra("height", 0.0);
        weight = getIntent().getIntExtra("weight", 0);
    }

    // Put data into tvResultBmi and ivPersonBmi
    private void putData() {
        double result = Double.parseDouble(String.format("%.1f", weight / Math.pow(height, 2)));

        tvResultBmi.setText(String.valueOf(result));

        if (result < 18.5) {
            ivPersonBmi.setImageResource(R.drawable.under_weight);
        } else if (result >= 18.6 && result <= 24.9) {
            ivPersonBmi.setImageResource(R.drawable.normal);
        } else if (result >= 25 && result <= 29.9) {
            ivPersonBmi.setImageResource(R.drawable.over_weight);
        } else {
            ivPersonBmi.setImageResource(R.drawable.obese);
        }
    }

}