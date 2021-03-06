package com.example.robotiumtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpinner;
    private EditText mTxtFirstNumber, mTxtSecondNumber;
    private TextView mTextResult, mTxtComment;

    private enum OperationType {
        Addition, Subtraction
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtFirstNumber = findViewById(R.id.txtFirstNumber);
        mTxtSecondNumber = findViewById(R.id.txtSecondNumber);
        mTextResult = findViewById(R.id.txtResult);
        mTxtComment = findViewById(R.id.txtComment);
        mSpinner = findViewById(R.id.operationSpinner);
        // Adding listener to get mTextResult button
        findViewById(R.id.btnGetResult).setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                OperationType operationType = OperationType.valueOf(mSpinner.getSelectedItem().toString());
                int num1 = Integer.parseInt(mTxtFirstNumber.getText().toString());
                int num2 = Integer.parseInt(mTxtSecondNumber.getText().toString());
                // Getting first & second values and passing to show mTextResult
                showResult(num1, num2, operationType);
            }
        });
    }

    // Showing operation results
    protected void showResult(int firstNumber, int secondNumber, OperationType type) {
        int resultVal = 0;
        if (type.equals(OperationType.Addition)) {
            resultVal = firstNumber + secondNumber;
        } else if (type.equals(OperationType.Subtraction)) {
            resultVal = firstNumber - secondNumber;
        }
        String operationResult = String.valueOf(resultVal);
        mTextResult.setText(operationResult);

        if (resultVal % 2 == 0) {
            mTxtComment.setText("????y l?? s??? ch???n");
            Toast.makeText(this, "????y l?? s??? ch???n", Toast.LENGTH_SHORT).show();
        } else {
            mTxtComment.setText("????y l?? s??? l???");
            Toast.makeText(this, "????y l?? s??? l???", Toast.LENGTH_SHORT).show();
        }
    }
}