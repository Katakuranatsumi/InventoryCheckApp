package com.example.katakuranatsumi.inventorycheckapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListDatail extends Fragment {

    //    このフラグメントが所蔵するアクティビティオブジェクト
    private Activity _parentActivity;
    int _inventID;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
//       親クラスのonCreateの呼び出し
        super.onCreate(savedInstanceState);
//       所属するアクティビティオブジェクトを取得
        _parentActivity = getActivity();

        Intent intent = _parentActivity.getIntent();
        Bundle extras;
        extras = intent.getExtras();

        String title = extras.getString("title");

        Log.d("インベントタイトル", title);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list_datail, container, false);
    }

}
