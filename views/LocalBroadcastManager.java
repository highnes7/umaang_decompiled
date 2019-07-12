package views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import d.p;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalBroadcastManager
{
  public static final String ACTION_SHOW_PLAYER = "al_nav_in";
  public static final String EVENTLOG_URL = "event_args";
  public static final String MODULE_PACKAGE = "al_nav_out";
  public static final String PAGE_KEY = "event_name";
  public static final String TAG = "com.parse.bolts.measurement_event";
  public Context appContext;
  public Bundle args;
  public String name;
  
  public LocalBroadcastManager(Context paramContext, String paramString, Bundle paramBundle)
  {
    appContext = paramContext.getApplicationContext();
    name = paramString;
    args = paramBundle;
  }
  
  public static String get(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((!(paramObject instanceof JSONArray)) && (!(paramObject instanceof JSONObject))) {
      if ((paramObject instanceof Collection)) {
        paramObject = (Collection)paramObject;
      }
    }
    try
    {
      paramObject = new JSONArray(paramObject).toString();
      return paramObject;
    }
    catch (Exception paramObject) {}
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      paramObject = new JSONObject(paramObject).toString();
      return paramObject;
    }
    paramObject = paramObject.toString();
    return paramObject;
    return paramObject.toString();
    return null;
  }
  
  public static Bundle parse(Context paramContext, String paramString, Bundle paramBundle, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    paramContext = paramIntent.resolveActivity(paramContext.getPackageManager());
    if (paramContext != null) {
      localBundle.putString("class", paramContext.getShortClassName());
    }
    if ("al_nav_out".equals(paramString))
    {
      if (paramContext != null) {
        localBundle.putString("package", paramContext.getPackageName());
      }
      if (paramIntent.getData() != null) {
        localBundle.putString("outputURL", paramIntent.getData().toString());
      }
      if (paramIntent.getScheme() != null) {
        localBundle.putString("outputURLScheme", paramIntent.getScheme());
      }
    }
    else if ("al_nav_in".equals(paramString))
    {
      if (paramIntent.getData() != null) {
        localBundle.putString("inputURL", paramIntent.getData().toString());
      }
      if (paramIntent.getScheme() != null) {
        localBundle.putString("inputURLScheme", paramIntent.getScheme());
      }
    }
    paramContext = paramBundle.keySet().iterator();
    while (paramContext.hasNext())
    {
      paramString = (String)paramContext.next();
      paramIntent = paramBundle.get(paramString);
      if ((paramIntent instanceof Bundle))
      {
        paramIntent = (Bundle)paramIntent;
        Iterator localIterator = paramIntent.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = get(paramIntent.get(str1));
          if (paramString.equals("referer_app_link"))
          {
            if (str1.equalsIgnoreCase("url"))
            {
              localBundle.putString("refererURL", str2);
              continue;
            }
            if (str1.equalsIgnoreCase("app_name"))
            {
              localBundle.putString("refererAppName", str2);
              continue;
            }
            if (str1.equalsIgnoreCase("package"))
            {
              localBundle.putString("sourceApplication", str2);
              continue;
            }
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("/");
          localStringBuilder.append(str1);
          localBundle.putString(localStringBuilder.toString(), str2);
        }
      }
      else
      {
        paramIntent = get(paramIntent);
        if (paramString.equals("target_url"))
        {
          paramString = Uri.parse(paramIntent);
          localBundle.putString("targetURL", paramString.toString());
          localBundle.putString("targetURLHost", paramString.getHost());
        }
        else
        {
          localBundle.putString(paramString, paramIntent);
        }
      }
    }
    return localBundle;
  }
  
  private void sendBroadcast()
  {
    if (name == null) {
      p.class.getName();
    }
    try
    {
      Object localObject1 = Class.forName("b.b.x.b.h");
      Object localObject2 = ((Class)localObject1).getMethod("getInstance", new Class[] { Context.class });
      localObject1 = ((Class)localObject1).getMethod("sendBroadcast", new Class[] { Intent.class });
      Object localObject3 = appContext;
      localObject2 = ((Method)localObject2).invoke(null, new Object[] { localObject3 });
      localObject3 = new Intent("com.parse.bolts.measurement_event");
      Object localObject4 = name;
      ((Intent)localObject3).putExtra("event_name", (String)localObject4);
      localObject4 = args;
      ((Intent)localObject3).putExtra("event_args", (Bundle)localObject4);
      ((Method)localObject1).invoke(localObject2, new Object[] { localObject3 });
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    p.class.getName();
  }
  
  public static void sendMessage(Context paramContext, String paramString, Intent paramIntent, Map paramMap)
  {
    Object localObject2 = new Bundle();
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = CordovaWebView.setup(paramIntent);
      if (localObject1 != null)
      {
        localObject1 = parse(paramContext, paramString, (Bundle)localObject1, paramIntent);
      }
      else
      {
        localObject1 = paramIntent.getData();
        if (localObject1 != null) {
          ((Bundle)localObject2).putString("intentData", ((Uri)localObject1).toString());
        }
        paramIntent = paramIntent.getExtras();
        localObject1 = localObject2;
        if (paramIntent != null)
        {
          Iterator localIterator = paramIntent.keySet().iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (String)localIterator.next();
            ((Bundle)localObject2).putString((String)localObject1, get(paramIntent.get((String)localObject1)));
          }
        }
      }
    }
    if (paramMap != null)
    {
      paramIntent = paramMap.keySet().iterator();
      while (paramIntent.hasNext())
      {
        localObject2 = (String)paramIntent.next();
        ((Bundle)localObject1).putString((String)localObject2, (String)paramMap.get(localObject2));
      }
    }
    new LocalBroadcastManager(paramContext, paramString, (Bundle)localObject1).sendBroadcast();
  }
}
