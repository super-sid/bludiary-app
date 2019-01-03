package com.example.siddhant.bludiary;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SrchResultActivity extends AppCompatActivity {

    Button button;
    DiaryDB diaryDB;
    RecyclerView recyclerView;
    SrchRecyclerAdapter recyclerAdapter;
    List<DiaryModel> diaryModelList;
    String sr_heading,id_sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srch_result);
        button = findViewById(R.id.button15);

        Intent i= getIntent();
        sr_heading=i.getStringExtra("Txtd");
        id_sr=i.getStringExtra("ID");
        diaryModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewSrch);
        diaryDB = new DiaryDB(SrchResultActivity.this);
        diaryModelList = diaryDB.searchData(sr_heading,id_sr);
        recyclerAdapter = new SrchRecyclerAdapter(diaryModelList);

        Log.i("SidData",""+diaryModelList);
        RecyclerView.LayoutManager reLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("ID",id_sr);
                startActivity(intent);
            }
        });
    }

}
