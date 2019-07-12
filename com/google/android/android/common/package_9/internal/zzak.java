package com.google.android.android.common.package_9.internal;

import android.app.Activity;
import b.b.x.n.d;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzh;
import support.android.v4.util.NodeList;

public class zzak
  extends AbstractGalleryActivity
{
  public zzbp zzfgv;
  public final d<zzh<?>> zzfle = new NodeList(0);
  
  public zzak(zzcg paramZzcg)
  {
    super(paramZzcg, GoogleApiAvailability.zzffi);
    zzfoo.handleResult("ConnectionlessLifecycleHelper", this);
  }
  
  public static void submit(Activity paramActivity, zzbp paramZzbp, Msg paramMsg)
  {
    LifecycleCallback.showProgressDialog(paramActivity);
    zzcg localZzcg = LifecycleCallback.showProgressDialog(paramActivity);
    zzak localZzak = (zzak)localZzcg.get("ConnectionlessLifecycleHelper", com.google.android.gms.common.api.internal.zzak.class);
    paramActivity = localZzak;
    if (localZzak == null) {
      paramActivity = new zzak(localZzcg);
    }
    zzfgv = paramZzbp;
    com.google.android.android.common.internal.zzbp.get(paramMsg, "ApiKey cannot be null");
    zzfle.add(paramMsg);
    paramZzbp.launch(paramActivity);
  }
  
  private final void zzagw()
  {
    if (!zzfle.isEmpty()) {
      zzfgv.launch(this);
    }
  }
  
  public final void handleMessage(ConnectionResult paramConnectionResult, int paramInt)
  {
    zzfgv.onPageChanged(paramConnectionResult, paramInt);
  }
  
  public final void onResume()
  {
    zzagw();
  }
  
  public final void onStart()
  {
    mStarted = true;
    zzagw();
  }
  
  public final void onStop()
  {
    mStarted = false;
    zzfgv.cancelTasks(this);
  }
  
  public final void zzafw()
  {
    zzfgv.zzafw();
  }
  
  public final NodeList zzagv()
  {
    return zzfle;
  }
}
