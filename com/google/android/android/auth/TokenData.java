package com.google.android.android.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;
import java.util.List;

public class TokenData
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.TokenData> CREATOR = new Point.1();
  public int zzdxs;
  public final String zzdxt;
  public final Long zzdxu;
  public final boolean zzdxv;
  public final boolean zzdxw;
  public final List<String> zzdxx;
  
  public TokenData(int paramInt, String paramString, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    zzdxs = paramInt;
    zzbp.zzgg(paramString);
    zzdxt = paramString;
    zzdxu = paramLong;
    zzdxv = paramBoolean1;
    zzdxw = paramBoolean2;
    zzdxx = paramList;
  }
  
  public static TokenData load(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(com.google.android.gms.auth.TokenData.class.getClassLoader());
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(com.google.android.gms.auth.TokenData.class.getClassLoader());
    return (TokenData)paramBundle.getParcelable("TokenData");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData)) {
      return false;
    }
    paramObject = (TokenData)paramObject;
    return (TextUtils.equals(zzdxt, zzdxt)) && (zzbf.equal(zzdxu, zzdxu)) && (zzdxv == zzdxv) && (zzdxw == zzdxw) && (zzbf.equal(zzdxx, zzdxx));
  }
  
  public final String getToken()
  {
    return zzdxt;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzdxt, zzdxu, Boolean.valueOf(zzdxv), Boolean.valueOf(zzdxw), zzdxx });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, zzdxt, false);
    zzbcn.writeValue(paramParcel, 3, zzdxu, false);
    zzbcn.onAction(paramParcel, 4, zzdxv);
    zzbcn.onAction(paramParcel, 5, zzdxw);
    zzbcn.readString(paramParcel, 6, zzdxx, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
