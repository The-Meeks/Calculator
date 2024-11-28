package com.example.calculator;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Place the onButtonClick method within the class
    public void onButtonClick(View v) {
        // Handle button click logic here
        EditText e1 =(EditText)findViewById(R.id.editTextNumber);
        EditText e2 =(EditText)findViewById(R.id.editTextNumber2);
        TextView t1= (TextView)findViewById(R.id.textView);
        TextView t2 =(TextView)findViewById(R.id.textView2);
        int num1= Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        int sum= num1 + num2;
        int product = num1 * num2;
        t1.setText(Integer.toString(sum));
        t2.setText(Integer.toString(product));
    }
}