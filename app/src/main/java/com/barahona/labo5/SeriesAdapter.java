package com.barahona.labo5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 18/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {
    private ArrayList<Serie> series;

    public static MyAdapterListener onClickListener;

    public interface MyAdapterListener {
        void toastOnClick(View v, int position);
    }

    @Override
    public  SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return (new SeriesViewHolder(v));
    }
    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position){
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());
    }
    @Override
    public int getItemCount(){
        return series.size();
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView name;
        ImageView img;
        ImageButton toast;

        public SeriesViewHolder(View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            toast = itemView.findViewById(R.id.button);

            toast.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    onClickListener.toastOnClick(v, getAdapterPosition());
                    toast.setImageResource(R.drawable.starfav);
                }
            });
        }
    }
    public SeriesAdapter(ArrayList<Serie> series, MyAdapterListener listener){
        this.series=series;
        onClickListener = listener;
    }
}
