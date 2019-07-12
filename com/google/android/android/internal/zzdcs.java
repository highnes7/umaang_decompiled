package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzdcs
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzdcs> CREATOR = new zzdct();
  public final String zzkjv;
  public final zzddb[] zzkka;
  public final zzdcm zzkkb;
  public zzdcm zzkkc;
  public zzdcm zzkkd;
  public final String zzkke;
  public float zzkkf;
  public int zzkkg;
  public final boolean zzkkh;
  public final int zzkki;
  public final int zzkkj;
  
  public zzdcs(zzddb[] paramArrayOfZzddb, zzdcm paramZzdcm1, zzdcm paramZzdcm2, zzdcm paramZzdcm3, String paramString1, float paramFloat, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    zzkka = paramArrayOfZzddb;
    zzkkb = paramZzdcm1;
    zzkkc = paramZzdcm2;
    zzkkd = paramZzdcm3;
    zzkke = paramString1;
    zzkkf = paramFloat;
    zzkjv = paramString2;
    zzkkg = paramInt1;
    zzkkh = paramBoolean;
    zzkki = paramInt2;
    zzkkj = paramInt3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.writeHeader(paramParcel, 2, zzkka, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 3, zzkkb, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 4, zzkkc, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 5, zzkkd, paramInt, false);
    zzbcn.append(paramParcel, 6, zzkke, false);
    zzbcn.set(paramParcel, 7, zzkkf);
    zzbcn.append(paramParcel, 8, zzkjv, false);
    zzbcn.setCustomVar(paramParcel, 9, zzkkg);
    zzbcn.onAction(paramParcel, 10, zzkkh);
    zzbcn.setCustomVar(paramParcel, 11, zzkki);
    zzbcn.setCustomVar(paramParcel, 12, zzkkj);
    zzbcn.zzah(paramParcel, i);
  }
}
