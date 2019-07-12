package com.google.android.android.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzcbe
  extends zzcdu
{
  public long zzing;
  public String zzinh;
  public Boolean zzini;
  
  public zzcbe(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final long zzaxw()
  {
    zzwk();
    return zzing;
  }
  
  public final String zzaxx()
  {
    zzwk();
    return zzinh;
  }
  
  public final boolean zzdm(Context paramContext)
  {
    if (zzini == null)
    {
      zzcax.zzawk();
      zzini = Boolean.valueOf(false);
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext.getPackageInfo("com.google.android.gms", 128);
        zzini = Boolean.valueOf(true);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return zzini.booleanValue();
  }
  
  public final void zzuk()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = TimeUnit.MINUTES;
    int i = ((Calendar)localObject1).get(15);
    zzing = ((TimeUnit)localObject2).convert(((Calendar)localObject1).get(16) + i, TimeUnit.MILLISECONDS);
    localObject2 = Locale.getDefault();
    localObject1 = ((Locale)localObject2).getLanguage().toLowerCase(Locale.ENGLISH);
    localObject2 = ((Locale)localObject2).getCountry().toLowerCase(Locale.ENGLISH);
    zzinh = StringBuilder.append(StringBuilder.append(localObject2, StringBuilder.append(localObject1, 1)), (String)localObject1, "-", (String)localObject2);
  }
}
