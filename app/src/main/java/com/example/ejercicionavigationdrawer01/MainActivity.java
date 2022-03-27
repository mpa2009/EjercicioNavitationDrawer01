package com.example.ejercicionavigationdrawer01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout myDrawer;
    NavigationView myNav;
    Toolbar myToolbar;

    //Implementa el icono de la hamburguesa
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawerLayout);
        myNav = findViewById(R.id.myNavigationView);
        myToolbar = findViewById(R.id.myToolbar);

        setSupportActionBar(myToolbar);

        //Click en items navigationDrawer
        myNav.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myFrame, new Fragmento1())
                .commit();
        setTitle("Home");

        //toggle = new ActionBarDrawerToggle(MainActivity.this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);
        toggle = setDrawerToogle();

        //Para ir al icono del sandwich
        //myDrawer.addDrawerListener(toogle);


    }
    //Metodo 1 Necesario para el menu de sandwich
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
    //Metodo 2 Necesario para el menu de sandwich
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private ActionBarDrawerToggle setDrawerToogle() {
        return new ActionBarDrawerToggle(MainActivity.this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Soporte a los fragmentos
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //Switch
        switch (item.getItemId()){
            case R.id.nav_home:
                ft.replace(R.id.myFrame, new Fragmento1()).commit();
                return true;
            case R.id.nav_profile:
                ft.replace(R.id.myFrame, new Fragmento2()).commit();
                return true;
            case R.id.nav_event:
                ft.replace(R.id.myFrame, new Fragmento3()).commit();
                return true;
            case R.id.nav_notifications:
                Toast.makeText(MainActivity.this, "Elejiste Notifications", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_contac:
                Toast.makeText(MainActivity.this, "Elejiste Contac", Toast.LENGTH_SHORT).show();
                return true;
        }
        setTitle(item.getTitle());
        myDrawer.closeDrawers();
        return false;
    }
}