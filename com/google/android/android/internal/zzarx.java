package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzarx
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzarx> CREATOR = new zzary();
  public String accountType;
  public int zzdxs = 1;
  public int zzdzy;
  
  public zzarx(int paramInt1, String paramString, int paramInt2)
  {
    zzbp.append(paramString);
    accountType = ((String)paramString);
    zzdzy = paramInt2;
  }
  
  public zzarx(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, accountType, false);
    zzbcn.setCustomVar(paramParcel, 3, zzdzy);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
