package com.google.android.android.common.internal;

import com.google.android.android.common.package_9.ApiException;
import com.google.android.android.common.package_9.ResolvableApiException;
import com.google.android.android.common.package_9.Status;

public final class ReflectClass
{
  public static ApiException newInstance(Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      return new ResolvableApiException(paramStatus);
    }
    return new ApiException(paramStatus);
  }
}
