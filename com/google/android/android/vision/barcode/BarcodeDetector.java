package com.google.android.android.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.android.internal.zzdcc;
import com.google.android.android.internal.zzdce;
import com.google.android.android.internal.zzdcj;
import com.google.android.android.internal.zzdck;
import com.google.android.android.vision.Frame;

public final class BarcodeDetector
  extends com.google.android.gms.vision.Detector<com.google.android.gms.vision.barcode.Barcode>
{
  public final zzdce zzkij;
  
  public BarcodeDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  public BarcodeDetector(zzdce paramZzdce)
  {
    zzkij = paramZzdce;
  }
  
  public final SparseArray detect(Frame paramFrame)
  {
    if (paramFrame != null)
    {
      Object localObject1 = zzdck.get(paramFrame);
      if (paramFrame.getBitmap() != null)
      {
        localObject1 = zzkij.generateKey(paramFrame.getBitmap(), (zzdck)localObject1);
        paramFrame = (Frame)localObject1;
        if (localObject1 == null) {
          throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
        }
      }
      else
      {
        paramFrame = paramFrame.getGrayscaleImageData();
        paramFrame = zzkij.max(paramFrame, (zzdck)localObject1);
      }
      localObject1 = new SparseArray(paramFrame.length);
      int j = paramFrame.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramFrame[i];
        ((SparseArray)localObject1).append(rawValue.hashCode(), localObject2);
        i += 1;
      }
      return localObject1;
    }
    paramFrame = new IllegalArgumentException("No frame supplied.");
    throw paramFrame;
  }
  
  public final boolean isOperational()
  {
    return zzkij.isOperational();
  }
  
  public final void release()
  {
    super.release();
    zzkij.zzbio();
  }
  
  public class Builder
  {
    public zzdcc zzkik = new zzdcc();
    
    public Builder() {}
    
    public BarcodeDetector build()
    {
      return new BarcodeDetector(new zzdce(BarcodeDetector.this, zzkik), null);
    }
    
    public Builder setBarcodeFormats(int paramInt)
    {
      zzkik.zzkil = paramInt;
      return this;
    }
  }
}
