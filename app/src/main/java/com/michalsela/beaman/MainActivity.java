package com.michalsela.beaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guidButton = findViewById(R.id.guid_button_id);
        guidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGuidActivity();
            }
        });

        Button treatButton = findViewById(R.id.treat_button_id);
        treatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTreatActivity();
            }
        });
    }

    private void openGuidActivity(){
        Intent guidIntent = new Intent(this, GuidnaceActivity.class);
        startActivity(guidIntent);
    }

    private void openTreatActivity(){
        Intent treatIntent = new Intent(this, MainTreatmentActivity.class);
        startActivity(treatIntent);
    }
}
