package com.example.katakuranatsumi.inventorycheckapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventListFragment extends Fragment {

//    このフラグメントが所蔵するアクティビティオブジェクト
    private Activity _parentActivity;
    int _inventID;

    //     データベースから取得した値を格納する変数の用意。データがなかった時のための初期値も用意
    private String title = "データなし";
    private String date = "日付なし";

    private List<MyListItem> items;
    protected MyListItem myListItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

//      親クラスのonCreate()の呼び出し
        super.onCreate(savedInstanceState);

//      所属するアクティビティオブジェクトを取得
        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //   データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(_parentActivity);
//     データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
//        フラグメントで表示する画面をXMLファイルからインフレートする
        View view = inflater.inflate(R.layout.fragment_invent_list, container, false);
//        ListViewオブジェクトを取得
        ListView inventList = view.findViewById(R.id.inventList);

//        リスナクラスの登録
        inventList.setOnItemClickListener(new ListItemClickListener());

//        リストビューに表示するリストビュー用Listオブジェクトを作成
        List<Map<String, String>> invent_list = new ArrayList<>();

        Map<String, String> list = new HashMap<>();

       try {
//     主キーによる検索SQL文字列の用意
           String sql = "SELECT * FROM inventlist";

//     SQLの実行
           Cursor cursor = db.rawQuery(sql, null);

           int rowcount = cursor.getCount();
           StringBuffer sb = new StringBuffer();
           boolean isEofF = cursor.moveToFirst();

//     SQL実行の戻り値であるカーソルオブジェクトをループさせてデータベース内のデータを取得
           while (isEofF) {
//     カラムのインデックス値を取得
               int idxTitle = cursor.getColumnIndex("title");
               int idxDate = cursor.getColumnIndex("date");
//     カラムのインデックス値を元に実際のデータを取得
                   title = cursor.getString(1);
                   date = cursor.getString(3);
                   list = new HashMap<>();
                   list.put("plans", title);
                   list.put("date", date);
                   invent_list.add(list);
                   Log.d("タイトル", title);

                   isEofF = cursor.moveToNext();
           }
       }finally {
//　　　データベース接続オブジェクトの解放
       db.close();

       }

//        SimpleAdapter第4引数from用データの用意
        String[] from = {"plans", "date"};
//        SimpleAdapter第5引数to用データの用意
        int[] to = {android.R.id.text1, android.R.id.text2};
//        アダプタオブジェクトを生成
        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, invent_list, android.R.layout.simple_list_item_2, from, to);
//        リストビューにアダプタオブジェクトを生成
        inventList.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;

        }

//  リストをタップした時のリスナクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        インテントオブジェクトを作成
         Intent intent = new Intent(_parentActivity, ListDetailActivity.class);
//        リスト詳細画面を起動
         startActivity(intent);
        }
    }

}
