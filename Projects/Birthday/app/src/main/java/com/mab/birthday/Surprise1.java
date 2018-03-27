package com.mab.birthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Surprise1 extends AppCompatActivity {
    private Button mSurprise1Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise1);
        mSurprise1Btn = findViewById(R.id.surpriseBtn);
        mSurprise1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Surprise1.this,Surprise2.class);
                startActivity(intent);
            }
        });
    }
}
