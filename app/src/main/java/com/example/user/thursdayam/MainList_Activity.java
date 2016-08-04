package com.example.user.thursdayam;

        import android.app.DatePickerDialog;
        import android.app.DialogFragment;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.w3c.dom.Text;

/**
 * Created by user on 2016-07-21.
 */
public class MainList_Activity extends AppCompatActivity implements onNetworkResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listadd);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("angry");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


       // Text hjhj =  (Text)  findViewById(R.id.whenday);
        findViewById(R.id.whenday).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListAdd_Activity hjhaha = new ListAdd_Activity();
                hjhaha.show(getSupportFragmentManager(), "angrr");
            }
        });

        getAccountList();
    }
    //괄호안에 null 넣어도됨




    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
    public void getAccountList() {
        //View view 지워줬음

        JSONObject req_data = new JSONObject();
        try {
            req_data.put("USER_ID","test_user1");


        CommNetwork commNetwork = new CommNetwork(this,this);
        commNetwork.requestToServer("ACCOUNT_L001",req_data);
        } catch (Exception e) {
            ErrorUtil.AlertException(this,"오류가 발생하였습니다",e);
        }
    }

    @Override
    public void onSuccess(String api_key, JSONObject response) {

        Toast.makeText(this,"요청성공",Toast.LENGTH_SHORT).show();
        //성공시
        AccountTitleSpinnerList spinnerList;

        JSONArray array = null;
        try {
            array = response.getJSONArray("REC");
            spinnerList = new AccountTitleSpinnerList(array);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList.getArrayList());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner spinner = (Spinner) findViewById(R.id.drop);
            spinner.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    public void onFailure(String api_key, String error_cd, String error_msg) {
        //실패시
        Toast.makeText(this,"요청실패",Toast.LENGTH_SHORT).show();
    }
}
