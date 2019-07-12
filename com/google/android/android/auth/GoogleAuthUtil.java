package com.google.android.android.auth;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.android.common.GooglePlayServicesUtil;
import com.google.android.android.common.TransactionInput;
import com.google.android.android.common.internal.zzbp;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil
  extends AccountManager
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static String KEY_ANDROID_PACKAGE_NAME = AccountManager.KEY_ANDROID_PACKAGE_NAME;
  public static String KEY_CALLER_UID = AccountManager.KEY_CALLER_UID;
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  
  public GoogleAuthUtil() {}
  
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    AccountManager.clearToken(paramContext, paramString);
  }
  
  public static List getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    return AccountManager.getAccountChangeEvents(paramContext, paramInt, paramString);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    return AccountManager.getAccountId(paramContext, paramString);
  }
  
  public static TokenData getAuthToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      paramAccount = AccountManager.save(paramContext, paramAccount, paramString, localBundle);
      TransactionInput.zzbv(paramContext);
      return paramAccount;
    }
    catch (GooglePlayServicesAvailabilityException paramAccount)
    {
      GooglePlayServicesUtil.showErrorNotification(paramAccount.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException paramAccount)
    {
      for (;;) {}
    }
    TransactionInput.zzbv(paramContext);
    throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return AccountManager.getToken(paramContext, paramAccount, paramString);
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return AccountManager.getToken(paramContext, paramAccount, paramString, paramBundle);
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return AccountManager.getToken(paramContext, paramString1, paramString2);
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return AccountManager.getToken(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("handle_notification", true);
    return getAuthToken(paramContext, paramAccount, paramString, localBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.toUri(1);
    }
    try
    {
      Intent.parseUri((String)localObject, 1);
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putParcelable("callback_intent", paramIntent);
      ((Bundle)localObject).putBoolean("handle_notification", true);
      return getAuthToken(paramContext, paramAccount, paramString, (Bundle)localObject).getToken();
    }
    catch (URISyntaxException paramContext)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    throw new IllegalArgumentException("Callback cannot be null.");
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    zzbp.format(paramString2, "Authority cannot be empty or null.");
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle1);
    localBundle.putString("authority", paramString2);
    localBundle.putBundle("sync_extras", paramBundle1);
    localBundle.putBoolean("handle_notification", true);
    return getAuthToken(paramContext, paramAccount, paramString1, localBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle, paramIntent);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
  }
  
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.invalidateToken(paramContext, paramString);
  }
  
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
    throws GoogleAuthException, IOException
  {
    return AccountManager.removeAccount(paramContext, paramAccount);
  }
}
