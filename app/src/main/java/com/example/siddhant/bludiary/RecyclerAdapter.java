package com.example.siddhant.bludiary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {
    private List<DiaryModel> diaryModelList;

    public RecyclerAdapter(List<DiaryModel> diaryModelList){
        this.diaryModelList = diaryModelList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        public TextView heading,desc;

         private Myholder(View itemView){
            super(itemView);

            heading = itemView.findViewById(R.id.tvhead);
            desc = itemView.findViewById(R.id.tvdesc);
        }
    }

    @Override
    public RecyclerAdapter.Myholder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        holder.heading.setText(diaryModelList.get(position).getHeading());
        holder.desc.setText(diaryModelList.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return diaryModelList.size();
    }
}
