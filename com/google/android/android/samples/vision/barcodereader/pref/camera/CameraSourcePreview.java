package com.google.android.android.samples.vision.barcodereader.pref.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.android.common.images.Size;
import java.io.IOException;

public class CameraSourcePreview
  extends ViewGroup
{
  public static final String PAGE_KEY = "CameraSourcePreview";
  public CameraSource mCameraSource;
  public Context mContext;
  public GraphicOverlay mOverlay;
  public boolean mStartRequested;
  public boolean mSurfaceAvailable;
  public SurfaceView mSurfaceView;
  
  public CameraSourcePreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mContext = paramContext;
    mStartRequested = false;
    mSurfaceAvailable = false;
    mSurfaceView = new SurfaceView(paramContext);
    mSurfaceView.getHolder().addCallback(new SurfaceCallback(null));
    addView(mSurfaceView);
  }
  
  private boolean isPortraitMode()
  {
    int i = mContext.getResources().getConfiguration().orientation;
    if (i == 2) {
      return false;
    }
    return i == 1;
  }
  
  private void startIfReady()
    throws IOException, SecurityException
  {
    if ((mStartRequested) && (mSurfaceAvailable))
    {
      mCameraSource.start(mSurfaceView.getHolder());
      if (mOverlay != null)
      {
        Size localSize = mCameraSource.getPreviewSize();
        int i = Math.min(localSize.getWidth(), localSize.getHeight());
        int j = Math.max(localSize.getWidth(), localSize.getHeight());
        if (isPortraitMode()) {
          mOverlay.setCameraInfo(i, j, mCameraSource.getCameraFacing());
        } else {
          mOverlay.setCameraInfo(j, i, mCameraSource.getCameraFacing());
        }
        mOverlay.clear();
      }
      mStartRequested = false;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = mCameraSource;
    if (localObject != null)
    {
      localObject = ((CameraSource)localObject).getPreviewSize();
      if (localObject != null)
      {
        i = ((Size)localObject).getWidth();
        j = ((Size)localObject).getHeight();
        break label50;
      }
    }
    int i = 320;
    int j = 240;
    label50:
    if (!isPortraitMode())
    {
      int k = j;
      j = i;
      i = k;
    }
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    float f2 = paramInt1;
    float f1 = j;
    f2 /= f1;
    float f4 = paramInt2;
    float f3 = i;
    f4 /= f3;
    i = 0;
    if (f2 > f4)
    {
      paramInt3 = (int)(f3 * f2);
      j = (paramInt3 - paramInt2) / 2;
      paramInt2 = paramInt3;
      paramInt4 = paramInt1;
      paramInt3 = 0;
      paramInt1 = j;
    }
    else
    {
      paramInt4 = (int)(f1 * f4);
      paramInt3 = (paramInt4 - paramInt1) / 2;
      paramInt1 = 0;
    }
    while (i < getChildCount())
    {
      getChildAt(i).layout(paramInt3 * -1, paramInt1 * -1, paramInt4 - paramInt3, paramInt2 - paramInt1);
      i += 1;
    }
    try
    {
      startIfReady();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void release()
  {
    CameraSource localCameraSource = mCameraSource;
    if (localCameraSource != null)
    {
      localCameraSource.release();
      mCameraSource = null;
    }
  }
  
  public void start(CameraSource paramCameraSource)
    throws IOException, SecurityException
  {
    if (paramCameraSource == null) {
      stop();
    }
    mCameraSource = paramCameraSource;
    if (mCameraSource != null)
    {
      mStartRequested = true;
      startIfReady();
    }
  }
  
  public void start(CameraSource paramCameraSource, GraphicOverlay paramGraphicOverlay)
    throws IOException, SecurityException
  {
    mOverlay = paramGraphicOverlay;
    start(paramCameraSource);
  }
  
  public void stop()
  {
    CameraSource localCameraSource = mCameraSource;
    if (localCameraSource != null) {
      localCameraSource.stop();
    }
  }
  
  public class SurfaceCallback
    implements SurfaceHolder.Callback
  {
    public SurfaceCallback() {}
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      CameraSourcePreview.access$102(CameraSourcePreview.this, true);
      paramSurfaceHolder = CameraSourcePreview.this;
      try
      {
        CameraSourcePreview.access$200(paramSurfaceHolder);
        return;
      }
      catch (SecurityException paramSurfaceHolder) {}catch (IOException paramSurfaceHolder) {}
    }
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      CameraSourcePreview.access$102(CameraSourcePreview.this, false);
    }
  }
}
