package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzcbk
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcbk> CREATOR = new zzcbl();
  public final String name;
  public final String zzimg;
  public final zzcbh zzinr;
  public final long zzins;
  
  public zzcbk(zzcbk paramZzcbk, long paramLong)
  {
    zzbp.append(paramZzcbk);
    name = name;
    zzinr = zzinr;
    zzimg = zzimg;
    zzins = paramLong;
  }
  
  public zzcbk(String paramString1, zzcbh paramZzcbh, String paramString2, long paramLong)
  {
    name = paramString1;
    zzinr = paramZzcbh;
    zzimg = paramString2;
    zzins = paramLong;
  }
  
  public final String toString()
  {
    String str1 = zzimg;
    String str2 = name;
    String str3 = String.valueOf(zzinr);
    int i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str2, f.sufficientlysecure.rootcommands.util.StringBuilder.append(str1, 21));
    StringBuilder localStringBuilder = new StringBuilder(str3.length() + i);
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, ",params=", str3);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 2, name, false);
    zzbcn.addMenuItem(paramParcel, 3, zzinr, paramInt, false);
    zzbcn.append(paramParcel, 4, zzimg, false);
    zzbcn.writeHeader(paramParcel, 5, zzins);
    zzbcn.zzah(paramParcel, i);
  }
}
