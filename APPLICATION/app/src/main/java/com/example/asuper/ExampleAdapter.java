package com.example.asuper;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> implements Filterable {
    private java.util.List<Prodotto> List; // oggetto lista cu cui andra effettuato ladapeter
    private ArrayList<Prodotto> ListFull;

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);// metodo per ottenere la posizione del prodotto nel momento in cui viene cliccato
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView; //immagine del exampleitem
        TextView textView1; // testo1 nomeProdotto
        TextView textView2; // testo2 codice prodotto
        TextView textView3; // nome Supermercato
        TextView textView4; // numero persone supermercato
        ExampleViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.text_view1);
            textView2 = itemView.findViewById(R.id.text_view2);
            textView3 = itemView.findViewById(R.id.text_view3);
            textView4 = itemView.findViewById(R.id.text_view4);

        }

    }
    ExampleAdapter(java.util.List<Prodotto> exampleList) {
        this.List = exampleList;
        ListFull = new ArrayList<Prodotto>(exampleList);
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,
                parent, false);
        return new ExampleViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Prodotto currentItem = List.get(position);
        holder.imageView.setImageResource(R.drawable.ic_baseline_fastfood_24);
        holder.textView1.setText(currentItem.getNome());
        holder.textView2.setText(currentItem.getCodice());
        holder.textView3.setText(currentItem.getidSupermarket());
        holder.textView4.setText(currentItem.getidSupermarket());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),SupermercatiDetails.class);
                i.putExtra("nome",currentItem.getNome());
                i.putExtra("codice",currentItem.getCodice());
                i.putExtra("codiceSupermercato",currentItem.getidSupermarket());
                v.getContext().startActivity(i);

            }
        });

    }
    @Override
    public int getItemCount() {
        return List.size();
    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Prodotto> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Prodotto item : ListFull) {
                    if (item.getNome().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List.clear();
            List.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
