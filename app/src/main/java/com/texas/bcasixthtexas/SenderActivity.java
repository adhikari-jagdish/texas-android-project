package com.texas.bcasixthtexas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderActivity extends AppCompatActivity {
    EditText etSendingData, etSendingDataForResult;
    Button btnSubmit, btnSubmitForResult;
    Spinner asSpinnerCountries;

    String[] countries = {"Nepal", "China", "USA", "Australia", "Maldives", "UK", "Canada", "India", "Bhutan"};

    final int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender);

        etSendingData = findViewById(R.id.as_et_sending_data);
        btnSubmit = findViewById(R.id.as_btn_submit);
        asSpinnerCountries = findViewById(R.id.as_spinner_countries);

        etSendingDataForResult = findViewById(R.id.as_et_sending_data_for_result);
        btnSubmitForResult = findViewById(R.id.as_btn_submit_for_result);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter spinnerAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, countries);
        asSpinnerCountries.setAdapter(spinnerAdapter);

        asSpinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i) != null) {
                    String selectedValue = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(getApplicationContext(), selectedValue, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSendingData != null) {
                    if (etSendingData.getText() != null) {
                        if (!etSendingData.getText().toString().isEmpty()) {
                            String sendData = etSendingData.getText().toString();

                            Intent intent = new Intent(getApplicationContext(), ReceiverActivity.class);
                            intent.putExtra("sending_data", sendData);
                            startActivityForResult(intent, REQUEST_CODE);
                        }
                    }
                }
            }
        });

        btnSubmitForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSendingDataForResult != null) {
                    if (etSendingDataForResult.getText() != null) {
                        if (!etSendingDataForResult.getText().toString().isEmpty()) {
                            String sendDataForResult = etSendingDataForResult.getText().toString();

                            Intent intent = new Intent(getApplicationContext(), ReceiverActivity.class);
                            intent.putExtra("name", sendDataForResult);
                            startActivityForResult(intent, REQUEST_CODE);
                        }
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data!=null){
                String receivedDataFromResult = data.getStringExtra("sendDataBackForResult");
                Toast.makeText(this, receivedDataFromResult, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No Data Received", Toast.LENGTH_SHORT).show();
            }
        }
    }
}