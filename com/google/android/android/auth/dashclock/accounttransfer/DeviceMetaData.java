package com.google.android.android.auth.dashclock.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public class DeviceMetaData
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.accounttransfer.DeviceMetaData> CREATOR = new Point.1();
  public int zzdxs;
  public boolean zzdzu;
  public long zzdzv;
  public final boolean zzdzw;
  
  public DeviceMetaData(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    zzdxs = paramInt;
    zzdzu = paramBoolean1;
    zzdzv = paramLong;
    zzdzw = paramBoolean2;
  }
  
  public long getMinAgeOfLockScreen()
  {
    return zzdzv;
  }
  
  public boolean isChallengeAllowed()
  {
    return zzdzw;
  }
  
  public boolean isLockScreenSolved()
  {
    return zzdzu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.onAction(paramParcel, 2, isLockScreenSolved());
    zzbcn.writeHeader(paramParcel, 3, getMinAgeOfLockScreen());
    zzbcn.onAction(paramParcel, 4, isChallengeAllowed());
    zzbcn.zzah(paramParcel, paramInt);
  }
}
