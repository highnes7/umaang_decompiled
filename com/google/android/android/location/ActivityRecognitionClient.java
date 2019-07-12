package com.google.android.android.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.android.common.internal.zzbi;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;

public class ActivityRecognitionClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  public ActivityRecognitionClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.proxy, null, new RealmObject());
  }
  
  public ActivityRecognitionClient(Context paramContext)
  {
    super(paramContext, LocationServices.proxy, null, new RealmObject());
  }
  
  public Task removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    return zzbi.f(ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(zzafl(), paramPendingIntent));
  }
  
  public Task requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    return zzbi.f(ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(zzafl(), paramLong, paramPendingIntent));
  }
}
