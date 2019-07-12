package com.facebook.internal;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers
{
  public static final String ANDROID_ID_COLUMN_NAME = "androidid";
  public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  public static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
  public static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
  public static final int CONNECTION_RESULT_SUCCESS = 0;
  public static final String HASHTAG = "com.facebook.internal.AttributionIdentifiers";
  public static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
  public static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
  public static AttributionIdentifiers recentlyFetchedIdentifiers;
  public String androidAdvertiserId;
  public String androidInstallerPackage;
  public String attributionId;
  public long fetchTime;
  public boolean limitTracking;
  
  public AttributionIdentifiers() {}
  
  public static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers paramAttributionIdentifiers)
  {
    fetchTime = System.currentTimeMillis();
    recentlyFetchedIdentifiers = paramAttributionIdentifiers;
    return paramAttributionIdentifiers;
  }
  
  public static AttributionIdentifiers getAndroidId(Context paramContext)
  {
    AttributionIdentifiers localAttributionIdentifiers = getAndroidIdViaReflection(paramContext);
    Object localObject = localAttributionIdentifiers;
    if (localAttributionIdentifiers == null)
    {
      paramContext = getAndroidIdViaService(paramContext);
      localObject = paramContext;
      if (paramContext == null) {
        localObject = new AttributionIdentifiers();
      }
    }
    return localObject;
  }
  
  public static AttributionIdentifiers getAndroidIdViaReflection(Context paramContext)
  {
    try
    {
      Object localObject1 = Looper.myLooper();
      Object localObject2 = Looper.getMainLooper();
      if (localObject1 != localObject2)
      {
        localObject1 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
        if (localObject1 == null) {
          return null;
        }
        localObject1 = Utility.invokeMethodQuietly(null, (Method)localObject1, new Object[] { paramContext });
        if ((localObject1 instanceof Integer))
        {
          localObject1 = (Integer)localObject1;
          int i = ((Integer)localObject1).intValue();
          if (i != 0) {
            return null;
          }
          localObject1 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
          if (localObject1 == null) {
            return null;
          }
          paramContext = Utility.invokeMethodQuietly(null, (Method)localObject1, new Object[] { paramContext });
          if (paramContext == null) {
            return null;
          }
          localObject1 = paramContext.getClass();
          localObject2 = Utility.getMethodQuietly((Class)localObject1, "getId", new Class[0]);
          localObject1 = paramContext.getClass();
          Method localMethod = Utility.getMethodQuietly((Class)localObject1, "isLimitAdTrackingEnabled", new Class[0]);
          if (localObject2 != null)
          {
            if (localMethod == null) {
              return null;
            }
            localObject1 = new AttributionIdentifiers();
            localObject2 = Utility.invokeMethodQuietly(paramContext, (Method)localObject2, new Object[0]);
            androidAdvertiserId = ((String)localObject2);
            paramContext = Utility.invokeMethodQuietly(paramContext, localMethod, new Object[0]);
            paramContext = (Boolean)paramContext;
            boolean bool = paramContext.booleanValue();
            limitTracking = bool;
            return localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      else
      {
        paramContext = new FacebookException("getAndroidId cannot be called on the main thread.");
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Utility.logd("android_id", paramContext);
    }
    return null;
  }
  
  public static AttributionIdentifiers getAndroidIdViaService(Context paramContext)
  {
    GoogleAdServiceConnection localGoogleAdServiceConnection = new GoogleAdServiceConnection();
    Object localObject = new Intent("com.google.android.gms.ads.identifier.service.START");
    ((Intent)localObject).setPackage("com.google.android.gms");
    if (paramContext.bindService((Intent)localObject, localGoogleAdServiceConnection, 1))
    {
      try
      {
        localObject = new GoogleAdInfo(localGoogleAdServiceConnection.getBinder());
        AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
        String str = ((GoogleAdInfo)localObject).getAdvertiserId();
        androidAdvertiserId = str;
        boolean bool = ((GoogleAdInfo)localObject).isTrackingLimited();
        limitTracking = bool;
        paramContext.unbindService(localGoogleAdServiceConnection);
        return localAttributionIdentifiers;
      }
      catch (Throwable localThrowable) {}catch (Exception localException)
      {
        Utility.logd("android_id", localException);
        paramContext.unbindService(localGoogleAdServiceConnection);
      }
      paramContext.unbindService(localGoogleAdServiceConnection);
      throw localException;
    }
    return null;
  }
  
  public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext)
  {
    Object localObject1;
    if (recentlyFetchedIdentifiers != null)
    {
      long l = System.currentTimeMillis();
      localObject1 = recentlyFetchedIdentifiers;
      if (l - fetchTime < 3600000L) {
        return localObject1;
      }
    }
    AttributionIdentifiers localAttributionIdentifiers = getAndroidId(paramContext);
    Object localObject2 = null;
    try
    {
      localObject1 = paramContext.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
      if (localObject1 != null) {
        localObject1 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
      }
      for (;;)
      {
        break;
        localObject1 = paramContext.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0);
        if (localObject1 != null) {
          localObject1 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
        } else {
          localObject1 = null;
        }
      }
      String str = getInstallerPackageName(paramContext);
      if (str != null) {
        androidInstallerPackage = str;
      }
      if (localObject1 == null)
      {
        cacheAndReturnIdentifiers(localAttributionIdentifiers);
        return localAttributionIdentifiers;
      }
      paramContext = paramContext.getContentResolver().query((Uri)localObject1, new String[] { "aid", "androidid", "limit_tracking" }, null, null, null);
      if (paramContext != null) {}
      try
      {
        boolean bool = paramContext.moveToFirst();
        if (bool)
        {
          int i = paramContext.getColumnIndex("aid");
          int j = paramContext.getColumnIndex("androidid");
          int k = paramContext.getColumnIndex("limit_tracking");
          localObject1 = paramContext.getString(i);
          attributionId = ((String)localObject1);
          if ((j > 0) && (k > 0))
          {
            localObject1 = localAttributionIdentifiers.getAndroidAdvertiserId();
            if (localObject1 == null)
            {
              localObject1 = paramContext.getString(j);
              androidAdvertiserId = ((String)localObject1);
              bool = Boolean.parseBoolean(paramContext.getString(k));
              limitTracking = bool;
            }
          }
          paramContext.close();
          cacheAndReturnIdentifiers(localAttributionIdentifiers);
          return localAttributionIdentifiers;
        }
        cacheAndReturnIdentifiers(localAttributionIdentifiers);
        if (paramContext == null) {
          break label411;
        }
        paramContext.close();
        return localAttributionIdentifiers;
      }
      catch (Throwable localThrowable1)
      {
        break label395;
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = HASHTAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Caught unexpected exception in getAttributionId(): ");
        ((StringBuilder)localObject2).append(((Exception)localException2).toString());
        ((StringBuilder)localObject2).toString();
        if (paramContext == null) {
          break label414;
        }
        paramContext.close();
        return null;
      }
      catch (Throwable localThrowable3) {}
    }
    catch (Throwable localThrowable2)
    {
      paramContext = (Context)localObject2;
    }
    catch (Exception localException2)
    {
      paramContext = null;
    }
    label395:
    if (paramContext != null) {
      paramContext.close();
    }
    throw localThrowable3;
    label411:
    return localAttributionIdentifiers;
    label414:
    return null;
  }
  
  public static String getInstallerPackageName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {
      return localPackageManager.getInstallerPackageName(paramContext.getPackageName());
    }
    return null;
  }
  
  public String getAndroidAdvertiserId()
  {
    return androidAdvertiserId;
  }
  
  public String getAndroidInstallerPackage()
  {
    return androidInstallerPackage;
  }
  
  public String getAttributionId()
  {
    return attributionId;
  }
  
  public boolean isTrackingLimited()
  {
    return limitTracking;
  }
  
  private static final class GoogleAdInfo
    implements IInterface
  {
    public static final int FIRST_TRANSACTION_CODE = 1;
    public static final int SECOND_TRANSACTION_CODE = 2;
    public IBinder binder;
    
    public GoogleAdInfo(IBinder paramIBinder)
    {
      binder = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return binder;
    }
    
    public String getAdvertiserId()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        binder.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        localParcel2.recycle();
        localParcel1.recycle();
        return str;
      }
      catch (Throwable localThrowable)
      {
        localParcel2.recycle();
        localParcel1.recycle();
        throw localThrowable;
      }
    }
    
    public boolean isTrackingLimited()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        boolean bool = true;
        localParcel1.writeInt(1);
        binder.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        if (i == 0) {
          bool = false;
        }
        localParcel2.recycle();
        localParcel1.recycle();
        return bool;
      }
      catch (Throwable localThrowable)
      {
        localParcel2.recycle();
        localParcel1.recycle();
        throw localThrowable;
      }
    }
  }
  
  private static final class GoogleAdServiceConnection
    implements ServiceConnection
  {
    public AtomicBoolean consumed = new AtomicBoolean(false);
    public final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();
    
    public GoogleAdServiceConnection() {}
    
    public IBinder getBinder()
      throws InterruptedException
    {
      if (!consumed.compareAndSet(true, true)) {
        return (IBinder)queue.take();
      }
      throw new IllegalStateException("Binder already consumed");
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      paramComponentName = queue;
      try
      {
        paramComponentName.put(paramIBinder);
        return;
      }
      catch (InterruptedException paramComponentName) {}
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}
