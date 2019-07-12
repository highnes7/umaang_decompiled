package com.google.android.android.common.package_9.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.package_7.Fragment;
import android.support.v4.package_7.FragmentManager;
import android.support.v4.package_7.FragmentTransaction;
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

public final class zzdb
  extends Fragment
  implements zzcg
{
  public static WeakHashMap<android.support.v4.app.FragmentActivity, WeakReference<com.google.android.gms.common.api.internal.zzdb>> zzfop = new WeakHashMap();
  public int zzbyz = 0;
  public Map<String, com.google.android.gms.common.api.internal.LifecycleCallback> zzfoq = new ArrayMap();
  public Bundle zzfor;
  
  public zzdb() {}
  
  public static zzdb show(android.support.v4.package_7.FragmentActivity paramFragmentActivity)
  {
    Object localObject = (WeakReference)zzfop.get(paramFragmentActivity);
    if (localObject != null)
    {
      localObject = (zzdb)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      zzdb localZzdb = (zzdb)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
      if (localZzdb != null)
      {
        localObject = localZzdb;
        if (!localZzdb.isRemoving()) {}
      }
      else
      {
        localObject = new zzdb();
        paramFragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment)localObject, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzfop.put(paramFragmentActivity, new WeakReference(localObject));
      return localObject;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", paramFragmentActivity);
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
        new Handler(Looper.getMainLooper()).post(new zzdc(this, paramLifecycleCallback, paramString));
      }
    }
    else
    {
      throw new IllegalArgumentException(StringBuilder.append(StringBuilder.append(paramString, 59), "LifecycleCallback with tag ", paramString, " already added to this fragment."));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
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
    mCalled = true;
    zzbyz = 3;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
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
    mCalled = true;
    zzbyz = 2;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
  }
  
  public final void onStop()
  {
    mCalled = true;
    zzbyz = 4;
    Iterator localIterator = zzfoq.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
  }
}
