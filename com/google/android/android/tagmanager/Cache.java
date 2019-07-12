package com.google.android.android.tagmanager;

public abstract interface Cache<K, V>
{
  public abstract Object get(Object paramObject);
  
  public abstract void put(Object paramObject1, Object paramObject2);
}
