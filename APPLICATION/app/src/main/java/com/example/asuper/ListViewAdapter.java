package com.example.asuper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static androidx.recyclerview.widget.RecyclerView.OnClickListener;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> modelArrayList;


    public ListViewAdapter(Context context,List<Model> modelList) {
        context=context;
        this.modelList = modelList;
        this.modelArrayList = modelArrayList;
        inflater = LayoutInflater.from(context);
        this.modelArrayList = new ArrayList<Model>();
        this.modelArrayList.addAll(modelList);

    }
    public class ViewHolder{
        TextView mTitle,mdesc;
        ImageView imageView;

    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View View, ViewGroup parent) {
        ViewHolder holder;
        if(View == null){
            holder = new ViewHolder();
            View = inflater.inflate(R.layout.row,null);


            holder.mTitle=View.findViewById(R.id.maintitle);
            holder.mdesc = View.findViewById(R.id.maindesc);
            holder.imageView = View.findViewById(R.id.mainicon);


            View.setTag(holder);

        }else{
            holder=(ViewHolder)View.getTag();
        }
        holder.mTitle.setText(modelList.get(position).getTitle());
        holder.mdesc.setText(modelList.get(position).getDesc());
        holder.imageView.setImageResource(modelList.get(position).getIcon());

        View.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

            }
        });
        return View;
    }
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0){
            modelList.addAll(modelArrayList);
        }else {
            for(Model model : modelArrayList ){
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();

    }

}
