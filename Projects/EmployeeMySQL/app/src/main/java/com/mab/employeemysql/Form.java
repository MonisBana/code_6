package com.mab.employeemysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Form extends AppCompatActivity {
    private EditText mIdVal,mNameVal;
    private Spinner mDeptVal;
    private Button mAddBtn;
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        mIdVal = findViewById(R.id.idVal);
        mNameVal = findViewById(R.id.nameVal);
        mDeptVal = findViewById(R.id.deptVal);
        mAddBtn = findViewById(R.id.addBtn);
        String[] items = new String[]{"IT", "CS", "EXTC","MECH"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mDeptVal.setAdapter(adapter);
        db=new DbHelper(this);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mIdVal.getText().toString();
                String name = mNameVal.getText().toString();
                String dept = mDeptVal.getSelectedItem().toString();
                Toast.makeText(Form.this, dept+"", Toast.LENGTH_SHORT).show();

                Student s = new Student(Integer.parseInt(id),name,dept);
                db.AddStudent(s);
                mIdVal.setText("");
                mNameVal.setText("");
            }
        });

    }
}
