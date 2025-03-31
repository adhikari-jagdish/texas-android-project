package com.texas.bcasixthtexas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderActivity extends AppCompatActivity {
    EditText etSendingData;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender);

        etSendingData = findViewById(R.id.as_et_sending_data);
        btnSubmit = findViewById(R.id.as_btn_submit);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etSendingData!=null){
                    if(etSendingData.getText()!=null){
                        if(!etSendingData.getText().toString().isEmpty()){
                            String sendData = etSendingData.getText().toString();

                            Intent intent = new Intent(getApplicationContext(), ReceiverActivity.class);
                            intent.putExtra("sending_data", sendData);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}