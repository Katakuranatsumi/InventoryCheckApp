package com.example.katakuranatsumi.inventorycheckapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    public static interface  View.OnFocusChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListViewオブジェクトを取得
        ListView inventList = findViewById(R.id.inventList);

//        リストビューに表示するリストビュー用Listオブジェクトを作成
        List<String> invent_list = new ArrayList<>();

//          リストデータの登録
        invent_list.add("遠足");
        invent_list.add("スケート");

//        アダプタオブジェクトを生成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,
                invent_list);

//        リストビューにアダプタオブジェクトを生成
        inventList.setAdapter(adapter);

        ImageButton button = findViewById(R.id.imageButton2);
        focusListener listener = new focusListener();
        button.setOnClickListener(listener);
    }

//    新規登録ボタンをクリックした時のリスナクラス
    private class focusListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
//        クリックしたらカレンダーダイアログが表示される処理
            CustomDialogFragment dialog = new CustomDialogFragment();
            dialog.show(getSupportFragmentManager(), "sample");
    }
}
}
