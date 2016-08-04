package com.example.user.thursdayam;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2016-07-21.
 */
public class List_Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("angry");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        ImageButton I = (ImageButton) findViewById(R.id.imgbtn1);
        I.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intnet1 = new Intent(getApplicationContext(), MainList_Activity.class);
                startActivity(intnet1);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}

