package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Collection;
import java.util.Iterator;

public final class Validate
{
  public static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
  public static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
  public static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "com.facebook.internal.Validate";
  public static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
  public static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
  
  public Validate() {}
  
  public static void containsNoNullOrEmpty(Collection paramCollection, String paramString)
  {
    notNull(paramCollection, paramString);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (str != null)
      {
        if (str.length() == 0) {
          throw new IllegalArgumentException(StringBuilder.append("Container '", paramString, "' cannot contain empty values"));
        }
      }
      else {
        throw new NullPointerException(StringBuilder.append("Container '", paramString, "' cannot contain null values"));
      }
    }
  }
  
  public static void containsNoNulls(Collection paramCollection, String paramString)
  {
    notNull(paramCollection, paramString);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (paramCollection.next() == null) {
        throw new NullPointerException(StringBuilder.append("Container '", paramString, "' cannot contain null values"));
      }
    }
  }
  
  public static String hasAppID()
  {
    String str = FacebookSdk.getApplicationId();
    if (str != null) {
      return str;
    }
    throw new IllegalStateException("No App ID found, please set the App ID.");
  }
  
  public static void hasContentProvider(Context paramContext)
  {
    notNull(paramContext, "context");
    String str = hasAppID();
    paramContext = paramContext.getPackageManager();
    if (paramContext != null)
    {
      str = StringBuilder.toString("com.facebook.app.FacebookContentProvider", str);
      if (paramContext.resolveContentProvider(str, 0) != null) {
        return;
      }
      throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", new Object[] { str }));
    }
  }
  
  public static void hasFacebookActivity(Context paramContext)
  {
    hasFacebookActivity(paramContext, true);
  }
  
  public static void hasFacebookActivity(Context paramContext, boolean paramBoolean)
  {
    notNull(paramContext, "context");
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {
      paramContext = new ComponentName(paramContext, FacebookActivity.class);
    }
    try
    {
      paramContext = localPackageManager.getActivityInfo(paramContext, 1);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    if (paramContext == null)
    {
      if (!paramBoolean)
      {
        paramContext = DEFAULT_IS_ASSIGNABLE_EX_MESSAGE;
        return;
      }
      throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
    }
  }
  
  public static void hasInternetPermissions(Context paramContext)
  {
    hasInternetPermissions(paramContext, true);
  }
  
  public static void hasInternetPermissions(Context paramContext, boolean paramBoolean)
  {
    notNull(paramContext, "context");
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
    {
      if (!paramBoolean)
      {
        paramContext = DEFAULT_IS_ASSIGNABLE_EX_MESSAGE;
        return;
      }
      throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
    }
  }
  
  public static void notEmpty(Collection paramCollection, String paramString)
  {
    if (!paramCollection.isEmpty()) {
      return;
    }
    throw new IllegalArgumentException(StringBuilder.append("Container '", paramString, "' cannot be empty"));
  }
  
  public static void notEmptyAndContainsNoNulls(Collection paramCollection, String paramString)
  {
    containsNoNulls(paramCollection, paramString);
    notEmpty(paramCollection, paramString);
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    throw new NullPointerException(StringBuilder.append("Argument '", paramString, "' cannot be null"));
  }
  
  public static void notNullOrEmpty(String paramString1, String paramString2)
  {
    if (!Utility.isNullOrEmpty(paramString1)) {
      return;
    }
    throw new IllegalArgumentException(StringBuilder.append("Argument '", paramString2, "' cannot be null or empty"));
  }
  
  public static void oneOf(Object paramObject, String paramString, Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null)
      {
        if (!localObject.equals(paramObject)) {}
      }
      else if (paramObject == null) {
        return;
      }
      i += 1;
    }
    paramObject = new IllegalArgumentException(StringBuilder.append("Argument '", paramString, "' was not one of the allowed values"));
    throw paramObject;
  }
  
  public static void runningOnUiThread()
  {
    if (Looper.getMainLooper().equals(Looper.myLooper())) {
      return;
    }
    throw new FacebookException("This method should be called from the UI thread");
  }
  
  public static void sdkInitialized()
  {
    if (FacebookSdk.isInitialized()) {
      return;
    }
    throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
  }
}
