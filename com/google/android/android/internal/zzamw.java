package com.google.android.android.internal;

import android.content.Context;
import com.google.android.android.common.internal.zzbp;

public final class zzamw
{
  public final Context mApplicationContext;
  public final Context zzdov;
  
  public zzamw(Context paramContext)
  {
    zzbp.append(paramContext);
    paramContext = paramContext.getApplicationContext();
    zzbp.get(paramContext, "Application context can't be null");
    mApplicationContext = paramContext;
    zzdov = paramContext;
  }
  
  public final Context getApplicationContext()
  {
    return mApplicationContext;
  }
  
  public final Context zzwl()
  {
    return zzdov;
  }
}
