package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    ChatFragment chatFragment;
    MypageFragment mypageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment=new HomeFragment();
        chatFragment=new ChatFragment();
        mypageFragment=new MypageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();
        NavigationBarView navigationBarView=findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                    getSupportFragmentManager().beginTransaction().addToBackStack(null);
                    Intent homeintent=new Intent(MainActivity.this,HomeFragment.class);
                    return true;
                } else if (itemId == R.id.chat) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers, chatFragment).commit();
                    getSupportFragmentManager().beginTransaction().addToBackStack(null);
                    return true;
                } else if (itemId == R.id.mypage) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers, mypageFragment).commit();
                    getSupportFragmentManager().beginTransaction().addToBackStack(null);
                    return true;
                }

                return false;
            }
        });
    }
}