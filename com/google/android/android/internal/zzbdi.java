package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbdi
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbdi> CREATOR = new zzbdk();
  public int versionCode;
  public final String zzfwo;
  public final int zzfwp;
  
  public zzbdi(int paramInt1, String paramString, int paramInt2)
  {
    versionCode = paramInt1;
    zzfwo = paramString;
    zzfwp = paramInt2;
  }
  
  public zzbdi(String paramString, int paramInt)
  {
    versionCode = 1;
    zzfwo = paramString;
    zzfwp = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.append(paramParcel, 2, zzfwo, false);
    zzbcn.setCustomVar(paramParcel, 3, zzfwp);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
