package com.google.android.android.common.internal;

import android.os.Looper;

public final class TextUtils
{
  public static void replace(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException("null reference");
  }
  
  public static void zzbg(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void zzfy(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      return;
    }
    String str1 = String.valueOf(Thread.currentThread());
    String str2 = String.valueOf(Looper.getMainLooper().getThread());
    int i = str1.length();
    StringBuilder localStringBuilder = new StringBuilder(str2.length() + (i + 57));
    localStringBuilder.append("checkMainThread: current thread ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" IS NOT the main thread ");
    localStringBuilder.append(str2);
    localStringBuilder.append("!");
    localStringBuilder.toString();
    throw new IllegalStateException(paramString);
  }
}
