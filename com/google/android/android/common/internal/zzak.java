package com.google.android.android.common.internal;

import android.util.Log;

public final class zzak
{
  public static int zzfvi;
  public static final String zzfvj;
  public final String zzfvk;
  public final String zzfvl;
  
  public zzak(String paramString)
  {
    this(paramString, null);
  }
  
  public zzak(String paramString1, String paramString2)
  {
    zzbp.get(paramString1, "log tag cannot be null");
    boolean bool;
    if (paramString1.length() <= 23) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.logf(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
    zzfvk = paramString1;
    zzfvl = null;
  }
  
  private final boolean zzcf(int paramInt)
  {
    return Log.isLoggable(zzfvk, paramInt);
  }
  
  private final String zzgf(String paramString)
  {
    String str = zzfvl;
    if (str == null) {
      return paramString;
    }
    return str.concat(paramString);
  }
  
  public final void calculate(String paramString1, String paramString2)
  {
    if (zzcf(6))
    {
      paramString1 = zzfvl;
      if (paramString1 == null) {
        return;
      }
      paramString1.concat(paramString2);
    }
  }
  
  public final void calculate(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcf(4))
    {
      paramString1 = zzfvl;
      if (paramString1 == null) {
        return;
      }
      paramString1.concat(paramString2);
    }
  }
  
  public final void loadFile(String paramString1, String paramString2)
  {
    if (zzcf(3))
    {
      paramString1 = zzfvl;
      if (paramString1 == null) {
        return;
      }
      paramString1.concat(paramString2);
    }
  }
  
  public final void loadFile(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcf(6))
    {
      paramString1 = zzfvl;
      if (paramString1 == null) {
        return;
      }
      paramString1.concat(paramString2);
    }
  }
  
  public final void scanDirectory(String paramString1, String paramString2)
  {
    if (zzcf(5))
    {
      paramString1 = zzfvl;
      if (paramString1 == null) {
        return;
      }
      paramString1.concat(paramString2);
    }
  }
  
  public final void scanDirectory(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcf(5))
    {
      paramString1 = zzfvl;
      if (paramString1 == null) {
        return;
      }
      paramString1.concat(paramString2);
    }
  }
  
  public final void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcf(7))
    {
      String str = zzfvl;
      if (str != null) {
        str.concat(paramString2);
      }
      str = zzfvl;
      if (str != null) {
        paramString2 = str.concat(paramString2);
      }
      Log.wtf(paramString1, paramString2, paramThrowable);
    }
  }
}
