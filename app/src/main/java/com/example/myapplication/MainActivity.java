package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "0";
    public static float dollarRate = 0.1477f;
    public static float enroRate = 0.1256f;
    public static float wonRate = 171.3421f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    public void verse(View view) {
        TextView in = findViewById(R.id.inputtext);
        TextView out = findViewById((R.id.textView));
        String s = view.getTag().toString();
        float old = 0f;
        if(isInteger(in.getText().toString()))
            old = Integer.parseInt(in.getText().toString());
        else
            Toast.makeText(this,"请输入数字",Toast.LENGTH_SHORT).show();
        float result= 0f ;
        switch (s){
            case "dollar":
                result = old*dollarRate;
                break;
            case "enro":
                result = old*enroRate;
                break;
            case "won":
                result = old*wonRate;
                break;
            default:
                result = 0;
                break;
        }
        out.setText(Float.toString(result));



    }
    public void openConfig(View v){
        Intent config = new Intent(this,MainActivity2.class);
        Bundle bdl = new Bundle();
        bdl.putFloat("dollar_rate",dollarRate);
        bdl.putFloat("enro_rate",enroRate);
        bdl.putFloat("won_rate",wonRate);
        config.putExtras(bdl);

        Log.i(TAG, "open: dollorRate="+ dollarRate);
        Log.i(TAG, "open: enroRate="+ dollarRate);
        Log.i(TAG, "open: wonRate="+ wonRate);

        startActivityForResult(config,1);
    }
    public void openList(View v){
        Intent list = new Intent(this,ListActivity.class);
        startActivity(list);
    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==2){
            dollarRate = data.getFloatExtra("dollar_rate",0f);
            enroRate = data.getFloatExtra("enro_rate",0f);
            wonRate = data.getFloatExtra("won_rate",0f);
        }
    }
}