package com.example.katakuranatsumi.inventorycheckapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class CustomDialogFragment extends DialogFragment {

    @NonNull

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

//        今日の日付のカレンダーのインスタンスを取得
        final Calendar calendar = Calendar.getInstance();

//       ビルダーの生成
        DatePickerDialog dateBuilder = new DatePickerDialog(
                getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        選択された年・月・日を整形
                        String dateStr = year + "年" + (month + 1) + "月" + dayOfMonth + "日";

//                        MainActivityのインスタンスを取得
//                          MainActivity mainActivity = (MainActivity) getActivity();
//                          mainActivity.setTitle(dateStr);

                          NewInventActivity newInventActivity = (NewInventActivity) getActivity();
                          EditText editDate = newInventActivity.findViewById(R.id.inventdate);
                          editDate.setText(dateStr);

                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        return dateBuilder;
    }
}
