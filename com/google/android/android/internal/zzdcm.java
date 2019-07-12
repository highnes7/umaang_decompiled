package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzdcm
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzdcm> CREATOR = new zzdcn();
  public final int height;
  public final int left;
  public final int width;
  public final int y;
  public final float zzkjz;
  
  public zzdcm(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    left = paramInt1;
    y = paramInt2;
    width = paramInt3;
    height = paramInt4;
    zzkjz = paramFloat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 2, left);
    zzbcn.setCustomVar(paramParcel, 3, y);
    zzbcn.setCustomVar(paramParcel, 4, width);
    zzbcn.setCustomVar(paramParcel, 5, height);
    zzbcn.set(paramParcel, 6, zzkjz);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
