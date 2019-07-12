package com.google.android.android.common.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.gms.common.internal.zzi;

public abstract class ContactAccessor
  extends zzi<Boolean>
{
  public int statusCode;
  public Bundle zzftk;
  
  public ContactAccessor(TaskManager paramTaskManager, int paramInt, Bundle paramBundle)
  {
    super(paramTaskManager, Boolean.valueOf(true));
    statusCode = paramInt;
    zzftk = paramBundle;
  }
  
  public abstract void startConnection(ConnectionResult paramConnectionResult);
  
  public abstract boolean zzajn();
}
