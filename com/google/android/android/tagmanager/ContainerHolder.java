package com.google.android.android.tagmanager;

import com.google.android.android.common.package_9.Releasable;
import com.google.android.android.common.package_9.Result;

public abstract interface ContainerHolder
  extends Releasable, Result
{
  public abstract Container getContainer();
  
  public abstract void refresh();
  
  public abstract void setContainerAvailableListener(ContainerAvailableListener paramContainerAvailableListener);
  
  public abstract interface ContainerAvailableListener
  {
    public abstract void onContainerAvailable(ContainerHolder paramContainerHolder, String paramString);
  }
}
