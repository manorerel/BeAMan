package com.michalsela.beaman;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.layout.mainmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.user_self_place:{
                return true;
            }
            case R.id.personal_treat: {
                Intent treatIntent = new Intent(this, TherapistsListActivity.class);
                treatIntent.putExtra("kind","personal");
                startActivity(treatIntent);
                return true;
            }
            case R.id.group_treat: {
                Intent groupVideoChatIntent = new Intent(this, TherapistsListActivity.class);
                groupVideoChatIntent.putExtra("kind","group");
                startActivity(groupVideoChatIntent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
