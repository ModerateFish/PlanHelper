package com.thornbird.planhelper.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thornbird.planhelper.AppLog;
import com.thornbird.planhelper.R;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author yangli
 * @email yanglijd@gmail.com
 * @date 2015/12/06
 */
public class SettingFragment extends PreferenceFragment {
    private static final String TAG = "SettingFragment";

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AppLog.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        AppLog.d(TAG, "onCreateView()");
//        // Inflate the layout for this fragment
//        // return inflater.inflate(R.layout.fragment_setting, container, false);
//    }


}
