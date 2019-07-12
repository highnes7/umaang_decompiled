package com.google.android.android.common.package_9;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.common.api.ResultCallbacks;

public abstract class ResolvingResultCallbacks<R extends com.google.android.gms.common.api.Result>
  extends ResultCallbacks<R>
{
  public final Activity mActivity;
  public final int zzfhs;
  
  public ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    zzbp.get(paramActivity, "Activity must not be null");
    mActivity = ((Activity)paramActivity);
    zzfhs = paramInt;
  }
  
  public final void onFailure(Status paramStatus)
  {
    Activity localActivity;
    int i;
    if (paramStatus.hasResolution())
    {
      localActivity = mActivity;
      i = zzfhs;
    }
    try
    {
      paramStatus.startResolutionForResult(localActivity, i);
      return;
    }
    catch (IntentSender.SendIntentException paramStatus)
    {
      for (;;) {}
    }
    onUnresolvableFailure(new Status(8));
    return;
    onUnresolvableFailure(paramStatus);
  }
  
  public abstract void onSuccess(Result paramResult);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}
