package com.google.android.android.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

public final class zzbvp
{
  public static Object run(Callable paramCallable)
    throws Exception
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
      paramCallable = paramCallable.call();
      StrictMode.setThreadPolicy(localThreadPolicy);
      return paramCallable;
    }
    catch (Throwable paramCallable)
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
      throw paramCallable;
    }
  }
}
