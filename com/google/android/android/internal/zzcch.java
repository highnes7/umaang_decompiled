package com.google.android.android.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.android.common.util.Log;
import com.google.android.android.wifi.identifier.AdvertisingIdClient;
import com.google.android.android.wifi.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public final class zzcch
  extends zzcdu
{
  public static final Pair<String, Long> zziqn = new Pair("", Long.valueOf(0L));
  public SharedPreferences zzdtq;
  public final zzccl zziqo = new zzccl(this, "health_monitor", zzcax.zzawq());
  public final zzcck zziqp = new zzcck(this, "last_upload", 0L);
  public final zzcck zziqq = new zzcck(this, "last_upload_attempt", 0L);
  public final zzcck zziqr = new zzcck(this, "backoff", 0L);
  public final zzcck zziqs = new zzcck(this, "last_delete_stale", 0L);
  public final zzcck zziqt = new zzcck(this, "midnight_offset", 0L);
  public final zzcck zziqu = new zzcck(this, "first_open_time", 0L);
  public final zzccm zziqv = new zzccm(this, "app_instance_id", null);
  public String zziqw;
  public boolean zziqx;
  public long zziqy;
  public String zziqz;
  public long zzira;
  public final Object zzirb = new Object();
  public final zzcck zzirc = new zzcck(this, "time_before_start", 10000L);
  public final zzcck zzird = new zzcck(this, "session_timeout", 1800000L);
  public final zzccj zzire = new zzccj(this, "start_new_session", true);
  public final zzcck zzirf = new zzcck(this, "last_pause_time", 0L);
  public final zzcck zzirg = new zzcck(this, "time_active", 0L);
  public boolean zzirh;
  
  public zzcch(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final SharedPreferences zzayl()
  {
    zzuj();
    zzwk();
    return zzdtq;
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    zzuj();
    zzaul().zzayj().append("Setting measurementEnabled", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzayl().edit();
    localEditor.putBoolean("measurement_enabled", paramBoolean);
    localEditor.apply();
  }
  
  public final String zzaym()
  {
    zzuj();
    return zzayl().getString("gmp_app_id", null);
  }
  
  public final String zzayn()
  {
    Object localObject = zzirb;
    try
    {
      if (Math.abs(zzvx().elapsedRealtime() - zzira) < 1000L)
      {
        String str = zziqz;
        return str;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Boolean zzayo()
  {
    zzuj();
    if (!zzayl().contains("use_service")) {
      return null;
    }
    return Boolean.valueOf(zzayl().getBoolean("use_service", false));
  }
  
  public final void zzayp()
  {
    zzuj();
    zzaul().zzayj().append("Clearing collection preferences.");
    boolean bool2 = zzayl().contains("measurement_enabled");
    boolean bool1 = true;
    if (bool2) {
      bool1 = zzbn(true);
    }
    SharedPreferences.Editor localEditor = zzayl().edit();
    localEditor.clear();
    localEditor.apply();
    if (bool2) {
      setMeasurementEnabled(bool1);
    }
  }
  
  public final String zzayq()
  {
    zzuj();
    String str1 = zzayl().getString("previous_os_version", null);
    zzaub().zzwk();
    String str2 = Build.VERSION.RELEASE;
    if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)))
    {
      SharedPreferences.Editor localEditor = zzayl().edit();
      localEditor.putString("previous_os_version", str2);
      localEditor.apply();
    }
    return str1;
  }
  
  public final void zzbm(boolean paramBoolean)
  {
    zzuj();
    zzaul().zzayj().append("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzayl().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
  }
  
  public final boolean zzbn(boolean paramBoolean)
  {
    zzuj();
    return zzayl().getBoolean("measurement_enabled", paramBoolean);
  }
  
  public final Pair zzjh(String paramString)
  {
    zzuj();
    long l = zzvx().elapsedRealtime();
    String str = zziqw;
    if ((str != null) && (l < zziqy)) {
      return new Pair(str, Boolean.valueOf(zziqx));
    }
    zziqy = (zzaun().parseAndAdd(paramString, zzcbm.zzioc) + l);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      if (paramString != null)
      {
        zziqw = paramString.getId();
        zziqx = paramString.isLimitAdTrackingEnabled();
      }
      paramString = zziqw;
      if (paramString == null) {
        zziqw = "";
      }
    }
    catch (Throwable paramString)
    {
      zzaul().zzayi().append("Unable to get advertising id", paramString);
      zziqw = "";
    }
    return new Pair(zziqw, Boolean.valueOf(zziqx));
  }
  
  public final String zzji(String paramString)
  {
    zzuj();
    paramString = (String)zzjhfirst;
    MessageDigest localMessageDigest = zzcfw.zzec("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  public final void zzjj(String paramString)
  {
    zzuj();
    SharedPreferences.Editor localEditor = zzayl().edit();
    localEditor.putString("gmp_app_id", paramString);
    localEditor.apply();
  }
  
  public final void zzjk(String paramString)
  {
    Object localObject = zzirb;
    try
    {
      zziqz = paramString;
      zzira = zzvx().elapsedRealtime();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void zzuk()
  {
    zzdtq = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    zzirh = zzdtq.getBoolean("has_been_opened", false);
    if (!zzirh)
    {
      SharedPreferences.Editor localEditor = zzdtq.edit();
      localEditor.putBoolean("has_been_opened", true);
      localEditor.apply();
    }
  }
}
