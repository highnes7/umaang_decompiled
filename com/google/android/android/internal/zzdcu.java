package com.google.android.android.internal;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzdcu
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzdcu> CREATOR = new zzdcv();
  public final Rect zzkkk;
  
  public zzdcu()
  {
    zzkkk = new Rect();
  }
  
  public zzdcu(Rect paramRect)
  {
    zzkkk = paramRect;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.addMenuItem(paramParcel, 2, zzkkk, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
