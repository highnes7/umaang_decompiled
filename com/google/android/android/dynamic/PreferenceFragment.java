package com.google.android.android.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.Resources;
import com.google.android.gms.dynamic.zzi;
import com.google.android.gms.dynamic.zzo;
import java.util.LinkedList;

public abstract class PreferenceFragment<T extends com.google.android.gms.dynamic.LifecycleDelegate>
{
  public T zzgou;
  public Bundle zzgov;
  public LinkedList<zzi> zzgow;
  public final zzo<T> zzgox = new AsyncSSLSocketWrapper.4(this);
  
  public PreferenceFragment() {}
  
  private final void init(Bundle paramBundle, Object paramObject)
  {
    LifecycleDelegate localLifecycleDelegate = zzgou;
    if (localLifecycleDelegate != null)
    {
      paramObject.method_4(localLifecycleDelegate);
      return;
    }
    if (zzgow == null) {
      zzgow = new LinkedList();
    }
    zzgow.add(paramObject);
    if (paramBundle != null)
    {
      paramObject = zzgov;
      if (paramObject == null) {
        zzgov = ((Bundle)paramBundle.clone());
      } else {
        paramObject.putAll(paramBundle);
      }
    }
    setDivider(zzgox);
  }
  
  public static void onCreateView(FrameLayout paramFrameLayout)
  {
    java.lang.Object localObject1 = GoogleApiAvailability.zzffi;
    Context localContext = paramFrameLayout.getContext();
    int i = ((GoogleApiAvailability)localObject1).isGooglePlayServicesAvailable(localContext);
    java.lang.Object localObject2 = Resources.getValue(localContext, i);
    localObject1 = Resources.getTitle(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText((CharSequence)localObject2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = PingManager.get(localContext, i, null);
    if (paramFrameLayout != null)
    {
      localObject2 = new Button(localContext);
      ((View)localObject2).setId(16908313);
      ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localLinearLayout.addView((View)localObject2);
      ((View)localObject2).setOnClickListener(new TaskEditFragment.1(localContext, paramFrameLayout));
    }
  }
  
  private final void zzcv(int paramInt)
  {
    while ((!zzgow.isEmpty()) && (((Object)zzgow.getLast()).getState() >= paramInt)) {
      zzgow.removeLast();
    }
  }
  
  public void init(FrameLayout paramFrameLayout)
  {
    java.lang.Object localObject1 = GoogleApiAvailability.zzffi;
    Context localContext = paramFrameLayout.getContext();
    int i = ((GoogleApiAvailability)localObject1).isGooglePlayServicesAvailable(localContext);
    java.lang.Object localObject2 = Resources.getValue(localContext, i);
    localObject1 = Resources.getTitle(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText((CharSequence)localObject2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = PingManager.get(localContext, i, null);
    if (paramFrameLayout != null)
    {
      localObject2 = new Button(localContext);
      ((View)localObject2).setId(16908313);
      ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localLinearLayout.addView((View)localObject2);
      ((View)localObject2).setOnClickListener(new TaskEditFragment.1(localContext, paramFrameLayout));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    init(paramBundle, new SettingsFragment.7(this, paramBundle));
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    init(paramBundle, new DatePickerDialog.1(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (zzgou == null) {
      init(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public final void onDestroy()
  {
    LifecycleDelegate localLifecycleDelegate = zzgou;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onDestroy();
      return;
    }
    zzcv(1);
  }
  
  public final void onDestroyView()
  {
    LifecycleDelegate localLifecycleDelegate = zzgou;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onDestroyView();
      return;
    }
    zzcv(2);
  }
  
  public final void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    init(paramBundle2, new BackgroundService.2(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  public final void onLowMemory()
  {
    LifecycleDelegate localLifecycleDelegate = zzgou;
    if (localLifecycleDelegate != null) {
      localLifecycleDelegate.onLowMemory();
    }
  }
  
  public final void onPause()
  {
    LifecycleDelegate localLifecycleDelegate = zzgou;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onPause();
      return;
    }
    zzcv(5);
  }
  
  public final void onResume()
  {
    init(null, new AudioRecorder(this));
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    java.lang.Object localObject = zzgou;
    if (localObject != null)
    {
      ((LifecycleDelegate)localObject).onSaveInstanceState(paramBundle);
      return;
    }
    localObject = zzgov;
    if (localObject != null) {
      paramBundle.putAll((Bundle)localObject);
    }
  }
  
  public final void onStart()
  {
    init(null, new RecordService.1(this));
  }
  
  public final void onStop()
  {
    LifecycleDelegate localLifecycleDelegate = zzgou;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onStop();
      return;
    }
    zzcv(4);
  }
  
  public abstract void setDivider(CompletedCallback paramCompletedCallback);
  
  public final LifecycleDelegate zzaob()
  {
    return zzgou;
  }
}
