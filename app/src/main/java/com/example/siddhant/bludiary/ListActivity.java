package com.example.siddhant.bludiary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    DiaryDB diaryDB;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    Button button;
    List<DiaryModel> diaryModelList;
    String id_l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        diaryModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewList);
        button =findViewById(R.id.button16);
        Intent i =getIntent();
        id_l=i.getStringExtra("ID");
        diaryDB = new DiaryDB(ListActivity.this);
        diaryModelList = diaryDB.getdata(id_l);
        recyclerAdapter = new RecyclerAdapter(diaryModelList);

        Log.i("SidData",""+diaryModelList);
        RecyclerView.LayoutManager reLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("ID",id_l);
                startActivity(intent);
            }
        });

    }


}
