package com.facebook;

public abstract interface FacebookDialog<CONTENT, RESULT>
{
  public abstract boolean canShow(Object paramObject);
  
  public abstract void registerCallback(CallbackManager paramCallbackManager, FacebookCallback paramFacebookCallback);
  
  public abstract void registerCallback(CallbackManager paramCallbackManager, FacebookCallback paramFacebookCallback, int paramInt);
  
  public abstract void show(Object paramObject);
}
