package com.example.katakuranatsumi.inventorycheckapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewInventActivity extends AppCompatActivity {

    Button bt_save;
    int _inventID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_invent);

//      日付記入欄のクリックイベントのためのリスナー作成
        dateListener listener = new dateListener();
        EditText editDate = findViewById(R.id.inventDate);
        editDate.setOnClickListener(listener);

////      持ち物追加ボタンのクリックイベントのためのリスナー作成
//        ImageButton addInventButton = findViewById(R.id.add_invent);
//        addInventListener listener1 = new addInventListener();
//        addInventButton.setOnClickListener(listener1);

//      保存ボタンを取得
        bt_save = findViewById(R.id.bt_save);

    }

    private class dateListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
//            カレンダーダイアログを呼び出す処理
            CustomDialogFragment dialog = new CustomDialogFragment();
            dialog.show(getSupportFragmentManager(), "sample");
        }
    }

//    private class addInventListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            System.out.println("持ち物リスト追加");
//        }
//    }

//  [保存] ボタンを押した時のイベント
    public void onSaveButtonClick(View view){
//        タイトル欄を取得
        EditText titleText = findViewById(R.id.inventTitle);
        String title = titleText.getText().toString();

//        持ち物欄を取得
        EditText inventData = findViewById(R.id.newInvent);
        String invent = inventData.getText().toString();


//        データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(NewInventActivity.this);

//        データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
//        はじめに持ち物リストのデータを削除。そのあとINSERTを行う
//        削除用SQL文字列を用意
         String sqlDelete = "DELETE FROM inventlist WHERE _id = ?";

//         for (int i = -1; i < 0; ++i) {

////        SQL文字列を元にプリペアドステートメントを取得
         SQLiteStatement stmt = db.compileStatement(sqlDelete);
//        変数のバインド
        stmt.bindLong(1, _inventID);
        stmt.executeUpdateDelete();

//       インサート用SQL文字列の用意。
         String sqlInsert = "INSERT INTO inventlist VALUES (?, ?, ?)";
//       SQL文字列を元にプリペアドステートメントを取得
         stmt = db.compileStatement(sqlInsert);


//        変数のバインド
             stmt.bindLong(1, _inventID);
             stmt.bindString(2, title);
             stmt.bindString(3, invent);
//        インサートSQLの実行
             stmt.executeInsert();
//         }
       }
    finally {
        db.close();
       }
      }
}
