package com.example.katakuranatsumi.inventorycheckapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    public static interface  View.OnFocusChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
