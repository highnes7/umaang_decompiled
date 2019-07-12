package com.google.android.android.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.android.common.util.BTC;

public final class zzbp
{
  public static Object append(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException("null reference");
  }
  
  public static void append(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
  
  public static String format(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static Object get(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    throw new NullPointerException(String.valueOf(paramObject2));
  }
  
  public static void get(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static int getDataInt(int paramInt, Object paramObject)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void logf(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  public static void remove(Handler paramHandler)
  {
    if (Looper.myLooper() == paramHandler.getLooper()) {
      return;
    }
    throw new IllegalStateException("Must be called on the handler thread");
  }
  
  public static long saveSentMessage(long paramLong, Object paramObject)
  {
    if (paramLong != 0L) {
      return paramLong;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void zzbg(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void zzbh(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void zzfy(String paramString)
  {
    if (BTC.zzaq()) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public static String zzgg(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  public static void zzgh(String paramString)
  {
    if (!BTC.zzaq()) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
}
