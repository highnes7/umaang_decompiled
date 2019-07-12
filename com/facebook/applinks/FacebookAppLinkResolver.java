package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import d.d;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import views.Context;
import views.Model;
import views.Project;
import views.Task;
import views.Task.TaskCompletionSource;

public class FacebookAppLinkResolver
  implements Context
{
  public static final String APP_LINK_ANDROID_TARGET_KEY = "android";
  public static final String APP_LINK_KEY = "app_links";
  public static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
  public static final String APP_LINK_TARGET_CLASS_KEY = "class";
  public static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
  public static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
  public static final String APP_LINK_TARGET_URL_KEY = "url";
  public static final String APP_LINK_WEB_TARGET_KEY = "web";
  public final HashMap<Uri, d> cachedAppLinks = new HashMap();
  
  public FacebookAppLinkResolver() {}
  
  public static Model getAndroidTargetFromJson(JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str1 = tryGetStringFromJson(paramJSONObject, "package", null);
    if (str1 == null) {
      return null;
    }
    String str2 = tryGetStringFromJson(paramJSONObject, "class", null);
    String str3 = tryGetStringFromJson(paramJSONObject, "app_name", null);
    String str4 = tryGetStringFromJson(paramJSONObject, "url", null);
    paramJSONObject = localObject;
    if (str4 != null) {
      paramJSONObject = Uri.parse(str4);
    }
    return new Model(str1, str2, paramJSONObject, str3);
  }
  
  public static Uri getWebFallbackUriFromJson(Uri paramUri, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("web");
      boolean bool = tryGetBooleanFromJson(paramJSONObject, "should_fallback", true);
      if (!bool) {
        return null;
      }
      paramJSONObject = tryGetStringFromJson(paramJSONObject, "url", null);
      if (paramJSONObject != null) {
        paramJSONObject = Uri.parse(paramJSONObject);
      } else {
        paramJSONObject = null;
      }
      if (paramJSONObject != null) {
        return paramJSONObject;
      }
    }
    catch (JSONException paramJSONObject) {}
    return paramUri;
  }
  
  public static boolean tryGetBooleanFromJson(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramJSONObject) {}
    return paramBoolean;
  }
  
  public static String tryGetStringFromJson(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString1);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject) {}
    return paramString2;
  }
  
  public Task getAppLinkFromUrlInBackground(final Uri paramUri)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramUri);
    getAppLinkFromUrlsInBackground(localArrayList).onSuccess(new views.Continuation()
    {
      public Project then(Task paramAnonymousTask)
        throws Exception
      {
        return (Project)((Map)paramAnonymousTask.getResult()).get(paramUri);
      }
    });
  }
  
  public Task getAppLinkFromUrlsInBackground(final List paramList)
  {
    HashMap localHashMap = new HashMap();
    final HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Uri localUri = (Uri)((Iterator)localObject).next();
      paramList = cachedAppLinks;
      try
      {
        Project localProject = (Project)cachedAppLinks.get(localUri);
        if (localProject != null)
        {
          localHashMap.put(localUri, localProject);
        }
        else
        {
          if (!localHashSet.isEmpty()) {
            localStringBuilder.append(',');
          }
          localStringBuilder.append(localUri.toString());
          localHashSet.add(localUri);
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    if (localHashSet.isEmpty()) {
      return Task.call(localThrowable);
    }
    paramList = Task.create();
    localObject = new Bundle();
    ((Bundle)localObject).putString("ids", localStringBuilder.toString());
    ((Bundle)localObject).putString("fields", String.format("%s.fields(%s,%s)", new Object[] { "app_links", "android", "web" }));
    new GraphRequest(AccessToken.getCurrentAccessToken(), "", (Bundle)localObject, null, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject1 = paramAnonymousGraphResponse.getError();
        if (localObject1 != null)
        {
          paramList.setError(((FacebookRequestError)localObject1).getException());
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null)
        {
          paramList.setResult(localThrowable);
          return;
        }
        localObject1 = localHashSet.iterator();
        for (;;)
        {
          Uri localUri;
          if (((Iterator)localObject1).hasNext())
          {
            localUri = (Uri)((Iterator)localObject1).next();
            if (!paramAnonymousGraphResponse.has(localUri.toString())) {
              continue;
            }
          }
          try
          {
            localObject3 = paramAnonymousGraphResponse.getJSONObject(localUri.toString()).getJSONObject("app_links");
            JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("android");
            int j = localJSONArray.length();
            localObject2 = new ArrayList(j);
            int i = 0;
            while (i < j)
            {
              Model localModel = FacebookAppLinkResolver.getAndroidTargetFromJson(localJSONArray.getJSONObject(i));
              if (localModel != null) {
                ((List)localObject2).add(localModel);
              }
              i += 1;
            }
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              Object localObject3;
              Object localObject2;
            }
          }
          localObject3 = FacebookAppLinkResolver.getWebFallbackUriFromJson(localUri, (JSONObject)localObject3);
          localObject2 = new Project(localUri, (List)localObject2, (Uri)localObject3);
          localObject3 = localThrowable;
          ((Map)localObject3).put(localUri, localObject2);
          localObject3 = FacebookAppLinkResolver.this;
          localObject3 = FacebookAppLinkResolver.access$200((FacebookAppLinkResolver)localObject3);
          try
          {
            FacebookAppLinkResolver.access$200(FacebookAppLinkResolver.this).put(localUri, localObject2);
          }
          catch (Throwable localThrowable) {}
        }
        try
        {
          throw localThrowable;
        }
        catch (JSONException localJSONException2) {}
        paramList.setResult(localThrowable);
      }
    }).executeAsync();
    return paramList.getTask();
  }
}
