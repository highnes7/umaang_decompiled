package com.google.android.android.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;

public final class zzdbx
{
  public static Integer zzkfs = Integer.valueOf(0);
  public static Integer zzkft = Integer.valueOf(1);
  public final Context mContext;
  public final ExecutorService zzisa;
  
  public zzdbx(Context paramContext)
  {
    mContext = paramContext;
    zzisa = localExecutorService;
  }
  
  public zzdbx(Context paramContext, ExecutorService paramExecutorService)
  {
    mContext = paramContext;
    zzisa = paramExecutorService;
  }
}
