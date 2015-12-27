package com.thornbird.planhelper.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thornbird.planhelper.R;
import com.thornbird.planhelper.TBCamera.CameraActivity;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author yangli
 * @email yanglijd@gmail.com
 * @date 2015/12/06
 */
public class TimerFragment extends Fragment {


    public TimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_timer, container, false);
        View button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }


}
