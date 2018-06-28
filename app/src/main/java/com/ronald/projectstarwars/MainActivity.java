package com.ronald.projectstarwars;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ronald.projectstarwars.fragments.HomeFragment;
import com.ronald.projectstarwars.fragments.MovieTextFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment homeFragment = new HomeFragment();
        mostrarFragment(homeFragment);

//        Bundle bundle = new Bundle();
//        String myMessage = "Stackoverflow is cool!";
//        bundle.putString("message", myMessage );
        //savedInstanceState.putString("message", myMessage );
        //Fragment movieTextFrament = new MovieTextFragment(1);
        //movieTextFrament.setArguments(bundle);
        //mostrarFragment(movieTextFrament);



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void mostrarFragment(Fragment fragment) {
        //FrameLayout contedorFragments = (FrameLayout)findViewById(R.id.contedorFragments);

        //getSupportFragmentManager()
        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.contedorFragments, fragment);
        transaccion.commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (ActionMenu(item)) return true;
            return false;
        }
    };

    private boolean ActionMenu(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Fragment homeFragment = new HomeFragment();
                mostrarFragment(homeFragment);
                //Toast.makeText(getBaseContext(),"Home", Toast.LENGTH_LONG).show();
                return true;
            case R.id.navigation_dashboard:
                Toast.makeText(getBaseContext(),"Comming soon", Toast.LENGTH_LONG).show();
                return true;
            case R.id.navigation_settings:
                Toast.makeText(getBaseContext(),"Comming soon", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (ActionMenu(item)) return true;
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
