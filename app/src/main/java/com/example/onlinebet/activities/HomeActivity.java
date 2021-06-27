package com.example.onlinebet.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.onlinebet.R;
import com.example.onlinebet.adapters.ListMatchAdapter;
import com.example.onlinebet.models.Match;
import com.example.onlinebet.models.Team;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ActionBar actionBar;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    private ListMatchAdapter listMatchAdapter;

    private Match[] matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        matches = generateMatch();

        recyclerView = findViewById(R.id.list_match_recycler_view);
        manager = new LinearLayoutManager(this);
        listMatchAdapter = new ListMatchAdapter(matches);
        recyclerView.setAdapter(listMatchAdapter);
        recyclerView.setLayoutManager(manager);

        initToolbar();
        initNavigationMenu();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Bet now");

        this.drawerLayout = findViewById(R.id.activity_home_drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void initNavigationMenu() {
        this.navigationView = (NavigationView) findViewById(R.id.activity_home_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.activity_home_drawer_login).setVisible(true);
        menu.findItem(R.id.activity_home_drawer_profil).setVisible(true);
        menu.findItem(R.id.activity_home_drawer_credit_account).setVisible(true);
        menu.findItem(R.id.activity_home_drawer_logout).setVisible(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        if(item.getItemId() == R.id.activity_home_drawer_credit_account) {
            startActivity(new Intent(this, CreditAccountActivity.class));
        }
        return true;
    }

    private Match[] generateMatch() {
        Match [] list = new Match[4];

        for(int i = 0; i < 4; i++) {
            Team team1 = new Team("Team1" + i);
            Team team2 = new Team("Team2" + i);

            list[i] = new Match("Match" + i, team1, team2, 1.1, 2.2, 0.0);
        }

        return list;
    }
}