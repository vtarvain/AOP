package com.example.tehtava_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ValintaAdapteri extends RecyclerView.Adapter<ValintaAdapteri.ViewHolder> {

    private List<String> maat;
    private OnkoMaaValittuListener listener;
    private int valittuMaa = -1;
    public interface OnkoMaaValittuListener {
        void onkoMaaValittu(String maa);
    }

    public ValintaAdapteri(List<String> maat, OnkoMaaValittuListener listener) {
        this.maat = maat;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int valittu) {
        String maa = maat.get(valittu);
        holder.textView.setText(maa);

        if (valittuMaa == valittu) {
            holder.itemView.setBackgroundColor(android.graphics.Color.LTGRAY);
        } else {
            holder.itemView.setBackgroundColor(android.graphics.Color.TRANSPARENT);
        }

        holder.itemView.setOnClickListener(v -> {
            int aiemminValittu = valittuMaa;
            valittuMaa = holder.getAdapterPosition();
            notifyItemChanged(aiemminValittu);
            notifyItemChanged(valittuMaa);

            listener.onkoMaaValittu(maa);
        });
    }

    @Override
    public int getItemCount() {
        return maat.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}