package com.google.android.android.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.Status;

public final class zzcpv
  extends zzbck
  implements Result
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcpv> CREATOR = new zzcpw();
  public int zzdxs;
  public int zzjnt;
  public Intent zzjnu;
  
  public zzcpv()
  {
    this(0, null);
  }
  
  public zzcpv(int paramInt1, int paramInt2, Intent paramIntent)
  {
    zzdxs = paramInt1;
    zzjnt = paramInt2;
    zzjnu = paramIntent;
  }
  
  public zzcpv(int paramInt, Intent paramIntent)
  {
    this(2, 0, null);
  }
  
  public final Status getStatus()
  {
    if (zzjnt == 0) {
      return Status.zzfhv;
    }
    return Status.zzfhz;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.setCustomVar(paramParcel, 2, zzjnt);
    zzbcn.addMenuItem(paramParcel, 3, zzjnu, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
