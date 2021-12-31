package com.example.healthhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Home()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home2);








        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.home2:
                        fragment = new Home();
                        break;
                    case R.id.profile:
                        fragment = new Profile();

                        break;
                    case R.id.diet:
                        fragment = new Diet();

                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();



                return true;
            }
        });

    }
}