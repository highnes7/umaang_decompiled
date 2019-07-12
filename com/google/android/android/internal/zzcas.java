package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;

public final class zzcas
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcas> CREATOR = new zzcat();
  public final String packageName;
  public final String zzhtt;
  public final String zzilu;
  public final String zzilv;
  public final long zzilw;
  public final long zzilx;
  public final String zzily;
  public final boolean zzilz;
  public final boolean zzima;
  public final long zzimb;
  public final String zzimc;
  public final long zzimd;
  public final long zzime;
  public final int zzimf;
  
  public zzcas(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, long paramLong4, long paramLong5, int paramInt)
  {
    zzbp.zzgg(paramString1);
    packageName = paramString1;
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = null;
    }
    zzilu = paramString2;
    zzhtt = paramString3;
    zzimb = paramLong1;
    zzilv = paramString4;
    zzilw = paramLong2;
    zzilx = paramLong3;
    zzily = paramString5;
    zzilz = paramBoolean1;
    zzima = paramBoolean2;
    zzimc = paramString6;
    zzimd = paramLong4;
    zzime = paramLong5;
    zzimf = paramInt;
  }
  
  public zzcas(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, String paramString6, long paramLong4, long paramLong5, int paramInt)
  {
    packageName = paramString1;
    zzilu = paramString2;
    zzhtt = paramString3;
    zzimb = paramLong3;
    zzilv = paramString4;
    zzilw = paramLong1;
    zzilx = paramLong2;
    zzily = paramString5;
    zzilz = paramBoolean1;
    zzima = paramBoolean2;
    zzimc = paramString6;
    zzimd = paramLong4;
    zzime = paramLong5;
    zzimf = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 2, packageName, false);
    zzbcn.append(paramParcel, 3, zzilu, false);
    zzbcn.append(paramParcel, 4, zzhtt, false);
    zzbcn.append(paramParcel, 5, zzilv, false);
    zzbcn.writeHeader(paramParcel, 6, zzilw);
    zzbcn.writeHeader(paramParcel, 7, zzilx);
    zzbcn.append(paramParcel, 8, zzily, false);
    zzbcn.onAction(paramParcel, 9, zzilz);
    zzbcn.onAction(paramParcel, 10, zzima);
    zzbcn.writeHeader(paramParcel, 11, zzimb);
    zzbcn.append(paramParcel, 12, zzimc, false);
    zzbcn.writeHeader(paramParcel, 13, zzimd);
    zzbcn.writeHeader(paramParcel, 14, zzime);
    zzbcn.setCustomVar(paramParcel, 15, zzimf);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
