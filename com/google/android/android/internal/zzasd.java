package com.google.android.android.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzasd
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzasd> CREATOR = new zzase();
  public String accountType;
  public int zzdxs = 1;
  public PendingIntent zzdzz;
  
  public zzasd(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    zzbp.append(paramString);
    accountType = ((String)paramString);
    zzbp.append(paramPendingIntent);
    zzdzz = ((PendingIntent)paramPendingIntent);
  }
  
  public zzasd(String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramString, paramPendingIntent);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, accountType, false);
    zzbcn.addMenuItem(paramParcel, 3, zzdzz, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
