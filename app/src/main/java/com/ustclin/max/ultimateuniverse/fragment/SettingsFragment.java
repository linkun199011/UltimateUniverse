package com.ustclin.max.ultimateuniverse.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustclin.max.ultimateuniverse.R;

public class SettingsFragment extends Fragment {

    private Activity mActivity;

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_layout, container, false);
        Log.e("settingFragment", "mActivity = null");
        return view;
    }
}
