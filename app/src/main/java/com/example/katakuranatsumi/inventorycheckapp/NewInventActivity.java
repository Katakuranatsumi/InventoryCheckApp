package com.example.katakuranatsumi.inventorycheckapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewInventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_invent);

        EditText editdate = findViewById(R.id.inventdate);
        dateListener listener = new dateListener();
        editdate.setOnClickListener(listener);
    }

    private class dateListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
//            カレンダーダイアログを呼び出す処理
            CustomDialogFragment dialog = new CustomDialogFragment();
            dialog.show(getSupportFragmentManager(), "sample");
        }
    }


}
