package com.google.android.android.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.zzca;
import com.google.android.android.common.util.MergedCells;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzcax
  extends zzcdt
{
  public static String zzimq = String.valueOf(PingManager.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
  public Boolean zzdqo;
  
  public zzcax(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public static boolean zzaif()
  {
    return zzca.zzaif();
  }
  
  public static long zzauv()
  {
    return 11400L;
  }
  
  public static String zzavl()
  {
    return (String)zzcbm.zziob.get0();
  }
  
  public static int zzavm()
  {
    return 25;
  }
  
  public static int zzavn()
  {
    return 40;
  }
  
  public static int zzavo()
  {
    return 24;
  }
  
  public static int zzavp()
  {
    return 40;
  }
  
  public static int zzavq()
  {
    return 100;
  }
  
  public static int zzavr()
  {
    return 256;
  }
  
  public static int zzavs()
  {
    return 1000;
  }
  
  public static int zzavt()
  {
    return 36;
  }
  
  public static int zzavu()
  {
    return 2048;
  }
  
  public static int zzavv()
  {
    return 500;
  }
  
  public static long zzavw()
  {
    return ((Integer)zzcbm.zziol.get0()).intValue();
  }
  
  public static long zzavx()
  {
    return ((Integer)zzcbm.zzion.get0()).intValue();
  }
  
  public static int zzavy()
  {
    return 25;
  }
  
  public static int zzavz()
  {
    return 1000;
  }
  
  public static int zzawa()
  {
    return 25;
  }
  
  public static int zzawb()
  {
    return 1000;
  }
  
  public static long zzawc()
  {
    return 15552000000L;
  }
  
  public static long zzawd()
  {
    return 15552000000L;
  }
  
  public static long zzawe()
  {
    return 3600000L;
  }
  
  public static long zzawf()
  {
    return 60000L;
  }
  
  public static long zzawg()
  {
    return 61000L;
  }
  
  public static long zzawh()
  {
    return ((Long)zzcbm.zziph.get0()).longValue();
  }
  
  public static String zzawi()
  {
    return "google_app_measurement.db";
  }
  
  public static String zzawj()
  {
    return "google_app_measurement_local.db";
  }
  
  public static boolean zzawk()
  {
    return false;
  }
  
  public static long zzawm()
  {
    return ((Long)zzcbm.zzipe.get0()).longValue();
  }
  
  public static long zzawn()
  {
    return ((Long)zzcbm.zzioz.get0()).longValue();
  }
  
  public static long zzawo()
  {
    return ((Long)zzcbm.zzipa.get0()).longValue();
  }
  
  public static long zzawp()
  {
    return 1000L;
  }
  
  public static long zzawq()
  {
    return Math.max(0L, ((Long)zzcbm.zziod.get0()).longValue());
  }
  
  public static int zzawr()
  {
    return Math.max(0, ((Integer)zzcbm.zzioj.get0()).intValue());
  }
  
  public static int zzaws()
  {
    return Math.max(1, ((Integer)zzcbm.zziok.get0()).intValue());
  }
  
  public static int zzawt()
  {
    return 100000;
  }
  
  public static String zzawu()
  {
    return (String)zzcbm.zzior.get0();
  }
  
  public static long zzawv()
  {
    return ((Long)zzcbm.zzioe.get0()).longValue();
  }
  
  public static long zzaww()
  {
    return Math.max(0L, ((Long)zzcbm.zzios.get0()).longValue());
  }
  
  public static long zzawx()
  {
    return Math.max(0L, ((Long)zzcbm.zziou.get0()).longValue());
  }
  
  public static long zzawy()
  {
    return Math.max(0L, ((Long)zzcbm.zziov.get0()).longValue());
  }
  
  public static long zzawz()
  {
    return Math.max(0L, ((Long)zzcbm.zziow.get0()).longValue());
  }
  
  public static long zzaxa()
  {
    return Math.max(0L, ((Long)zzcbm.zziox.get0()).longValue());
  }
  
  public static long zzaxb()
  {
    return Math.max(0L, ((Long)zzcbm.zzioy.get0()).longValue());
  }
  
  public static long zzaxc()
  {
    return ((Long)zzcbm.zziot.get0()).longValue();
  }
  
  public static long zzaxd()
  {
    return Math.max(0L, ((Long)zzcbm.zzipb.get0()).longValue());
  }
  
  public static long zzaxe()
  {
    return Math.max(0L, ((Long)zzcbm.zzipc.get0()).longValue());
  }
  
  public static int zzaxf()
  {
    return Math.min(20, Math.max(0, ((Integer)zzcbm.zzipd.get0()).intValue()));
  }
  
  public static boolean zzaxh()
  {
    return ((Boolean)zzcbm.zzinz.get0()).booleanValue();
  }
  
  public final int next(String paramString, zzcbn paramZzcbn)
  {
    if (paramString == null) {}
    for (;;)
    {
      return ((Integer)paramZzcbn.get0()).intValue();
      paramString = zzaui().zzan(paramString, paramZzcbn.getKey());
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          paramString = paramZzcbn.add(Integer.valueOf(Integer.valueOf(paramString).intValue()));
          paramString = (Integer)paramString;
          int i = paramString.intValue();
          return i;
        }
        catch (NumberFormatException paramString) {}
      }
    }
  }
  
  public final long parseAndAdd(String paramString, zzcbn paramZzcbn)
  {
    if (paramString == null) {}
    for (;;)
    {
      return ((Long)paramZzcbn.get0()).longValue();
      paramString = zzaui().zzan(paramString, paramZzcbn.getKey());
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          paramString = paramZzcbn.add(Long.valueOf(Long.valueOf(paramString).longValue()));
          paramString = (Long)paramString;
          long l = paramString.longValue();
          return l;
        }
        catch (NumberFormatException paramString) {}
      }
    }
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzawk();
  }
  
  public final boolean zzawl()
  {
    Boolean localBoolean = zzit("firebase_analytics_collection_deactivated");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public final String zzaxg()
  {
    Object localObject;
    zzcby localZzcby;
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
      localObject = ((Method)localObject).invoke(null, new Object[] { "debug.firebase.analytics.app", "" });
      return (String)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localZzcby = zzaul().zzayd();
      localObject = "SystemProperties.get() threw an exception";
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localZzcby = zzaul().zzayd();
      localObject = "Could not access SystemProperties.get()";
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localZzcby = zzaul().zzayd();
      localObject = "Could not find SystemProperties.get() method";
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localZzcby = zzaul().zzayd();
      localObject = "Could not find SystemProperties class";
    }
    localZzcby.append((String)localObject, localClassNotFoundException);
    return "";
  }
  
  public final int zzis(String paramString)
  {
    return next(paramString, zzcbm.zziop);
  }
  
  public final Boolean zzit(String paramString)
  {
    zzbp.zzgg(paramString);
    try
    {
      Object localObject = getContext().getPackageManager();
      if (localObject == null)
      {
        zzaul().zzayd().append("Failed to load metadata: PackageManager is null");
        return null;
      }
      localObject = zzbed.zzcr(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
      if (localObject == null)
      {
        zzaul().zzayd().append("Failed to load metadata: ApplicationInfo is null");
        return null;
      }
      if (metaData == null)
      {
        zzaul().zzayd().append("Failed to load metadata: Metadata bundle is null");
        return null;
      }
      Bundle localBundle = metaData;
      boolean bool = localBundle.containsKey(paramString);
      if (!bool) {
        return null;
      }
      localObject = metaData;
      bool = ((Bundle)localObject).getBoolean(paramString);
      return Boolean.valueOf(bool);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      zzaul().zzayd().append("Failed to load metadata: Package name not found", paramString);
    }
    return null;
  }
  
  public final boolean zziu(String paramString)
  {
    return "1".equals(zzaui().zzan(paramString, "gaia_collection_enabled"));
  }
  
  public final boolean zzxu()
  {
    if (zzdqo == null) {}
    for (;;)
    {
      try
      {
        if (zzdqo == null)
        {
          Object localObject = getContext().getApplicationInfo();
          String str = MergedCells.zzalk();
          if (localObject != null)
          {
            localObject = processName;
            if ((localObject == null) || (!((String)localObject).equals(str))) {
              break label107;
            }
            bool = true;
            zzdqo = Boolean.valueOf(bool);
          }
          if (zzdqo == null)
          {
            zzdqo = Boolean.TRUE;
            zzaul().zzayd().append("My process not in the list of running processes");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return zzdqo.booleanValue();
      label107:
      boolean bool = false;
    }
  }
}
