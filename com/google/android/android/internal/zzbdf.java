package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbdf
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbdf> CREATOR = new zzbdg();
  public int zzdxs;
  public final zzbdh zzfwk;
  
  public zzbdf(int paramInt, zzbdh paramZzbdh)
  {
    zzdxs = paramInt;
    zzfwk = paramZzbdh;
  }
  
  public zzbdf(zzbdh paramZzbdh)
  {
    zzdxs = 1;
    zzfwk = paramZzbdh;
  }
  
  public static zzbdf getId(zzbdn paramZzbdn)
  {
    if ((paramZzbdn instanceof zzbdh)) {
      return new zzbdf((zzbdh)paramZzbdn);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.addMenuItem(paramParcel, 2, zzfwk, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final zzbdn zzakp()
  {
    zzbdh localZzbdh = zzfwk;
    if (localZzbdh != null) {
      return localZzbdh;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}
