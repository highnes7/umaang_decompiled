package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbh;
import java.util.Arrays;

public final class zzekv
{
  public String zzdxt;
  
  public zzekv(String paramString)
  {
    zzdxt = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzekv)) {
      return false;
    }
    paramObject = (zzekv)paramObject;
    return zzbf.equal(zzdxt, zzdxt);
  }
  
  public final String getToken()
  {
    return zzdxt;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzdxt });
  }
  
  public final String toString()
  {
    return zzbf.peekPersisted(this).add("token", zzdxt).toString();
  }
}
