package com.google.android.android.samples.vision.barcodereader.pref.camera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.android.common.images.Size;
import com.google.android.android.vision.Frame;
import com.google.android.android.vision.Frame.Builder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraSource
{
  public static final float ASPECT_RATIO_TOLERANCE = 0.01F;
  @SuppressLint({"InlinedApi"})
  public static final int CAMERA_FACING_BACK = 0;
  @SuppressLint({"InlinedApi"})
  public static final int CAMERA_FACING_FRONT = 1;
  public static final int DUMMY_TEXTURE_NAME = 100;
  public static final String PAGE_KEY = "OpenCameraSource";
  public Map<byte[], ByteBuffer> mBytesToByteBuffer = new HashMap();
  public Camera mCamera;
  public final Object mCameraLock = new Object();
  public Context mContext;
  public SurfaceTexture mDummySurfaceTexture;
  public SurfaceView mDummySurfaceView;
  public int mFacing = 0;
  public String mFlashMode = null;
  public String mFocusMode = null;
  public FrameProcessingRunnable mFrameProcessor;
  public Size mPreviewSize;
  public Thread mProcessingThread;
  public float mRequestedFps = 30.0F;
  public int mRequestedPreviewHeight = 768;
  public int mRequestedPreviewWidth = 1024;
  public int mRotation;
  
  public CameraSource() {}
  
  private Camera createCamera()
  {
    int i = getIdForRequestedCamera(mFacing);
    if (i != -1)
    {
      Camera localCamera = Camera.open(i);
      Object localObject1 = selectSizePair(localCamera, mRequestedPreviewWidth, mRequestedPreviewHeight);
      if (localObject1 != null)
      {
        Object localObject2 = ((SizePair)localObject1).pictureSize();
        mPreviewSize = ((SizePair)localObject1).previewSize();
        int[] arrayOfInt = selectPreviewFpsRange(localCamera, mRequestedFps);
        if (arrayOfInt != null)
        {
          localObject1 = localCamera.getParameters();
          if (localObject2 != null) {
            ((Camera.Parameters)localObject1).setPictureSize(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
          }
          ((Camera.Parameters)localObject1).setPreviewSize(mPreviewSize.getWidth(), mPreviewSize.getHeight());
          ((Camera.Parameters)localObject1).setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
          ((Camera.Parameters)localObject1).setPreviewFormat(17);
          setRotation(localCamera, (Camera.Parameters)localObject1, i);
          if (mFocusMode != null) {
            if (((Camera.Parameters)localObject1).getSupportedFocusModes().contains(mFocusMode))
            {
              ((Camera.Parameters)localObject1).setFocusMode(mFocusMode);
            }
            else
            {
              localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Camera focus mode: ");
              ((StringBuilder)localObject2).append(mFocusMode);
              ((StringBuilder)localObject2).append(" is not supported on this device.");
              ((StringBuilder)localObject2).toString();
            }
          }
          mFocusMode = ((Camera.Parameters)localObject1).getFocusMode();
          if ((mFlashMode != null) && (((Camera.Parameters)localObject1).getSupportedFlashModes() != null)) {
            if (((Camera.Parameters)localObject1).getSupportedFlashModes().contains(mFlashMode))
            {
              ((Camera.Parameters)localObject1).setFlashMode(mFlashMode);
            }
            else
            {
              localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Camera flash mode: ");
              ((StringBuilder)localObject2).append(mFlashMode);
              ((StringBuilder)localObject2).append(" is not supported on this device.");
              ((StringBuilder)localObject2).toString();
            }
          }
          mFlashMode = ((Camera.Parameters)localObject1).getFlashMode();
          localCamera.setParameters((Camera.Parameters)localObject1);
          localCamera.setPreviewCallbackWithBuffer(new CameraPreviewCallback(null));
          localCamera.addCallbackBuffer(createPreviewBuffer(mPreviewSize));
          localCamera.addCallbackBuffer(createPreviewBuffer(mPreviewSize));
          localCamera.addCallbackBuffer(createPreviewBuffer(mPreviewSize));
          localCamera.addCallbackBuffer(createPreviewBuffer(mPreviewSize));
          return localCamera;
        }
        throw new RuntimeException("Could not find suitable preview frames per second range.");
      }
      throw new RuntimeException("Could not find suitable preview size.");
    }
    throw new RuntimeException("Could not find requested camera.");
  }
  
  private byte[] createPreviewBuffer(Size paramSize)
  {
    int i = ImageFormat.getBitsPerPixel(17);
    int j = paramSize.getHeight();
    double d = paramSize.getWidth() * j * i;
    Double.isNaN(d);
    paramSize = new byte[(int)Math.ceil(d / 8.0D) + 1];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramSize);
    if ((localByteBuffer.hasArray()) && (localByteBuffer.array() == paramSize))
    {
      mBytesToByteBuffer.put(paramSize, localByteBuffer);
      return paramSize;
    }
    throw new IllegalStateException("Failed to create valid buffer for camera source.");
  }
  
  public static List generateValidPreviewSizeList(Camera paramCamera)
  {
    Object localObject = paramCamera.getParameters();
    paramCamera = ((Camera.Parameters)localObject).getSupportedPreviewSizes();
    List localList = ((Camera.Parameters)localObject).getSupportedPictureSizes();
    localObject = new ArrayList();
    Iterator localIterator1 = paramCamera.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label142;
      }
      Camera.Size localSize1 = (Camera.Size)localIterator1.next();
      float f = width / height;
      Iterator localIterator2 = localList.iterator();
      if (localIterator2.hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)localIterator2.next();
        if (Math.abs(f - width / height) >= 0.01F) {
          break;
        }
        ((List)localObject).add(new SizePair(localSize1, localSize2));
      }
    }
    label142:
    if (((List)localObject).size() == 0)
    {
      paramCamera = paramCamera.iterator();
      while (paramCamera.hasNext()) {
        ((List)localObject).add(new SizePair((Camera.Size)paramCamera.next(), null));
      }
    }
    return localObject;
  }
  
  public static int getIdForRequestedCamera(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (facing == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int[] selectPreviewFpsRange(Camera paramCamera, float paramFloat)
  {
    int k = (int)(paramFloat * 1000.0F);
    Iterator localIterator = paramCamera.getParameters().getSupportedPreviewFpsRange().iterator();
    paramCamera = null;
    int i = Integer.MAX_VALUE;
    while (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      int m = arrayOfInt[0];
      int j = arrayOfInt[1];
      m = Math.abs(k - m);
      j = Math.abs(k - j) + m;
      if (j < i)
      {
        paramCamera = arrayOfInt;
        i = j;
      }
    }
    return paramCamera;
  }
  
  public static SizePair selectSizePair(Camera paramCamera, int paramInt1, int paramInt2)
  {
    Iterator localIterator = generateValidPreviewSizeList(paramCamera).iterator();
    paramCamera = null;
    int i = Integer.MAX_VALUE;
    while (localIterator.hasNext())
    {
      SizePair localSizePair = (SizePair)localIterator.next();
      Size localSize = localSizePair.previewSize();
      int j = Math.abs(localSize.getWidth() - paramInt1);
      j = Math.abs(localSize.getHeight() - paramInt2) + j;
      if (j < i)
      {
        paramCamera = localSizePair;
        i = j;
      }
    }
    return paramCamera;
  }
  
  private void setRotation(Camera paramCamera, Camera.Parameters paramParameters, int paramInt)
  {
    int k = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getRotation();
    int j = 0;
    int i = j;
    if (k != 0) {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            f.sufficientlysecure.rootcommands.util.StringBuilder.append("Bad rotation value: ", k);
            i = j;
          }
          else
          {
            i = 270;
          }
        }
        else {
          i = 180;
        }
      }
      else {
        i = 90;
      }
    }
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    if (facing == 1)
    {
      i = (orientation + i) % 360;
      paramInt = (360 - i) % 360;
    }
    else
    {
      i = (orientation - i + 360) % 360;
      paramInt = i;
    }
    mRotation = (i / 90);
    paramCamera.setDisplayOrientation(paramInt);
    paramParameters.setRotation(i);
  }
  
  public void autoFocus(AutoFocusCallback paramAutoFocusCallback)
  {
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null)
      {
        CameraAutoFocusCallback localCameraAutoFocusCallback = null;
        if (paramAutoFocusCallback != null)
        {
          localCameraAutoFocusCallback = new CameraAutoFocusCallback(null);
          CameraAutoFocusCallback.access$1402(localCameraAutoFocusCallback, paramAutoFocusCallback);
        }
        mCamera.autoFocus(localCameraAutoFocusCallback);
      }
      return;
    }
    catch (Throwable paramAutoFocusCallback)
    {
      throw paramAutoFocusCallback;
    }
  }
  
  public void cancelAutoFocus()
  {
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null) {
        mCamera.cancelAutoFocus();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int doZoom(float paramFloat)
  {
    Object localObject = mCameraLock;
    for (;;)
    {
      int j;
      int k;
      try
      {
        if (mCamera == null) {
          return 0;
        }
        Camera.Parameters localParameters = mCamera.getParameters();
        if (!localParameters.isZoomSupported()) {
          return 0;
        }
        j = localParameters.getMaxZoom();
        i = localParameters.getZoom() + 1;
        if (paramFloat > 1.0F)
        {
          float f = i;
          paramFloat = paramFloat * (j / 10) + f;
          k = Math.round(paramFloat) - 1;
          if (k >= 0) {
            break label135;
          }
          i = 0;
          localParameters.setZoom(i);
          mCamera.setParameters(localParameters);
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      paramFloat *= i;
      continue;
      label135:
      int i = k;
      if (k > j) {
        i = j;
      }
    }
  }
  
  public Camera getCamera()
  {
    return mCamera;
  }
  
  public int getCameraFacing()
  {
    return mFacing;
  }
  
  public String getFlashMode()
  {
    return mFlashMode;
  }
  
  public String getFocusMode()
  {
    return mFocusMode;
  }
  
  public Size getPreviewSize()
  {
    return mPreviewSize;
  }
  
  public void release()
  {
    Object localObject = mCameraLock;
    try
    {
      stop();
      mFrameProcessor.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean setAutoFocusMoveCallback(AutoFocusMoveCallback paramAutoFocusMoveCallback)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null)
      {
        CameraAutoFocusMoveCallback localCameraAutoFocusMoveCallback = null;
        if (paramAutoFocusMoveCallback != null)
        {
          localCameraAutoFocusMoveCallback = new CameraAutoFocusMoveCallback(null);
          CameraAutoFocusMoveCallback.access$1602(localCameraAutoFocusMoveCallback, paramAutoFocusMoveCallback);
        }
        mCamera.setAutoFocusMoveCallback(localCameraAutoFocusMoveCallback);
      }
      return true;
    }
    catch (Throwable paramAutoFocusMoveCallback)
    {
      throw paramAutoFocusMoveCallback;
    }
  }
  
  public boolean setCameraFacing(int paramInt)
  {
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null) {
        mFacing = paramInt;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean setFlashMode(String paramString)
  {
    Object localObject = mCameraLock;
    try
    {
      if ((mCamera != null) && (paramString != null))
      {
        Camera.Parameters localParameters = mCamera.getParameters();
        localParameters.setFlashMode(paramString);
        mCamera.setParameters(localParameters);
        mFlashMode = paramString;
        return true;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean setFocusMode(String paramString)
  {
    Object localObject = mCameraLock;
    try
    {
      if ((mCamera != null) && (paramString != null))
      {
        Camera.Parameters localParameters = mCamera.getParameters();
        if (localParameters.getSupportedFocusModes().contains(paramString))
        {
          localParameters.setFocusMode(paramString);
          mCamera.setParameters(localParameters);
          mFocusMode = paramString;
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public CameraSource start()
    throws IOException
  {
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null) {
        return this;
      }
      mCamera = createCamera();
      int i = Build.VERSION.SDK_INT;
      mDummySurfaceTexture = new SurfaceTexture(100);
      mCamera.setPreviewTexture(mDummySurfaceTexture);
      mCamera.startPreview();
      mProcessingThread = new Thread(mFrameProcessor);
      mFrameProcessor.setActive(true);
      mProcessingThread.start();
      return this;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public CameraSource start(SurfaceHolder paramSurfaceHolder)
    throws IOException
  {
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null) {
        return this;
      }
      mCamera = createCamera();
      mCamera.setPreviewDisplay(paramSurfaceHolder);
      mCamera.startPreview();
      mProcessingThread = new Thread(mFrameProcessor);
      mFrameProcessor.setActive(true);
      mProcessingThread.start();
      return this;
    }
    catch (Throwable paramSurfaceHolder)
    {
      throw paramSurfaceHolder;
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCameraLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 137	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mFrameProcessor	Lcom/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource$FrameProcessingRunnable;
    //   11: iconst_0
    //   12: invokevirtual 505	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource$FrameProcessingRunnable:setActive	(Z)V
    //   15: aload_0
    //   16: getfield 114	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mProcessingThread	Ljava/lang/Thread;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnull +17 -> 38
    //   24: aload_0
    //   25: getfield 114	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mProcessingThread	Ljava/lang/Thread;
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 520	java/lang/Thread:join	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 114	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mProcessingThread	Ljava/lang/Thread;
    //   38: aload_0
    //   39: getfield 97	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mBytesToByteBuffer	Ljava/util/Map;
    //   42: invokeinterface 523 1 0
    //   47: aload_0
    //   48: getfield 110	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCamera	Landroid/hardware/Camera;
    //   51: ifnull +79 -> 130
    //   54: aload_0
    //   55: getfield 110	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCamera	Landroid/hardware/Camera;
    //   58: invokevirtual 526	android/hardware/Camera:stopPreview	()V
    //   61: aload_0
    //   62: getfield 110	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCamera	Landroid/hardware/Camera;
    //   65: aconst_null
    //   66: invokevirtual 255	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   69: getstatic 466	android/os/Build$VERSION:SDK_INT	I
    //   72: istore_1
    //   73: aload_0
    //   74: getfield 110	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCamera	Landroid/hardware/Camera;
    //   77: astore_3
    //   78: aload_3
    //   79: aconst_null
    //   80: invokevirtual 493	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   83: goto +35 -> 118
    //   86: astore_3
    //   87: new 223	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 527	java/lang/StringBuilder:<init>	()V
    //   94: astore 4
    //   96: aload 4
    //   98: ldc_w 529
    //   101: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_3
    //   108: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: pop
    //   118: aload_0
    //   119: getfield 110	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCamera	Landroid/hardware/Camera;
    //   122: invokevirtual 533	android/hardware/Camera:release	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 110	com/google/android/android/samples/vision/barcodereader/pref/camera/CameraSource:mCamera	Landroid/hardware/Camera;
    //   130: aload_2
    //   131: monitorexit
    //   132: return
    //   133: astore_3
    //   134: aload_2
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    //   138: astore_3
    //   139: goto -106 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	CameraSource
    //   72	1	1	i	int
    //   4	131	2	localObject1	Object
    //   19	60	3	localObject2	Object
    //   86	22	3	localException	Exception
    //   133	4	3	localThrowable	Throwable
    //   138	1	3	localInterruptedException	InterruptedException
    //   94	19	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	83	86	java/lang/Exception
    //   7	20	133	java/lang/Throwable
    //   29	33	133	java/lang/Throwable
    //   33	38	133	java/lang/Throwable
    //   38	69	133	java/lang/Throwable
    //   78	83	133	java/lang/Throwable
    //   87	118	133	java/lang/Throwable
    //   118	130	133	java/lang/Throwable
    //   130	132	133	java/lang/Throwable
    //   134	136	133	java/lang/Throwable
    //   29	33	138	java/lang/InterruptedException
  }
  
  public void takePicture(ShutterCallback paramShutterCallback, PictureCallback paramPictureCallback)
  {
    Object localObject = mCameraLock;
    try
    {
      if (mCamera != null)
      {
        PictureStartCallback localPictureStartCallback = new PictureStartCallback(null);
        PictureStartCallback.access$1002(localPictureStartCallback, paramShutterCallback);
        paramShutterCallback = new PictureDoneCallback(null);
        PictureDoneCallback.access$1202(paramShutterCallback, paramPictureCallback);
        mCamera.takePicture(localPictureStartCallback, null, null, paramShutterCallback);
      }
      return;
    }
    catch (Throwable paramShutterCallback)
    {
      throw paramShutterCallback;
    }
  }
  
  public abstract interface AutoFocusCallback
  {
    public abstract void onAutoFocus(boolean paramBoolean);
  }
  
  public abstract interface AutoFocusMoveCallback
  {
    public abstract void onAutoFocusMoving(boolean paramBoolean);
  }
  
  public class Builder
  {
    public CameraSource mCameraSource = new CameraSource();
    public final com.google.android.gms.vision.Detector<?> mDetector;
    
    public Builder(com.google.android.android.vision.Detector paramDetector)
    {
      if (this$1 != null)
      {
        if (paramDetector != null)
        {
          mDetector = paramDetector;
          CameraSource.access$102(mCameraSource, this$1);
          return;
        }
        throw new IllegalArgumentException("No detector supplied.");
      }
      throw new IllegalArgumentException("No context supplied.");
    }
    
    public CameraSource build()
    {
      CameraSource localCameraSource = mCameraSource;
      localCameraSource.getClass();
      CameraSource.access$802(localCameraSource, new CameraSource.FrameProcessingRunnable(localCameraSource, mDetector));
      return mCameraSource;
    }
    
    public Builder setFacing(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Invalid camera: ", paramInt));
      }
      CameraSource.access$702(mCameraSource, paramInt);
      return this;
    }
    
    public Builder setFlashMode(String paramString)
    {
      CameraSource.access$402(mCameraSource, paramString);
      return this;
    }
    
    public Builder setFocusMode(String paramString)
    {
      CameraSource.access$302(mCameraSource, paramString);
      return this;
    }
    
    public Builder setRequestedFps(float paramFloat)
    {
      if (paramFloat > 0.0F)
      {
        CameraSource.access$202(mCameraSource, paramFloat);
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid fps: ");
      localStringBuilder.append(paramFloat);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Builder setRequestedPreviewSize(int paramInt1, int paramInt2)
    {
      if ((paramInt1 > 0) && (paramInt1 <= 1000000) && (paramInt2 > 0) && (paramInt2 <= 1000000))
      {
        CameraSource.access$502(mCameraSource, paramInt1);
        CameraSource.access$602(mCameraSource, paramInt2);
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid preview size: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public class CameraAutoFocusCallback
    implements Camera.AutoFocusCallback
  {
    public CameraSource.AutoFocusCallback mDelegate;
    
    public CameraAutoFocusCallback() {}
    
    public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      paramCamera = mDelegate;
      if (paramCamera != null) {
        paramCamera.onAutoFocus(paramBoolean);
      }
    }
  }
  
  @TargetApi(16)
  public class CameraAutoFocusMoveCallback
    implements Camera.AutoFocusMoveCallback
  {
    public CameraSource.AutoFocusMoveCallback mDelegate;
    
    public CameraAutoFocusMoveCallback() {}
    
    public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
    {
      paramCamera = mDelegate;
      if (paramCamera != null) {
        paramCamera.onAutoFocusMoving(paramBoolean);
      }
    }
  }
  
  public class CameraPreviewCallback
    implements Camera.PreviewCallback
  {
    public CameraPreviewCallback() {}
    
    public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      CameraSource.access$800(CameraSource.this).setNextFrame(paramArrayOfByte, paramCamera);
    }
  }
  
  public class FrameProcessingRunnable
    implements Runnable
  {
    public boolean mActive = true;
    public com.google.android.gms.vision.Detector<?> mDetector;
    public final Object mLock = new Object();
    public ByteBuffer mPendingFrameData;
    public int mPendingFrameId = 0;
    public long mPendingTimeMillis;
    public long mStartTimeMillis = SystemClock.elapsedRealtime();
    
    public FrameProcessingRunnable(com.google.android.android.vision.Detector paramDetector)
    {
      mDetector = paramDetector;
    }
    
    public void release()
    {
      mDetector.release();
      mDetector = null;
    }
    
    public void run()
    {
      for (;;)
      {
        localObject1 = mLock;
        for (;;)
        {
          try
          {
            if (mActive)
            {
              localObject2 = mPendingFrameData;
              if (localObject2 == null) {
                localObject2 = mLock;
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            Object localObject2;
            Frame localFrame;
            throw localThrowable2;
          }
          try
          {
            localObject2.wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        return;
        if (!mActive) {
          return;
        }
        localFrame = new Frame.Builder().setImageData(mPendingFrameData, CameraSource.access$2300(CameraSource.this).getWidth(), CameraSource.access$2300(CameraSource.this).getHeight(), 17).setId(mPendingFrameId).setTimestampMillis(mPendingTimeMillis).setRotation(CameraSource.access$2200(CameraSource.this)).build();
        localObject2 = mPendingFrameData;
        mPendingFrameData = null;
        try
        {
          mDetector.receiveFrame(localFrame);
          CameraSource.access$1800(CameraSource.this).addCallbackBuffer(((ByteBuffer)localObject2).array());
        }
        catch (Throwable localThrowable1)
        {
          for (;;) {}
        }
        CameraSource.access$1800(CameraSource.this).addCallbackBuffer(((ByteBuffer)localObject2).array());
      }
    }
    
    public void setActive(boolean paramBoolean)
    {
      Object localObject = mLock;
      try
      {
        mActive = paramBoolean;
        mLock.notifyAll();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public void setNextFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      Object localObject = mLock;
      try
      {
        if (mPendingFrameData != null)
        {
          paramCamera.addCallbackBuffer(mPendingFrameData.array());
          mPendingFrameData = null;
        }
        if (!CameraSource.access$2100(CameraSource.this).containsKey(paramArrayOfByte)) {
          return;
        }
        mPendingTimeMillis = (SystemClock.elapsedRealtime() - mStartTimeMillis);
        mPendingFrameId += 1;
        mPendingFrameData = ((ByteBuffer)CameraSource.access$2100(CameraSource.this).get(paramArrayOfByte));
        mLock.notifyAll();
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  public abstract interface PictureCallback
  {
    public abstract void onPictureTaken(byte[] paramArrayOfByte);
  }
  
  public class PictureDoneCallback
    implements Camera.PictureCallback
  {
    public CameraSource.PictureCallback mDelegate;
    
    public PictureDoneCallback() {}
    
    public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
    {
      paramCamera = mDelegate;
      if (paramCamera != null) {
        paramCamera.onPictureTaken(paramArrayOfByte);
      }
      paramArrayOfByte = CameraSource.access$1700(CameraSource.this);
      try
      {
        if (CameraSource.access$1800(CameraSource.this) != null) {
          CameraSource.access$1800(CameraSource.this).startPreview();
        }
        return;
      }
      catch (Throwable paramCamera)
      {
        throw paramCamera;
      }
    }
  }
  
  public class PictureStartCallback
    implements Camera.ShutterCallback
  {
    public CameraSource.ShutterCallback mDelegate;
    
    public PictureStartCallback() {}
    
    public void onShutter()
    {
      CameraSource.ShutterCallback localShutterCallback = mDelegate;
      if (localShutterCallback != null) {
        localShutterCallback.onShutter();
      }
    }
  }
  
  public abstract interface ShutterCallback
  {
    public abstract void onShutter();
  }
  
  public class SizePair
  {
    public Size mPicture;
    public Size mPreview;
    
    public SizePair(Camera.Size paramSize)
    {
      mPreview = new Size(width, height);
      if (paramSize != null) {
        mPicture = new Size(width, height);
      }
    }
    
    public Size pictureSize()
    {
      return mPicture;
    }
    
    public Size previewSize()
    {
      return mPreview;
    }
  }
}
