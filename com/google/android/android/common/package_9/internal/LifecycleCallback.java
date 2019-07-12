package com.google.android.android.common.package_9.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import com.google.android.android.common.internal.zzbp;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback
{
  public final zzcg zzfoo;
  
  public LifecycleCallback(zzcg paramZzcg)
  {
    zzfoo = paramZzcg;
  }
  
  public static zzcg getChimeraLifecycleFragmentImpl(zzcf paramZzcf)
  {
    throw new IllegalStateException("Method not available in SDK.");
  }
  
  public static zzcg showProgressDialog(Activity paramActivity)
  {
    zzbp.get(paramActivity, "Activity must not be null");
    if ((paramActivity instanceof FragmentActivity)) {
      return zzdb.show((FragmentActivity)paramActivity);
    }
    if ((paramActivity instanceof Activity)) {
      return zzch.showDialog(paramActivity);
    }
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }
  
  public static zzcg showProgressDialog(zzcf paramZzcf)
  {
    if (paramZzcf.zzaig()) {
      return zzdb.show(paramZzcf.zzaii());
    }
    if (paramZzcf.isAndroid()) {
      return zzch.showDialog(paramZzcf.zzaih());
    }
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Activity getActivity()
  {
    return zzfoo.zzaij();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}
