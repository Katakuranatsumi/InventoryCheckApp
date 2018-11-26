package com.example.katakuranatsumi.inventorycheckapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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

//        フラグメントで表示する画面をXMLファイルからインフレートする
        View view = inflater.inflate(R.layout.fragment_invent_list, container, false);

//        ListViewオブジェクトを取得
        ListView inventList = view.findViewById(R.id.inventList);

//        リストビューに表示するリストビュー用Listオブジェクトを作成
        List<Map<String, String>> invent_list = new ArrayList<>();

        Map<String, String> list = new HashMap<>();

//        リストデータの登録
        list = new HashMap<>();
        list.put("plans", "遠足");
        list.put("date", "2018年10月9日");
        invent_list.add(list);

//        SimpleAdapter第4引数from用データの用意
        String[] from = {"plans", "date"};

//        SimpleAdapter第5引数to用データの用意
        int[] to = {android.R.id.text1, android.R.id.text2};

//        アダプタオブジェクトを生成
        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, invent_list, android.R.layout.simple_list_item_2,
                from, to);
//        リストビューにアダプタオブジェクトを生成
        inventList.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;

    }

}
