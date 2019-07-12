package com.google.android.android.internal;

import android.util.Log;
import com.google.android.android.common.internal.zzak;

public final class zzbde
{
  public final String mTag;
  public final int zzdqr;
  public final String zzfvl;
  public final zzak zzfwj;
  
  public zzbde(String paramString1, String paramString2)
  {
    zzfvl = paramString2;
    mTag = paramString1;
    zzfwj = new zzak(paramString1, null);
    zzdqr = getLogLevel();
  }
  
  public zzbde(String paramString, String... paramVarArgs)
  {
    this(paramString, arrayToString(paramVarArgs));
  }
  
  public static String arrayToString(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    localStringBuilder.append(']');
    localStringBuilder.append(' ');
    return localStringBuilder.toString();
  }
  
  private final String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return zzfvl.concat(str);
  }
  
  private final int getLogLevel()
  {
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(mTag, i))) {
      i += 1;
    }
    return i;
  }
  
  private final boolean zzad(int paramInt)
  {
    return zzdqr <= paramInt;
  }
  
  public final void append(String paramString, Object... paramVarArgs)
  {
    if (zzad(3)) {
      format(paramString, paramVarArgs);
    }
  }
  
  public final void execSQL(String paramString, Object... paramVarArgs)
  {
    format(paramString, paramVarArgs);
  }
  
  public final void log(Throwable paramThrowable)
  {
    Log.wtf(mTag, paramThrowable);
  }
  
  public final void logError(String paramString, Object... paramVarArgs)
  {
    format(paramString, paramVarArgs);
  }
  
  public final void showErrorAlert(String paramString, Object... paramVarArgs)
  {
    if (zzad(2)) {
      format(paramString, paramVarArgs);
    }
  }
  
  public final void w(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    Log.wtf(mTag, format(paramString, paramVarArgs), paramThrowable);
  }
}
