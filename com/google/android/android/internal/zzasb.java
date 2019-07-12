package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzasb
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzasb> CREATOR = new zzasc();
  public String accountType;
  public int zzdxs = 1;
  public byte[] zzdzs;
  
  public zzasb(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    zzbp.append(paramString);
    accountType = ((String)paramString);
    zzbp.append(paramArrayOfByte);
    zzdzs = ((byte[])paramArrayOfByte);
  }
  
  public zzasb(String paramString, byte[] paramArrayOfByte)
  {
    this(1, paramString, paramArrayOfByte);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, accountType, false);
    zzbcn.writeString(paramParcel, 3, zzdzs, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
