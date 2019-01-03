package com.example.siddhant.bludiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    public String ter_ser,id_s;
    EditText ser_ter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final Button bt_srch= findViewById(R.id.button4);
        final Button bt_back= findViewById(R.id.button9);
        ser_ter=findViewById(R.id.editText);
        Intent i=getIntent();
        id_s=i.getStringExtra("ID");

        bt_srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ter_ser=ser_ter.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(), SrchResultActivity.class);
                intent.putExtra("Txtd",ter_ser);
                intent.putExtra("ID",id_s);
                startActivity(intent);
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("ID",id_s);
                startActivity(intent);
            }
        });
    }
}
