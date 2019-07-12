package com.google.android.android.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.android.internal.zzbye;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.internal.zzbzu;

public class ActivityRecognition
{
  @Deprecated
  public static final ActivityRecognitionApi ActivityRecognitionApi = new zzbye();
  public static final String CLIENT_NAME = "activity_recognition";
  public static final Api<Api.ApiOptions.NoOptions> IOERR;
  public static final com.google.android.gms.common.api.Api.zzf<zzbzu> zzdwp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzbzu, Api.ApiOptions.NoOptions> zzdwq = new Configuration();
  
  static
  {
    IOERR = new Sample("ActivityRecognition.API", zzdwq, zzdwp);
  }
  
  public ActivityRecognition() {}
  
  public static ActivityRecognitionClient getClient(Activity paramActivity)
  {
    return new ActivityRecognitionClient(paramActivity);
  }
  
  public static ActivityRecognitionClient getClient(Context paramContext)
  {
    return new ActivityRecognitionClient(paramContext);
  }
  
  public abstract class zza<R extends Result>
    extends zzm<R, zzbzu>
  {
    public zza()
    {
      super(this$1);
    }
  }
}
