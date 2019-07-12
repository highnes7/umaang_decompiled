package com.facebook.login;

import android.app.Activity;
import android.content.Intent;

public abstract interface StartActivityDelegate
{
  public abstract Activity getActivityContext();
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}
