package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.zzbs;

public final class zzcqf
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcqf> CREATOR = new zzcqg();
  public int zzdxs;
  public final ConnectionResult zzfiz;
  public final zzbs zzjny;
  
  public zzcqf(int paramInt)
  {
    this(1, new ConnectionResult(8, null), null);
  }
  
  public zzcqf(int paramInt, ConnectionResult paramConnectionResult, zzbs paramZzbs)
  {
    zzdxs = paramInt;
    zzfiz = paramConnectionResult;
    zzjny = paramZzbs;
  }
  
  public zzcqf(ConnectionResult paramConnectionResult, zzbs paramZzbs)
  {
    this(1, paramConnectionResult, null);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.addMenuItem(paramParcel, 2, zzfiz, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 3, zzjny, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final ConnectionResult zzagd()
  {
    return zzfiz;
  }
  
  public final zzbs zzbcc()
  {
    return zzjny;
  }
}
