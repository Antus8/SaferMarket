package com.example.asuper;


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

public class ExampleAdapterSupermercato extends RecyclerView.Adapter<ExampleAdapterSupermercato.ExampleViewHolder> implements Filterable {
    private List<Supermarket> List; // oggetto lista cu cui andra effettuato ladapeter
    private List<Supermarket> ListFull;

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);// metodo per ottenere la posizione del prodotto nel momento in cui viene cliccato
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView; //immagine del exampleitem
        TextView textView1; // testo1 nome Supermercato
        TextView textView2; // codice supermercato
        TextView textView3; // numero persone supermercato
        ExampleViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.text_view1);
            textView2 = itemView.findViewById(R.id.text_view2);
            textView3 = itemView.findViewById(R.id.text_view3);


        }

    }
    ExampleAdapterSupermercato(java.util.List<Supermarket> exampleList) {
        this.List = exampleList;
        ListFull = new ArrayList<>(exampleList);
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
        Supermarket currentItem = List.get(position);
        holder.imageView.setImageResource(R.drawable.ic_baseline_storefront_24);
        holder.textView1.setText(currentItem.getNome());
        holder.textView2.setText(currentItem.getId());
        holder.textView3.setText(currentItem.getId());

        holder.itemView.setOnClickListener(/*new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),SupermercatiDetails.class);
                i.putExtra("nome",currentItem.getNome());
                i.putExtra("indirizzo",currentItem.getVia());
                i.putExtra("numero persone", currentItem.getNumpersone());
                v.getContext().startActivity(i);

            }
        }*/null);

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
            List<Supermarket> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Supermarket item : ListFull) {
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
