package com.google.android.android.internal;

public abstract interface ResponseDelivery
{
  public abstract void postError(Request paramRequest, zzaa paramZzaa);
  
  public abstract void postResponse(Request paramRequest, Response paramResponse);
  
  public abstract void postResponse(Request paramRequest, Response paramResponse, Runnable paramRunnable);
}
