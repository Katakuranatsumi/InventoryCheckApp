package com.example.katakuranatsumi.inventorycheckapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

//    データベースファイル名の定数フィールド
    private static final String DATABASE_NAME = "inventlist.db";

//    バージョン情報の定数フィールド
    private static final int DATABASE_VARSION = 1;

//    コンストラクタ
    public DatabaseHelper(Context context) {
//    親クラスのコンストラクタの呼び出し
      super(context, DATABASE_NAME, null , DATABASE_VARSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
//        テーブル作成用SQL文字列の作成。
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE inventlist(");
        sb.append("_id INTEGER PRIMARY KEY,");
        sb.append("name TEXT,");
        sb.append("note TEXT");
        sb.append(");");
        String sql = sb.toString();

//        SQLの実行
        db.execSQL(sql);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
