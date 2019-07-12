package com.google.android.android.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.android.common.internal.zzbp;

public final class zzcck
{
  public final String zzbff;
  public long zzdmt;
  public boolean zzirj;
  public final long zzirl;
  
  public zzcck(zzcch paramZzcch, String paramString, long paramLong)
  {
    zzbp.zzgg(paramString);
    zzbff = paramString;
    zzirl = paramLong;
  }
  
  public final long lastModified()
  {
    if (!zzirj)
    {
      zzirj = true;
      zzdmt = zzcch.getDefaultSharedPreferences(zzirk).getLong(zzbff, zzirl);
    }
    return zzdmt;
  }
  
  public final void setDefaultAccount(long paramLong)
  {
    SharedPreferences.Editor localEditor = zzcch.getDefaultSharedPreferences(zzirk).edit();
    localEditor.putLong(zzbff, paramLong);
    localEditor.apply();
    zzdmt = paramLong;
  }
}
