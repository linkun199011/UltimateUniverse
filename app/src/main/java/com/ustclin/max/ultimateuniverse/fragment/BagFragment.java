package com.ustclin.max.ultimateuniverse.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustclin.max.ultimateuniverse.R;

public class BagFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bag_layout, container, false);
        Log.e("BagFragment", "mActivity = null");
        return view;
    }
}
