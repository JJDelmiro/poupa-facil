package com.example.poupafacil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.poupafacil.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextInitialAmount = findViewById(R.id.editTextInitialAmount);
        EditText editTextInterestRate = findViewById(R.id.editTextInterestRate);
        EditText editTextTimePeriod = findViewById(R.id.editTextTimePeriod);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(v -> {
            try {
                String initialAmountStr = editTextInitialAmount.getText().toString();
                String interestRateStr = editTextInterestRate.getText().toString();
                String timePeriodStr = editTextTimePeriod.getText().toString();

                double initialAmount = Double.parseDouble(initialAmountStr.isEmpty() ? "0" : initialAmountStr);
                double interestRate = Double.parseDouble(interestRateStr.isEmpty() ? "0" : interestRateStr);
                double timePeriod = Double.parseDouble(timePeriodStr.isEmpty() ? "0" : timePeriodStr);

                if (initialAmount <= 0 || interestRate <= 0 || timePeriod <= 0) {
                    textViewResult.setText("Por favor, insira valores positivos válidos.");
                } else {
                    double futureValue = initialAmount * Math.pow(1 + interestRate / 100, timePeriod);
                    textViewResult.setText(String.format("Resultado: R$ %.2f", futureValue));
                }
            } catch (NumberFormatException e) {
                textViewResult.setText("Ocorreu um erro: " + e.getMessage());
            }
        });
    }
}
