package com.google.android.android.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.zzcj;
import com.google.android.android.location.LocationAvailability;
import com.google.android.android.location.LocationRequest;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
import java.util.Map;

public final class zzbzo
{
  public final Context mContext;
  public final Map<com.google.android.gms.common.api.internal.zzcl<LocationListener>, com.google.android.gms.internal.zzbzs> zzgzm = new HashMap();
  public final com.google.android.gms.internal.zzcae<com.google.android.gms.internal.zzbzk> zzhzb;
  public ContentProviderClient zzhzm = null;
  public boolean zzhzn = false;
  public final Map<com.google.android.gms.common.api.internal.zzcl<LocationCallback>, com.google.android.gms.internal.zzbzp> zzhzo = new HashMap();
  
  public zzbzo(Context paramContext, zzcae paramZzcae)
  {
    mContext = paramContext;
    zzhzb = paramZzcae;
  }
  
  private final zzbzp getPackageInfo(zzcj paramZzcj)
  {
    Map localMap = zzhzo;
    try
    {
      zzbzp localZzbzp2 = (zzbzp)zzhzo.get(paramZzcj.zzaik());
      zzbzp localZzbzp1 = localZzbzp2;
      if (localZzbzp2 == null) {
        localZzbzp1 = new zzbzp(paramZzcj);
      }
      zzhzo.put(paramZzcj.zzaik(), localZzbzp1);
      return localZzbzp1;
    }
    catch (Throwable paramZzcj)
    {
      throw paramZzcj;
    }
  }
  
  private final zzbzs putIfAbsent(zzcj paramZzcj)
  {
    Map localMap = zzgzm;
    try
    {
      zzbzs localZzbzs2 = (zzbzs)zzgzm.get(paramZzcj.zzaik());
      zzbzs localZzbzs1 = localZzbzs2;
      if (localZzbzs2 == null) {
        localZzbzs1 = new zzbzs(paramZzcj);
      }
      zzgzm.put(paramZzcj.zzaik(), localZzbzs1);
      return localZzbzs1;
    }
    catch (Throwable paramZzcj)
    {
      throw paramZzcj;
    }
  }
  
  public final void addMenuItem(PendingIntent paramPendingIntent, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    zzbzk localZzbzk = (zzbzk)zzhzb.zzajj();
    if (paramZzbzf != null) {
      paramZzbzf = paramZzbzf.asBinder();
    } else {
      paramZzbzf = null;
    }
    localZzbzk.next(new zzcaa(2, null, null, paramPendingIntent, null, paramZzbzf));
  }
  
  public final void createNote(Location paramLocation)
    throws RemoteException
  {
    zzhzb.zzaji();
    ((zzbzk)zzhzb.zzajj()).replaceFragment(paramLocation);
  }
  
  public final void estimateSize(LocationRequest paramLocationRequest, zzcj paramZzcj, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    Object localObject = putIfAbsent(paramZzcj);
    paramZzcj = (zzbzk)zzhzb.zzajj();
    zzbzy localZzbzy = zzbzy.getSimpleName(paramLocationRequest);
    localObject = ((IInterface)localObject).asBinder();
    if (paramZzbzf != null) {
      paramLocationRequest = paramZzbzf.asBinder();
    } else {
      paramLocationRequest = null;
    }
    paramZzcj.next(new zzcaa(1, localZzbzy, (IBinder)localObject, null, null, paramLocationRequest));
  }
  
  public final Location getLastLocation()
  {
    zzhzb.zzaji();
    Object localObject = zzhzb;
    try
    {
      localObject = ((zzcae)localObject).zzajj();
      localObject = (zzbzk)localObject;
      Context localContext = mContext;
      localObject = ((zzbzk)localObject).zzia(localContext.getPackageName());
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public final void registerRenderer(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    zzbzk localZzbzk = (zzbzk)zzhzb.zzajj();
    zzbzy localZzbzy = zzbzy.getSimpleName(paramLocationRequest);
    if (paramZzbzf != null) {
      paramLocationRequest = paramZzbzf.asBinder();
    } else {
      paramLocationRequest = null;
    }
    localZzbzk.next(new zzcaa(1, localZzbzy, null, paramPendingIntent, null, paramLocationRequest));
  }
  
  public final void remainder(zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    ((zzbzk)zzhzb.zzajj()).remainder(paramZzbzf);
  }
  
  /* Error */
  public final void removeAllListeners()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/google/android/android/internal/zzbzo:zzgzm	Ljava/util/Map;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 32	com/google/android/android/internal/zzbzo:zzgzm	Ljava/util/Map;
    //   11: invokeinterface 143 1 0
    //   16: invokeinterface 149 1 0
    //   21: astore_2
    //   22: aload_2
    //   23: invokeinterface 155 1 0
    //   28: ifeq +42 -> 70
    //   31: aload_2
    //   32: invokeinterface 158 1 0
    //   37: checkcast 68	com/google/android/android/internal/zzbzs
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull -20 -> 22
    //   45: aload_0
    //   46: getfield 38	com/google/android/android/internal/zzbzo:zzhzb	Lcom/google/android/android/internal/zzcae;
    //   49: invokeinterface 82 1 0
    //   54: checkcast 84	com/google/android/android/internal/zzbzk
    //   57: aload_3
    //   58: aconst_null
    //   59: invokestatic 162	com/google/android/android/internal/zzcaa:getAttachment	(Lcom/google/android/android/location/LocationBackend;Lcom/google/android/android/internal/zzbzf;)Lcom/google/android/android/internal/zzcaa;
    //   62: invokeinterface 99 2 0
    //   67: goto -45 -> 22
    //   70: aload_0
    //   71: getfield 32	com/google/android/android/internal/zzbzo:zzgzm	Ljava/util/Map;
    //   74: invokeinterface 165 1 0
    //   79: aload_1
    //   80: monitorexit
    //   81: aload_0
    //   82: getfield 34	com/google/android/android/internal/zzbzo:zzhzo	Ljava/util/Map;
    //   85: astore_1
    //   86: aload_1
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 34	com/google/android/android/internal/zzbzo:zzhzo	Ljava/util/Map;
    //   92: invokeinterface 143 1 0
    //   97: invokeinterface 149 1 0
    //   102: astore_2
    //   103: aload_2
    //   104: invokeinterface 155 1 0
    //   109: ifeq +42 -> 151
    //   112: aload_2
    //   113: invokeinterface 158 1 0
    //   118: checkcast 57	com/google/android/android/internal/zzbzp
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull -20 -> 103
    //   126: aload_0
    //   127: getfield 38	com/google/android/android/internal/zzbzo:zzhzb	Lcom/google/android/android/internal/zzcae;
    //   130: invokeinterface 82 1 0
    //   135: checkcast 84	com/google/android/android/internal/zzbzk
    //   138: aload_3
    //   139: aconst_null
    //   140: invokestatic 168	com/google/android/android/internal/zzcaa:getAttachment	(Lcom/google/android/android/location/IOnBufferingUpdateListenerCallback_0_8;Lcom/google/android/android/internal/zzbzf;)Lcom/google/android/android/internal/zzcaa;
    //   143: invokeinterface 99 2 0
    //   148: goto -45 -> 103
    //   151: aload_0
    //   152: getfield 34	com/google/android/android/internal/zzbzo:zzhzo	Ljava/util/Map;
    //   155: invokeinterface 165 1 0
    //   160: aload_1
    //   161: monitorexit
    //   162: return
    //   163: astore_2
    //   164: aload_1
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: astore_2
    //   169: aload_1
    //   170: monitorexit
    //   171: aload_2
    //   172: athrow
    //   173: astore_1
    //   174: new 129	java/lang/IllegalStateException
    //   177: dup
    //   178: aload_1
    //   179: invokespecial 132	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   182: astore_1
    //   183: goto +3 -> 186
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	zzbzo
    //   4	166	1	localMap	Map
    //   173	6	1	localRemoteException	RemoteException
    //   182	5	1	localIllegalStateException	IllegalStateException
    //   21	92	2	localIterator	java.util.Iterator
    //   163	4	2	localThrowable1	Throwable
    //   168	4	2	localThrowable2	Throwable
    //   40	99	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   88	103	163	java/lang/Throwable
    //   103	122	163	java/lang/Throwable
    //   126	148	163	java/lang/Throwable
    //   151	162	163	java/lang/Throwable
    //   164	166	163	java/lang/Throwable
    //   7	22	168	java/lang/Throwable
    //   22	41	168	java/lang/Throwable
    //   45	67	168	java/lang/Throwable
    //   70	81	168	java/lang/Throwable
    //   169	171	168	java/lang/Throwable
    //   166	168	173	android/os/RemoteException
    //   171	173	173	android/os/RemoteException
  }
  
  public final void repaint(com.google.android.android.common.package_9.internal.zzcl paramZzcl, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    zzbp.get(paramZzcl, "Invalid null listener key");
    Map localMap = zzhzo;
    try
    {
      paramZzcl = (zzbzp)zzhzo.remove(paramZzcl);
      if (paramZzcl != null)
      {
        paramZzcl.release();
        ((zzbzk)zzhzb.zzajj()).next(zzcaa.getAttachment(paramZzcl, paramZzbzf));
      }
      return;
    }
    catch (Throwable paramZzcl)
    {
      throw paramZzcl;
    }
  }
  
  public final void startSession(zzbzy paramZzbzy, zzcj paramZzcj, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    paramZzcj = getPackageInfo(paramZzcj);
    zzbzk localZzbzk = (zzbzk)zzhzb.zzajj();
    IBinder localIBinder = paramZzcj.asBinder();
    if (paramZzbzf != null) {
      paramZzcj = paramZzbzf.asBinder();
    } else {
      paramZzcj = null;
    }
    localZzbzk.next(new zzcaa(1, paramZzbzy, null, null, localIBinder, paramZzcj));
  }
  
  public final void zoomChanged(com.google.android.android.common.package_9.internal.zzcl paramZzcl, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzb.zzaji();
    zzbp.get(paramZzcl, "Invalid null listener key");
    Map localMap = zzgzm;
    try
    {
      paramZzcl = (zzbzs)zzgzm.remove(paramZzcl);
      if (paramZzcl != null)
      {
        paramZzcl.release();
        ((zzbzk)zzhzb.zzajj()).next(zzcaa.getAttachment(paramZzcl, paramZzbzf));
      }
      return;
    }
    catch (Throwable paramZzcl)
    {
      throw paramZzcl;
    }
  }
  
  public final LocationAvailability zzasw()
  {
    zzhzb.zzaji();
    Object localObject = zzhzb;
    try
    {
      localObject = ((zzcae)localObject).zzajj();
      localObject = (zzbzk)localObject;
      Context localContext = mContext;
      localObject = ((zzbzk)localObject).zzib(localContext.getPackageName());
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public final void zzasx()
  {
    if (zzhzn) {
      try
      {
        zzbk(false);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new IllegalStateException(localRemoteException);
      }
    }
  }
  
  public final void zzbk(boolean paramBoolean)
    throws RemoteException
  {
    zzhzb.zzaji();
    ((zzbzk)zzhzb.zzajj()).zzbk(paramBoolean);
    zzhzn = paramBoolean;
  }
}
