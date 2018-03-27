package com.mab.code_6;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView mPayloadList;
    private static ArrayList<Buyer> Buyerdata;
    private static ArrayList<Seller> Sellerdata;
    private static ArrayList<Card> data;
    static View.OnClickListener myOnClickListener;
    static View.OnClickListener buyerOnClickListener;
    static View.OnClickListener sellerOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPayloadList = findViewById(R.id.payloadList);
        mPayloadList.setHasFixedSize(true);
        mPayloadList.setLayoutManager(new LinearLayoutManager(this));
        mPayloadList.setItemAnimator(new DefaultItemAnimator());
        myOnClickListener = new MyOnClickListener(this);
        buyerOnClickListener = new BuyerOnClickListener(this);
        sellerOnClickListener = new SellerOnClickListener(this);
        data = new ArrayList<Card>();
        for (int i = 0; i < CardData.buyerArray.length; i++) {
            data.add(new Card(
                    CardData.cropName[i],
                    CardData.quantity[i],
                    CardData.sellerArray[i],
                    CardData.buyerArray[i],
                    CardData.price[i]
            ));
        }
        adapter = new CustomAdapter(data);
        mPayloadList.setAdapter(adapter);
    }
    private static class MyOnClickListener implements View.OnClickListener {
        private final Context context;
        
        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int pos = (int) v.getTag();
            Toast.makeText(context, pos+"", Toast.LENGTH_SHORT).show();
        }
    }
    private class BuyerOnClickListener implements View.OnClickListener {
        private final Context context;

        private BuyerOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            final AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(context);
            LayoutInflater layoutInflater = getLayoutInflater();
            final View buyerDetal = layoutInflater.inflate(R.layout.buyer_detail, null);
            dialogbuilder.setView(buyerDetal);
            dialogbuilder.setTitle("Buyer Detail");
            final EditText mEnterOTP;
            final Button mOTPBtn;
            mEnterOTP = v.findViewById(R.id.enterOTP);
            mOTPBtn = v.findViewById(R.id.OTPBtn);
            final AlertDialog buyerDetailDialog = dialogbuilder.create();
            buyerDetailDialog.show();
            /*mOTPBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, mEnterOTP.getText().toString()+"", Toast.LENGTH_SHORT).show();
                    buyerDetailDialog.dismiss();
                }
            });*/
        }
    }
    private class SellerOnClickListener implements View.OnClickListener {
        private final Context context;

        private SellerOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            final AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(context);
            LayoutInflater layoutInflater = getLayoutInflater();
            final View buyerDetal = layoutInflater.inflate(R.layout.seller_detail, null);
            dialogbuilder.setView(buyerDetal);
            dialogbuilder.setTitle("Seller Detail");
            final EditText mEnterOTP;
            final Button mOTPBtn;
            mEnterOTP = v.findViewById(R.id.enterOTP);
            mOTPBtn = v.findViewById(R.id.OTPBtn);
            final AlertDialog buyerDetailDialog = dialogbuilder.create();
            buyerDetailDialog.show();
            /*mOTPBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, mEnterOTP.getText().toString()+"", Toast.LENGTH_SHORT).show();
                    buyerDetailDialog.dismiss();
                }
            });*/
        }
    }
}
