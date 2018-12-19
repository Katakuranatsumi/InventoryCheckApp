package com.example.katakuranatsumi.inventorycheckapp;


import android.app.Activity;
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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListDatail extends Fragment {

    //    このフラグメントが所蔵するアクティビティオブジェクト
    private Activity _parentActivity;
    private int _inventID;

    private String title = "";
    private String date = "";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
//       親クラスのonCreateの呼び出し
        super.onCreate(savedInstanceState);
//       所属するアクティビティオブジェクトを取得
        _parentActivity = getActivity();

        Intent intent = _parentActivity.getIntent();
        Bundle extras;
        extras = intent.getExtras();

        title = extras.getString("title");
        date = extras.getString("date");
        _inventID = extras.getInt("position");
        _inventID = _inventID + 1;

        Log.d("インベントタイトル", title);
        Log.d("インベント日付", date);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_datail, container, false);

//      データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(_parentActivity);
//      データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
//      主キーによる検索SQL文字列の用意
            String sql = "SELECT * FROM inventlist WHERE _id = ?";
            String[] params = {String.valueOf(_inventID)};
//      SQLの実行
            Cursor cursor = db.rawQuery(sql, params);

            String invent = "";

            boolean isEofF = cursor.moveToNext();

//      SQL実行の戻り値であるカーソルオブジェクトをループさせてデータベース内のデータを取得
        while (isEofF) {
//         選択したリストのインデックス値を取得
                int inventIndex = cursor.getColumnIndex("invent");
                invent = cursor.getString(inventIndex);
                Log.d("持ち物リスト", invent);

//              一回でループを止めるためisEofFをfalseに設定
                isEofF = false;
            }
            TextView listInvent = view.findViewById(R.id.list_invent);
            listInvent.setText(invent);
            }
            finally{
                db.close();
            }

//      Top画面で選択したタイトルのデータを取得
        TextView listTitle = view.findViewById(R.id.list_title);
        listTitle.setText(title);

//      Tp画面で選択した日付データの取得
        TextView listDate = view.findViewById(R.id.list_date);
        listDate.setText(date);

        return view;
    }

}
