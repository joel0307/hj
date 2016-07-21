package com.example.user.thursdayam;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

/**
 * Created by user on 2016-07-21.
 */
public class List_Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("angry");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ImageButton I = (ImageButton) findViewById(R.id.imgbtn);
        I.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intnet1 = new Intent(getApplicationContext(), MainList_Activity.class);
                startActivity(intnet1);
            }
        });
    }
}

