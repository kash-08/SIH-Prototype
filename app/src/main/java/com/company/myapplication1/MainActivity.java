package com.company.myapplication1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private FrameLayout fragmentContainer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ImageView toolbarLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarLogo = findViewById(R.id.toolbar_logo);
        drawerLayout = findViewById(R.id.drawer_layout);
        fragmentContainer = findViewById(R.id.fragment_container);
        navigationView = findViewById(R.id.nav_view);

        // Setup toolbar - KEEP TITLE STATIC AS "AUSADHI.AI"
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Hide default title
        }
        toolbarTitle.setText(R.string.app_name); // Always show "AUSADHI.AI"

        // Setup navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // Optional: Add any actions when drawer opens
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Optional: Add any actions when drawer closes
            }
        };

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Set toolbar logo click listener - navigate to dashboard when clicked
        toolbarLogo.setOnClickListener(v -> {
            loadFragment(new DashboardFragment());
            navigationView.setCheckedItem(R.id.nav_dashboard);
        });

        // Set toolbar title click listener - same as logo
        toolbarTitle.setOnClickListener(v -> {
            loadFragment(new DashboardFragment());
            navigationView.setCheckedItem(R.id.nav_dashboard);
        });

        // Load default fragment (Dashboard)
        if (savedInstanceState == null) {
            loadFragment(new DashboardFragment());
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_dashboard) {
            fragment = new DashboardFragment();
        } else if (id == R.id.nav_diet_plan) {
            fragment = new DietPlanFragment();
        } else if (id == R.id.nav_progress) {
            fragment = new ProgressFragment();
        } else if (id == R.id.nav_chatbot) {
            fragment = new ChatbotFragment();
        } else if (id == R.id.nav_profile) {
            fragment = new ProfileFragment();
        } else {
            // Handle other menu items if they exist in your current menu
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        if (fragment != null) {
            loadFragment(fragment);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);

        // Add to back stack only if it's not the dashboard
        if (!(fragment instanceof DashboardFragment)) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();

        // REMOVED: updateToolbarTitle(fragment); - Toolbar title stays "AUSADHI.AI"
    }

    // REMOVED THE updateToolbarTitle() METHOD COMPLETELY
    // Toolbar title will now always stay as "AUSADHI.AI"

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // If current fragment is not dashboard, navigate to dashboard
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (!(currentFragment instanceof DashboardFragment)) {
                loadFragment(new DashboardFragment());
                navigationView.setCheckedItem(R.id.nav_dashboard);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Ensure the correct item is selected when activity resumes
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (currentFragment instanceof DashboardFragment) {
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }

        // Ensure toolbar title stays as "AUSADHI.AI"
        toolbarTitle.setText(R.string.app_name);
    }
}