package com.google.android.android.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.android.common.GooglePlayServicesNotAvailableException;
import com.google.android.android.common.GooglePlayServicesRepairableException;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.TransactionInput;
import com.google.android.android.common.internal.zzbp;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  public static final Object zzaqd = new Object();
  public static final PingManager zzjnj = PingManager.zzffk;
  public static Method zzjnk = null;
  
  public ProviderInstaller() {}
  
  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zzbp.get(paramContext, "Context must not be null");
    PingManager.zzbu(paramContext);
    Context localContext = TransactionInput.getRemoteContext(paramContext);
    if (localContext != null)
    {
      paramContext = zzaqd;
      try
      {
        if (zzjnk == null) {}
        Object localObject;
        String str;
        label113:
        label123:
        throw new GooglePlayServicesNotAvailableException(8);
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localObject = localContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl");
          localObject = ((Class)localObject).getMethod("insertProvider", new Class[] { Context.class });
          zzjnk = (Method)localObject;
          localObject = zzjnk;
          ((Method)localObject).invoke(null, new Object[] { localContext });
          return;
        }
        catch (Exception localException)
        {
          str = String.valueOf(localException.getMessage());
          if (str.length() == 0) {
            break label113;
          }
          "Failed to install provider: ".concat(str);
          break label123;
          new String("Failed to install provider: ");
          throw new GooglePlayServicesNotAvailableException(8);
        }
        localThrowable = localThrowable;
        throw str;
      }
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    zzbp.get(paramContext, "Context must not be null");
    zzbp.get(paramProviderInstallListener, "Listener must not be null");
    zzbp.zzfy("Must be called on the UI thread");
    new AttachmentView.1(paramContext, paramProviderInstallListener).execute(new Void[0]);
  }
  
  public abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}
