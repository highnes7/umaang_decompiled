package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzcav
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcav> CREATOR = new zzcaw();
  public String packageName;
  public int versionCode;
  public String zzimg;
  public zzcft zzimh;
  public long zzimi;
  public boolean zzimj;
  public String zzimk;
  public zzcbk zziml;
  public long zzimm;
  public zzcbk zzimn;
  public long zzimo;
  public zzcbk zzimp;
  
  public zzcav(int paramInt, String paramString1, String paramString2, zzcft paramZzcft, long paramLong1, boolean paramBoolean, String paramString3, zzcbk paramZzcbk1, long paramLong2, zzcbk paramZzcbk2, long paramLong3, zzcbk paramZzcbk3)
  {
    versionCode = paramInt;
    packageName = paramString1;
    zzimg = paramString2;
    zzimh = paramZzcft;
    zzimi = paramLong1;
    zzimj = paramBoolean;
    zzimk = paramString3;
    zziml = paramZzcbk1;
    zzimm = paramLong2;
    zzimn = paramZzcbk2;
    zzimo = paramLong3;
    zzimp = paramZzcbk3;
  }
  
  public zzcav(zzcav paramZzcav)
  {
    versionCode = 1;
    zzbp.append(paramZzcav);
    packageName = packageName;
    zzimg = zzimg;
    zzimh = zzimh;
    zzimi = zzimi;
    zzimj = zzimj;
    zzimk = zzimk;
    zziml = zziml;
    zzimm = zzimm;
    zzimn = zzimn;
    zzimo = zzimo;
    zzimp = zzimp;
  }
  
  public zzcav(String paramString1, String paramString2, zzcft paramZzcft, long paramLong1, boolean paramBoolean, String paramString3, zzcbk paramZzcbk1, long paramLong2, zzcbk paramZzcbk2, long paramLong3, zzcbk paramZzcbk3)
  {
    versionCode = 1;
    packageName = paramString1;
    zzimg = paramString2;
    zzimh = paramZzcft;
    zzimi = paramLong1;
    zzimj = paramBoolean;
    zzimk = paramString3;
    zziml = paramZzcbk1;
    zzimm = paramLong2;
    zzimn = paramZzcbk2;
    zzimo = paramLong3;
    zzimp = paramZzcbk3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.append(paramParcel, 2, packageName, false);
    zzbcn.append(paramParcel, 3, zzimg, false);
    zzbcn.addMenuItem(paramParcel, 4, zzimh, paramInt, false);
    zzbcn.writeHeader(paramParcel, 5, zzimi);
    zzbcn.onAction(paramParcel, 6, zzimj);
    zzbcn.append(paramParcel, 7, zzimk, false);
    zzbcn.addMenuItem(paramParcel, 8, zziml, paramInt, false);
    zzbcn.writeHeader(paramParcel, 9, zzimm);
    zzbcn.addMenuItem(paramParcel, 10, zzimn, paramInt, false);
    zzbcn.writeHeader(paramParcel, 11, zzimo);
    zzbcn.addMenuItem(paramParcel, 12, zzimp, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
