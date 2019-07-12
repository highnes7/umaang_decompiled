package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbq;

public final class zzcqd
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcqd> CREATOR = new zzcqe();
  public int zzdxs;
  public zzbq zzjnx;
  
  public zzcqd(int paramInt, zzbq paramZzbq)
  {
    zzdxs = paramInt;
    zzjnx = paramZzbq;
  }
  
  public zzcqd(zzbq paramZzbq)
  {
    this(1, paramZzbq);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.addMenuItem(paramParcel, 2, zzjnx, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
