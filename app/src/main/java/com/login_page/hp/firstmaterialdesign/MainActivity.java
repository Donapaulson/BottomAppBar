package com.login_page.hp.firstmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    NavigationView navigationView;
    Toast toast;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bar1);
        setSupportActionBar(bottomAppBar);
        floatingActionButton = findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(this);

        //Navigation drawer
        navigationView = findViewById(R.id.navigationView);
        navigationView.setVisibility(View.INVISIBLE);
        bottomAppBar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_menu));
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setVisibility(View.VISIBLE);
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
        switch (item.getItemId()) {
            //Bottom App bar menu
            case R.id.app_bar_fav:
                toast = makeText(this, "Favorite clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 600);
                toast.show();
                break;
            case R.id.ic_settings:
                toast = makeText(this, "Settings clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 600);
                toast.show();
                break;
            case R.id.app_bar_search:
                toast = makeText(this, "Search clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 600);
                toast.show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (floatingActionButton == v) {
//            toast = makeText(this, "Add clicked", Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER, 0, 600);
//            toast.show();
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //Navigation drawer
        switch (menuItem.getItemId()) {
            case R.id.nav1:
                toast = Toast.makeText(this, "You clicked Navigation1", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 455);
                toast.show();
                break;
            case R.id.nav2:
                toast = Toast.makeText(this, "You clicked Navigation2", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 455);
                toast.show();
                break;
            case R.id.nav3:
                toast = Toast.makeText(this, "You clicked Navigation3", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 455);
                toast.show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        navigationView.setVisibility(View.INVISIBLE);

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit..", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}

