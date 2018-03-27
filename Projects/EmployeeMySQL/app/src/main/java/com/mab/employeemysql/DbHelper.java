package com.mab.employeemysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MonisBana on 3/3/2018.
 */

public class DbHelper extends SQLiteOpenHelper{
    Context context;
    SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, "studdb", null, 1);
        this.context=context;
        db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table stud(id integer primary key,name text,dept text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void AddStudent(Student s){
        ContentValues cv = new ContentValues();
        cv.put("id",s.getId());
        cv.put("name",s.getName());
        cv.put("dept",s.getDepartment());

        long rid = db.insert("stud",null,cv);

        if(rid<0){
            Toast.makeText(context, "Insert issues", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
        }
    }
    public void UpdateStudent(Student s){
        ContentValues cv = new ContentValues();
        cv.put("id",s.getId());
        cv.put("name",s.getName());
        cv.put("dept",s.getDepartment());

        long nor = db.update("stud",cv,"id="+s.getId(),null);
        Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
    }
    public void DeleteStudent(Student s){
        long nor = db.delete("stud","id="+s.getId(),null);
        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
    }
    public List<Student> getAllEntries(){
        List<Student> studlist = new ArrayList<Student>();
        String selectQuery = "SELECT  * FROM " + "stud";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {

            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setDepartment(cursor.getString(2));
                studlist.add(student);
            }while (cursor.moveToNext());
        }
        return studlist;
    }
}
