package com.google.android.android.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import android.view.View;

public final class ActivityBase
  extends IPackageStatsObserver.Stub
{
  public Fragment zzgph;
  
  public ActivityBase(Fragment paramFragment)
  {
    zzgph = paramFragment;
  }
  
  public static ActivityBase attachFragment(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new ActivityBase(paramFragment);
    }
    return null;
  }
  
  public final Bundle getArguments()
  {
    return zzgph.getArguments();
  }
  
  public final int getId()
  {
    return zzgph.getId();
  }
  
  public final boolean getRetainInstance()
  {
    return zzgph.getRetainInstance();
  }
  
  public final String getTag()
  {
    return zzgph.getTag();
  }
  
  public final int getTargetRequestCode()
  {
    return zzgph.getTargetRequestCode();
  }
  
  public final boolean getUserVisibleHint()
  {
    return zzgph.getUserVisibleHint();
  }
  
  public final IObjectWrapper getView()
  {
    return new Integer(zzgph.getView());
  }
  
  public final void getView(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)Integer.get(paramIObjectWrapper);
    zzgph.unregisterForContextMenu(paramIObjectWrapper);
  }
  
  public final boolean isAdded()
  {
    return zzgph.isAdded();
  }
  
  public final boolean isDetached()
  {
    return zzgph.isDetached();
  }
  
  public final boolean isHidden()
  {
    return zzgph.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return zzgph.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return zzgph.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return zzgph.isResumed();
  }
  
  public final boolean isVisible()
  {
    return zzgph.isVisible();
  }
  
  public final void onCreate(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)Integer.get(paramIObjectWrapper);
    zzgph.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    zzgph.setHasOptionsMenu(paramBoolean);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    zzgph.setMenuVisibility(paramBoolean);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    zzgph.setRetainInstance(paramBoolean);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    zzgph.setUserVisibleHint(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    zzgph.startActivity(paramIntent);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    zzgph.startActivityForResult(paramIntent, paramInt);
  }
  
  public final IObjectWrapper zzaoc()
  {
    return new Integer(zzgph.getActivity());
  }
  
  public final Action zzaod()
  {
    return attachFragment(zzgph.getParentFragment());
  }
  
  public final IObjectWrapper zzaoe()
  {
    return new Integer(zzgph.getResources());
  }
  
  public final Action zzaof()
  {
    return attachFragment(zzgph.getTargetFragment());
  }
}
