package com.example.siddhant.bludiary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class SrchRecyclerAdapter extends RecyclerView.Adapter<SrchRecyclerAdapter.Myholder> {
    private List<DiaryModel> diaryModelList;

    public SrchRecyclerAdapter(List<DiaryModel> diaryModelList){
        this.diaryModelList = diaryModelList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        public TextView heading,desc;

        private Myholder(View itemView){
            super(itemView);

            heading = itemView.findViewById(R.id.textView4);
            desc = itemView.findViewById(R.id.textView3);
        }
    }

    @Override
    public SrchRecyclerAdapter.Myholder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_res_layout,parent,false);
        return new SrchRecyclerAdapter.Myholder(view);
    }

    @Override
    public void onBindViewHolder(SrchRecyclerAdapter.Myholder holder, int position) {
        holder.heading.setText(diaryModelList.get(position).getHeading());
        holder.desc.setText(diaryModelList.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return diaryModelList.size();
    }
}
