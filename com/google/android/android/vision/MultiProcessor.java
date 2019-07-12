package com.google.android.android.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Processor;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiProcessor<T>
  implements Detector.Processor<T>
{
  public int zzkhu = 3;
  public com.google.android.gms.vision.MultiProcessor.Factory<T> zzkig;
  public SparseArray<com.google.android.gms.vision.MultiProcessor.zza> zzkih = new SparseArray();
  
  public MultiProcessor() {}
  
  private final void deleteItems(Detector.Detections paramDetections)
  {
    SparseArray localSparseArray = paramDetections.getDetectedItems();
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      Object localObject = localSparseArray.valueAt(i);
      zza localZza = (zza)zzkih.get(j);
      zzkhx = 0;
      zzkht.onUpdate(paramDetections, localObject);
      i += 1;
    }
  }
  
  public void receiveDetections(Detector.Detections paramDetections)
  {
    Object localObject1 = paramDetections.getDetectedItems();
    int j = 0;
    int i = 0;
    zza localZza;
    while (i < ((SparseArray)localObject1).size())
    {
      int k = ((SparseArray)localObject1).keyAt(i);
      localObject2 = ((SparseArray)localObject1).valueAt(i);
      if (zzkih.get(k) == null)
      {
        localZza = new zza(null);
        zzkht = zzkig.create(localObject2);
        zzkht.onNewItem(k, localObject2);
        zzkih.append(k, localZza);
      }
      i += 1;
    }
    localObject1 = paramDetections.getDetectedItems();
    Object localObject2 = new HashSet();
    i = j;
    while (i < zzkih.size())
    {
      j = zzkih.keyAt(i);
      if (((SparseArray)localObject1).get(j) == null)
      {
        localZza = (zza)zzkih.valueAt(i);
        zza.access$2608(localZza);
        if (zzkhx >= zzkhu)
        {
          zzkht.onDone();
          ((Set)localObject2).add(Integer.valueOf(j));
        }
        else
        {
          zzkht.onMissing(paramDetections);
        }
      }
      i += 1;
    }
    localObject1 = ((Set)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      zzkih.delete(((Integer)localObject2).intValue());
    }
    deleteItems(paramDetections);
  }
  
  public void release()
  {
    int i = 0;
    while (i < zzkih.size())
    {
      zzkih.valueAt(i)).zzkht.onDone();
      i += 1;
    }
    zzkih.clear();
  }
  
  public class Builder<T>
  {
    public com.google.android.gms.vision.MultiProcessor<T> zzkii = new MultiProcessor();
    
    public Builder()
    {
      if (this$1 != null)
      {
        zzkii.zzkig = this$1;
        return;
      }
      throw new IllegalArgumentException("No factory supplied.");
    }
    
    public MultiProcessor build()
    {
      return zzkii;
    }
    
    public Builder setMaxGapFrames(int paramInt)
    {
      if (paramInt >= 0)
      {
        zzkii.zzkhu = paramInt;
        return this;
      }
      throw new IllegalArgumentException(StringBuilder.add(28, "Invalid max gap: ", paramInt));
    }
  }
  
  public abstract interface Factory<T>
  {
    public abstract Tracker create(Object paramObject);
  }
  
  public final class zza
  {
    public com.google.android.gms.vision.Tracker<T> zzkht;
    public int zzkhx = 0;
    
    public zza() {}
  }
}
