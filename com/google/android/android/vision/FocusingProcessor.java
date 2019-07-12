package com.google.android.android.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Processor;

public abstract class FocusingProcessor<T>
  implements Detector.Processor<T>
{
  public com.google.android.gms.vision.Detector<T> zzkhe;
  public com.google.android.gms.vision.Tracker<T> zzkht;
  public int zzkhu = 3;
  public boolean zzkhv = false;
  public int zzkhw;
  public int zzkhx = 0;
  
  public FocusingProcessor(Detector paramDetector, Tracker paramTracker)
  {
    zzkhe = paramDetector;
    zzkht = paramTracker;
  }
  
  public void receiveDetections(Detector.Detections paramDetections)
  {
    Object localObject1 = paramDetections.getDetectedItems();
    if (((SparseArray)localObject1).size() == 0)
    {
      if (zzkhx == zzkhu)
      {
        zzkht.onDone();
        zzkhv = false;
      }
      else
      {
        zzkht.onMissing(paramDetections);
      }
      zzkhx += 1;
      return;
    }
    zzkhx = 0;
    if (zzkhv)
    {
      Object localObject2 = ((SparseArray)localObject1).get(zzkhw);
      if (localObject2 != null)
      {
        zzkht.onUpdate(paramDetections, localObject2);
        return;
      }
      zzkht.onDone();
      zzkhv = false;
    }
    int i = selectFocus(paramDetections);
    localObject1 = ((SparseArray)localObject1).get(i);
    if (localObject1 == null)
    {
      paramDetections = new StringBuilder(35);
      paramDetections.append("Invalid focus selected: ");
      paramDetections.append(i);
      paramDetections.toString();
      return;
    }
    zzkhv = true;
    zzkhw = i;
    zzkhe.setFocus(zzkhw);
    zzkht.onNewItem(zzkhw, localObject1);
    zzkht.onUpdate(paramDetections, localObject1);
  }
  
  public void release()
  {
    zzkht.onDone();
  }
  
  public abstract int selectFocus(Detector.Detections paramDetections);
  
  public final void zzer(int paramInt)
  {
    if (paramInt >= 0)
    {
      zzkhu = paramInt;
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(28, "Invalid max gap: ", paramInt));
  }
}
