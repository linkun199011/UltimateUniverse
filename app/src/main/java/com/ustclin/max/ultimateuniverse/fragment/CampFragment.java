package com.ustclin.max.ultimateuniverse.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ustclin.max.ultimateuniverse.R;

public class CampFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camp_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textTest);
        Spannable wordToSpan = new SpannableString("I know just how to whisper, \n" +
                "And I know just how to cry, \n" +
                "I know just where to find the answers.");
        wordToSpan.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordToSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 15, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordToSpan.setSpan(new ForegroundColorSpan(Color.GREEN), 30, 40, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(wordToSpan);
        Log.e("CampFragment", "mActivity = null");
        return view;
    }

}
