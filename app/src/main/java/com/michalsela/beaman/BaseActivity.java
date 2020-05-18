package com.michalsela.beaman;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ActionBar supportActionBar = this.getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setTitle(getString(R.string.app_name));
        Drawable color;
        color = new ColorDrawable(getResources().getColor(R.color.green));
        supportActionBar.setBackgroundDrawable(color);
    }
}
