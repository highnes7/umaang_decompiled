package com.google.android.android.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.android.internal.zzbcp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivityRecognitionResult
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.location.ActivityRecognitionResult> CREATOR = new DiscreteSeekBar.CustomState.1();
  public Bundle extras;
  public List<com.google.android.gms.location.DetectedActivity> zzhwu;
  public long zzhwv;
  public long zzhww;
  public int zzhwx;
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(List paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(List paramList, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramList != null) && (paramList.size() > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.get(bool1, "Must have at least 1 detected activity");
    if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    zzbp.get(bool1, "Must set times");
    zzhwu = paramList;
    zzhwv = paramLong1;
    zzhww = paramLong2;
    zzhwx = paramInt;
    extras = paramBundle;
  }
  
  public static List execute(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent == null) {
      bool = false;
    } else {
      bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST");
    }
    if (!bool) {
      return null;
    }
    return zzbcp.get(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    if (hasResult(paramIntent))
    {
      Object localObject2 = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
      localObject1 = localObject2;
      if ((localObject2 instanceof byte[])) {
        localObject1 = zzbcp.get((byte[])localObject2, CREATOR);
      } else {
        if (!(localObject2 instanceof ActivityRecognitionResult)) {
          break label55;
        }
      }
      localObject1 = (ActivityRecognitionResult)localObject1;
      break label57;
    }
    label55:
    Object localObject1 = null;
    label57:
    if (localObject1 != null) {
      return localObject1;
    }
    paramIntent = execute(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.isEmpty()) {
        return null;
      }
      return (ActivityRecognitionResult)f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramIntent, -1);
    }
    return null;
  }
  
  public static boolean get(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return true;
    }
    if ((paramBundle1 != null) || (paramBundle2 == null))
    {
      if ((paramBundle1 != null) && (paramBundle2 == null)) {
        return false;
      }
      if (paramBundle1.size() != paramBundle2.size()) {
        return false;
      }
      Iterator localIterator = paramBundle1.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!paramBundle2.containsKey(str)) {
          return false;
        }
        if (paramBundle1.get(str) == null)
        {
          if (paramBundle2.get(str) != null) {
            return false;
          }
        }
        else if ((paramBundle1.get(str) instanceof Bundle))
        {
          if (!get(paramBundle1.getBundle(str), paramBundle2.getBundle(str))) {
            return false;
          }
        }
        else if (!paramBundle1.get(str).equals(paramBundle2.get(str))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
      return true;
    }
    paramIntent = execute(paramIntent);
    return (paramIntent != null) && (!paramIntent.isEmpty());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (com.google.android.gms.location.ActivityRecognitionResult.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (ActivityRecognitionResult)paramObject;
      if ((zzhwv == zzhwv) && (zzhww == zzhww) && (zzhwx == zzhwx) && (zzbf.equal(zzhwu, zzhwu)) && (get(extras, extras))) {
        return true;
      }
    }
    return false;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = zzhwu.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return zzhww;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)zzhwu.get(0);
  }
  
  public List getProbableActivities()
  {
    return zzhwu;
  }
  
  public long getTime()
  {
    return zzhwv;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(zzhwv), Long.valueOf(zzhww), Integer.valueOf(zzhwx), zzhwu, extras });
  }
  
  public String toString()
  {
    String str = String.valueOf(zzhwu);
    long l1 = zzhwv;
    long l2 = zzhww;
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 124);
    localStringBuilder.append("ActivityRecognitionResult [probableActivities=");
    localStringBuilder.append(str);
    localStringBuilder.append(", timeMillis=");
    localStringBuilder.append(l1);
    localStringBuilder.append(", elapsedRealtimeMillis=");
    localStringBuilder.append(l2);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.save(paramParcel, 1, zzhwu, false);
    zzbcn.writeHeader(paramParcel, 2, zzhwv);
    zzbcn.writeHeader(paramParcel, 3, zzhww);
    zzbcn.setCustomVar(paramParcel, 4, zzhwx);
    zzbcn.writeString(paramParcel, 5, extras, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
