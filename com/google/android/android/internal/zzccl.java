package com.google.android.android.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import java.security.SecureRandom;

public final class zzccl
{
  public final long zzdtu;
  public String zzirm;
  public final String zzirn;
  public final String zziro;
  
  public zzccl(zzcch paramZzcch, String paramString, long paramLong)
  {
    zzbp.zzgg(paramString);
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbh(bool);
    zzirm = String.valueOf(paramString).concat(":start");
    zzirn = String.valueOf(paramString).concat(":count");
    zziro = String.valueOf(paramString).concat(":value");
    zzdtu = paramLong;
  }
  
  private final void zzzh()
  {
    zzirk.zzuj();
    long l = zzirk.zzvx().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzcch.getDefaultSharedPreferences(zzirk).edit();
    localEditor.remove(zzirn);
    localEditor.remove(zziro);
    localEditor.putLong(zzirm, l);
    localEditor.apply();
  }
  
  private final long zzzj()
  {
    return zzcch.prefs(zzirk).getLong(zzirm, 0L);
  }
  
  public final void store(String paramString, long paramLong)
  {
    zzirk.zzuj();
    if (zzzj() == 0L) {
      zzzh();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l = zzcch.getDefaultSharedPreferences(zzirk).getLong(zzirn, 0L);
    if (l <= 0L)
    {
      paramString = zzcch.getDefaultSharedPreferences(zzirk).edit();
      paramString.putString(zziro, str);
      paramString.putLong(zzirn, 1L);
      paramString.apply();
      return;
    }
    paramLong = zzirk.zzauh().zzazy().nextLong();
    l += 1L;
    int i;
    if ((paramLong & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / l) {
      i = 1;
    } else {
      i = 0;
    }
    paramString = zzcch.getDefaultSharedPreferences(zzirk).edit();
    if (i != 0) {
      paramString.putString(zziro, str);
    }
    paramString.putLong(zzirn, l);
    paramString.apply();
  }
  
  public final Pair zzzi()
  {
    zzirk.zzuj();
    Object localObject = zzirk;
    zzccl localZzccl = this;
    ((zzcdt)localObject).zzuj();
    long l1 = localZzccl.zzzj();
    if (l1 == 0L)
    {
      localZzccl.zzzh();
      l1 = 0L;
    }
    else
    {
      l1 = Math.abs(l1 - zzirk.zzvx().currentTimeMillis());
    }
    localZzccl = this;
    long l2 = zzdtu;
    if (l1 < l2) {
      return null;
    }
    if (l1 > l2 << 1)
    {
      localZzccl.zzzh();
      return null;
    }
    localObject = zzcch.prefs(zzirk).getString(zziro, null);
    l1 = zzcch.prefs(zzirk).getLong(zzirn, 0L);
    localZzccl.zzzh();
    if ((localObject != null) && (l1 > 0L)) {
      return new Pair(localObject, Long.valueOf(l1));
    }
    return zzcch.zziqn;
  }
}
