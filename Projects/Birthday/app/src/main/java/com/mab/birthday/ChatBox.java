package com.mab.birthday;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.HashMap;

public class ChatBox extends AppCompatActivity {
    private RecyclerView mChatList;
    private DatabaseReference mDatabaseReference;
    private String Username;
    private EditText mWriteMsg;
    private ImageButton mSendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);
        mChatList = findViewById(R.id.chatList);
        mChatList.setHasFixedSize(true);
        mChatList.setLayoutManager(new LinearLayoutManager(this));
        mWriteMsg = findViewById(R.id.writeMsg);
        mSendBtn = findViewById(R.id.sendBtn);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Msg");
        boolean isfirsttime= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("IsFirsttime",true);
        Username = "Aliza";
        if(isfirsttime == true){
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean("IsFirsttime",false).apply();
            final AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("Chat App")
                    .setMessage("The Second surprise is a Chat app where we can chat the best part is that you won't get notifications when you recieve messages")
                    .setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                                                  }
                    })
                    .setIcon(R.drawable.ic_cake_white_24dp)
                    .show();

        }
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Msg = String.valueOf(mWriteMsg.getText());
                HashMap<String,String> datamap = new HashMap<>();
                datamap.put("Username", Username);
                datamap.put("Msg",Msg);
                mDatabaseReference.push().setValue(datamap);
                mWriteMsg.setText("");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Msg, MsgViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Msg, MsgViewHolder>(
                Msg.class,
                R.layout.msg,
                MsgViewHolder.class,
                mDatabaseReference
        ) {
            @Override
            protected void populateViewHolder(final MsgViewHolder viewHolder, Msg model,int position) {
                final String post_key = getRef(position).getKey();
                viewHolder.setName(model.getUsername());
                viewHolder.setMsg(model.getMsg());
                mDatabaseReference.child(post_key).addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(DataSnapshot dataSnapshot) {
                      if(dataSnapshot.child("Username").getValue().equals(Username)) {
                          RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.MATCH_PARENT);
                          params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                          viewHolder.mCardView.setContentPadding(30,5,15,5);
                          viewHolder.mCardView.setLayoutParams(params);
                          viewHolder.mCardView.setForegroundGravity(Gravity.RIGHT);
                          viewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                          viewHolder.mMsgField.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                          viewHolder.mNameField.setTextColor(getResources().getColor(R.color.white));
                          viewHolder.mMsgField.setTextColor(getResources().getColor(R.color.white));

                      }
                      else{
                          RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.MATCH_PARENT);
                          params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                          viewHolder.mCardView.setContentPadding(15,5,30,5);
                          viewHolder.mCardView.setLayoutParams(params);
                          viewHolder.mCardView.setForegroundGravity(Gravity.LEFT);
                          viewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.GrayColor));
                          viewHolder.mMsgField.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                          viewHolder.mNameField.setTextColor(getResources().getColor(R.color.Black));
                          viewHolder.mMsgField.setTextColor(getResources().getColor(R.color.Black));

                      }
                  }

                  @Override
                  public void onCancelled(DatabaseError databaseError) {

                  }
              });
              viewHolder.mView.setOnLongClickListener(new View.OnLongClickListener() {
                  @Override
                  public boolean onLongClick(View v) {
                      final AlertDialog.Builder builder;
                      builder = new AlertDialog.Builder(ChatBox.this,android.R.style.Theme_Material_Dialog_Alert);
                      builder.setTitle("Delete Message")
                              .setMessage("You wanna delete this text?")
                              .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog, int which) {
                                      mDatabaseReference.child(post_key).removeValue();
                                  }
                              })
                              .setNegativeButton("Cancel",null)
                              .setIcon(android.R.drawable.ic_dialog_alert)
                              .show();
                      return false;
                  }

              });
            }
        };
        mChatList.setAdapter(firebaseRecyclerAdapter);
    }
        public static class MsgViewHolder extends RecyclerView.ViewHolder {
            View mView;
            TextView mMsgField;
            TextView mNameField ;
            CardView mCardView;
            public MsgViewHolder(View itemView) {
                super(itemView);
                 mView = itemView;
                mCardView=mView.findViewById(R.id.msgCard);
                mMsgField= mView.findViewById(R.id.MsgField);
                mNameField = mView.findViewById(R.id.NameField);
            }
            public void setName(String Username){
                TextView name = (TextView) mView.findViewById(R.id.NameField);
                name.setText(Username);
            }
            public void setMsg(String Msg){
                TextView msg = (TextView) mView.findViewById(R.id.MsgField);
                msg.setText(Msg);
            }
        }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChatBox.this,ChatBox.class);
        startActivity(intent);
        super.onBackPressed();
    }
}

