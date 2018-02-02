package com.hpl.howlong.toolkit;

import android.text.Editable;
import android.widget.EditText;

/**
 * Created by Hpl on 2018/2/1 0001.
 */

public class ViewValue {
    public static boolean empty(EditText editText) {
        Editable text = editText.getText();
        return text == null || text.length() == 0;
    }

    public static int getInt(EditText editText, int defaultValue) {
        if (empty(editText)) return defaultValue;
        return Integer.parseInt(editText.getText().toString());
    }

    public static String getStr(EditText editText, String defaultValue){
        if (empty(editText)) return defaultValue;
        return editText.getText().toString();
    }

}
