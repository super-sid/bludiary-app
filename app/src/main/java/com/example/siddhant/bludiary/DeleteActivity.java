package com.example.siddhant.bludiary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    DiaryDB diaryDB;
    RecyclerView recyclerView;
    DelRecyclerAdapter recyclerAdapter;
    List<DiaryModel> diaryModelList;
    Button button;
    String id_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        button = findViewById(R.id.button13);
        diaryModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewDel);
        Intent intent=getIntent();
        id_d=intent.getStringExtra("ID");
        diaryDB = new DiaryDB(DeleteActivity.this);
        diaryModelList = diaryDB.getdata(id_d);
        recyclerAdapter = new DelRecyclerAdapter(diaryModelList,diaryDB);

        Log.i("SidData",""+diaryModelList);
        RecyclerView.LayoutManager reLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("ID",id_d);
                startActivity(intent);
            }
        });
    }
}
