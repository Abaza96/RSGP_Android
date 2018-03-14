package com.justgraduationproject.android.recommenderapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MessagingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        //Bottom Nav Accessing

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNaviHelper.disableShiftMode(navigation);


        //Highlighting

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
    }

    //Navigation Method

    public void Navigation(int X)
    {
        if (X == R.id.navigation_home)
        {
            Intent I = new Intent(MessagingActivity.this, HomeActivity.class);
            startActivity(I);

        } else if (X == R.id.navigation_community)
        {
            Intent I = new Intent(MessagingActivity.this, CommunityActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_messaging)
        {
            Intent I = new Intent(MessagingActivity.this, MessagingActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_notifications)
        {
            Intent I = new Intent(MessagingActivity.this, NotificationsActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_profile)
        {
            Intent I = new Intent(MessagingActivity.this, ProfileActivity.class);
            startActivity(I);
        }

    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    Navigation(R.id.navigation_home);
                    return true;
                }
                case R.id.navigation_messaging:{
                    Navigation(R.id.navigation_messaging);
                    return true;
                }
                case R.id.navigation_notifications: {
                    Navigation(R.id.navigation_notifications);
                    return true;
                }
                case R.id.navigation_profile: {
                    Navigation(R.id.navigation_profile);
                    return true;
                }
                case R.id.navigation_community: {
                    Navigation(R.id.navigation_community);
                    return true;
                }
            }
            return false;
        }
    };
}