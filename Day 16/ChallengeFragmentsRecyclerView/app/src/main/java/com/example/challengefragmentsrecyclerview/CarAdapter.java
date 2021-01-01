package com.example.challengefragmentsrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>
{
    private ArrayList<Car> carsList;

    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> list)
    {
        carsList = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivCarMaker;
        TextView tvCarModel;
        TextView tvCarOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCarMaker = itemView.findViewById(R.id.ivCarMaker);
            tvCarModel = itemView.findViewById(R.id.tvCarModel);
            tvCarOwner = itemView.findViewById(R.id.tvCarOwner);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    activity.onItemClicked(carsList.indexOf((Car) view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        Log.i("tage", "size: " + ApplicationClass.cars.size());
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(carsList.get(position));
        Log.i("tage", "size: " + ApplicationClass.cars.size());

        holder.ivCarMaker.setImageResource(carsList.get(position).getMaker());
        holder.tvCarModel.setText(carsList.get(position).getModel());
        holder.tvCarOwner.setText(carsList.get(position).getOwner());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }
}
