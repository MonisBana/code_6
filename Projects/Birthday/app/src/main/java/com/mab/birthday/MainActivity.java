package com.mab.birthday;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView mDaysToGo,mTextView;
    private ImageButton mMsgBtn,mChatBtn;
    private LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMsgBtn=findViewById(R.id.messageBtn);
        mChatBtn=findViewById(R.id.chatBtn);
        mTextView=findViewById(R.id.textView1);
        mLinearLayout=findViewById(R.id.L1);
        Calendar cal = Calendar.getInstance();
        int CurrentDay = cal.get(Calendar.DAY_OF_MONTH);
        int CurrentMonth = cal.get(Calendar.MONTH) + 1;
        int DaysToGo = (27 - CurrentDay );//+ ((12-CurrentMonth+11) * 30) ;
        mDaysToGo =findViewById(R.id.daysToGO);
        mDaysToGo.setText(DaysToGo+"");
        boolean isfirsttime=PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("IsfirstTime",true);
        if(DaysToGo > 0 && CurrentMonth == 11) {
            final AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("WAIT")
                    .setMessage("Its not your Birthday yet")
                    .setPositiveButton("ohhk", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        if(DaysToGo==0 && isfirsttime == true && CurrentMonth==11){
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean("IsfirstTime",false).apply();
            final AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("Happy Birthday")
                    .setMessage("Yay It's your Birthday")
                    .setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent surpriseIntent = new Intent(MainActivity.this,Surprise1.class);
                        startActivity(surpriseIntent);
                        }
                    })
                    .setIcon(R.drawable.ic_cake_white_24dp)
                    .show();
        }
        if(DaysToGo < 0 || CurrentMonth != 11){
            mDaysToGo.setVisibility(View.GONE);
            mTextView.setVisibility(View.GONE);
            RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.removeRule(RelativeLayout.BELOW);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            mLinearLayout.setLayoutParams(params);
            mMsgBtn.setVisibility(View.VISIBLE);
            mChatBtn.setVisibility(View.VISIBLE);
        }
        if(isfirsttime == false){
            mMsgBtn.setVisibility(View.VISIBLE);
            mChatBtn.setVisibility(View.VISIBLE);
        }
        mMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surpriseintent =new Intent(MainActivity.this,Surprise1.class);
                startActivity(surpriseintent);
            }
        });
        mChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatintent = new Intent(MainActivity.this,ChatBox.class);
                startActivity(chatintent);
            }
        });
    }
}
