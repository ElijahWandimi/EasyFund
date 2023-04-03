package com.muendo.k_changa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.muendo.k_changa.databinding.ActivityDashBinding;
import com.muendo.k_changa.ui.home.HomeFragment;

public class DashActivity extends AppCompatActivity {

    private ActivityDashBinding binding;
    int count = 456321;

    private String bodyL = "Fundraiser for a hospital bill. \nPlease help me raise funding to pay for my hospital bill. Thank you.\n" +
            "The paybill number is " + count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_shares)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_dash);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_share_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        System.out.println("Item: " + item.getItemId());
        if (item.getItemId() == R.id.navigation_shares) {
//            Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String body = String.valueOf(bodyL);
            String sub = "Your Subject";
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
            shareIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(shareIntent, "Share Using"));
            return true;
        }
        return false;
    }
}