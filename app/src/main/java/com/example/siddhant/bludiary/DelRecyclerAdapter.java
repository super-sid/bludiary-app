package com.example.siddhant.bludiary;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DelRecyclerAdapter extends RecyclerView.Adapter<DelRecyclerAdapter.Myholder> {
    List<DiaryModel> diaryModelList;
    DiaryDB ddb;
    Context ctx;

   public DelRecyclerAdapter(List<DiaryModel> diaryModelList, DiaryDB ddb){
        this.diaryModelList = new ArrayList<>();
        this.diaryModelList = diaryModelList;
        this.ddb = ddb;
    }

    class Myholder extends RecyclerView.ViewHolder {
        public TextView heading,desc;
        public Button button;

        private Myholder(View itemView){
            super(itemView);

            heading = itemView.findViewById(R.id.tvheadd);
            desc = itemView.findViewById(R.id.tvdescd);
            button = itemView.findViewById(R.id.button14);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ddb.deleteData(diaryModelList.get(getAdapterPosition()).getHeading());
                    diaryModelList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    Toast.makeText(v.getContext(),"Entry Deleted",Toast.LENGTH_SHORT).show();
                }

            });
        }


    }

    @Override
    public DelRecyclerAdapter.Myholder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_layout,parent,false);
        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(DelRecyclerAdapter.Myholder holder, final int position) {
        holder.heading.setText(diaryModelList.get(position).getHeading());
        holder.desc.setText(diaryModelList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return diaryModelList.size();
    }
}
