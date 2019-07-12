package com.google.android.android.vision;

import android.util.SparseArray;

public abstract class Detector<T>
{
  public final Object zzkho = new Object();
  public com.google.android.gms.vision.Detector.Processor<T> zzkhp;
  
  public Detector() {}
  
  public abstract SparseArray detect(Frame paramFrame);
  
  public boolean isOperational()
  {
    return true;
  }
  
  public void receiveFrame(Frame paramFrame)
  {
    Object localObject = zzkho;
    try
    {
      if (zzkhp != null)
      {
        Frame.Metadata localMetadata = new Frame.Metadata(paramFrame.getMetadata());
        localMetadata.zzbil();
        paramFrame = new Detections(detect(paramFrame), localMetadata, isOperational());
        zzkhp.receiveDetections(paramFrame);
        return;
      }
      throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
    }
    catch (Throwable paramFrame)
    {
      throw paramFrame;
    }
  }
  
  public void release()
  {
    Object localObject = zzkho;
    try
    {
      if (zzkhp != null)
      {
        zzkhp.release();
        zzkhp = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean setFocus(int paramInt)
  {
    return true;
  }
  
  public void setProcessor(Processor paramProcessor)
  {
    zzkhp = paramProcessor;
  }
  
  public class Detections<T>
  {
    public Frame.Metadata zzkhr;
    public boolean zzkhs;
    
    public Detections(Frame.Metadata paramMetadata, boolean paramBoolean)
    {
      zzkhr = paramMetadata;
      zzkhs = paramBoolean;
    }
    
    public boolean detectorIsOperational()
    {
      return zzkhs;
    }
    
    public SparseArray getDetectedItems()
    {
      return Detector.this;
    }
    
    public Frame.Metadata getFrameMetadata()
    {
      return zzkhr;
    }
  }
  
  public abstract interface Processor<T>
  {
    public abstract void receiveDetections(Detector.Detections paramDetections);
    
    public abstract void release();
  }
}
