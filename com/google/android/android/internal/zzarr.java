package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzarr
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzarr> CREATOR = new zzars();
  public String accountType;
  public int zzdxs = 1;
  
  public zzarr(int paramInt, String paramString)
  {
    zzbp.append(paramString);
    accountType = ((String)paramString);
  }
  
  public zzarr(String paramString)
  {
    this(1, paramString);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, accountType, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
