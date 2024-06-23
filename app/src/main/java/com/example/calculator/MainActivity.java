package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double first, second, result;
    private String currentOperation;
    private Boolean isOperationOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        currentOperation = "";
    }

    public void onNumberClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = null;
            second = null;
            result = null;
            currentOperation = "";
        } else if (textButton.equals(".")) {
            if (!textView.getText().toString().contains(".")) {
                textView.append(".");
            }
        } else if (textView.getText().toString().equals("0") || isOperationOnClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationOnClick = false;
    }

    public void onOperationClick(View view) {
        isOperationOnClick = true;
        if (view.getId() == R.id.btn_plus) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "-";
        } else if (view.getId() == R.id.btn_multiply) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "*";
        } else if (view.getId() == R.id.btn_divide) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            second = Double.valueOf(textView.getText().toString());
            if (currentOperation.equals("+")) {
                result = first + second;
            } else if (currentOperation.equals("-")) {
                result = first - second;
            } else if (currentOperation.equals("*")) {
                result = first * second;
            } else if (currentOperation.equals("/")) {
                result = first / second;
            } else if (currentOperation.equals("%")) {
                result = first / 100;
            }
            if (result % 1 == 0) {
                textView.setText(String.valueOf(result.intValue()));
            } else {
                textView.setText(result.toString());
            }
            first = null;
            second = null;
            currentOperation = "";
        } else if (view.getId() == R.id.btn_percent) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "%";
        } else if (view.getId() == R.id.btn_plus_minus) {
            double value = Double.valueOf(textView.getText().toString());
            value = value * -1;
            textView.setText(String.valueOf(value));
        }
    }
}