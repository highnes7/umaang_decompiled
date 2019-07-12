package com.google.android.android.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.package_9.Scope;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class zzbu
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.common.internal.zzbu> CREATOR = new zzbv();
  public int zzdxs;
  public final int zzfwb;
  public final int zzfwc;
  @Deprecated
  public final Scope[] zzfwd;
  
  public zzbu(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    zzdxs = paramInt1;
    zzfwb = paramInt2;
    zzfwc = paramInt3;
    zzfwd = paramArrayOfScope;
  }
  
  public zzbu(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.setCustomVar(paramParcel, 2, zzfwb);
    zzbcn.setCustomVar(paramParcel, 3, zzfwc);
    zzbcn.writeHeader(paramParcel, 4, zzfwd, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
