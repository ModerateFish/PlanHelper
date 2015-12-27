package com.thornbird.planhelper.TBCamera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.thornbird.planhelper.AppLog;

import java.io.IOException;
import java.util.List;

/**
 * Created by yangli on 15/12/27.
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CameraPreview";

    private Context mContext;
    private SurfaceHolder mHolder;
    private Camera mCamera;

    public CameraPreview(Context context) {
        super(context);
        mContext = context;
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    private void openCamera() {
        if (mCamera == null) {
            try {
                mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
            } catch (Exception e) {
                AppLog.d(TAG, "openCamera failed, exception: " + e);
            }
        }
    }

    private void closeCamera() {
        if (mCamera != null) {
            try {
                mCamera.stopPreview();
                mCamera.setPreviewDisplay(null);
            } catch (Exception e) {
                AppLog.d(TAG, "closeCamera failed, exception: " + e);
            } finally {
                mCamera.release();
                mCamera = null;
            }
        }
    }

    public void prepare() {
        AppLog.d(TAG, "prepare()");
        openCamera();
    }

    public void stop() {
        AppLog.d(TAG, "stop()");
        closeCamera();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        AppLog.d(TAG, "surfaceCreated()");
        if (mCamera == null) {
            return;
        }
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            AppLog.d(TAG, "surfaceCreated failed, exception: " + e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        AppLog.d(TAG, "surfaceChanged()");
        if (mCamera == null || mHolder.getSurface() == null) {
            return;
        }
        try {
            mCamera.stopPreview();
        } catch (Exception e) {
            // ignore: tried to stop a non-existent preview
        }

        Camera.Parameters parameters = mCamera.getParameters();
        List<Camera.Size> sizes = parameters.getSupportedPreviewSizes();
        if (sizes != null) {
            // adjust preview size
        }
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
        mCamera.setParameters(parameters);
        CameraHelper.setCameraDisplayOrientation((Activity)mContext, Camera.CameraInfo.CAMERA_FACING_FRONT, mCamera);

        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();

        } catch (Exception e){
            AppLog.d(TAG, "surfaceChanged failed, exception: " + e.getMessage());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        AppLog.d(TAG, "surfaceDestroyed()");
    }
}
