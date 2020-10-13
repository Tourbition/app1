package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Intent intent;
    EditText t1;
    EditText t2;
    EditText t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1 = findViewById(R.id.editTextTextPersonName2);
        t2 = findViewById(R.id.editTextTextPersonName3);
        t3 = findViewById(R.id.editTextTextPersonName4);
        Intent in = getIntent();
        Bundle bdl = in.getExtras();
        String text1 = Float.toString(bdl.getFloat("dollar_rate"));
        String text2 = Float.toString(bdl.getFloat("enro_rate"));
        String text3 = Float.toString(bdl.getFloat("won_rate"));
        t1.setText(text1);
        t2.setText(text2);
        t3.setText(text3);

    }
    public void save(View v){
        Intent data = getIntent();
        t1 = findViewById(R.id.editTextTextPersonName2);
        t2 = findViewById(R.id.editTextTextPersonName3);
        t3 = findViewById(R.id.editTextTextPersonName4);
        Float f1 = Float.parseFloat(t1.getText().toString());
        Float f2 = Float.parseFloat(t2.getText().toString());
        Float f3 = Float.parseFloat(t3.getText().toString());
        data.putExtra("dollar_rate",f1);
        data.putExtra("enro_rate",f2);
        data.putExtra("won_rate",f3);
        setResult(2,data);
        finish();

    }
}