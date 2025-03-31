package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReceiverActivity extends AppCompatActivity {

    TextView tvReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);

        tvReceiver = findViewById(R.id.ar_tv_receiving_data);

        if(getIntent()!=null){
            if(getIntent().getExtras()!=null){
                String receivedValue = getIntent().getStringExtra("sending_data");

                if(receivedValue!=null){
                    if(!receivedValue.isEmpty()){
                        tvReceiver.setText("Received Value:"+receivedValue);
                    }
                }
            }

        }

    }
}