package com.example.katakuranatsumi.inventorycheckapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class NewInventActivity extends AppCompatActivity {

    Button bt_save;
    int _inventID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_invent);

//      日付記入欄のクリックイベントのためのリスナー作成
        dateListener listener = new dateListener();
        EditText editDate = findViewById(R.id.inventTime);
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

//  [保存] ボタンを押した時のイベント
    public void onSaveButtonClick(View view){
//        タイトル欄を取得
        EditText titleText = findViewById(R.id.inventTitle);
        String title = titleText.getText().toString();

//        日付データを取得
        EditText dateText = findViewById(R.id.inventTime);
        String date = dateText.getText().toString();

//        持ち物欄を取得
        EditText inventData = findViewById(R.id.newInvent);
        String invent = inventData.getText().toString();


//        データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(NewInventActivity.this);

//        データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();

//        トランザクションの開始
        db.beginTransaction();

        try {
//       インサート用SQL文字列の用意。
         String sqlInsert = "INSERT INTO inventlist (title, invent ,date) VALUES (?, ?, ?)";
//       SQL文字列を元にプリペアドステートメントを取得
         SQLiteStatement stmt = db.compileStatement(sqlInsert);

//        変数のバインド
            stmt.bindString(1, title);
            stmt.bindString(2, invent);
            stmt.bindString(3, date);
//        インサートSQLの実行
            stmt.executeInsert();
//        トランザクションへのコミット
            db.setTransactionSuccessful();

//        Toastの設置
            Toast toast = Toast.makeText(this, "保存が完了しました", Toast.LENGTH_LONG);
            toast.show();

//         TOP画面に戻る処理
            finish();
       }
        finally {
//        トランザクションの終了
        db.endTransaction();
        db.close();
       }
      }
}
