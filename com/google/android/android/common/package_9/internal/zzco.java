package com.google.android.android.common.package_9.internal;

import android.app.Activity;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.internal.ReflectClass;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.tasks.Task;
import java.util.concurrent.CancellationException;

public class zzco
  extends AbstractGalleryActivity
{
  public com.google.android.gms.tasks.TaskCompletionSource<Void> zzdzc = new com.google.android.android.tasks.TaskCompletionSource();
  
  public zzco(zzcg paramZzcg)
  {
    super(paramZzcg, GoogleApiAvailability.zzffi);
    zzfoo.handleResult("GmsAvailabilityHelper", this);
  }
  
  public static zzco findAll(Activity paramActivity)
  {
    paramActivity = LifecycleCallback.showProgressDialog(paramActivity);
    zzco localZzco = (zzco)paramActivity.get("GmsAvailabilityHelper", com.google.android.gms.common.api.internal.zzco.class);
    if (localZzco != null)
    {
      paramActivity = localZzco;
      if (zzdzc.getTask().isComplete())
      {
        zzdzc = new com.google.android.android.tasks.TaskCompletionSource();
        return localZzco;
      }
    }
    else
    {
      paramActivity = new zzco(paramActivity);
    }
    return paramActivity;
  }
  
  public final Task getTask()
  {
    return zzdzc.getTask();
  }
  
  public final void handleMessage(ConnectionResult paramConnectionResult, int paramInt)
  {
    zzdzc.setException(ReflectClass.newInstance(new Status(1, paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution())));
  }
  
  public final void onDestroy()
  {
    zzdzc.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  public final void zzafw()
  {
    int i = zzfhl.isGooglePlayServicesAvailable(zzfoo.zzaij());
    if (i == 0)
    {
      zzdzc.setResult(null);
      return;
    }
    if (!zzdzc.getTask().isComplete()) {
      clear(new ConnectionResult(i, null), 0);
    }
  }
}
