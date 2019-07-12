package com.google.android.android.dynamic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"NewApi"})
public final class Fragment
  extends IPackageStatsObserver.Stub
{
  public android.app.Fragment zzgpe;
  
  public Fragment(android.app.Fragment paramFragment)
  {
    zzgpe = paramFragment;
  }
  
  public static Fragment instantiate(android.app.Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new Fragment(paramFragment);
    }
    return null;
  }
  
  public final Bundle getArguments()
  {
    return zzgpe.getArguments();
  }
  
  public final int getId()
  {
    return zzgpe.getId();
  }
  
  public final boolean getRetainInstance()
  {
    return zzgpe.getRetainInstance();
  }
  
  public final String getTag()
  {
    return zzgpe.getTag();
  }
  
  public final int getTargetRequestCode()
  {
    return zzgpe.getTargetRequestCode();
  }
  
  public final boolean getUserVisibleHint()
  {
    return zzgpe.getUserVisibleHint();
  }
  
  public final IObjectWrapper getView()
  {
    return new Integer(zzgpe.getView());
  }
  
  public final void getView(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)Integer.get(paramIObjectWrapper);
    zzgpe.unregisterForContextMenu(paramIObjectWrapper);
  }
  
  public final boolean isAdded()
  {
    return zzgpe.isAdded();
  }
  
  public final boolean isDetached()
  {
    return zzgpe.isDetached();
  }
  
  public final boolean isHidden()
  {
    return zzgpe.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return zzgpe.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return zzgpe.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return zzgpe.isResumed();
  }
  
  public final boolean isVisible()
  {
    return zzgpe.isVisible();
  }
  
  public final void onCreate(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)Integer.get(paramIObjectWrapper);
    zzgpe.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    zzgpe.setHasOptionsMenu(paramBoolean);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    zzgpe.setMenuVisibility(paramBoolean);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    zzgpe.setRetainInstance(paramBoolean);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    zzgpe.setUserVisibleHint(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    zzgpe.startActivity(paramIntent);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    zzgpe.startActivityForResult(paramIntent, paramInt);
  }
  
  public final IObjectWrapper zzaoc()
  {
    return new Integer(zzgpe.getActivity());
  }
  
  public final Action zzaod()
  {
    return instantiate(zzgpe.getParentFragment());
  }
  
  public final IObjectWrapper zzaoe()
  {
    return new Integer(zzgpe.getResources());
  }
  
  public final Action zzaof()
  {
    return instantiate(zzgpe.getTargetFragment());
  }
}
