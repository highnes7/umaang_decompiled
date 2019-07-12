package com.google.android.android.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.android.common.internal.zzbp;

public final class zzccj
{
  public final String zzbff;
  public boolean zzfgq;
  public final boolean zziri;
  public boolean zzirj;
  
  public zzccj(zzcch paramZzcch, String paramString, boolean paramBoolean)
  {
    zzbp.zzgg(paramString);
    zzbff = paramString;
    zziri = true;
  }
  
  public final boolean getActiveAccount()
  {
    if (!zzirj)
    {
      zzirj = true;
      zzfgq = zzcch.getDefaultSharedPreferences(zzirk).getBoolean(zzbff, zziri);
    }
    return zzfgq;
  }
  
  public final void updatePreferences(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = zzcch.getDefaultSharedPreferences(zzirk).edit();
    localEditor.putBoolean(zzbff, paramBoolean);
    localEditor.apply();
    zzfgq = paramBoolean;
  }
}
