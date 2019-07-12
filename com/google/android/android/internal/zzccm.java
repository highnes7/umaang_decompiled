package com.google.android.android.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.android.common.internal.zzbp;

public final class zzccm
{
  public String mValue;
  public final String zzbff;
  public boolean zzirj;
  public final String zzirp;
  
  public zzccm(zzcch paramZzcch, String paramString1, String paramString2)
  {
    zzbp.zzgg(paramString1);
    zzbff = paramString1;
    zzirp = null;
  }
  
  public final String zzayr()
  {
    if (!zzirj)
    {
      zzirj = true;
      mValue = zzcch.getDefaultSharedPreferences(zzirk).getString(zzbff, null);
    }
    return mValue;
  }
  
  public final void zzjl(String paramString)
  {
    if (zzcfw.zzas(paramString, mValue)) {
      return;
    }
    SharedPreferences.Editor localEditor = zzcch.getDefaultSharedPreferences(zzirk).edit();
    localEditor.putString(zzbff, paramString);
    localEditor.apply();
    mValue = paramString;
  }
}
