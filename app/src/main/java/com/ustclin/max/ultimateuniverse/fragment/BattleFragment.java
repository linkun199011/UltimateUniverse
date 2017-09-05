package com.ustclin.max.ultimateuniverse.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustclin.max.ultimateuniverse.R;

public class BattleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.battle_layout, container, false);
        Log.e("BattleFragment", "mActivity = null");
        return view;
    }
}
