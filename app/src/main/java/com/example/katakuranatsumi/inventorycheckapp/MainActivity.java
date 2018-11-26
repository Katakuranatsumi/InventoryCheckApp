package com.example.katakuranatsumi.inventorycheckapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    public static interface  View.OnFocusChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

////        ListViewオブジェクトを取得
//        ListView inventList = findViewById(R.id.inventList);
//
////        リストビューに表示するリストビュー用Listオブジェクトを作成
//        List<Map<String, String>> invent_list = new ArrayList<>();
//
//        Map<String, String> list = new HashMap<>();
//
////        リストデータの登録
//        list = new HashMap<>();
//        list.put("plans","遠足");
//        list.put("date", "2018年10月9日");
//        invent_list.add(list);
//
////        SimpleAdapter第4引数from用データの用意
//        String[] from = {"plans", "date"};
//
////        SimpleAdapter第5引数to用データの用意
//        int[] to = {android.R.id.text1, android.R.id.text2};
//
////        アダプタオブジェクトを生成
//        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, invent_list, android.R.layout.simple_list_item_2,
//                 from, to);
////        リストビューにアダプタオブジェクトを生成
//        inventList.setAdapter(adapter);

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
