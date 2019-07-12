package com.google.android.android.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class SearchableActivity
  extends zzaw
{
  public TaskManager zzftn;
  public final int zzfto;
  
  public SearchableActivity(TaskManager paramTaskManager, int paramInt)
  {
    zzftn = paramTaskManager;
    zzfto = paramInt;
  }
  
  public final void browse(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
  
  public final void onSearchFinished(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    zzbp.get(zzftn, "onPostInitComplete can be called only once per call to getRemoteService");
    zzftn.show(paramInt, paramIBinder, paramBundle, zzfto);
    zzftn = null;
  }
}
