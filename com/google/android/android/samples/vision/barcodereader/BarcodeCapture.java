package com.google.android.android.samples.vision.barcodereader;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.samples.vision.barcodereader.pref.camera.CameraSource;
import com.google.android.android.samples.vision.barcodereader.pref.camera.CameraSource.Builder;
import com.google.android.android.samples.vision.barcodereader.pref.camera.CameraSourcePreview;
import com.google.android.android.vision.Detector;
import com.google.android.android.vision.Detector.Processor;
import com.google.android.android.vision.MultiProcessor;
import com.google.android.android.vision.barcode.Barcode;
import f.s.b.f;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.b.ByteVector;
import s.a.a.b;
import s.a.a.c;
import s.a.a.e.e;
import s.a.a.e.g;
import s.a.a.e.h;

public final class BarcodeCapture
  extends b
{
  public static final String BarcodeObject = "Barcode";
  public static final String PAGE_KEY = "Barcode-reader";
  public static final int RC_HANDLE_CAMERA_PERM = 2;
  public static final int RC_HANDLE_GMS = 9001;
  public boolean forceRefresh;
  public GestureDetector gestureDetector;
  public CameraSource mCameraSource;
  public com.google.android.gms.samples.vision.barcodereader.ui.camera.GraphicOverlay<com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic> mGraphicOverlay;
  public CameraSourcePreview mPreview;
  public boolean pendingPermission;
  public ScaleGestureDetector scaleGestureDetector;
  
  public BarcodeCapture() {}
  
  private void createCameraSource(Detector paramDetector, boolean paramBoolean1, boolean paramBoolean2)
  {
    BarcodeCapture.3 local3 = new BarcodeCapture.3(this, mGraphicOverlay);
    Object localObject = new MultiProcessor();
    zzkig = local3;
    paramDetector.setProcessor((Detector.Processor)localObject);
    boolean bool = paramDetector.isOperational();
    local3 = null;
    if (!bool)
    {
      localObject = new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW");
      if (((Fragment)this).getActivity().registerReceiver(null, (IntentFilter)localObject) != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Toast.makeText(((Fragment)this).getContext(), e.h.low_storage_error, 1).show();
        i = e.h.low_storage_error;
        ((Fragment)this).getString(i);
      }
    }
    localObject = new DisplayMetrics();
    ((Activity)((Fragment)this).getContext()).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = heightPixels;
    int j = widthPixels;
    localObject = new CameraSource.Builder(((Fragment)this).getContext(), paramDetector).setFacing(getCameraFacing()).setRequestedPreviewSize(i, j).setRequestedFps(15.0F);
    i = Build.VERSION.SDK_INT;
    if (paramBoolean1) {
      paramDetector = "continuous-picture";
    } else {
      paramDetector = null;
    }
    localObject = ((CameraSource.Builder)localObject).setFocusMode(paramDetector);
    paramDetector = local3;
    if (paramBoolean2) {
      paramDetector = "torch";
    }
    mCameraSource = ((CameraSource.Builder)localObject).setFlashMode(paramDetector).build();
  }
  
  private void createCameraSource(boolean paramBoolean1, boolean paramBoolean2)
  {
    createCameraSource(getCustomBarcodeDetector(), paramBoolean1, paramBoolean2);
  }
  
  private void handleSourceRefresh(boolean paramBoolean)
  {
    forceRefresh = false;
    pendingPermission = false;
    mGraphicOverlay.setDrawRect(isShowDrawRect());
    mGraphicOverlay.setRectColors(getRectColors());
    mGraphicOverlay.setShowText(isShouldShowText());
    CameraSource localCameraSource = mCameraSource;
    String str;
    if (isAutoFocus()) {
      str = "continuous-picture";
    } else {
      str = null;
    }
    localCameraSource.setFocusMode(str);
    localCameraSource = mCameraSource;
    if (isShowFlash()) {
      str = "torch";
    } else {
      str = "off";
    }
    localCameraSource.setFlashMode(str);
    if ((getCameraFacing() != mCameraSource.getCameraFacing()) || (isBarcodeFormatUpdate()) || (paramBoolean))
    {
      if (getCustomBarcodeDetector().isOperational()) {
        getCustomBarcodeDetector().release();
      }
      setBarcodeFormatUpdate(false);
      mCameraSource.setCameraFacing(getCameraFacing());
      mCameraSource.stop();
      mCameraSource.release();
      requestCameraPermission(true);
    }
  }
  
  private boolean onTap(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = new int[2];
    mGraphicOverlay.getLocationOnScreen((int[])localObject1);
    float f1 = (paramFloat1 - localObject1[0]) / mGraphicOverlay.getWidthScaleFactor();
    float f2 = (paramFloat2 - localObject1[1]) / mGraphicOverlay.getHeightScaleFactor();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = mGraphicOverlay.getGraphics().iterator();
    localObject1 = null;
    paramFloat1 = Float.MAX_VALUE;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = ((BarcodeGraphic)localIterator.next()).getBarcode();
      localArrayList.add(localObject2);
      if (((Barcode)localObject2).getBoundingBox().contains((int)f1, (int)f2)) {
        break;
      }
      paramFloat2 = f1 - ((Barcode)localObject2).getBoundingBox().centerX();
      float f3 = f2 - ((Barcode)localObject2).getBoundingBox().centerY();
      paramFloat2 = f3 * f3 + paramFloat2 * paramFloat2;
      if (paramFloat2 < paramFloat1)
      {
        localObject1 = localObject2;
        paramFloat1 = paramFloat2;
      }
    }
    if (localObject2 != null)
    {
      if (barcodeRetriever != null)
      {
        if (supportMultipleScan())
        {
          barcodeRetriever.a((Barcode)localObject2, mGraphicOverlay.getGraphics());
          return true;
        }
        barcodeRetriever.a((Barcode)localObject2);
        return true;
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void requestCameraPermission()
  {
    requestCameraPermission(false);
  }
  
  private void requestCameraPermission(boolean paramBoolean)
  {
    new f(((Fragment)this).getActivity()).c(new String[] { "android.permission.CAMERA" }).add(new BarcodeCapture.2(this, paramBoolean));
  }
  
  private void startCameraSource()
    throws SecurityException
  {
    int i = GoogleApiAvailability.zzffi.isGooglePlayServicesAvailable(((Fragment)this).getContext());
    if (i != 0) {
      GoogleApiAvailability.zzffi.getErrorDialog(((Fragment)this).getActivity(), i, 9001).show();
    }
    CameraSource localCameraSource = mCameraSource;
    if (localCameraSource != null)
    {
      CameraSourcePreview localCameraSourcePreview = mPreview;
      com.google.android.android.samples.vision.barcodereader.pref.camera.GraphicOverlay localGraphicOverlay = mGraphicOverlay;
      try
      {
        localCameraSourcePreview.start(localCameraSource, localGraphicOverlay);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      mCameraSource.release();
      mCameraSource = null;
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(e.g.barcode_capture, paramViewGroup, false);
    mPreview = ((CameraSourcePreview)paramLayoutInflater.findViewById(e.e.preview));
    mGraphicOverlay = ((com.google.android.android.samples.vision.barcodereader.pref.camera.GraphicOverlay)paramLayoutInflater.findViewById(e.e.graphicOverlay));
    mGraphicOverlay.setShowText(isShouldShowText());
    mGraphicOverlay.setRectColors(getRectColors());
    mGraphicOverlay.setDrawRect(isShowDrawRect());
    requestCameraPermission(false);
    gestureDetector = new GestureDetector(((Fragment)this).getContext(), new CaptureGestureListener(null));
    scaleGestureDetector = new ScaleGestureDetector(((Fragment)this).getContext(), new ScaleListener(null));
    paramLayoutInflater.setOnTouchListener(new BarcodeCapture.1(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    ((Fragment)this).onDestroy();
    CameraSourcePreview localCameraSourcePreview = mPreview;
    if (localCameraSourcePreview != null) {
      localCameraSourcePreview.release();
    }
  }
  
  public void onPause()
  {
    mCalled = true;
    CameraSourcePreview localCameraSourcePreview = mPreview;
    if (localCameraSourcePreview != null) {
      localCameraSourcePreview.stop();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 2)
    {
      StringBuilder.append("Got unexpected permission result: ", paramInt);
      return;
    }
    if ((paramArrayOfInt.length != 0) && (paramArrayOfInt[0] == 0))
    {
      createCameraSource(isAutoFocus(), isShowFlash());
      return;
    }
    paramArrayOfString = barcodeRetriever;
    paramInt = e.h.no_camera_permission;
    paramArrayOfString.b(((Fragment)this).getString(paramInt));
  }
  
  public void onResume()
  {
    mCalled = true;
    startCameraSource();
  }
  
  public void refresh()
  {
    refresh(false);
  }
  
  public void refresh(boolean paramBoolean)
  {
    if (mCameraSource == null)
    {
      pendingPermission = true;
      forceRefresh = paramBoolean;
      requestCameraPermission(false);
      return;
    }
    handleSourceRefresh(paramBoolean);
  }
  
  public Camera retrieveCamera()
  {
    return mCameraSource.getCamera();
  }
  
  public void stopScanning()
  {
    if (getCustomBarcodeDetector().isOperational()) {
      getCustomBarcodeDetector().release();
    }
  }
  
  public class CaptureGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    public CaptureGestureListener() {}
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return (BarcodeCapture.access$1100(BarcodeCapture.this, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (super.onSingleTapConfirmed(paramMotionEvent));
    }
  }
  
  public class ScaleListener
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    public ScaleListener() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      return false;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      BarcodeCapture.access$1200(BarcodeCapture.this).doZoom(paramScaleGestureDetector.getScaleFactor());
    }
  }
}
