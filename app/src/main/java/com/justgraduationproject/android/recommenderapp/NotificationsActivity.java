package com.justgraduationproject.android.recommenderapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NotificationsActivity extends Activity {

    private ListView mListView;

    private ArrayList<String> Notis = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        mListView = (ListView) findViewById(R.id.Notis);

        Notis.add("Notification One");
        Notis.add("Notification Two");
        Notis.add("Notification Three");
        Notis.add("Notification Four");
        Notis.add("Notification Five");
        Notis.add("Notification Six");
        Notis.add("Notification Seven");
        Notis.add("Notification Eight");
        Notis.add("Notification Nine");
        Notis.add("Notification Ten");

/*
          ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Notis);

          mListView.setAdapter(itemsAdapter);

*/

        for (int i = 0; i < 10 ; i++)
        {
            TextView word = new TextView(this);

            word.setText(Notis.get(i));

            mListView.addView(word);
        }
        //Bottom Nav Accessing

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //Highlighting

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }

    //Navigation Method

    public void Navigation(int X)
    {
        if (X == R.id.navigation_home)
        {
            Intent I = new Intent(NotificationsActivity.this, HomeActivity.class);
            startActivity(I);

        } else if (X == R.id.navigation_community)
        {
            Intent I = new Intent(NotificationsActivity.this, CommunityActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_messaging)
        {
            Intent I = new Intent(NotificationsActivity.this, MessagingActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_notifications)
        {
            Intent I = new Intent(NotificationsActivity.this, NotificationsActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_profile)
        {
            Intent I = new Intent(NotificationsActivity.this, ProfileActivity.class);
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