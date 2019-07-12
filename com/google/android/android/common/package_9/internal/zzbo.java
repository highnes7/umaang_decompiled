package com.google.android.android.common.package_9.internal;

import com.google.android.android.internal.zzbdz;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzbo
{
  public static final ExecutorService zzfnj = Executors.newFixedThreadPool(2, new zzbdz("GAC_Executor", 0));
  
  public static ExecutorService zzahn()
  {
    return zzfnj;
  }
}
