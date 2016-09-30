package com.calvin.kec32.homework1;

/*
Karen Cudjoe
CS 262
Homework 1
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalculator extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //define variables for the widget
    private EditText inputNum1;
    private EditText inputNum2;
    private Spinner spinner;
    private TextView result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        //get references to the widgets
        inputNum1 = (EditText) findViewById(R.id.inputNum1);
        inputNum2 = (EditText) findViewById(R.id.inputNum2);
        spinner = (Spinner) findViewById(R.id.spinner);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);
        //set the listeners
        calculate.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements; add to list
        List<String> spinnerItems = new ArrayList<String>();
        spinnerItems.add("+");
        spinnerItems.add("-");
        spinnerItems.add("*");
        spinnerItems.add("/");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onClick(View v) {
        //get input numbers
        String num1 = inputNum1.getText().toString();
        String num2 = inputNum2.getText().toString();
    //get spinner value
        String value= spinner.getSelectedItem().toString();
    //switch case statement to cater for all spinner values
        switch (v.getId()){
            case R.id.calculate:
                if( value =="+"){
                    int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                }
                if (value == "-") {
                        int sub = Integer.parseInt(num1) - Integer.parseInt(num2);
                        result.setText(String.valueOf(sub));
                }
                if( value =="*") {
                    int mul = Integer.parseInt(num1)*Integer.parseInt(num2);
                    result.setText(String.valueOf(mul));
                }
                if( value =="/") {
                    int div = Integer.parseInt(num1) / Integer.parseInt(num2);
                    result.setText(String.valueOf(div));
                }
                break;
        }

    }

        //Method to select spinnerItem
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
