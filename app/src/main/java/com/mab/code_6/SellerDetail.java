package com.mab.code_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.mab.code_6.R.id.action_add;
import static com.mab.code_6.R.menu.main_menu;

public class SellerDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_detail);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(main_menu,menu);
        menu.findItem(R.id.action_add).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == action_add){
            Intent intent =  new Intent(SellerDetail.this,Splash.class);
            intent.putExtra("Priority",1);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
