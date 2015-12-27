package com.thornbird.planhelper.TBCamera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.thornbird.planhelper.R;

public class CameraActivity extends AppCompatActivity {
    private static final String TAG = "CameraActivity";

    private CameraPreview mCameraPreview;
    private FrameLayout mPreviewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mCameraPreview = new CameraPreview(this);
        mPreviewContainer = (FrameLayout) findViewById(R.id.camera_preview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPreviewContainer.addView(mCameraPreview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCameraPreview.prepare();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCameraPreview.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPreviewContainer.removeView(mCameraPreview);
    }
}
