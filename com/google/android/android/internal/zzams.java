package com.google.android.android.internal;

public abstract class zzams
  extends zzamr
{
  public boolean zzdoe;
  
  public zzams(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public final void initialize()
  {
    zzuk();
    zzdoe = true;
  }
  
  public final boolean isInitialized()
  {
    return zzdoe;
  }
  
  public abstract void zzuk();
  
  public final void zzwk()
  {
    if (isInitialized()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
}
