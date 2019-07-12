package com.google.android.android.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.util.Log;

public final class zzaor
  extends zzams
{
  public SharedPreferences zzdtq;
  public long zzdtr;
  public long zzdts = -1L;
  public final zzaot zzdtt = new zzaot(this, "monitoring", ((Long)zzaod.zzdso.setDoOutput()).longValue());
  
  public zzaor(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public final void zzdx(String paramString)
  {
    TerminalManager.zzuj();
    zzwk();
    SharedPreferences.Editor localEditor = zzdtq.edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("installation_campaign");
    } else {
      localEditor.putString("installation_campaign", paramString);
    }
    if (!localEditor.commit()) {
      zzdp("Failed to commit campaign data");
    }
  }
  
  public final void zzuk()
  {
    zzdtq = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
  }
  
  public final long zzzb()
  {
    TerminalManager.zzuj();
    zzwk();
    if (zzdtr == 0L)
    {
      long l = zzdtq.getLong("first_run", 0L);
      if (l != 0L)
      {
        zzdtr = l;
      }
      else
      {
        l = zzvx().currentTimeMillis();
        SharedPreferences.Editor localEditor = zzdtq.edit();
        localEditor.putLong("first_run", l);
        if (!localEditor.commit()) {
          zzdp("Failed to commit first run time");
        }
        zzdtr = l;
      }
    }
    return zzdtr;
  }
  
  public final zzaoz zzzc()
  {
    return new zzaoz(zzvx(), zzzb());
  }
  
  public final long zzzd()
  {
    TerminalManager.zzuj();
    zzwk();
    if (zzdts == -1L) {
      zzdts = zzdtq.getLong("last_dispatch", 0L);
    }
    return zzdts;
  }
  
  public final void zzze()
  {
    TerminalManager.zzuj();
    zzwk();
    long l = zzvx().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzdtq.edit();
    localEditor.putLong("last_dispatch", l);
    localEditor.apply();
    zzdts = l;
  }
  
  public final String zzzf()
  {
    TerminalManager.zzuj();
    zzwk();
    String str = zzdtq.getString("installation_campaign", null);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str;
  }
  
  public final zzaot zzzg()
  {
    return zzdtt;
  }
}
