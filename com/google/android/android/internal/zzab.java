package com.google.android.android.internal;

import android.os.SystemClock;
import android.util.Log;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class zzab
{
  public static boolean DEBUG = Log.isLoggable("Volley", 2);
  public static String data;
  
  public zzab() {}
  
  public static void addToCache(String paramString, Object... paramVarArgs)
  {
    String str = data;
    get(paramString, paramVarArgs);
  }
  
  public static String get(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      paramString = String.format(Locale.US, paramString, paramVarArgs);
    }
    paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
    int i = 2;
    while (i < paramVarArgs.length)
    {
      if (!paramVarArgs[i].getClass().equals(com.google.android.gms.internal.zzab.class))
      {
        String str = paramVarArgs[i].getClassName();
        str = str.substring(str.lastIndexOf('.') + 1);
        str = str.substring(str.lastIndexOf('$') + 1);
        paramVarArgs = paramVarArgs[i].getMethodName();
        paramVarArgs = StringBuilder.append(StringBuilder.append(paramVarArgs, StringBuilder.append(str, 1)), str, ".", paramVarArgs);
        break label122;
      }
      i += 1;
    }
    paramVarArgs = "<unknown>";
    label122:
    return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (DEBUG)
    {
      String str = data;
      get(paramString, paramVarArgs);
    }
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    String str = data;
    get(paramString, paramVarArgs);
  }
  
  public static void wtf(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    paramThrowable = data;
    get(paramString, paramVarArgs);
  }
  
  public final class zza
  {
    public static final boolean zzbi = zzab.DEBUG;
    public final List<com.google.android.gms.internal.zzac> zzbj = new ArrayList();
    public boolean zzbk = false;
    
    public zza() {}
    
    public final void add(String paramString, long paramLong)
    {
      try
      {
        if (!zzbk)
        {
          zzbj.add(new zzac(paramString, paramLong, SystemClock.elapsedRealtime()));
          return;
        }
        throw new IllegalStateException("Marker added to finished log");
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
    }
    
    public final void finalize()
      throws Throwable
    {
      if (!zzbk)
      {
        finish("Request on the loose");
        String str = zzab.data;
        zzab.get("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    public final void finish(String paramString)
    {
      try
      {
        zzbk = true;
        if (zzbj.size() == 0)
        {
          l1 = 0L;
        }
        else
        {
          l1 = zzbj.get(0)).time;
          l2 = zzbj.get(zzbj.size() - 1)).time;
          l1 = l2 - l1;
        }
        if (l1 <= 0L) {
          return;
        }
        long l2 = zzbj.get(0)).time;
        Object localObject = zzab.data;
        zzab.get("(%-4d ms) %s", new Object[] { Long.valueOf(l1), paramString });
        paramString = zzbj.iterator();
        for (long l1 = l2; paramString.hasNext(); l1 = l2)
        {
          localObject = (zzac)paramString.next();
          l2 = time;
          long l3 = zzbl;
          localObject = name;
          String str = zzab.data;
          zzab.get("(+%-4d) [%2d] %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3), localObject });
        }
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
    }
  }
}
