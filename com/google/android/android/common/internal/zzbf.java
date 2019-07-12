package com.google.android.android.common.internal;

public final class zzbf
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static zzbh peekPersisted(Object paramObject)
  {
    return new zzbh(paramObject, null);
  }
}
