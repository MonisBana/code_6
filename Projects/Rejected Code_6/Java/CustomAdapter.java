package com.mab.code_6;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MonisBana on 3/7/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<Card> cardset;

    public CustomAdapter(ArrayList<Card> cardset) {
        this.cardset = cardset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);
        view.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView CropName = holder.cropName;
        TextView Quantity = holder.Quantity;
        TextView SellarName = holder.sellerName;
        TextView BuyerName = holder.buyerName;
        TextView Price = holder.price;
        CardView cardView = holder.mCardView;
        Button BuyerBtn = holder.mBuyerButton;
        Button SellarBtn = holder.mSellarBtn;
        Button OTPBtn = holder.OTPBtn;

        cardView.setTag(position);
        CropName.setText(cardset.get(position).getCropName());
        Quantity.setText(cardset.get(position).getQuantity()+"");
        SellarName.setText(cardset.get(position).getSellarName());
        BuyerName.setText(cardset.get(position).getBuyerName());
        Price.setText(cardset.get(position).getPrice()+"");
        cardView.setOnClickListener(MainActivity.myOnClickListener);
        BuyerBtn.setOnClickListener(MainActivity.buyerOnClickListener);
        SellarBtn.setOnClickListener(MainActivity.sellerOnClickListener);
    }

    @Override
    public int getItemCount() {
        return cardset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cropName,Quantity,sellerName,buyerName,price;
        public CardView mCardView;
        public Button mBuyerButton,mSellarBtn,OTPBtn;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.OTPBtn = itemView.findViewById(R.id.OTPBtn);
            this.mBuyerButton = itemView.findViewById(R.id.buyerBtn);
            this.mSellarBtn = itemView.findViewById(R.id.sellerBtn);
            this.mCardView = itemView.findViewById(R.id.cardRow);
            this.cropName = itemView.findViewById(R.id.productVal);
            this.Quantity = itemView.findViewById(R.id.quantityVal);
            this.sellerName = itemView.findViewById(R.id.sellerVal);
            this.buyerName = itemView.findViewById(R.id.buyerVal);
            this.price = itemView.findViewById(R.id.priceVal);
        }
    }
}
