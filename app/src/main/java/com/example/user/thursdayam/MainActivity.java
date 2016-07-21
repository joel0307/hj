package com.example.user.thursdayam;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText edit;
    TextView tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);



        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);


                String id = editText1.getText().toString();
                String pw = editText2.getText().toString();

                TextView tv = (TextView) findViewById(R.id.TPM);
                tv.setText("id=" + id + "\npw=" + pw);





               if(!TextUtils.isEmpty(editText1.getText()) && !TextUtils.isEmpty(editText2.getText())) {
                   Intent intent = new Intent(MainActivity.this, List_Activity.class);
                   startActivity(intent);

               }
                EditText serverUrl = (EditText) findViewById(R.id.editText1);
                String getServerUrl = serverUrl.getText().toString();
                if(getServerUrl.getBytes().length <=0){
                    Toast.makeText(MainActivity.this,"아이디를 입력안함",Toast.LENGTH_LONG).show();
                }
                else{
                    EditText serverUrl1 = (EditText) findViewById(R.id.editText2);
                    String getServerUrl1 = serverUrl1.getText().toString();
                    if(getServerUrl1.getBytes().length <=0){
                        Toast.makeText(MainActivity.this,"비밀번호를 입력안함",Toast.LENGTH_LONG).show();
                    }

                }



            }
        });




    }








    protected void OnResume(){
        super.onResume();
        final View view = findViewById(R.id.editText1);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager manager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                manager.showSoftInput(view,0);
            }
        },100);
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
