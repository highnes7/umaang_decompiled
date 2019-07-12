package com.google.android.android.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import java.util.UUID;

public final class zzaot
{
  public final String mName;
  public final long zzdtu;
  
  public zzaot(zzaor paramZzaor, String paramString, long paramLong)
  {
    zzbp.zzgg(paramString);
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbh(bool);
    mName = paramString;
    zzdtu = paramLong;
  }
  
  private final void zzzh()
  {
    long l = zzdtv.zzvx().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzdtv.zzdtq.edit();
    localEditor.remove(zzzl());
    localEditor.remove(zzzm());
    localEditor.putLong(zzzk(), l);
    localEditor.commit();
  }
  
  private final long zzzj()
  {
    return zzdtv.zzdtq.getLong(zzzk(), 0L);
  }
  
  private final String zzzk()
  {
    return String.valueOf(mName).concat(":start");
  }
  
  private final String zzzl()
  {
    return String.valueOf(mName).concat(":count");
  }
  
  private final String zzzm()
  {
    return String.valueOf(mName).concat(":value");
  }
  
  public final void zzdy(String paramString)
  {
    if (zzzj() == 0L) {
      zzzh();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    for (;;)
    {
      try
      {
        long l2 = zzdtv.zzdtq.getLong(zzzl(), 0L);
        if (l2 <= 0L)
        {
          paramString = zzdtv.zzdtq.edit();
          paramString.putString(zzzm(), str);
          paramString.putLong(zzzl(), 1L);
          paramString.apply();
          return;
        }
        long l1 = UUID.randomUUID().getLeastSignificantBits();
        l2 += 1L;
        if ((l1 & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / l2)
        {
          i = 1;
          paramString = zzdtv.zzdtq.edit();
          if (i != 0) {
            paramString.putString(zzzm(), str);
          }
          paramString.putLong(zzzl(), l2);
          paramString.apply();
          return;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      int i = 0;
    }
  }
  
  public final Pair zzzi()
  {
    long l1 = zzzj();
    if (l1 == 0L) {
      l1 = 0L;
    } else {
      l1 = Math.abs(l1 - zzdtv.zzvx().currentTimeMillis());
    }
    long l2 = zzdtu;
    if (l1 < l2) {
      return null;
    }
    if (l1 > l2 << 1)
    {
      zzzh();
      return null;
    }
    String str = zzdtv.zzdtq.getString(zzzm(), null);
    l1 = zzdtv.zzdtq.getLong(zzzl(), 0L);
    zzzh();
    if (str != null)
    {
      if (l1 <= 0L) {
        return null;
      }
      return new Pair(str, Long.valueOf(l1));
    }
    return null;
  }
}
