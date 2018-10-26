package com.login_page.hp.firstmaterialdesign;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.makeText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        bottomAppBar = findViewById(R.id.bar2);
        setSupportActionBar(bottomAppBar);
        floatingActionButton = findViewById(R.id.fab2);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
        switch (item.getItemId()) {
            //Bottom App bar menu
            case R.id.search:
                Toast toast = makeText(this, "Search clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 600);
                toast.show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (floatingActionButton == v){
            Toast toast = makeText(this, "Favorite clicked", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 600);
            toast.show();
        }
    }
}
