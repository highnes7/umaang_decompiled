package com.google.android.android.tagmanager;

import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.package_9.Status;

public final class ServiceListener
  implements ContainerHolder
{
  public Status mStatus;
  public final Looper zzakg;
  public boolean zzgfp;
  public Container zzjph;
  public Container zzjpi;
  public Launcher.17 zzjpj;
  public ResultSet zzjpk;
  public TagManager zzjpl;
  
  public ServiceListener(Status paramStatus)
  {
    mStatus = paramStatus;
    zzakg = null;
  }
  
  public ServiceListener(TagManager paramTagManager, Looper paramLooper, Container paramContainer, ResultSet paramResultSet)
  {
    zzjpl = paramTagManager;
    if (paramLooper == null) {
      paramLooper = Looper.getMainLooper();
    }
    zzakg = paramLooper;
    zzjph = paramContainer;
    zzjpk = paramResultSet;
    mStatus = Status.zzfhv;
    paramTagManager.getInstance(this);
  }
  
  private final void zzbcq()
  {
    Launcher.17 local17 = zzjpj;
    if (local17 != null) {
      local17.sendMessage(local17.obtainMessage(1, zzjpi.zzbcn()));
    }
  }
  
  public final Container getContainer()
  {
    try
    {
      if (zzgfp)
      {
        zzdj.zzjss.get("ContainerHolder is released.");
        return null;
      }
      if (zzjpi != null)
      {
        zzjph = zzjpi;
        zzjpi = null;
      }
      Container localContainer = zzjph;
      return localContainer;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final String getContainerId()
  {
    if (zzgfp)
    {
      zzdj.zzjss.get("getContainerId called on a released ContainerHolder.");
      return "";
    }
    return zzjph.getContainerId();
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
  
  public final void refresh()
  {
    try
    {
      if (zzgfp)
      {
        zzdj.zzjss.get("Refreshing a released ContainerHolder.");
        return;
      }
      zzjpk.zzbcr();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void release()
  {
    try
    {
      if (zzgfp)
      {
        zzdj.zzjss.get("Releasing a released ContainerHolder.");
        return;
      }
      zzgfp = true;
      zzjpl.get(this);
      zzjph.release();
      zzjph = null;
      zzjpi = null;
      zzjpk = null;
      zzjpj = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void removeListener(Container paramContainer)
  {
    try
    {
      boolean bool = zzgfp;
      if (bool) {
        return;
      }
      zzjpi = paramContainer;
      zzbcq();
      return;
    }
    catch (Throwable paramContainer)
    {
      throw paramContainer;
    }
  }
  
  public final void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener)
  {
    try
    {
      if (zzgfp)
      {
        zzdj.zzjss.get("ContainerHolder is released.");
        return;
      }
      if (paramContainerAvailableListener == null)
      {
        zzjpj = null;
        return;
      }
      zzjpj = new Launcher.17(this, paramContainerAvailableListener, zzakg);
      if (zzjpi != null) {
        zzbcq();
      }
      return;
    }
    catch (Throwable paramContainerAvailableListener)
    {
      throw paramContainerAvailableListener;
    }
  }
  
  public final String zzbcp()
  {
    if (zzgfp)
    {
      zzdj.zzjss.get("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return "";
    }
    return zzjpk.zzbcp();
  }
  
  public final void zzlg(String paramString)
  {
    try
    {
      boolean bool = zzgfp;
      if (bool) {
        return;
      }
      zzjph.zzlg(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void zzlh(String paramString)
  {
    if (zzgfp)
    {
      zzdj.zzjss.get("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return;
    }
    zzjpk.zzlh(paramString);
  }
}
