package com.example.siddhant.bludiary;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.CameraCharacteristics;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DiaryDB  extends SQLiteOpenHelper {

    public static final String DB_TABLE="diary_db";
    private static final String DB_NAME="diary2331 .db";
    public static final String KEY_HEADING="heading";
    public static final String KEY_DESC="desc_";
    public static final String KEY_USER="user";
    private static final int DB_VERSION=1;

    public DiaryDB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlDiary = "CREATE TABLE IF NOT EXISTS diary_db(heading VARCHAR(255), desc_ VARCHAR(255),user VARCHAR(255) );";
        db.execSQL(sqlDiary);
    }

    public void addData(String head, String desc,String user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_HEADING, head);
        contentValues.put(KEY_DESC, desc);
        contentValues.put(KEY_USER,user);
        db.insert(DB_TABLE, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDiary = "DROP TABLE IF EXISTS diary_db";

        db.execSQL(sqlDiary);
    }
    public List<DiaryModel> getdata(String us_){
        List<DiaryModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM diary_db WHERE user = '"+us_+"'", null);
        StringBuilder stringBuffer = new StringBuilder();
        DiaryModel diaryModel;
        while (cursor.moveToNext()){
            diaryModel = new DiaryModel();
            String heading = cursor.getString(cursor.getColumnIndexOrThrow(KEY_HEADING));
            String desc = cursor.getString(cursor.getColumnIndexOrThrow(KEY_DESC));
            diaryModel.setHeading(heading);
            diaryModel.setDesc(desc);
            stringBuffer.append(diaryModel);
            data.add(diaryModel);
        }
        return data;
    }
    public boolean deleteData(String heading){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DB_TABLE,KEY_HEADING +"=?",new String[]{heading}) > 0;
    }
    public List<DiaryModel> searchData(String srchTerm,String us_s){
        List<DiaryModel> data2=new ArrayList<>();
        SQLiteDatabase db1 = this.getWritableDatabase();
        String sql="SELECT * FROM "+DB_TABLE+" WHERE "+KEY_HEADING+" LIKE '"+srchTerm+"%' AND user = '"+us_s+"'";
        Cursor cursor2 =db1.rawQuery(sql,null);
        StringBuilder stringBuffer2;
        stringBuffer2 = new StringBuilder();
        DiaryModel diaryModel2;
        while (cursor2.moveToNext()){
            diaryModel2 = new DiaryModel();
            String heading = cursor2.getString(cursor2.getColumnIndexOrThrow("heading"));
            String desc = cursor2.getString(cursor2.getColumnIndexOrThrow("desc_"));
            diaryModel2.setHeading(heading);
            diaryModel2.setDesc(desc);
            stringBuffer2.append(diaryModel2);
            data2.add(diaryModel2);
        }
        return data2;
    }

}
