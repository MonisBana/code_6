package com.mab.mongodbcloud;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mab.mongodbcloud.Class.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lstView;
    Button btnAdd,btnEdit,btnDelete;
    EditText edtUser;
    User UserSelected = null;
    List<User> users = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView = findViewById(R.id.lstView);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        edtUser = findViewById(R.id.edtUsername);

        new GetData().execute(Common.getAddressAPI());
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserSelected = users.get(i);
                edtUser.setText(UserSelected.getUser());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PostData(edtUser.getText().toString()).execute(Common.getAddressAPI());
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PutData(edtUser.getText().toString()).execute(Common.getAddressSingle(UserSelected));
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DeleteData(UserSelected).execute(Common.getAddressSingle(UserSelected));
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
    class GetData  extends AsyncTask<String,Void,String>
    {
        ProgressDialog pd = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Please Wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];
            HTTPDataHandler http = new HTTPDataHandler();
            stream = http.GetHTTPData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<User>>(){}.getType();
            users = gson.fromJson(s,listType);
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(),users);
            lstView.setAdapter(adapter);
            pd.dismiss();
        }
    }
    class PostData extends AsyncTask<String,Void,String>{
        String userName;

        public PostData(String userName) {
            this.userName = userName;
        }

        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Please Wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
           String urlString = strings[0];

           HTTPDataHandler hh = new HTTPDataHandler();
           String json = "{\"user\":\""+userName+"\"}";
           hh.PostHTTPData(urlString,json);
           return "";
    }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            new GetData().execute(Common.getAddressAPI());
            pd.dismiss();
        }
    }

    class PutData extends AsyncTask<String,Void,String>{
        String userName;

        public PutData(String userName) {
            this.userName = userName;
        }

        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Please Wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String urlString = strings[0];

            HTTPDataHandler hh = new HTTPDataHandler();
            String json = "{\"user\":\""+userName+"\"}";
            hh.PutHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            new GetData().execute(Common.getAddressAPI());
            pd.dismiss();
        }
    }

    class DeleteData extends AsyncTask<String,Void,String>{
        User user;

        public DeleteData(User user) {
            this.user = user;
        }

        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Please Wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String urlString = strings[0];

            HTTPDataHandler hh = new HTTPDataHandler();
            String json = "{\"user\":\""+user.getUser()+"\"}";
            hh.DeleteHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            new GetData().execute(Common.getAddressAPI());
            pd.dismiss();
        }
    }
}
