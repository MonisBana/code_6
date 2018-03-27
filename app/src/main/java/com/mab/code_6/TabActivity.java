package com.mab.code_6;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import static com.mab.code_6.R.id.pager;
import static com.mab.code_6.R.menu.main_menu;
import static com.mab.code_6.R.id.action_add;

public class TabActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    static  AdapterView.OnItemClickListener mBuyListener;
    static  AdapterView.OnItemClickListener mSellListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

            //Adding toolbar to the activity
            Toolbar toolbar =findViewById(R.id.toolbar  );
            setSupportActionBar(toolbar);
            mBuyListener = new BuyOnItemClickListener(this);
            mSellListener = new SellOnItemClickListener(this);
            //Initializing the tablayout
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            /*Bundle extras = getIntent().getExtras();
            Tab1 tab1 = new Tab1();
            tab1.setArguments(extras);
            getSupportFragmentManager().beginTransaction().commit();
            if(extras != null){
                Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
            }*/
            //Adding the tabs using addTab() method
            tabLayout.addTab(tabLayout.newTab().setText("Farmer"));
            tabLayout.addTab(tabLayout.newTab().setText("Merchant"));
            //tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            //Initializing viewPager
            viewPager = (ViewPager) findViewById(R.id.pager);

            //Creating our pager adapter
            Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

            //Adding adapter to pager
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

            //Adding onTabSelectedListener to swipe views
            tabLayout.setOnTabSelectedListener(this);

        }
    private class BuyOnItemClickListener implements AdapterView.OnItemClickListener{
        private final Context context;

        private BuyOnItemClickListener(Context context) {
            this.context = context;
        }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(TabActivity.this,BuyerDetail.class);
            startActivity(intent);
        }
    }
    private class SellOnItemClickListener implements AdapterView.OnItemClickListener{
        private final Context context;

        private SellOnItemClickListener(Context context) {
            this.context = context;
        }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(TabActivity.this,SellerDetail.class);
            startActivity(intent);
        }
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

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
           Intent intent =  new Intent(TabActivity.this,Splash.class);
           intent.putExtra("Priority",0);
           startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
