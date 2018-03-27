package com.mab.birthday;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Surprise2 extends AppCompatActivity {
    private Button mDoneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise2);
        mDoneBtn =findViewById(R.id.surpriseBtn);
        mDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isfirsttime=PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("IsFirstTime",true);
                Log.d("FFHIRST",isfirsttime+"");
                if(isfirsttime == true) {
                    Intent firstintent = new Intent(Surprise2.this, AnotherSurprise.class);
                    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean("IsFirstTime",false).apply();
                    startActivity(firstintent);
                }
                else
                {
                    Intent otherintent = new Intent(Surprise2.this,MainActivity.class);
                    startActivity(otherintent);
                }
            }
        });
    }
}
