package com.michalsela.beaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainTreatmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_treatment);
    }

    public void openTherapistList(View view){
        Intent treatIntent = new Intent(this, TherapistsListActivity.class);
        startActivity(treatIntent);
    }
}
