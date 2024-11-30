package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2; // EditTexts for user input
    private TextView resultText; // TextView to display the result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the correct layout

        // Initialize UI elements
        editTextNumber1 = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        resultText = findViewById(R.id.resultText);

        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        // Set click listeners for each button
        addButton.setOnClickListener(v -> calculate("+"));
        subtractButton.setOnClickListener(v -> calculate("-"));
        multiplyButton.setOnClickListener(v -> calculate("*"));
        divideButton.setOnClickListener(v -> calculate("/"));
    }

    // Method to perform calculations
    private void calculate(String operation) {
        String num1Str = editTextNumber1.getText().toString().trim();
        String num2Str = editTextNumber2.getText().toString().trim();

        // Check for empty inputs
        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            try {
                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);
                int result = 0;

                // Perform the appropriate operation
                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            resultText.setText("Error: Division by zero");
                            return;
                        }
                        break;
                    default:
                        resultText.setText("Unknown operation");
                        return;
                }

                // Display the result
                resultText.setText("Result: " + result);

            } catch (NumberFormatException e) {
                // Handle invalid input
                resultText.setText("Error: Invalid input");
            }
        } else {
            // Handle empty inputs
            resultText.setText("Please enter valid numbers");
        }
    }
}
