package com.google.android.android.vision.face;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.android.internal.zzdcj;
import com.google.android.android.internal.zzdck;
import com.google.android.android.vision.Frame;
import com.google.android.android.vision.MergedCells;
import com.google.android.android.vision.face.internal.client.CustomTile;
import com.google.android.android.vision.face.internal.client.PieRenderer;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public final class FaceDetector
  extends com.google.android.gms.vision.Detector<com.google.android.gms.vision.face.Face>
{
  public static final int ACCURATE_MODE = 1;
  public static final int ALL_CLASSIFICATIONS = 1;
  public static final int ALL_LANDMARKS = 1;
  public static final int FAST_MODE = 0;
  public static final int NO_CLASSIFICATIONS = 0;
  public static final int NO_LANDMARKS = 0;
  public final Object mLock = new Object();
  public final MergedCells zzkit = new MergedCells();
  public final PieRenderer zzkiu;
  public boolean zzkiv = true;
  
  public FaceDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  public FaceDetector(PieRenderer paramPieRenderer)
  {
    zzkiu = paramPieRenderer;
  }
  
  public final SparseArray detect(Frame paramFrame)
  {
    if (paramFrame != null)
    {
      Object localObject2 = paramFrame.getGrayscaleImageData();
      Object localObject1 = mLock;
      try
      {
        if (zzkiv)
        {
          paramFrame = zzkiu.onRender((ByteBuffer)localObject2, zzdck.get(paramFrame));
          localObject1 = new HashSet();
          localObject2 = new SparseArray(paramFrame.length);
          int i1 = paramFrame.length;
          int j = 0;
          int i = 0;
          while (j < i1)
          {
            Object localObject3 = paramFrame[j];
            int m = localObject3.getId();
            int k = m;
            int n = Math.max(i, m);
            i = n;
            if (((Set)localObject1).contains(Integer.valueOf(m)))
            {
              k = n + 1;
              i = k;
            }
            ((Set)localObject1).add(Integer.valueOf(k));
            ((SparseArray)localObject2).append(zzkit.zzes(k), localObject3);
            j += 1;
          }
          return localObject2;
        }
        throw new RuntimeException("Cannot use detector after release()");
      }
      catch (Throwable paramFrame)
      {
        throw paramFrame;
      }
    }
    paramFrame = new IllegalArgumentException("No frame supplied.");
    throw paramFrame;
  }
  
  /* Error */
  public final void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/android/vision/face/FaceDetector:mLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/google/android/android/vision/face/FaceDetector:zzkiv	Z
    //   11: ifeq +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 133	com/google/android/android/vision/face/FaceDetector:release	()V
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_0
    //   21: invokespecial 135	java/lang/Object:finalize	()V
    //   24: return
    //   25: astore_2
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: invokespecial 135	java/lang/Object:finalize	()V
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	FaceDetector
    //   4	23	1	localObject	Object
    //   30	6	1	localThrowable1	Throwable
    //   25	4	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	18	25	java/lang/Throwable
    //   18	20	25	java/lang/Throwable
    //   26	28	25	java/lang/Throwable
    //   0	7	30	java/lang/Throwable
    //   28	30	30	java/lang/Throwable
  }
  
  public final boolean isOperational()
  {
    return zzkiu.isOperational();
  }
  
  public final void release()
  {
    super.release();
    Object localObject = mLock;
    try
    {
      if (!zzkiv) {
        return;
      }
      zzkiu.zzbio();
      zzkiv = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean setFocus(int paramInt)
  {
    paramInt = zzkit.zzet(paramInt);
    Object localObject = mLock;
    try
    {
      if (zzkiv)
      {
        boolean bool = zzkiu.zzeu(paramInt);
        return bool;
      }
      throw new RuntimeException("Cannot use detector after release()");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public class Builder
  {
    public int zzgdd = 0;
    public int zzkiw = 0;
    public boolean zzkix = false;
    public int zzkiy = 0;
    public boolean zzkiz = true;
    public float zzkja = -1.0F;
    
    public Builder() {}
    
    public FaceDetector build()
    {
      CustomTile localCustomTile = new CustomTile();
      mode = zzgdd;
      zzkjj = zzkiw;
      zzkjk = zzkiy;
      zzkjl = zzkix;
      zzkjm = zzkiz;
      zzkjn = zzkja;
      return new FaceDetector(new PieRenderer(FaceDetector.this, localCustomTile));
    }
    
    public Builder setClassificationType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(40, "Invalid classification type: ", paramInt));
      }
      zzkiy = paramInt;
      return this;
    }
    
    public Builder setLandmarkType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(34, "Invalid landmark type: ", paramInt));
      }
      zzkiw = paramInt;
      return this;
    }
    
    public Builder setMinFaceSize(float paramFloat)
    {
      if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
      {
        zzkja = paramFloat;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder(47);
      localStringBuilder.append("Invalid proportional face size: ");
      localStringBuilder.append(paramFloat);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Builder setMode(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(25, "Invalid mode: ", paramInt));
      }
      zzgdd = paramInt;
      return this;
    }
    
    public Builder setProminentFaceOnly(boolean paramBoolean)
    {
      zzkix = paramBoolean;
      return this;
    }
    
    public Builder setTrackingEnabled(boolean paramBoolean)
    {
      zzkiz = paramBoolean;
      return this;
    }
  }
}
