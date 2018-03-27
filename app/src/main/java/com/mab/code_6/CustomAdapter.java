package com.mab.code_6;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mab.code_6.models.OrderDetails;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by MonisBana on 3/7/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<OrderDetails> cardset;

    public CustomAdapter(ArrayList<OrderDetails> cardset) {
        this.cardset = cardset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);
        //view.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView CropName = holder.cropName;
        TextView Quantity = holder.Quantity;
        TextView Type = holder.type;
        TextView Price = holder.price;
        CardView cardView = holder.mCardView;


        cardView.setTag(position);
        CropName.setText(cardset.get(position).getCropDetails().getName());
        Quantity.setText(cardset.get(position).getCropDetails().getQuantity());
        Type.setText(cardset.get(position).getCropDetails().getType());
        Price.setText(cardset.get(position).getTransportAmount()+"");
        cardView.setOnClickListener(MainActivity.myOnClickListener);
    }

    @Override
    public int getItemCount() {
        return cardset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cropName,Quantity,price,type;
        public CardView mCardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.mCardView = itemView.findViewById(R.id.cardRow);
            this.cropName = itemView.findViewById(R.id.productVal);
            this.Quantity = itemView.findViewById(R.id.quantityVal);
            this.price = itemView.findViewById(R.id.priceVal);
            this.type = itemView.findViewById(R.id.typeVal);
        }
    }
}
