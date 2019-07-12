package com.google.android.android.vision.face;

import android.util.SparseArray;
import com.google.android.android.vision.Detector;
import com.google.android.android.vision.Detector.Detections;
import com.google.android.android.vision.Tracker;

public class LargestFaceFocusingProcessor
  extends com.google.android.gms.vision.FocusingProcessor<com.google.android.gms.vision.face.Face>
{
  public LargestFaceFocusingProcessor(Detector paramDetector, Tracker paramTracker)
  {
    super(paramDetector, paramTracker);
  }
  
  public int selectFocus(Detector.Detections paramDetections)
  {
    paramDetections = paramDetections.getDetectedItems();
    if (paramDetections.size() != 0)
    {
      int j = paramDetections.keyAt(0);
      float f1 = ((Face)paramDetections.valueAt(0)).getWidth();
      int i = 1;
      while (i < paramDetections.size())
      {
        int k = paramDetections.keyAt(i);
        float f3 = ((Face)paramDetections.valueAt(i)).getWidth();
        float f2 = f1;
        if (f3 > f1)
        {
          j = k;
          f2 = f3;
        }
        i += 1;
        f1 = f2;
      }
      return j;
    }
    paramDetections = new IllegalArgumentException("No faces for selectFocus.");
    throw paramDetections;
  }
  
  public class Builder
  {
    public LargestFaceFocusingProcessor zzkjb;
    
    public Builder(Tracker paramTracker)
    {
      zzkjb = new LargestFaceFocusingProcessor(this$1, paramTracker);
    }
    
    public LargestFaceFocusingProcessor build()
    {
      return zzkjb;
    }
    
    public Builder setMaxGapFrames(int paramInt)
    {
      zzkjb.zzer(paramInt);
      return this;
    }
  }
}
