package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// View.OnClickListener - Implementation of the function "onClick"
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etHeightPerson, etWeightPerson; // Set EditText
    private Button btnCalculate; // Set Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // The design of MainActivity

        initUI();
        initListeners();
    }

    private void initUI() {
        // Id of EditText
        etHeightPerson = findViewById(R.id.etHeightPerson);
        etWeightPerson = findViewById(R.id.etWeightPerson);
        // Id of Button
        btnCalculate = findViewById(R.id.btnCalculate);
    }

    private void initListeners() {
        // Give access to elements to be clicked
        btnCalculate.setOnClickListener(this);
    }

    // Performs tasks after click on the elements
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculate:
                double height = Double.parseDouble(etHeightPerson.getText().toString());
                int weight = Integer.parseInt(etWeightPerson.getText().toString());

                // Intent to SecondActivity and pass to SecondActivity data
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                startActivity(intent);
                break;
        }
    }

}