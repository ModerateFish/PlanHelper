package com.thornbird.planhelper.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;

import com.thornbird.planhelper.AppLog;
import com.thornbird.planhelper.R;
import com.thornbird.planhelper.fragment.SettingFragment;
import com.thornbird.planhelper.fragment.TimerFragment;

/**
 * MainActivity
 *
 * @author yangli
 * @email yanglijd@gmail.com
 * @date 2015/12/06
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Layout mFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppLog.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            Fragment fragment = new TimerFragment();
            fragment.setArguments(getIntent().getExtras());
            transaction.add(R.id.fragment_container, fragment);
//            fragment = new SettingFragment();
//            fragment.setArguments(getIntent().getExtras());
//            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        AppLog.d(TAG, "onCreateView()");
        View view = super.onCreateView(parent, name, context, attrs);
        return view;
    }
}
