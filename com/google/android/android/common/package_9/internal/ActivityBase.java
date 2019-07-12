package com.google.android.android.common.package_9.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

public class ActivityBase
  extends AbstractGalleryActivity
{
  public final SparseArray<com.google.android.gms.common.api.internal.zzi.zza> zzfik = new SparseArray();
  
  public ActivityBase(zzcg paramZzcg)
  {
    super(paramZzcg, GoogleApiAvailability.zzffi);
    zzfoo.handleResult("AutoManageHelper", this);
  }
  
  public static ActivityBase onCreate(zzcf paramZzcf)
  {
    paramZzcf = LifecycleCallback.showProgressDialog(paramZzcf);
    ActivityBase localActivityBase = (ActivityBase)paramZzcf.get("AutoManageHelper", zzi.class);
    if (localActivityBase != null) {
      return localActivityBase;
    }
    return new ActivityBase(paramZzcf);
  }
  
  private final zzi.zza zzbq(int paramInt)
  {
    if (zzfik.size() <= paramInt) {
      return null;
    }
    SparseArray localSparseArray = zzfik;
    return (zzi.zza)localSparseArray.get(localSparseArray.keyAt(paramInt));
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < zzfik.size())
    {
      zzi.zza localZza = zzbq(i);
      if (localZza != null)
      {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zzfil);
        paramPrintWriter.println(":");
        zzfim.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      i += 1;
    }
  }
  
  public final void handleMessage(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (paramInt < 0)
    {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      return;
    }
    Object localObject = (zzi.zza)zzfik.get(paramInt);
    if (localObject != null)
    {
      zzbp(paramInt);
      localObject = zzfin;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
  }
  
  public final void onActivityResult(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzbp.get(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (zzfik.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder(54);
    ((StringBuilder)localObject).append("Already managing a GoogleApiClient with id ");
    ((StringBuilder)localObject).append(paramInt);
    zzbp.append(bool, ((StringBuilder)localObject).toString());
    localObject = (Fragment)zzfiw.get();
    boolean bool = mStarted;
    String str = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 49);
    localStringBuilder.append("starting AutoManage for client ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    paramOnConnectionFailedListener = new zzi.zza(this, paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
    zzfik.put(paramInt, paramOnConnectionFailedListener);
    if ((mStarted) && (localObject == null))
    {
      paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
      localObject = new StringBuilder(paramOnConnectionFailedListener.length() + 11);
      ((StringBuilder)localObject).append("connecting ");
      ((StringBuilder)localObject).append(paramOnConnectionFailedListener);
      ((StringBuilder)localObject).toString();
      paramGoogleApiClient.connect();
    }
  }
  
  public final void onStart()
  {
    mStarted = true;
    boolean bool = mStarted;
    Object localObject = String.valueOf(zzfik);
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 14);
    localStringBuilder.append("onStart ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.toString();
    if (zzfiw.get() == null)
    {
      int i = 0;
      while (i < zzfik.size())
      {
        localObject = zzbq(i);
        if (localObject != null) {
          zzfim.connect();
        }
        i += 1;
      }
    }
  }
  
  public final void onStop()
  {
    int i = 0;
    mStarted = false;
    while (i < zzfik.size())
    {
      zzi.zza localZza = zzbq(i);
      if (localZza != null) {
        zzfim.disconnect();
      }
      i += 1;
    }
  }
  
  public final void zzafw()
  {
    int i = 0;
    while (i < zzfik.size())
    {
      zzi.zza localZza = zzbq(i);
      if (localZza != null) {
        zzfim.connect();
      }
      i += 1;
    }
  }
  
  public final void zzbp(int paramInt)
  {
    zzi.zza localZza = (zzi.zza)zzfik.get(paramInt);
    zzfik.remove(paramInt);
    if (localZza != null)
    {
      zzfim.unregisterConnectionFailedListener(localZza);
      zzfim.disconnect();
    }
  }
}
