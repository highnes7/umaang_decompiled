package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData
{
  public static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
  public static final String APPLINK_METHOD_ARGS_KEY = "method_args";
  public static final String APPLINK_VERSION_KEY = "version";
  public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
  public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
  public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
  public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
  public static final String BRIDGE_ARGS_METHOD_KEY = "method";
  public static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
  public static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
  public static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
  public static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
  public static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
  public static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
  public static final String DEFERRED_APP_LINK_PATH = "%s/activities";
  public static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
  public static final String METHOD_ARGS_REF_KEY = "ref";
  public static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
  public static final String REFERER_DATA_REF_KEY = "fb_ref";
  public static final String command = "com.facebook.applinks.AppLinkData";
  public Bundle argumentBundle;
  public JSONObject arguments;
  public String mRef;
  public Uri targetUri;
  
  public AppLinkData() {}
  
  public static AppLinkData createFromActivity(Activity paramActivity)
  {
    Validate.notNull(paramActivity, "activity");
    Intent localIntent = paramActivity.getIntent();
    if (localIntent == null) {
      return null;
    }
    AppLinkData localAppLinkData = createFromAlApplinkData(localIntent);
    paramActivity = localAppLinkData;
    if (localAppLinkData == null) {
      paramActivity = createFromJson(localIntent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
    }
    if (paramActivity == null) {
      return createFromUri(localIntent.getData());
    }
    return paramActivity;
  }
  
  public static AppLinkData createFromAlApplinkData(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getBundleExtra("al_applink_data");
    if (localBundle == null) {
      return null;
    }
    AppLinkData localAppLinkData = new AppLinkData();
    targetUri = paramIntent.getData();
    if (targetUri == null)
    {
      paramIntent = localBundle.getString("target_url");
      if (paramIntent != null) {
        targetUri = Uri.parse(paramIntent);
      }
    }
    argumentBundle = localBundle;
    arguments = null;
    paramIntent = localBundle.getBundle("referer_data");
    if (paramIntent != null) {
      mRef = paramIntent.getString("fb_ref");
    }
    return localAppLinkData;
  }
  
  public static AppLinkData createFromJson(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("version");
      boolean bool = ((JSONObject)localObject).getJSONObject("bridge_args").getString("method").equals("applink");
      if (!bool) {
        break label234;
      }
      bool = paramString.equals("2");
      if (!bool) {
        break label234;
      }
      paramString = new AppLinkData();
      localObject = ((JSONObject)localObject).getJSONObject("method_args");
      arguments = ((JSONObject)localObject);
      localObject = arguments;
      bool = ((JSONObject)localObject).has("ref");
      if (bool)
      {
        localObject = arguments;
        localObject = ((JSONObject)localObject).getString("ref");
        mRef = ((String)localObject);
      }
      else
      {
        localObject = arguments;
        bool = ((JSONObject)localObject).has("referer_data");
        if (bool)
        {
          localObject = arguments;
          localObject = ((JSONObject)localObject).getJSONObject("referer_data");
          bool = ((JSONObject)localObject).has("fb_ref");
          if (bool)
          {
            localObject = ((JSONObject)localObject).getString("fb_ref");
            mRef = ((String)localObject);
          }
        }
      }
      localObject = arguments;
      bool = ((JSONObject)localObject).has("target_url");
      if (bool)
      {
        localObject = arguments;
        localObject = Uri.parse(((JSONObject)localObject).getString("target_url"));
        targetUri = ((Uri)localObject);
      }
      localObject = arguments;
      localObject = toBundle((JSONObject)localObject);
      argumentBundle = ((Bundle)localObject);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    catch (FacebookException paramString)
    {
      for (;;) {}
    }
    paramString = command;
    return null;
    paramString = command;
    return null;
    label234:
    return null;
  }
  
  public static AppLinkData createFromUri(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    AppLinkData localAppLinkData = new AppLinkData();
    targetUri = paramUri;
    return localAppLinkData;
  }
  
  public static void fetchDeferredAppLinkData(Context paramContext, CompletionHandler paramCompletionHandler)
  {
    fetchDeferredAppLinkData(paramContext, null, paramCompletionHandler);
  }
  
  public static void fetchDeferredAppLinkData(Context paramContext, String paramString, final CompletionHandler paramCompletionHandler)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramCompletionHandler, "completionHandler");
    final String str = paramString;
    if (paramString == null) {
      str = Utility.getMetadataApplicationId(paramContext);
    }
    Validate.notNull(str, "applicationId");
    paramContext = paramContext.getApplicationContext();
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        AppLinkData.fetchDeferredAppLinkFromServer(val$applicationContext, str, paramCompletionHandler);
      }
    });
  }
  
  public static void fetchDeferredAppLinkFromServer(Context paramContext, String paramString, CompletionHandler paramCompletionHandler)
  {
    Object localObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("event", "DEFERRED_APP_LINK");
        Utility.setAppEventAttributionParameters((JSONObject)localObject2, AttributionIdentifiers.getAttributionIdentifiers(paramContext), AppEventsLogger.getAnonymousAppDeviceGUID(paramContext), FacebookSdk.getLimitEventAndDataUsage(paramContext));
        ((JSONObject)localObject2).put("application_package_name", paramContext.getPackageName());
        paramString = String.format("%s/activities", new Object[] { paramString });
        localObject1 = null;
        paramContext = null;
      }
      catch (JSONException paramContext)
      {
        Object localObject1;
        long l;
        String str1;
        throw new FacebookException("An error occurred while preparing deferred app link", paramContext);
      }
      try
      {
        localObject2 = GraphRequest.newPostRequest(null, paramString, (JSONObject)localObject2, null).executeAndWait().getJSONObject();
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          String str2 = ((JSONObject)localObject2).optString("applink_args");
          l = ((JSONObject)localObject2).optLong("click_time", -1L);
          str1 = ((JSONObject)localObject2).optString("applink_class");
          localObject2 = ((JSONObject)localObject2).optString("applink_url");
          boolean bool = TextUtils.isEmpty(str2);
          paramString = (String)localObject1;
          if (!bool)
          {
            localObject1 = createFromJson(str2);
            paramContext = (Context)localObject1;
            if (l != -1L) {
              if (arguments != null) {
                paramString = arguments;
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        continue;
      }
      try
      {
        paramString.get("com.facebook.platform.APPLINK_TAP_TIME_UTC", l);
        paramString = argumentBundle;
        if (paramString == null) {
          continue;
        }
        paramString.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", Long.toString(l));
      }
      catch (JSONException paramString) {}catch (Exception paramString) {}
    }
    paramString = command;
    if (str1 != null) {
      if (arguments != null) {
        paramString = arguments;
      }
    }
    try
    {
      paramString.put("com.facebook.platform.APPLINK_NATIVE_CLASS", str1);
      paramString = argumentBundle;
      if (paramString == null) {
        break label264;
      }
      paramString.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", str1);
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    paramString = command;
    label264:
    paramString = paramContext;
    if (localObject2 != null) {
      if (arguments != null) {
        paramString = arguments;
      }
    }
    try
    {
      paramString.put("com.facebook.platform.APPLINK_NATIVE_URL", localObject2);
      localObject1 = argumentBundle;
      paramString = paramContext;
      if (localObject1 == null) {
        break label342;
      }
      ((Bundle)localObject1).putString("com.facebook.platform.APPLINK_NATIVE_URL", (String)localObject2);
      paramString = paramContext;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    paramString = command;
    paramString = paramContext;
    break label342;
    Utility.logd(command, "Unable to fetch deferred applink from server");
    paramString = paramContext;
    label342:
    paramCompletionHandler.onDeferredAppLinkDataFetched(paramString);
  }
  
  public static Bundle toBundle(JSONObject paramJSONObject)
    throws JSONException
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str);
      if ((localObject1 instanceof JSONObject))
      {
        localBundle.putBundle(str, toBundle((JSONObject)localObject1));
      }
      else if ((localObject1 instanceof JSONArray))
      {
        localObject1 = (JSONArray)localObject1;
        int k = ((JSONArray)localObject1).length();
        int j = 0;
        int i = 0;
        if (k == 0)
        {
          localBundle.putStringArray(str, new String[0]);
        }
        else
        {
          Object localObject2 = ((JSONArray)localObject1).get(0);
          if ((localObject2 instanceof JSONObject))
          {
            localObject2 = new Bundle[((JSONArray)localObject1).length()];
            while (i < ((JSONArray)localObject1).length())
            {
              localObject2[i] = toBundle(((JSONArray)localObject1).getJSONObject(i));
              i += 1;
            }
            localBundle.putParcelableArray(str, (Parcelable[])localObject2);
          }
          else if (!(localObject2 instanceof JSONArray))
          {
            localObject2 = new String[((JSONArray)localObject1).length()];
            i = j;
            while (i < ((JSONArray)localObject1).length())
            {
              localObject2[i] = ((JSONArray)localObject1).get(i).toString();
              i += 1;
            }
            localBundle.putStringArray(str, (String[])localObject2);
          }
          else
          {
            throw new FacebookException("Nested arrays are not supported.");
          }
        }
      }
      else
      {
        localBundle.putString(str, localObject1.toString());
      }
    }
    return localBundle;
  }
  
  public Bundle getArgumentBundle()
  {
    return argumentBundle;
  }
  
  public String getRef()
  {
    return mRef;
  }
  
  public Bundle getRefererData()
  {
    Bundle localBundle = argumentBundle;
    if (localBundle != null) {
      return localBundle.getBundle("referer_data");
    }
    return null;
  }
  
  public Uri getTargetUri()
  {
    return targetUri;
  }
  
  public static abstract interface CompletionHandler
  {
    public abstract void onDeferredAppLinkDataFetched(AppLinkData paramAppLinkData);
  }
}
