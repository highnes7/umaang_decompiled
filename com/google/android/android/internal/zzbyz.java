package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.Status;

public final class zzbyz
  extends zzbck
  implements Result
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbyz> CREATOR = new zzbza();
  public static zzbyz zzhzj = new zzbyz(Status.zzfhv);
  public final Status mStatus;
  
  public zzbyz(Status paramStatus)
  {
    mStatus = paramStatus;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.addMenuItem(paramParcel, 1, getStatus(), paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
