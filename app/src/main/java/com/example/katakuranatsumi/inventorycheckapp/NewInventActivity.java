package com.example.katakuranatsumi.inventorycheckapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewInventActivity extends AppCompatActivity {

    Button bt_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_invent);

//      日付記入欄のクリックイベントのためのリスナー作成
        EditText editdate = findViewById(R.id.inventdate);
        dateListener listener = new dateListener();
        editdate.setOnClickListener(listener);

//      持ち物追加ボタンのクリックイベントのためのリスナー作成
        ImageButton addInventButton = findViewById(R.id.add_invent);
        addInventListener listener1 = new addInventListener();
        addInventButton.setOnClickListener(listener1);

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

    private class addInventListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            System.out.println("持ち物リスト追加");
////              持ち物リストを追加する処理
//            layout.addView(editText);
        }
    }

//  [保存] ボタンを押した時のイベント
    public void onSaveButtonClick(View view){
//        タイトル欄を取得
        EditText titleText = findViewById(R.id.inventTitle);
        String title = titleText.getText().toString();

//        データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(NewInventActivity.this);

//        データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
    }

}
