package com.google.android.android.common.package_9.internal;

import android.app.Activity;
import android.support.v4.package_7.FragmentActivity;
import com.google.android.android.common.internal.zzbp;

public final class zzcf
{
  public final Object zzfon;
  
  public zzcf(Activity paramActivity)
  {
    zzbp.get(paramActivity, "Activity must not be null");
    zzfon = paramActivity;
  }
  
  public final boolean isAndroid()
  {
    return zzfon instanceof Activity;
  }
  
  public final boolean zzaig()
  {
    return zzfon instanceof FragmentActivity;
  }
  
  public final Activity zzaih()
  {
    return (Activity)zzfon;
  }
  
  public final FragmentActivity zzaii()
  {
    return (FragmentActivity)zzfon;
  }
}
