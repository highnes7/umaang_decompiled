package com.google.android.android.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.SystemClock;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.android.common.images.Size;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraSource
{
  @SuppressLint({"InlinedApi"})
  public static final int CAMERA_FACING_BACK = 0;
  @SuppressLint({"InlinedApi"})
  public static final int CAMERA_FACING_FRONT = 1;
  public Context mContext;
  public int zzcew;
  public final Object zzkgr = new Object();
  public Camera zzkgs;
  public int zzkgt = 0;
  public Size zzkgu;
  public float zzkgv = 30.0F;
  public int zzkgw = 1024;
  public int zzkgx = 768;
  public boolean zzkgy = false;
  public SurfaceTexture zzkgz;
  public boolean zzkha;
  public Thread zzkhb;
  public zzb zzkhc;
  public Map<byte[], ByteBuffer> zzkhd = new HashMap();
  
  public CameraSource() {}
  
  private final byte[] decode(Size paramSize)
  {
    int i = ImageFormat.getBitsPerPixel(17);
    int j = paramSize.getHeight();
    double d = paramSize.getWidth() * j * i;
    Double.isNaN(d);
    paramSize = new byte[(int)Math.ceil(d / 8.0D) + 1];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramSize);
    if ((localByteBuffer.hasArray()) && (localByteBuffer.array() == paramSize))
    {
      zzkhd.put(paramSize, localByteBuffer);
      return paramSize;
    }
    throw new IllegalStateException("Failed to create valid buffer for camera source.");
  }
  
  public static zze doInBackground(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Object localObject1 = paramCamera.getSupportedPreviewSizes();
    paramCamera = paramCamera.getSupportedPictureSizes();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ((List)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label146;
      }
      Camera.Size localSize1 = (Camera.Size)((Iterator)localObject2).next();
      float f = width / height;
      Iterator localIterator = paramCamera.iterator();
      if (localIterator.hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)localIterator.next();
        if (Math.abs(f - width / height) >= 0.01F) {
          break;
        }
        localArrayList.add(new zze(localSize1, localSize2));
      }
    }
    label146:
    int i = localArrayList.size();
    paramCamera = null;
    if (i == 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new zze((Camera.Size)((Iterator)localObject1).next(), null));
      }
    }
    i = Integer.MAX_VALUE;
    int n = localArrayList.size();
    int j = 0;
    while (j < n)
    {
      localObject1 = localArrayList.get(j);
      int k = j + 1;
      localObject1 = (zze)localObject1;
      localObject2 = ((zze)localObject1).zzbij();
      j = Math.abs(((Size)localObject2).getWidth() - paramInt1);
      int m = Math.abs(((Size)localObject2).getHeight() - paramInt2) + j;
      j = k;
      if (m < i)
      {
        paramCamera = (Camera)localObject1;
        i = m;
        j = k;
      }
    }
    return paramCamera;
  }
  
  public static int[] generate(Camera paramCamera, float paramFloat)
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
  
  private final Camera zzbii()
    throws IOException
  {
    int j = zzkgt;
    Object localObject1 = new Camera.CameraInfo();
    int k = 0;
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if (facing == j)
      {
        j = i;
        break label54;
      }
      i += 1;
    }
    j = -1;
    label54:
    if (j != -1)
    {
      localObject1 = Camera.open(j);
      Object localObject2 = doInBackground((Camera)localObject1, zzkgw, zzkgx);
      if (localObject2 != null)
      {
        Object localObject3 = ((zze)localObject2).zzbik();
        zzkgu = ((zze)localObject2).zzbij();
        int[] arrayOfInt = generate((Camera)localObject1, zzkgv);
        if (arrayOfInt != null)
        {
          localObject2 = ((Camera)localObject1).getParameters();
          if (localObject3 != null) {
            ((Camera.Parameters)localObject2).setPictureSize(((Size)localObject3).getWidth(), ((Size)localObject3).getHeight());
          }
          ((Camera.Parameters)localObject2).setPreviewSize(zzkgu.getWidth(), zzkgu.getHeight());
          ((Camera.Parameters)localObject2).setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
          ((Camera.Parameters)localObject2).setPreviewFormat(17);
          int m = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getRotation();
          i = k;
          if (m != 0) {
            if (m != 1)
            {
              if (m != 2)
              {
                if (m != 3)
                {
                  localObject3 = new StringBuilder(31);
                  ((StringBuilder)localObject3).append("Bad rotation value: ");
                  ((StringBuilder)localObject3).append(m);
                  ((StringBuilder)localObject3).toString();
                  i = k;
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
          localObject3 = new Camera.CameraInfo();
          Camera.getCameraInfo(j, (Camera.CameraInfo)localObject3);
          if (facing == 1)
          {
            j = (orientation + i) % 360;
            i = (360 - j) % 360;
          }
          else
          {
            j = (orientation - i + 360) % 360;
            i = j;
          }
          zzcew = (j / 90);
          ((Camera)localObject1).setDisplayOrientation(i);
          ((Camera.Parameters)localObject2).setRotation(j);
          if ((zzkgy) && (((Camera.Parameters)localObject2).getSupportedFocusModes().contains("continuous-video"))) {
            ((Camera.Parameters)localObject2).setFocusMode("continuous-video");
          }
          ((Camera)localObject1).setParameters((Camera.Parameters)localObject2);
          ((Camera)localObject1).setPreviewCallbackWithBuffer(new zza(null));
          ((Camera)localObject1).addCallbackBuffer(decode(zzkgu));
          ((Camera)localObject1).addCallbackBuffer(decode(zzkgu));
          ((Camera)localObject1).addCallbackBuffer(decode(zzkgu));
          ((Camera)localObject1).addCallbackBuffer(decode(zzkgu));
          return localObject1;
        }
        throw new IOException("Could not find suitable preview frames per second range.");
      }
      throw new IOException("Could not find suitable preview size.");
    }
    localObject1 = new IOException("Could not find requested camera.");
    throw ((Throwable)localObject1);
  }
  
  public int getCameraFacing()
  {
    return zzkgt;
  }
  
  public Size getPreviewSize()
  {
    return zzkgu;
  }
  
  public void release()
  {
    Object localObject = zzkgr;
    try
    {
      stop();
      zzkhc.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public CameraSource start()
    throws IOException
  {
    Object localObject = zzkgr;
    try
    {
      if (zzkgs != null) {
        return this;
      }
      zzkgs = zzbii();
      zzkgz = new SurfaceTexture(100);
      zzkgs.setPreviewTexture(zzkgz);
      zzkha = true;
      zzkgs.startPreview();
      zzkhb = new Thread(zzkhc);
      zzkhc.setActive(true);
      zzkhb.start();
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
    Object localObject = zzkgr;
    try
    {
      if (zzkgs != null) {
        return this;
      }
      zzkgs = zzbii();
      zzkgs.setPreviewDisplay(paramSurfaceHolder);
      zzkgs.startPreview();
      zzkhb = new Thread(zzkhc);
      zzkhc.setActive(true);
      zzkhb.start();
      zzkha = false;
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
    //   1: getfield 60	com/google/android/android/vision/CameraSource:zzkgr	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 235	com/google/android/android/vision/CameraSource:zzkhc	Lcom/google/android/android/vision/CameraSource$zzb;
    //   11: iconst_0
    //   12: invokevirtual 411	com/google/android/android/vision/CameraSource$zzb:setActive	(Z)V
    //   15: aload_0
    //   16: getfield 407	com/google/android/android/vision/CameraSource:zzkhb	Ljava/lang/Thread;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +17 -> 38
    //   24: aload_0
    //   25: getfield 407	com/google/android/android/vision/CameraSource:zzkhb	Ljava/lang/Thread;
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 425	java/lang/Thread:join	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 407	com/google/android/android/vision/CameraSource:zzkhb	Ljava/lang/Thread;
    //   38: aload_0
    //   39: getfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   42: ifnull +103 -> 145
    //   45: aload_0
    //   46: getfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   49: invokevirtual 428	android/hardware/Camera:stopPreview	()V
    //   52: aload_0
    //   53: getfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   56: aconst_null
    //   57: invokevirtual 358	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   60: aload_0
    //   61: getfield 397	com/google/android/android/vision/CameraSource:zzkha	Z
    //   64: ifeq +16 -> 80
    //   67: aload_0
    //   68: getfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   71: astore_2
    //   72: aload_2
    //   73: aconst_null
    //   74: invokevirtual 395	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   77: goto +56 -> 133
    //   80: aload_0
    //   81: getfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   84: astore_2
    //   85: aload_2
    //   86: aconst_null
    //   87: invokevirtual 418	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   90: goto +43 -> 133
    //   93: astore_2
    //   94: aload_2
    //   95: invokestatic 434	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: astore_2
    //   99: new 312	java/lang/StringBuilder
    //   102: dup
    //   103: aload_2
    //   104: invokevirtual 437	java/lang/String:length	()I
    //   107: bipush 32
    //   109: iadd
    //   110: invokespecial 314	java/lang/StringBuilder:<init>	(I)V
    //   113: astore_3
    //   114: aload_3
    //   115: ldc_w 439
    //   118: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_3
    //   123: aload_2
    //   124: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: pop
    //   133: aload_0
    //   134: getfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   137: invokevirtual 440	android/hardware/Camera:release	()V
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 245	com/google/android/android/vision/CameraSource:zzkgs	Landroid/hardware/Camera;
    //   145: aload_0
    //   146: getfield 76	com/google/android/android/vision/CameraSource:zzkhd	Ljava/util/Map;
    //   149: invokeinterface 443 1 0
    //   154: aload_1
    //   155: monitorexit
    //   156: return
    //   157: astore_2
    //   158: aload_1
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: goto -130 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	CameraSource
    //   4	155	1	localObject1	Object
    //   19	67	2	localObject2	Object
    //   93	2	2	localException	Exception
    //   98	26	2	str	String
    //   157	4	2	localThrowable	Throwable
    //   162	1	2	localInterruptedException	InterruptedException
    //   113	16	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	77	93	java/lang/Exception
    //   85	90	93	java/lang/Exception
    //   7	20	157	java/lang/Throwable
    //   29	33	157	java/lang/Throwable
    //   33	38	157	java/lang/Throwable
    //   38	72	157	java/lang/Throwable
    //   72	77	157	java/lang/Throwable
    //   85	90	157	java/lang/Throwable
    //   94	133	157	java/lang/Throwable
    //   133	145	157	java/lang/Throwable
    //   145	156	157	java/lang/Throwable
    //   158	160	157	java/lang/Throwable
    //   29	33	162	java/lang/InterruptedException
  }
  
  public void takePicture(ShutterCallback paramShutterCallback, PictureCallback paramPictureCallback)
  {
    Object localObject = zzkgr;
    try
    {
      if (zzkgs != null)
      {
        zzd localZzd = new zzd(null);
        zzd.createBitmap(localZzd, paramShutterCallback);
        paramShutterCallback = new zzc(null);
        zzc.createBitmap(paramShutterCallback, paramPictureCallback);
        zzkgs.takePicture(localZzd, null, null, paramShutterCallback);
      }
      return;
    }
    catch (Throwable paramShutterCallback)
    {
      throw paramShutterCallback;
    }
  }
  
  public class Builder
  {
    public final com.google.android.gms.vision.Detector<?> zzkhe;
    public CameraSource zzkhf = new CameraSource();
    
    public Builder(Detector paramDetector)
    {
      if (this$1 != null)
      {
        if (paramDetector != null)
        {
          zzkhe = paramDetector;
          zzkhf.mContext = this$1;
          return;
        }
        throw new IllegalArgumentException("No detector supplied.");
      }
      throw new IllegalArgumentException("No context supplied.");
    }
    
    public CameraSource build()
    {
      CameraSource localCameraSource = zzkhf;
      localCameraSource.getClass();
      zzkhc = new CameraSource.zzb(localCameraSource, zzkhe);
      return zzkhf;
    }
    
    public Builder setAutoFocusEnabled(boolean paramBoolean)
    {
      zzkhf.zzkgy = paramBoolean;
      return this;
    }
    
    public Builder setFacing(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(27, "Invalid camera: ", paramInt));
      }
      zzkhf.zzkgt = paramInt;
      return this;
    }
    
    public Builder setRequestedFps(float paramFloat)
    {
      if (paramFloat > 0.0F)
      {
        zzkhf.zzkgv = paramFloat;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder(28);
      localStringBuilder.append("Invalid fps: ");
      localStringBuilder.append(paramFloat);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Builder setRequestedPreviewSize(int paramInt1, int paramInt2)
    {
      if ((paramInt1 > 0) && (paramInt1 <= 1000000) && (paramInt2 > 0) && (paramInt2 <= 1000000))
      {
        localObject = zzkhf;
        zzkgw = paramInt1;
        zzkgx = paramInt2;
        return this;
      }
      Object localObject = new StringBuilder(45);
      ((StringBuilder)localObject).append("Invalid preview size: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  public abstract interface PictureCallback
  {
    public abstract void onPictureTaken(byte[] paramArrayOfByte);
  }
  
  public abstract interface ShutterCallback
  {
    public abstract void onShutter();
  }
  
  public final class zza
    implements Camera.PreviewCallback
  {
    public zza() {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      zzkhc.add(paramArrayOfByte, paramCamera);
    }
  }
  
  public final class zzb
    implements Runnable
  {
    public boolean mActive = true;
    public final Object mLock = new Object();
    public long zzdqt = SystemClock.elapsedRealtime();
    public com.google.android.gms.vision.Detector<?> zzkhe;
    public long zzkhh;
    public int zzkhi = 0;
    public ByteBuffer zzkhj;
    
    public zzb(Detector paramDetector)
    {
      zzkhe = paramDetector;
    }
    
    public final void add(byte[] paramArrayOfByte, Camera paramCamera)
    {
      Object localObject = mLock;
      try
      {
        if (zzkhj != null)
        {
          paramCamera.addCallbackBuffer(zzkhj.array());
          zzkhj = null;
        }
        if (!zzkhd.containsKey(paramArrayOfByte)) {
          return;
        }
        zzkhh = (SystemClock.elapsedRealtime() - zzdqt);
        zzkhi += 1;
        zzkhj = ((ByteBuffer)zzkhd.get(paramArrayOfByte));
        mLock.notifyAll();
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
    
    public final void release()
    {
      zzkhe.release();
      zzkhe = null;
    }
    
    public final void run()
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
              localObject2 = zzkhj;
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
        localFrame = new Frame.Builder().setImageData(zzkhj, zzkgu.getWidth(), zzkgu.getHeight(), 17).setId(zzkhi).setTimestampMillis(zzkhh).setRotation(zzcew).build();
        localObject2 = zzkhj;
        zzkhj = null;
        try
        {
          zzkhe.receiveFrame(localFrame);
          zzkgs.addCallbackBuffer(((ByteBuffer)localObject2).array());
        }
        catch (Throwable localThrowable1)
        {
          for (;;) {}
        }
        zzkgs.addCallbackBuffer(((ByteBuffer)localObject2).array());
      }
    }
    
    public final void setActive(boolean paramBoolean)
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
  }
  
  public final class zzc
    implements Camera.PictureCallback
  {
    public CameraSource.PictureCallback zzkhk;
    
    public zzc() {}
    
    public final void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
    {
      paramCamera = zzkhk;
      if (paramCamera != null) {
        paramCamera.onPictureTaken(paramArrayOfByte);
      }
      paramArrayOfByte = zzkgr;
      try
      {
        if (zzkgs != null) {
          zzkgs.startPreview();
        }
        return;
      }
      catch (Throwable paramCamera)
      {
        throw paramCamera;
      }
    }
  }
  
  public final class zzd
    implements Camera.ShutterCallback
  {
    public CameraSource.ShutterCallback zzkhl;
    
    public zzd() {}
    
    public final void onShutter()
    {
      CameraSource.ShutterCallback localShutterCallback = zzkhl;
      if (localShutterCallback != null) {
        localShutterCallback.onShutter();
      }
    }
  }
  
  public final class zze
  {
    public Size zzkhm;
    public Size zzkhn;
    
    public zze(Camera.Size paramSize)
    {
      zzkhm = new Size(width, height);
      if (paramSize != null) {
        zzkhn = new Size(width, height);
      }
    }
    
    public final Size zzbij()
    {
      return zzkhm;
    }
    
    public final Size zzbik()
    {
      return zzkhn;
    }
  }
}
