package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import views.CordovaWebView;

public class MessengerUtils
{
  public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
  public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
  public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
  public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
  public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
  public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
  public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
  public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
  public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
  public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
  public static final String PACKAGE_NAME = "com.facebook.orca";
  public static final String PAGE_KEY = "MessengerUtils";
  public static final int PROTOCOL_VERSION_20150314 = 20150314;
  
  public MessengerUtils() {}
  
  public static void finishShareToMessenger(Activity paramActivity, ShareToMessengerParams paramShareToMessengerParams)
  {
    Object localObject = paramActivity.getIntent();
    Set localSet = ((Intent)localObject).getCategories();
    if (localSet == null)
    {
      paramActivity.setResult(0, null);
      paramActivity.finish();
      return;
    }
    if (localSet.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314"))
    {
      localObject = CordovaWebView.getExtras((Intent)localObject);
      Intent localIntent = new Intent();
      if (localSet.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314"))
      {
        localIntent.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
        localIntent.putExtra("com.facebook.orca.extra.THREAD_TOKEN", ((Bundle)localObject).getString("com.facebook.orca.extra.THREAD_TOKEN"));
        localIntent.setDataAndType(tempFile, mimeType);
        localIntent.setFlags(1);
        localIntent.putExtra("com.facebook.orca.extra.APPLICATION_ID", FacebookSdk.getApplicationId());
        localIntent.putExtra("com.facebook.orca.extra.METADATA", metaData);
        localIntent.putExtra("com.facebook.orca.extra.EXTERNAL_URI", externalUri);
        paramActivity.setResult(-1, localIntent);
        paramActivity.finish();
        return;
      }
      throw new RuntimeException();
    }
    paramActivity.setResult(0, null);
    paramActivity.finish();
  }
  
  public static Set getAllAvailableProtocolVersions(Context paramContext)
  {
    Object localObject = paramContext.getContentResolver();
    paramContext = new HashSet();
    localObject = ((ContentResolver)localObject).query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[] { "version" }, null, null, null);
    if (localObject != null) {
      try
      {
        int i = ((Cursor)localObject).getColumnIndex("version");
        for (;;)
        {
          boolean bool = ((Cursor)localObject).moveToNext();
          if (!bool) {
            break;
          }
          paramContext.add(Integer.valueOf(((Cursor)localObject).getInt(i)));
        }
        ((Cursor)localObject).close();
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        ((Cursor)localObject).close();
        throw paramContext;
      }
    }
    return paramContext;
  }
  
  public static MessengerThreadParams getMessengerThreadParamsForIntent(Intent paramIntent)
  {
    Object localObject = paramIntent.getCategories();
    if (localObject == null) {
      return null;
    }
    if (((Set)localObject).contains("com.facebook.orca.category.PLATFORM_THREAD_20150314"))
    {
      paramIntent = CordovaWebView.getExtras(paramIntent);
      localObject = paramIntent.getString("com.facebook.orca.extra.THREAD_TOKEN");
      String str1 = paramIntent.getString("com.facebook.orca.extra.METADATA");
      String str2 = paramIntent.getString("com.facebook.orca.extra.PARTICIPANTS");
      boolean bool1 = paramIntent.getBoolean("com.facebook.orca.extra.IS_REPLY");
      boolean bool2 = paramIntent.getBoolean("com.facebook.orca.extra.IS_COMPOSE");
      paramIntent = MessengerThreadParams.Origin.UNKNOWN;
      if (bool1) {
        paramIntent = MessengerThreadParams.Origin.REPLY_FLOW;
      } else if (bool2) {
        paramIntent = MessengerThreadParams.Origin.COMPOSE_FLOW;
      }
      return new MessengerThreadParams(paramIntent, (String)localObject, str1, parseParticipants(str2));
    }
    return null;
  }
  
  public static boolean hasMessengerInstalled(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.facebook.orca", 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static void openMessengerInPlayStore(Context paramContext)
  {
    try
    {
      startViewUri(paramContext, "market://details?id=com.facebook.orca");
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;) {}
    }
    startViewUri(paramContext, "http://play.google.com/store/apps/details?id=com.facebook.orca");
  }
  
  public static List parseParticipants(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.split(",");
      ArrayList localArrayList = new ArrayList();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramString[i].trim());
        i += 1;
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  public static void shareToMessenger(Activity paramActivity, int paramInt, ShareToMessengerParams paramShareToMessengerParams)
  {
    if (!hasMessengerInstalled(paramActivity))
    {
      openMessengerInPlayStore(paramActivity);
      return;
    }
    if (getAllAvailableProtocolVersions(paramActivity).contains(Integer.valueOf(20150314)))
    {
      shareToMessenger20150314(paramActivity, paramInt, paramShareToMessengerParams);
      return;
    }
    openMessengerInPlayStore(paramActivity);
  }
  
  public static void shareToMessenger20150314(Activity paramActivity, int paramInt, ShareToMessengerParams paramShareToMessengerParams)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setFlags(1);
      localIntent.setPackage("com.facebook.orca");
      Object localObject = tempFile;
      localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
      localObject = mimeType;
      localIntent.setType((String)localObject);
      localObject = FacebookSdk.getApplicationId();
      if (localObject != null)
      {
        localIntent.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
        localIntent.putExtra("com.facebook.orca.extra.APPLICATION_ID", (String)localObject);
        localObject = metaData;
        localIntent.putExtra("com.facebook.orca.extra.METADATA", (String)localObject);
        paramShareToMessengerParams = externalUri;
        localIntent.putExtra("com.facebook.orca.extra.EXTERNAL_URI", paramShareToMessengerParams);
      }
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (ActivityNotFoundException paramShareToMessengerParams)
    {
      for (;;) {}
    }
    paramActivity.startActivity(paramActivity.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
  }
  
  public static void startViewUri(Context paramContext, String paramString)
  {
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }
}
