package views;

import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ByteVector
{
  public static final String KEY_APP_NAME = "app_name";
  public static final String KEY_PACKAGE = "package";
  public static final String USER_AGENT = "user_agent";
  public static final String VERSION = "1.0";
  public static final String a = "version";
  public static final String b = "referer_app_link";
  public static Context c;
  public final Bundle data;
  public final Bundle n;
  public final Project size;
  
  public ByteVector(Project paramProject, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramProject != null)
    {
      Bundle localBundle = paramBundle1;
      if (paramBundle1 == null) {
        localBundle = new Bundle();
      }
      paramBundle1 = paramBundle2;
      if (paramBundle2 == null) {
        paramBundle1 = new Bundle();
      }
      size = paramProject;
      data = localBundle;
      n = paramBundle1;
      return;
    }
    throw new IllegalArgumentException("appLink must not be null.");
  }
  
  private Object add(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle)) {
      return add((Bundle)paramObject);
    }
    if ((paramObject instanceof CharSequence)) {
      return paramObject.toString();
    }
    JSONArray localJSONArray;
    if ((paramObject instanceof List))
    {
      localJSONArray = new JSONArray();
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        localJSONArray.put(add(paramObject.next()));
      }
      return localJSONArray;
    }
    boolean bool = paramObject instanceof SparseArray;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    if (bool)
    {
      localJSONArray = new JSONArray();
      paramObject = (SparseArray)paramObject;
      i = i6;
      while (i < paramObject.size())
      {
        localJSONArray.put(paramObject.keyAt(i), add(paramObject.valueAt(i)));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof Character)) {
      return paramObject.toString();
    }
    if ((paramObject instanceof Boolean)) {
      return paramObject;
    }
    if ((paramObject instanceof Number))
    {
      if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float))) {
        return Long.valueOf(((Number)paramObject).longValue());
      }
      return Double.valueOf(((Number)paramObject).doubleValue());
    }
    if ((paramObject instanceof boolean[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (boolean[])paramObject;
      j = paramObject.length;
      while (i < j)
      {
        localJSONArray.put(add(Boolean.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof char[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (char[])paramObject;
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        localJSONArray.put(add(Character.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof CharSequence[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (CharSequence[])paramObject;
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        localJSONArray.put(add(paramObject[i]));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof double[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (double[])paramObject;
      j = paramObject.length;
      i = m;
      while (i < j)
      {
        localJSONArray.put(add(Double.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof float[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (float[])paramObject;
      j = paramObject.length;
      i = i1;
      while (i < j)
      {
        localJSONArray.put(add(Float.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof int[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (int[])paramObject;
      j = paramObject.length;
      i = i2;
      while (i < j)
      {
        localJSONArray.put(add(Integer.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof long[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (long[])paramObject;
      j = paramObject.length;
      i = i3;
      while (i < j)
      {
        localJSONArray.put(add(Long.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof short[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (short[])paramObject;
      j = paramObject.length;
      i = i4;
      while (i < j)
      {
        localJSONArray.put(add(Short.valueOf(paramObject[i])));
        i += 1;
      }
      return localJSONArray;
    }
    if ((paramObject instanceof String[]))
    {
      localJSONArray = new JSONArray();
      paramObject = (String[])paramObject;
      j = paramObject.length;
      i = i5;
    }
    for (;;)
    {
      Object localObject;
      if (i < j) {
        localObject = paramObject[i];
      }
      try
      {
        localObject = add(localObject);
        localJSONArray.put(localObject);
        i += 1;
      }
      catch (Throwable paramObject)
      {
        throw paramObject;
      }
    }
    return localJSONArray;
    return null;
  }
  
  private JSONObject add(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, add(paramBundle.get(str)));
    }
    return localJSONObject;
  }
  
  public static Task add(android.content.Context paramContext, String paramString)
  {
    return get(paramContext, paramString, get(paramContext));
  }
  
  public static Context b()
  {
    return c;
  }
  
  public static void b(Context paramContext)
  {
    c = paramContext;
  }
  
  public static Task create(android.content.Context paramContext, Uri paramUri, Context paramContext1)
  {
    return paramContext1.getAppLinkFromUrlInBackground(paramUri).onSuccess(new Task.1(paramContext), Task.UI_THREAD_EXECUTOR);
  }
  
  public static Context get(android.content.Context paramContext)
  {
    Context localContext = c;
    if (localContext != null) {
      return localContext;
    }
    return new Task.3(paramContext);
  }
  
  public static Task get(android.content.Context paramContext, Uri paramUri)
  {
    return create(paramContext, paramUri, get(paramContext));
  }
  
  public static Task get(android.content.Context paramContext, String paramString, Context paramContext1)
  {
    return create(paramContext, Uri.parse(paramString), paramContext1);
  }
  
  private Bundle init(android.content.Context paramContext)
  {
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    if (paramContext != null)
    {
      Object localObject = paramContext.getPackageName();
      if (localObject != null) {
        localBundle2.putString("package", (String)localObject);
      }
      localObject = paramContext.getApplicationInfo();
      if (localObject != null)
      {
        paramContext = paramContext.getString(labelRes);
        if (paramContext != null) {
          localBundle2.putString("app_name", paramContext);
        }
      }
    }
    localBundle1.putAll(length());
    localBundle1.putString("target_url", read().getSourceUrl().toString());
    localBundle1.putString("version", "1.0");
    localBundle1.putString("user_agent", "Bolts Android 1.2.0");
    localBundle1.putBundle("referer_app_link", localBundle2);
    localBundle1.putBundle("extras", get());
    return localBundle1;
  }
  
  public static Handle navigate(android.content.Context paramContext, Project paramProject)
  {
    return new ByteVector(paramProject, null, null).navigate(paramContext);
  }
  
  public static Task read(android.content.Context paramContext, URL paramURL)
  {
    Context localContext = get(paramContext);
    return create(paramContext, Uri.parse(paramURL.toString()), localContext);
  }
  
  public static Task read(android.content.Context paramContext, URL paramURL, Context paramContext1)
  {
    return create(paramContext, Uri.parse(paramURL.toString()), paramContext1);
  }
  
  private void sendMessage(android.content.Context paramContext, Intent paramIntent, Handle paramHandle, JSONException paramJSONException)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONException != null) {
      localHashMap.put("error", paramJSONException.getLocalizedMessage());
    }
    if (paramHandle.equals()) {
      paramJSONException = "1";
    } else {
      paramJSONException = "0";
    }
    localHashMap.put("success", paramJSONException);
    localHashMap.put("type", paramHandle.getName());
    LocalBroadcastManager.sendMessage(paramContext, "al_nav_out", paramIntent, localHashMap);
  }
  
  public Bundle get()
  {
    return data;
  }
  
  public Bundle length()
  {
    return n;
  }
  
  public Handle navigate(android.content.Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    Bundle localBundle = init(paramContext);
    Object localObject2 = read().getTargets().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Model localModel = (Model)((Iterator)localObject2).next();
      localIntent = new Intent("android.intent.action.VIEW");
      if (localModel.getUrl() != null) {
        localIntent.setData(localModel.getUrl());
      } else {
        localIntent.setData(size.getSourceUrl());
      }
      localIntent.setPackage(localModel.getPackageName());
      if (localModel.getClassName() != null) {
        localIntent.setClassName(localModel.getPackageName(), localModel.getClassName());
      }
      localIntent.putExtra("al_applink_data", localBundle);
      if (((PackageManager)localObject1).resolveActivity(localIntent, 65536) != null) {
        break label151;
      }
    }
    Intent localIntent = null;
    label151:
    localObject1 = Handle.FAILED;
    if (localIntent != null)
    {
      localObject1 = Handle.APP;
    }
    else
    {
      localObject2 = read().getWebUrl();
      if (localObject2 != null) {
        try
        {
          localObject1 = add(localBundle);
          localIntent = new Intent("android.intent.action.VIEW", ((Uri)localObject2).buildUpon().appendQueryParameter("al_applink_data", ((JSONObject)localObject1).toString()).build());
          localObject1 = Handle.WEB;
        }
        catch (JSONException localJSONException)
        {
          sendMessage(paramContext, localIntent, Handle.FAILED, localJSONException);
          throw new RuntimeException(localJSONException);
        }
      } else {
        localIntent = null;
      }
    }
    sendMessage(paramContext, localIntent, localJSONException, null);
    if (localIntent != null) {
      paramContext.startActivity(localIntent);
    }
    return localJSONException;
  }
  
  public Project read()
  {
    return size;
  }
}
