package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity layout
        setContentView(R.layout.activity_main);

        // Apply insets to the root view (main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Handle button click logic
    public void onButtonClick(View v) {
        EditText e1 = findViewById(R.id.editTextNumber);
        EditText e2 = findViewById(R.id.editTextNumber2);
        TextView t1 = findViewById(R.id.textView);
        TextView t2 = findViewById(R.id.textView2);

        // Ensure input fields are not empty to prevent crash
        String num1Str = e1.getText().toString();
        String num2Str = e2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            int sum = num1 + num2;
            int product = num1 * num2;

            t1.setText("Sum: " + sum);
            t2.setText("Product: " + product);
        } else {
            t1.setText("Please enter valid numbers.");
            t2.setText("");
        }
    }
}
