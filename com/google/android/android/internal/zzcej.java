package com.google.android.android.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import b.b.a.C;
import com.google.android.android.common.util.Log;

@TargetApi(14)
@C
public final class zzcej
  implements Application.ActivityLifecycleCallbacks
{
  public zzcej(zzcdw paramZzcdw) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      zziuy.zzaul().zzayj().append("onActivityCreated");
      Object localObject = paramActivity.getIntent();
      if (localObject != null)
      {
        Uri localUri = ((Intent)localObject).getData();
        if (localUri != null)
        {
          boolean bool = localUri.isHierarchical();
          if (bool)
          {
            if (paramBundle == null)
            {
              Bundle localBundle = zziuy.zzauh().parse(localUri);
              zziuy.zzauh();
              bool = zzcfw.loadData((Intent)localObject);
              if (bool) {
                localObject = "gs";
              } else {
                localObject = "auto";
              }
              if (localBundle != null) {
                zziuy.put((String)localObject, "_cmp", localBundle);
              }
            }
            localObject = localUri.getQueryParameter("referrer");
            bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              return;
            }
            bool = ((String)localObject).contains("gclid");
            if (bool)
            {
              bool = ((String)localObject).contains("utm_campaign");
              if (!bool)
              {
                bool = ((String)localObject).contains("utm_source");
                if (!bool)
                {
                  bool = ((String)localObject).contains("utm_medium");
                  if (!bool)
                  {
                    bool = ((String)localObject).contains("utm_term");
                    if (!bool)
                    {
                      bool = ((String)localObject).contains("utm_content");
                      if (!bool) {
                        break label228;
                      }
                    }
                  }
                }
              }
              i = 1;
              break label230;
            }
            label228:
            int i = 0;
            label230:
            if (i == 0)
            {
              zziuy.zzaul().zzayi().append("Activity created with data 'referrer' param without gclid and at least one utm field");
              return;
            }
            zziuy.zzaul().zzayi().append("Activity created with referrer", localObject);
            bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              zziuy.attribute("auto", "_ldl", localObject);
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      zziuy.zzaul().zzayd().append("Throwable caught in onActivityCreated", localThrowable);
    }
    zzcek localZzcek = zziuy.zzaud();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("com.google.firebase.analytics.screen_service");
      if (paramBundle != null)
      {
        paramActivity = localZzcek.e(paramActivity);
        zzikp = paramBundle.getLong("id");
        zzikn = paramBundle.getString("name");
        zziko = paramBundle.getString("referrer_name");
      }
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    zziuy.zzaud().onActivityDestroyed(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    zziuy.zzaud().onActivityPaused(paramActivity);
    paramActivity = zziuy.zzauj();
    long l = paramActivity.zzvx().elapsedRealtime();
    paramActivity.zzauk().e(new zzcfp(paramActivity, l));
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    zziuy.zzaud().onActivityResumed(paramActivity);
    paramActivity = zziuy.zzauj();
    long l = paramActivity.zzvx().elapsedRealtime();
    paramActivity.zzauk().e(new zzcfo(paramActivity, l));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zziuy.zzaud().onActivitySaveInstanceState(paramActivity, paramBundle);
  }
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}
