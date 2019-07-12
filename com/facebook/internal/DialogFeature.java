package com.facebook.internal;

public abstract interface DialogFeature
{
  public abstract String getAction();
  
  public abstract int getMinVersion();
  
  public abstract String name();
}
