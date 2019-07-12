package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbdt
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbdt> CREATOR = new zzbdq();
  public final String userId;
  public int versionCode;
  public final com.google.android.gms.internal.zzbdm<?, ?> zzfxe;
  
  public zzbdt(int paramInt, String paramString, zzbdm paramZzbdm)
  {
    versionCode = paramInt;
    userId = paramString;
    zzfxe = paramZzbdm;
  }
  
  public zzbdt(String paramString, zzbdm paramZzbdm)
  {
    versionCode = 1;
    userId = paramString;
    zzfxe = paramZzbdm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.append(paramParcel, 2, userId, false);
    zzbcn.addMenuItem(paramParcel, 3, zzfxe, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
