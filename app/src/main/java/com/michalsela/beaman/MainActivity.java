package com.michalsela.beaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openGuidActivity(View view){
        Intent guidIntent = new Intent(this, GuidnaceActivity.class);
        startActivity(guidIntent);
    }

    public void openTreatActivity(View view){
        Intent treatIntent = new Intent(this, MainTreatmentActivity.class);
        startActivity(treatIntent);
    }
}
