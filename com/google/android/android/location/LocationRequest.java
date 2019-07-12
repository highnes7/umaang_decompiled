package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;

public final class LocationRequest
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.location.LocationRequest> CREATOR = new PaymentIntent.Output.1();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  public int mPriority;
  public boolean zzgzv;
  public long zzhxg;
  public long zzhxx;
  public long zzhxy;
  public int zzhxz;
  public float zzhya;
  public long zzhyb;
  
  public LocationRequest()
  {
    mPriority = 102;
    zzhxx = 3600000L;
    zzhxy = 600000L;
    zzgzv = false;
    zzhxg = Long.MAX_VALUE;
    zzhxz = Integer.MAX_VALUE;
    zzhya = 0.0F;
    zzhyb = 0L;
  }
  
  public LocationRequest(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt2, float paramFloat, long paramLong4)
  {
    mPriority = paramInt1;
    zzhxx = paramLong1;
    zzhxy = paramLong2;
    zzgzv = paramBoolean;
    zzhxg = paramLong3;
    zzhxz = paramInt2;
    zzhya = paramFloat;
    zzhyb = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  public static void zzai(long paramLong)
  {
    if (paramLong >= 0L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(38);
    localStringBuilder.append("invalid interval: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LocationRequest)) {
      return false;
    }
    paramObject = (LocationRequest)paramObject;
    return (mPriority == mPriority) && (zzhxx == zzhxx) && (zzhxy == zzhxy) && (zzgzv == zzgzv) && (zzhxg == zzhxg) && (zzhxz == zzhxz) && (zzhya == zzhya) && (getMaxWaitTime() == paramObject.getMaxWaitTime());
  }
  
  public final long getExpirationTime()
  {
    return zzhxg;
  }
  
  public final long getFastestInterval()
  {
    return zzhxy;
  }
  
  public final long getInterval()
  {
    return zzhxx;
  }
  
  public final long getMaxWaitTime()
  {
    long l1 = zzhyb;
    long l2 = zzhxx;
    if (l1 < l2) {
      return l2;
    }
    return l1;
  }
  
  public final int getNumUpdates()
  {
    return zzhxz;
  }
  
  public final int getPriority()
  {
    return mPriority;
  }
  
  public final float getSmallestDisplacement()
  {
    return zzhya;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(mPriority), Long.valueOf(zzhxx), Float.valueOf(zzhya), Long.valueOf(zzhyb) });
  }
  
  public final LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {
      zzhxg = Long.MAX_VALUE;
    } else {
      zzhxg = (paramLong + l);
    }
    if (zzhxg < 0L) {
      zzhxg = 0L;
    }
    return this;
  }
  
  public final LocationRequest setExpirationTime(long paramLong)
  {
    zzhxg = paramLong;
    if (zzhxg < 0L) {
      zzhxg = 0L;
    }
    return this;
  }
  
  public final LocationRequest setFastestInterval(long paramLong)
  {
    zzai(paramLong);
    zzgzv = true;
    zzhxy = paramLong;
    return this;
  }
  
  public final LocationRequest setInterval(long paramLong)
  {
    zzai(paramLong);
    zzhxx = paramLong;
    if (!zzgzv)
    {
      double d = zzhxx;
      Double.isNaN(d);
      zzhxy = ((d / 6.0D));
    }
    return this;
  }
  
  public final LocationRequest setMaxWaitTime(long paramLong)
  {
    zzai(paramLong);
    zzhyb = paramLong;
    return this;
  }
  
  public final LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt > 0)
    {
      zzhxz = paramInt;
      return this;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(31, "invalid numUpdates: ", paramInt));
  }
  
  public final LocationRequest setPriority(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 102) && (paramInt != 104) && (paramInt != 105)) {
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(28, "invalid quality: ", paramInt));
    }
    mPriority = paramInt;
    return this;
  }
  
  public final LocationRequest setSmallestDisplacement(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      zzhya = paramFloat;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder(37);
    localStringBuilder.append("invalid displacement: ");
    localStringBuilder.append(paramFloat);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Request[");
    int i = mPriority;
    String str;
    if (i != 100)
    {
      if (i != 102)
      {
        if (i != 104)
        {
          if (i != 105) {
            str = "???";
          } else {
            str = "PRIORITY_NO_POWER";
          }
        }
        else {
          str = "PRIORITY_LOW_POWER";
        }
      }
      else {
        str = "PRIORITY_BALANCED_POWER_ACCURACY";
      }
    }
    else {
      str = "PRIORITY_HIGH_ACCURACY";
    }
    localStringBuilder.append(str);
    if (mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(zzhxx);
      localStringBuilder.append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(zzhxy);
    localStringBuilder.append("ms");
    if (zzhyb > zzhxx)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(zzhyb);
      localStringBuilder.append("ms");
    }
    if (zzhya > 0.0F)
    {
      localStringBuilder.append(" smallestDisplacement=");
      localStringBuilder.append(zzhya);
      localStringBuilder.append("m");
    }
    long l1 = zzhxg;
    if (l1 != Long.MAX_VALUE)
    {
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
    }
    if (zzhxz != Integer.MAX_VALUE)
    {
      localStringBuilder.append(" num=");
      localStringBuilder.append(zzhxz);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, mPriority);
    zzbcn.writeHeader(paramParcel, 2, zzhxx);
    zzbcn.writeHeader(paramParcel, 3, zzhxy);
    zzbcn.onAction(paramParcel, 4, zzgzv);
    zzbcn.writeHeader(paramParcel, 5, zzhxg);
    zzbcn.setCustomVar(paramParcel, 6, zzhxz);
    zzbcn.set(paramParcel, 7, zzhya);
    zzbcn.writeHeader(paramParcel, 8, zzhyb);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
