package com.mab.birthday;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnotherSurprise extends AppCompatActivity {
    private Button mNextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_surprise);
        mNextBtn=findViewById(R.id.nextbtn);
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean("IsFirstTime",false);
                Intent intent = new Intent(AnotherSurprise.this,ChatBox.class);
                startActivity(intent);
            }
        });

    }
}
