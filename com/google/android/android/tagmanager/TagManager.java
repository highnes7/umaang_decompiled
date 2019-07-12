package com.google.android.android.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.gms.tagmanager.zzv;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  public static TagManager zzjvz;
  public final Context mContext;
  public final DataLayer zzjpa;
  public final zzal zzjtz;
  public final zza zzjvw;
  public final zzfn zzjvx;
  public final ConcurrentMap<String, zzv> zzjvy;
  
  public TagManager(Context paramContext, zza paramZza, DataLayer paramDataLayer, zzfn paramZzfn)
  {
    if (paramContext != null)
    {
      mContext = paramContext.getApplicationContext();
      zzjvx = paramZzfn;
      zzjvw = paramZza;
      zzjvy = new ConcurrentHashMap();
      zzjpa = paramDataLayer;
      zzjpa.scan(new zzgb(this));
      zzjpa.scan(new FileChooser.1(mContext));
      zzjtz = new zzal();
      mContext.registerComponentCallbacks(new zzgd(this));
      ScreenshotTaker.zzdp(mContext);
      return;
    }
    throw new NullPointerException("context cannot be null");
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (zzjvz == null) {
        if (paramContext != null)
        {
          zzjvz = new TagManager(paramContext, new zzgc(), new DataLayer(new zzat(paramContext)), zzfo.zzbez());
        }
        else
        {
          zzdj.zzjss.get("TagManager.getInstance requires non-null context.");
          throw new NullPointerException();
        }
      }
      paramContext = zzjvz;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private final void zzmb(String paramString)
  {
    Iterator localIterator = zzjvy.values().iterator();
    while (localIterator.hasNext()) {
      ((ServiceListener)localIterator.next()).zzlg(paramString);
    }
  }
  
  public void dispatch()
  {
    zzjvx.dispatch();
  }
  
  public final boolean get(Uri paramUri)
  {
    try
    {
      zzei localZzei = zzei.zzbeh();
      if (localZzei.parseUrl(paramUri))
      {
        paramUri = localZzei.getContainerId();
        int i = zzge.zzjwb[localZzei.zzbei().ordinal()];
        if (i != 1)
        {
          if ((i == 2) || (i == 3))
          {
            Iterator localIterator = zzjvy.keySet().iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ServiceListener localServiceListener = (ServiceListener)zzjvy.get(str);
              if (str.equals(paramUri)) {
                localServiceListener.zzlh(localZzei.zzbej());
              }
              for (;;)
              {
                localServiceListener.refresh();
                break;
                if (localServiceListener.zzbcp() == null) {
                  break;
                }
                localServiceListener.zzlh(null);
              }
            }
          }
        }
        else
        {
          paramUri = (ServiceListener)zzjvy.get(paramUri);
          if (paramUri != null)
          {
            paramUri.zzlh(null);
            paramUri.refresh();
          }
        }
        return true;
      }
      return false;
    }
    catch (Throwable paramUri)
    {
      throw paramUri;
    }
  }
  
  public final boolean get(ServiceListener paramServiceListener)
  {
    return zzjvy.remove(paramServiceListener.getContainerId()) != null;
  }
  
  public DataLayer getDataLayer()
  {
    return zzjpa;
  }
  
  public final int getInstance(ServiceListener paramServiceListener)
  {
    zzjvy.put(paramServiceListener.getContainerId(), paramServiceListener);
    return zzjvy.size();
  }
  
  public PendingResult loadContainerDefaultOnly(String paramString, int paramInt)
  {
    paramString = zzjvw.showError(mContext, this, null, paramString, paramInt, zzjtz);
    paramString.zzbcs();
    return paramString;
  }
  
  public PendingResult loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = zzjvw.showError(mContext, this, paramHandler.getLooper(), paramString, paramInt, zzjtz);
    paramString.zzbcs();
    return paramString;
  }
  
  public PendingResult loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = zzjvw.showError(mContext, this, null, paramString, paramInt, zzjtz);
    paramString.zzbcu();
    return paramString;
  }
  
  public PendingResult loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = zzjvw.showError(mContext, this, paramHandler.getLooper(), paramString, paramInt, zzjtz);
    paramString.zzbcu();
    return paramString;
  }
  
  public PendingResult loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = zzjvw.showError(mContext, this, null, paramString, paramInt, zzjtz);
    paramString.zzbct();
    return paramString;
  }
  
  public PendingResult loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = zzjvw.showError(mContext, this, paramHandler.getLooper(), paramString, paramInt, zzjtz);
    paramString.zzbct();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 5;
    }
    zzdj.setLogLevel(i);
  }
  
  public abstract interface zza
  {
    public abstract Waypoint showError(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzal paramZzal);
  }
}
