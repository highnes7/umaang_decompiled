package com.google.android.android.auth;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.android.common.GooglePlayServicesNotAvailableException;
import com.google.android.android.common.GooglePlayServicesRepairableException;
import com.google.android.android.common.HttpRequest;
import com.google.android.android.common.TransactionInput;
import com.google.android.android.common.UserRecoverableException;
import com.google.android.android.common.internal.zzaf;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbde;
import java.io.IOException;
import java.util.List;

public class AccountManager
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  @SuppressLint({"InlinedApi"})
  public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
  @SuppressLint({"InlinedApi"})
  public static final String KEY_CALLER_UID;
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  public static final String[] zzdxj = { "com.google", "com.google.work", "cn.google" };
  public static final ComponentName zzdxk = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  public static final zzbde zzdxl = new zzbde("Auth", new String[] { "GoogleAuthUtil" });
  
  static
  {
    KEY_CALLER_UID = "callerUid";
  }
  
  public AccountManager() {}
  
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    zzbp.zzgh("Calling this from your main thread can lead to deadlock");
    zzbj(paramContext);
    Bundle localBundle = new Bundle();
    String str = getApplicationInfopackageName;
    localBundle.putString("clientPackageName", str);
    if (!localBundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
      localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    }
    paramString = new ActivityChooserModel.1(paramString, localBundle);
    delete(paramContext, zzdxk, paramString);
  }
  
  public static java.lang.Object delete(Context paramContext, ComponentName paramComponentName, Object paramObject)
    throws IOException, GoogleAuthException
  {
    HttpRequest localHttpRequest = new HttpRequest();
    zzaf localZzaf = zzaf.zzce(paramContext);
    if (localZzaf.connect(paramComponentName, localHttpRequest, "GoogleAuthUtil"))
    {
      try
      {
        paramContext = paramObject.zzaa(localHttpRequest.zzaew());
        localZzaf.send(paramComponentName, localHttpRequest, "GoogleAuthUtil");
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        break label89;
      }
      catch (InterruptedException paramContext) {}catch (RemoteException paramContext) {}
      zzdxl.execSQL("GoogleAuthUtil", new java.lang.Object[] { "Error on service connection.", paramContext });
      throw new IOException("Error on service connection.", paramContext);
      label89:
      localZzaf.send(paramComponentName, localHttpRequest, "GoogleAuthUtil");
      throw paramContext;
    }
    throw new IOException("Could not bind to service.");
  }
  
  public static List getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    zzbp.format(paramString, "accountName must be provided");
    zzbp.zzgh("Calling this from your main thread can lead to deadlock");
    zzbj(paramContext);
    paramString = new StandardExceptionParser(paramString, paramInt);
    return (List)delete(paramContext, zzdxk, paramString);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    zzbp.format(paramString, "accountName must be provided");
    zzbp.zzgh("Calling this from your main thread can lead to deadlock");
    zzbj(paramContext);
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    save(paramAccount);
    return save(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  public static void invalidateToken(Context paramContext, String paramString)
  {
    android.accounts.AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
    throws GoogleAuthException, IOException
  {
    zzbp.append(paramContext);
    save(paramAccount);
    zzbj(paramContext);
    paramAccount = new PacketWriter(paramAccount);
    return (Bundle)delete(paramContext, zzdxk, paramAccount);
  }
  
  public static TokenData save(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    zzbp.zzgh("Calling this from your main thread can lead to deadlock");
    zzbp.format(paramString, "Scope cannot be empty or null.");
    save(paramAccount);
    zzbj(paramContext);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    String str = getApplicationInfopackageName;
    paramBundle.putString("clientPackageName", str);
    if (TextUtils.isEmpty(paramBundle.getString(KEY_ANDROID_PACKAGE_NAME))) {
      paramBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    }
    paramBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
    paramAccount = new AbstractTag(paramAccount, paramString, paramBundle);
    return (TokenData)delete(paramContext, zzdxk, paramAccount);
  }
  
  public static void save(Account paramAccount)
  {
    if (paramAccount != null)
    {
      if (!TextUtils.isEmpty(name))
      {
        String[] arrayOfString = zzdxj;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equals(type)) {
            return;
          }
          i += 1;
        }
        throw new IllegalArgumentException("Account type not supported");
      }
      throw new IllegalArgumentException("Account name cannot be empty!");
    }
    paramAccount = new IllegalArgumentException("Account cannot be null");
    throw paramAccount;
  }
  
  public static java.lang.Object update(java.lang.Object paramObject)
    throws IOException
  {
    if (paramObject != null) {
      return paramObject;
    }
    zzdxl.logError("GoogleAuthUtil", new java.lang.Object[] { "Binder call returned null." });
    throw new IOException("Service unavailable.");
  }
  
  public static void zzbj(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      TransactionInput.zzbj(paramContext.getApplicationContext());
      return;
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
  }
}
