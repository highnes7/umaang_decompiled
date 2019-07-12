package com.google.android.android.common.internal;

import com.google.android.android.common.package_9.ApiException;
import com.google.android.android.common.package_9.Status;

public final class zzbj
  implements zzbo
{
  public zzbj() {}
  
  public final ApiException newInstance(Status paramStatus)
  {
    return ReflectClass.newInstance(paramStatus);
  }
}
