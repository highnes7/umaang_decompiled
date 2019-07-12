package com.google.android.android.common.package_9;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.b.a.G;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbh;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;

public final class Status
  extends zzbck
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.common.api.Status> CREATOR = new DiscreteSeekBar.CustomState.1();
  public static final Status zzfhv = new Status(0);
  public static final Status zzfhw = new Status(14);
  public static final Status zzfhx = new Status(8);
  public static final Status zzfhy = new Status(15);
  public static final Status zzfhz = new Status(16);
  public static Status zzfia = new Status(17);
  public static Status zzfib = new Status(18);
  @G
  public final PendingIntent mPendingIntent;
  public int zzdxs;
  public final int zzfac;
  @G
  public final String zzffg;
  
  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }
  
  public Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    zzdxs = paramInt1;
    zzfac = paramInt2;
    zzffg = paramString;
    mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {
      return false;
    }
    paramObject = (Status)paramObject;
    return (zzdxs == zzdxs) && (zzfac == zzfac) && (zzbf.equal(zzffg, zzffg)) && (zzbf.equal(mPendingIntent, mPendingIntent));
  }
  
  public final PendingIntent getResolution()
  {
    return mPendingIntent;
  }
  
  public final Status getStatus()
  {
    return this;
  }
  
  public final int getStatusCode()
  {
    return zzfac;
  }
  
  public final String getStatusMessage()
  {
    return zzffg;
  }
  
  public final boolean hasResolution()
  {
    return mPendingIntent != null;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzdxs), Integer.valueOf(zzfac), zzffg, mPendingIntent });
  }
  
  public final boolean isCanceled()
  {
    return zzfac == 16;
  }
  
  public final boolean isInterrupted()
  {
    return zzfac == 14;
  }
  
  public final boolean isSuccess()
  {
    return zzfac <= 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString()
  {
    return zzbf.peekPersisted(this).add("statusCode", zzafu()).add("resolution", mPendingIntent).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, getStatusCode());
    zzbcn.append(paramParcel, 2, getStatusMessage(), false);
    zzbcn.addMenuItem(paramParcel, 3, mPendingIntent, paramInt, false);
    zzbcn.setCustomVar(paramParcel, 1000, zzdxs);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final String zzafu()
  {
    String str = zzffg;
    if (str != null) {
      return str;
    }
    return CommonStatusCodes.getStatusCodeString(zzfac);
  }
}
