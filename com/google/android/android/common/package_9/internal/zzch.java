package com.google.android.android.common.package_9.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import support.android.v4.util.ArrayMap;

public final class zzch
  extends Fragment
  implements zzcg
{
  public static WeakHashMap<Activity, WeakReference<com.google.android.gms.common.api.internal.zzch>> zzfop = new WeakHashMap();
  public int zzbyz = 0;
  public Map<String, com.google.android.gms.common.api.internal.LifecycleCallback> zzfoq = new ArrayMap();
  public Bundle zzfor;
  
  public zzch() {}
  
  public static zzch showDialog(Activity paramActivity)
  {
    Object localObject = (WeakReference)zzfop.get(paramActivity);
    if (localObject != null)
    {
      localObject = (zzch)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      zzch localZzch = (zzch)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localZzch != null)
      {
        localObject = localZzch;
        if (!localZzch.isRemoving()) {}
      }
      else
      {
        localObject = new zzch();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzfop.put(paramActivity, new WeakReference(localObject));
      return localObject;
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final LifecycleCallback get(String paramString, Class paramClass)
  {
    return (LifecycleCallback)paramClass.cast(zzfoq.get(paramString));
  }
  
  public final void handleResult(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    if (!zzfoq.containsKey(paramString))
    {
      zzfoq.put(paramString, paramLifecycleCallback);
      if (zzbyz > 0) {
        new Handler(Looper.getMainLooper()).post(new zzci(this, paramLifecycleCallback, paramString));
      }
    }
    else
    {
      throw new IllegalArgumentException(StringBuilder.append(StringBuilder.append(paramString, 59), "LifecycleCallback with tag ", paramString, " already added to this fragment."));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzbyz = 1;
    zzfor = paramBundle;
    Iterator localIterator = zzfoq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      LifecycleCallback localLifecycleCallback = (LifecycleCallback)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {
        localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());
      } else {
        localObject = null;
      }
      localLifecycleCallback.onCreate((Bundle)localObject);
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    zzbyz = 5;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onDestroy();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    zzbyz = 3;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    Iterator localIterator = zzfoq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bundle localBundle = new Bundle();
      ((LifecycleCallback)localEntry.getValue()).onSaveInstanceState(localBundle);
      paramBundle.putBundle((String)localEntry.getKey(), localBundle);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    zzbyz = 2;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    zzbyz = 4;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
  }
  
  public final Activity zzaij()
  {
    return getActivity();
  }
}
