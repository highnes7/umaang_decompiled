package com.google.android.android.common.package_9.internal;

import com.google.android.android.internal.zzbdz;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzct
{
  public static final ExecutorService zzfnj = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzbdz("GAC_Transform", 0));
  
  public static ExecutorService zzahn()
  {
    return zzfnj;
  }
}
