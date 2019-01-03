package com.example.siddhant.bludiary;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import static android.app.PendingIntent.getActivity;

public class AddActivity extends AppCompatActivity {

    Button bt_back, bt_save;
    EditText et1,et2;
    String heading,desc,id_a;

    DiaryDB diaryDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        bt_back = (Button)findViewById(R.id.button10);
        bt_save = (Button)findViewById(R.id.button11);

        Intent intent=getIntent();
        id_a = intent.getStringExtra("ID");
        diaryDB = new DiaryDB(this);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading = et1.getText().toString().trim();
                desc = et2.getText().toString().trim();

                if(heading.isEmpty() || desc.isEmpty()){
                    Toast.makeText(AddActivity.this,"All details are required", Toast.LENGTH_LONG).show();
                }else{
                    diaryDB.addData(heading,desc,id_a);
                    Toast.makeText(getApplicationContext(),"Entry Saved",Toast.LENGTH_SHORT).show();
                    et1.setText("");
                    et2.setText("");
                }
            }
        });

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("ID",id_a);
                startActivity(intent);
            }
        });
    }

}
