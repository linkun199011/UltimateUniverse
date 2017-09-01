package com.ustclin.max.ultimateuniverse;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View messageLayout = inflater.inflate(R.layout.message_layout,
				container, false);
		//
		TextView textView = (TextView) messageLayout.findViewById(R.id.brand);
		String brand = Build.BRAND;
		if (brand != null) {
			textView.setText("设备名称为： " + brand);
		} else {
			textView.setText("找不到该设备名称");
		}
		return messageLayout;
	}

}
