package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReceiverActivity extends AppCompatActivity {

    TextView tvReceiver, tvReceivingDataForResult;
    Button arShowAlertBtn, btnSubmitForResult;
    EditText etSendingDataBackForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);

        tvReceiver = findViewById(R.id.ar_tv_receiving_data);
        arShowAlertBtn = findViewById(R.id.ar_btn_show_dialog);
        tvReceivingDataForResult = findViewById(R.id.ar_tv_receiving_data_for_result);
        btnSubmitForResult = findViewById(R.id.as_btn_submit_for_result);
        etSendingDataBackForResult = findViewById(R.id.as_et_sending_back_data_for_result);

        if(getIntent()!=null){
            if(getIntent().getExtras()!=null){
                String receivedValue = getIntent().getStringExtra("sending_data");
                String receivedValueForResult = getIntent().getStringExtra("name");

                if(receivedValue!=null){
                    if(!receivedValue.isEmpty()){
                        tvReceiver.setText("Received Value:"+receivedValue);
                    }
                }

                if(receivedValueForResult!=null){
                    if(!receivedValueForResult.isEmpty()){
                        tvReceivingDataForResult.setText("Received Data from Result Activity:"+receivedValueForResult);
                    }
                }
            }

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        arShowAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
                alertDialogFragment.show(getSupportFragmentManager(), "MyDialog");
            }
        });
    }
}