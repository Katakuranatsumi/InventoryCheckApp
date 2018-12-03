package com.example.katakuranatsumi.inventorycheckapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewInventActivity extends AppCompatActivity {

    private LinearLayout layout;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_invent);

//      日付記入欄のクリックイベントのためのリスナー作成
        EditText editdate = findViewById(R.id.inventdate);
        dateListener listener = new dateListener();
        editdate.setOnClickListener(listener);

//      持ち物追加ボタンのクリックイベントのためのリスナー作成
        ImageButton addInventButton = findViewById(R.id.add_invent);
        addInventListener listener1 = new addInventListener();
        addInventButton.setOnClickListener(listener1);

//        LinearLayout　インスタンス作成
        layout = findViewById(R.id.Linear_Layout);
        setContentView(layout);
//        TextView　インスタンス作成
        editText = new EditText(this);
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        editText.setLayoutParams(editTextParams);
        layout.addView(editText);
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
////              持ち物リストを追加する処理
//            layout.addView(editText);
        }
    }
}