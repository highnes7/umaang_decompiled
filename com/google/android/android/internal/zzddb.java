package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzddb
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzddb> CREATOR = new zzddc();
  public final String zzkjv;
  public final zzdcm zzkkb;
  public zzdcm zzkkc;
  public final String zzkke;
  public float zzkkf;
  public zzdcw[] zzkkl;
  public boolean zzkkm;
  
  public zzddb(zzdcw[] paramArrayOfZzdcw, zzdcm paramZzdcm1, zzdcm paramZzdcm2, String paramString1, float paramFloat, String paramString2, boolean paramBoolean)
  {
    zzkkl = paramArrayOfZzdcw;
    zzkkb = paramZzdcm1;
    zzkkc = paramZzdcm2;
    zzkke = paramString1;
    zzkkf = paramFloat;
    zzkjv = paramString2;
    zzkkm = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.writeHeader(paramParcel, 2, zzkkl, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 3, zzkkb, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 4, zzkkc, paramInt, false);
    zzbcn.append(paramParcel, 5, zzkke, false);
    zzbcn.set(paramParcel, 6, zzkkf);
    zzbcn.append(paramParcel, 7, zzkjv, false);
    zzbcn.onAction(paramParcel, 8, zzkkm);
    zzbcn.zzah(paramParcel, i);
  }
}
