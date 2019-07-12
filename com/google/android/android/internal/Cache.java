package com.google.android.android.internal;

public abstract interface Cache
{
  public abstract Cache.Entry get(String paramString);
  
  public abstract void initialize();
  
  public abstract void put(String paramString, Cache.Entry paramEntry);
}
