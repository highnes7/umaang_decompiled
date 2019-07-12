package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzdcc
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzdcc> CREATOR = new zzdcd();
  public int zzkil;
  
  public zzdcc() {}
  
  public zzdcc(int paramInt)
  {
    zzkil = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 2, zzkil);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
