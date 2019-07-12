package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility
{
  public static final String APPLICATION_FIELDS = "fields";
  public static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
  public static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
  public static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
  public static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
  public static final String[] APP_SETTING_FIELDS = { "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories" };
  public static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
  public static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
  public static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
  public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
  public static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
  public static final String DIALOG_CONFIG_NAME_KEY = "name";
  public static final String DIALOG_CONFIG_URL_KEY = "url";
  public static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
  public static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
  public static final int GINGERBREAD_MR1 = 10;
  public static final String HASH_ALGORITHM_MD5 = "MD5";
  public static final String HASH_ALGORITHM_SHA1 = "SHA-1";
  public static final String LOG_TAG = "FacebookSDK";
  public static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
  public static final String URL_SCHEME = "https";
  public static final String UTF8 = "UTF-8";
  public static long availableExternalStorageGB = 0L;
  public static String carrierName = "NoCarrier";
  public static String deviceTimezone;
  public static Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
  public static AtomicBoolean loadingSettings = new AtomicBoolean(false);
  public static final String noCarrierConstant = "NoCarrier";
  public static int numCPUCores = 0;
  public static long timestampOfLastCheck = -1L;
  public static long totalExternalStorageGB = -1L;
  
  static
  {
    availableExternalStorageGB = -1L;
    deviceTimezone = "";
  }
  
  public Utility() {}
  
  public static boolean areObjectsEqual(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static ArrayList arrayList(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static List asListNoNulls(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static JSONObject awaitGetGraphMeRequestWithCache(String paramString)
  {
    JSONObject localJSONObject = ProfileInformationCache.getProfileInformation(paramString);
    if (localJSONObject != null) {
      return localJSONObject;
    }
    paramString = getGraphMeRequestWithCache(paramString).executeAndWait();
    if (paramString.getError() != null) {
      return null;
    }
    return paramString.getJSONObject();
  }
  
  public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    if (paramBundle != null)
    {
      paramString1 = paramBundle.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        Object localObject = paramBundle.get(paramString2);
        if ((localObject instanceof String)) {
          localBuilder.appendQueryParameter(paramString2, (String)localObject);
        }
      }
    }
    return localBuilder.build();
  }
  
  public static void clearCaches(Context paramContext)
  {
    ImageDownloader.clearCache(paramContext);
  }
  
  public static void clearCookiesForDomain(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext).sync();
    paramContext = CookieManager.getInstance();
    Object localObject = paramContext.getCookie(paramString);
    if (localObject == null) {
      return;
    }
    localObject = ((String)localObject).split(";");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = localObject[i].split("=");
      if (arrayOfString.length > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[0].trim());
        localStringBuilder.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
        paramContext.setCookie(paramString, localStringBuilder.toString());
      }
      i += 1;
    }
    paramContext.removeExpiredCookie();
  }
  
  public static void clearFacebookCookies(Context paramContext)
  {
    clearCookiesForDomain(paramContext, "facebook.com");
    clearCookiesForDomain(paramContext, ".facebook.com");
    clearCookiesForDomain(paramContext, "https://facebook.com");
    clearCookiesForDomain(paramContext, "https://.facebook.com");
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    }
  }
  
  public static String coerceValueIfNullOrEmpty(String paramString1, String paramString2)
  {
    if (isNullOrEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static long convertBytesToGB(double paramDouble)
  {
    return Math.round(paramDouble / 1.073741824E9D);
  }
  
  public static Map convertJSONObjectToHashMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray = paramJSONObject.names();
    int i = 0;
    while (i < localJSONArray.length())
    {
      try
      {
        String str = localJSONArray.getString(i);
        Object localObject2 = paramJSONObject.get(str);
        Object localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject))
        {
          localObject1 = (JSONObject)localObject2;
          localObject1 = convertJSONObjectToHashMap((JSONObject)localObject1);
        }
        localHashMap.put(str, localObject1);
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static int copyAndCloseInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    int i;
    try
    {
      Object localObject = new BufferedInputStream(paramInputStream);
      try
      {
        byte[] arrayOfByte = new byte['?'];
        i = 0;
        for (;;)
        {
          int j = ((BufferedInputStream)localObject).read(arrayOfByte);
          if (j == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, j);
          i += j;
        }
        ((BufferedInputStream)localObject).close();
        if (paramInputStream == null) {
          return i;
        }
        paramInputStream.close();
        return i;
      }
      catch (Throwable localThrowable2)
      {
        paramOutputStream = (OutputStream)localObject;
        localObject = localThrowable2;
      }
      if (paramOutputStream == null) {
        break label86;
      }
    }
    catch (Throwable localThrowable1)
    {
      paramOutputStream = null;
    }
    paramOutputStream.close();
    label86:
    if (paramInputStream != null) {
      paramInputStream.close();
    }
    throw localThrowable1;
    return i;
  }
  
  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        deleteDirectory(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public static void disconnectQuietly(URLConnection paramURLConnection)
  {
    if ((paramURLConnection instanceof HttpURLConnection)) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
  }
  
  public static boolean externalStorageExists()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static List filter(List paramList, Mapper paramMapper)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramMapper.apply(paramList.next());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return localArrayList;
  }
  
  public static List filter(List paramList, Predicate paramPredicate)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (paramPredicate.apply(localObject)) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return localArrayList;
  }
  
  public static String getActivityName(Context paramContext)
  {
    if (paramContext == null) {
      return "null";
    }
    if (paramContext == paramContext.getApplicationContext()) {
      return "unknown";
    }
    return paramContext.getClass().getSimpleName();
  }
  
  public static JSONObject getAppSettingsQueryResponse(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
    paramString = GraphRequest.newGraphPathRequest(null, paramString, null);
    paramString.setSkipClientToken(true);
    paramString.setParameters(localBundle);
    return paramString.executeAndWait().getJSONObject();
  }
  
  public static FetchedAppSettings getAppSettingsWithoutQuery(String paramString)
  {
    if (paramString != null) {
      return (FetchedAppSettings)fetchedAppSettings.get(paramString);
    }
    return null;
  }
  
  public static Date getBundleLongAsDate(Bundle paramBundle, String paramString, Date paramDate)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle = paramBundle.get(paramString);
    long l;
    if ((paramBundle instanceof Long))
    {
      l = ((Long)paramBundle).longValue();
    }
    else
    {
      if (!(paramBundle instanceof String)) {
        break label83;
      }
      paramBundle = (String)paramBundle;
    }
    try
    {
      l = Long.parseLong(paramBundle);
      if (l == 0L) {
        return new Date(Long.MAX_VALUE);
      }
      return new Date(l * 1000L + paramDate.getTime());
    }
    catch (NumberFormatException paramBundle) {}
    label83:
    return null;
  }
  
  public static long getContentSize(Uri paramUri)
  {
    Uri localUri = null;
    try
    {
      Cursor localCursor = FacebookSdk.getApplicationContext().getContentResolver().query(paramUri, null, null, null, null);
      paramUri = localCursor;
      localUri = paramUri;
      int i = localCursor.getColumnIndex("_size");
      localUri = paramUri;
      localCursor.moveToFirst();
      localUri = paramUri;
      long l = localCursor.getLong(i);
      localCursor.close();
      return l;
    }
    catch (Throwable paramUri)
    {
      if (localUri != null) {
        localUri.close();
      }
      throw paramUri;
    }
  }
  
  public static DialogFeatureConfig getDialogFeatureConfig(String paramString1, String paramString2, String paramString3)
  {
    if (!isNullOrEmpty(paramString2))
    {
      if (isNullOrEmpty(paramString3)) {
        return null;
      }
      paramString1 = (FetchedAppSettings)fetchedAppSettings.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (Map)paramString1.getDialogConfigurations().get(paramString2);
        if (paramString1 != null) {
          return (DialogFeatureConfig)paramString1.get(paramString3);
        }
      }
    }
    return null;
  }
  
  public static GraphRequest getGraphMeRequestWithCache(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
    localBundle.putString("access_token", paramString);
    return new GraphRequest(null, "me", localBundle, HttpMethod.HEAD, null);
  }
  
  public static void getGraphMeRequestWithCacheAsync(final String paramString, GraphMeRequestWithCacheCallback paramGraphMeRequestWithCacheCallback)
  {
    JSONObject localJSONObject = ProfileInformationCache.getProfileInformation(paramString);
    if (localJSONObject != null)
    {
      paramGraphMeRequestWithCacheCallback.onSuccess(localJSONObject);
      return;
    }
    paramGraphMeRequestWithCacheCallback = new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (paramAnonymousGraphResponse.getError() != null)
        {
          val$callback.onFailure(paramAnonymousGraphResponse.getError().getException());
          return;
        }
        String str = paramString;
        JSONObject localJSONObject = paramAnonymousGraphResponse.getJSONObject();
        ProfileInformationCache.infoCache.put(str, localJSONObject);
        val$callback.onSuccess(paramAnonymousGraphResponse.getJSONObject());
      }
    };
    paramString = getGraphMeRequestWithCache(paramString);
    paramString.setCallback(paramGraphMeRequestWithCacheCallback);
    paramString.executeAsync();
  }
  
  public static String getMetadataApplicationId(Context paramContext)
  {
    Validate.notNull(paramContext, "context");
    FacebookSdk.sdkInitialize(paramContext);
    return FacebookSdk.getApplicationId();
  }
  
  public static Method getMethodQuietly(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramVarArgs);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method getMethodQuietly(String paramString1, String paramString2, Class... paramVarArgs)
  {
    try
    {
      paramString1 = getMethodQuietly(Class.forName(paramString1), paramString2, paramVarArgs);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws JSONException
  {
    Object localObject = paramJSONObject.opt(paramString1);
    paramString1 = localObject;
    paramJSONObject = paramString1;
    if (localObject != null)
    {
      paramJSONObject = paramString1;
      if ((localObject instanceof String)) {
        paramJSONObject = new JSONTokener((String)localObject).nextValue();
      }
    }
    if ((paramJSONObject != null) && (!(paramJSONObject instanceof JSONObject)) && (!(paramJSONObject instanceof JSONArray)))
    {
      if (paramString2 != null)
      {
        paramString1 = new JSONObject();
        paramString1.putOpt(paramString2, paramJSONObject);
        return paramString1;
      }
      throw new FacebookException("Got an unexpected non-JSON object.");
    }
    return paramJSONObject;
  }
  
  public static String getUriString(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    return paramUri.toString();
  }
  
  public static boolean hasSameId(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 != null) && (paramJSONObject2 != null) && (paramJSONObject1.has("id")))
    {
      if (!paramJSONObject2.has("id")) {
        return false;
      }
      if (paramJSONObject1.equals(paramJSONObject2)) {
        return true;
      }
      paramJSONObject1 = paramJSONObject1.optString("id");
      paramJSONObject2 = paramJSONObject2.optString("id");
      if (paramJSONObject1 != null)
      {
        if (paramJSONObject2 == null) {
          return false;
        }
        return paramJSONObject1.equals(paramJSONObject2);
      }
    }
    return false;
  }
  
  public static String hashBytes(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    paramMessageDigest.update(paramArrayOfByte);
    paramMessageDigest = paramMessageDigest.digest();
    paramArrayOfByte = new StringBuilder();
    int j = paramMessageDigest.length;
    int i = 0;
    while (i < j)
    {
      int k = paramMessageDigest[i];
      paramArrayOfByte.append(Integer.toHexString(k >> 4 & 0xF));
      paramArrayOfByte.append(Integer.toHexString(k >> 0 & 0xF));
      i += 1;
    }
    return paramArrayOfByte.toString();
  }
  
  public static HashSet hashSet(Object... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramVarArgs[i]);
      i += 1;
    }
    return localHashSet;
  }
  
  public static String hashWithAlgorithm(String paramString1, String paramString2)
  {
    return hashWithAlgorithm(paramString1, paramString2.getBytes());
  }
  
  public static String hashWithAlgorithm(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      return hashBytes(paramString, paramArrayOfByte);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static int[] intersectRanges(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == null) {
      return paramArrayOfInt2;
    }
    if (paramArrayOfInt2 == null) {
      return paramArrayOfInt1;
    }
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
    int m = 0;
    int n = 0;
    int k = 0;
    for (;;)
    {
      i = k;
      if (m >= paramArrayOfInt1.length) {
        break label287;
      }
      i = k;
      if (n >= paramArrayOfInt2.length) {
        break label287;
      }
      int j = paramArrayOfInt1[m];
      int i2 = paramArrayOfInt2[n];
      if (m < paramArrayOfInt1.length - 1) {
        i1 = paramArrayOfInt1[(m + 1)];
      } else {
        i1 = Integer.MAX_VALUE;
      }
      if (n < paramArrayOfInt2.length - 1) {
        i = paramArrayOfInt2[(n + 1)];
      } else {
        i = Integer.MAX_VALUE;
      }
      if (j < i2)
      {
        if (i1 > i2)
        {
          if (i1 > i)
          {
            n += 2;
            j = i2;
            i2 = n;
          }
          else
          {
            i = m + 2;
            j = i2;
            i2 = n;
            break label227;
          }
        }
        else
        {
          i = m + 2;
          break label214;
        }
      }
      else
      {
        if (i <= j) {
          break label205;
        }
        if (i > i1)
        {
          i = m + 2;
          i2 = n;
          break label227;
        }
        i2 = n + 2;
      }
      int i1 = i;
      i = m;
      break label227;
      label205:
      n += 2;
      i = m;
      label214:
      j = Integer.MIN_VALUE;
      i1 = Integer.MAX_VALUE;
      i2 = n;
      label227:
      m = i;
      n = i2;
      if (j != Integer.MIN_VALUE)
      {
        m = k + 1;
        arrayOfInt[k] = j;
        if (i1 == Integer.MAX_VALUE) {
          break;
        }
        k = m + 1;
        arrayOfInt[m] = i1;
        m = i;
        n = i2;
      }
    }
    int i = m;
    label287:
    return Arrays.copyOf(arrayOfInt, i);
  }
  
  public static Object invokeMethodQuietly(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      return null;
    }
    catch (InvocationTargetException paramObject) {}
    return null;
  }
  
  public static boolean isContentUri(Uri paramUri)
  {
    return (paramUri != null) && ("content".equalsIgnoreCase(paramUri.getScheme()));
  }
  
  public static boolean isCurrentAccessToken(AccessToken paramAccessToken)
  {
    if (paramAccessToken != null) {
      return paramAccessToken.equals(AccessToken.getCurrentAccessToken());
    }
    return false;
  }
  
  public static boolean isFileUri(Uri paramUri)
  {
    return (paramUri != null) && ("file".equalsIgnoreCase(paramUri.getScheme()));
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNullOrEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }
  
  public static boolean isSubset(Collection paramCollection1, Collection paramCollection2)
  {
    if ((paramCollection2 != null) && (paramCollection2.size() != 0))
    {
      paramCollection2 = new HashSet(paramCollection2);
      paramCollection1 = paramCollection1.iterator();
      while (paramCollection1.hasNext()) {
        if (!paramCollection2.contains(paramCollection1.next())) {
          return false;
        }
      }
      return true;
    }
    return (paramCollection1 == null) || (paramCollection1.size() == 0);
  }
  
  public static boolean isWebUri(Uri paramUri)
  {
    return (paramUri != null) && (("http".equalsIgnoreCase(paramUri.getScheme())) || ("https".equalsIgnoreCase(paramUri.getScheme())));
  }
  
  public static Set jsonArrayToSet(JSONArray paramJSONArray)
    throws JSONException
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localHashSet.add(paramJSONArray.getString(i));
      i += 1;
    }
    return localHashSet;
  }
  
  public static List jsonArrayToStringList(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.getString(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void loadAppSettingsAsync(Context paramContext, final String paramString)
  {
    boolean bool = loadingSettings.compareAndSet(false, true);
    if ((!isNullOrEmpty(paramString)) && (!fetchedAppSettings.containsKey(paramString)))
    {
      if (!bool) {
        return;
      }
      final String str = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[] { paramString });
      FacebookSdk.getExecutor().execute(new Runnable()
      {
        public void run()
        {
          SharedPreferences localSharedPreferences = val$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
          Object localObject2 = str;
          Object localObject1 = null;
          localObject2 = localSharedPreferences.getString((String)localObject2, null);
          if (!Utility.isNullOrEmpty((String)localObject2))
          {
            try
            {
              localObject2 = new JSONObject((String)localObject2);
              localObject1 = localObject2;
            }
            catch (JSONException localJSONException)
            {
              Utility.logd("FacebookSDK", localJSONException);
            }
            if (localObject1 != null) {
              Utility.parseAppSettingsFromJSON(paramString, (JSONObject)localObject1);
            }
          }
          localObject1 = Utility.getAppSettingsQueryResponse(paramString);
          if (localObject1 != null)
          {
            Utility.parseAppSettingsFromJSON(paramString, (JSONObject)localObject1);
            localSharedPreferences.edit().putString(str, ((JSONObject)localObject1).toString()).apply();
          }
          Utility.loadingSettings.set(false);
        }
      });
    }
  }
  
  public static void logd(String paramString, Exception paramException)
  {
    if ((FacebookSdk.isDebugEnabled) && (paramString != null) && (paramException != null))
    {
      paramString = new StringBuilder();
      paramString.append(paramException.getClass().getSimpleName());
      paramString.append(": ");
      paramString.append(paramException.getMessage());
      paramString.toString();
    }
  }
  
  public static void logd(String paramString1, String paramString2)
  {
    boolean bool = FacebookSdk.isDebugEnabled;
  }
  
  public static void logd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (FacebookSdk.isDebugEnabled) {
      isNullOrEmpty(paramString1);
    }
  }
  
  public static String md5hash(String paramString)
  {
    return hashWithAlgorithm("MD5", paramString.getBytes());
  }
  
  public static FetchedAppSettings parseAppSettingsFromJSON(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONArray("android_sdk_error_categories");
    if (localObject == null) {
      localObject = FacebookRequestErrorClassification.getDefaultErrorClassification();
    } else {
      localObject = FacebookRequestErrorClassification.createFromJSON((JSONArray)localObject);
    }
    paramJSONObject = new FetchedAppSettings(paramJSONObject.optBoolean("supports_implicit_sdk_logging", false), paramJSONObject.optString("gdpv4_nux_content", ""), paramJSONObject.optBoolean("gdpv4_nux_enabled", false), parseDialogConfigurations(paramJSONObject.optJSONObject("android_dialog_configs")), (FacebookRequestErrorClassification)localObject, null);
    fetchedAppSettings.put(paramString, paramJSONObject);
    return paramJSONObject;
  }
  
  public static Map parseDialogConfigurations(JSONObject paramJSONObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a9 = a8\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static Bundle parseUrlQueryString(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!isNullOrEmpty(paramString))
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i].split("=");
        String str;
        if (localObject.length == 2) {
          str = localObject[0];
        }
        try
        {
          str = URLDecoder.decode(str, "UTF-8");
          localObject = localObject[1];
          localBundle.putString(str, URLDecoder.decode((String)localObject, "UTF-8"));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          logd("FacebookSDK", (Exception)localUnsupportedEncodingException);
        }
        if (localObject.length == 1)
        {
          localObject = localObject[0];
          localBundle.putString(URLDecoder.decode((String)localObject, "UTF-8"), "");
        }
        i += 1;
      }
    }
    return localBundle;
  }
  
  public static void putCommaSeparatedStringList(Bundle paramBundle, String paramString, ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localStringBuilder.append((String)paramArrayList.next());
        localStringBuilder.append(",");
      }
      if (localStringBuilder.length() > 0) {
        paramArrayList = localStringBuilder.substring(0, localStringBuilder.length() - 1);
      } else {
        paramArrayList = "";
      }
      paramBundle.putString(paramString, paramArrayList);
    }
  }
  
  public static boolean putJSONValueInBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      paramBundle.remove(paramString);
    }
    else if ((paramObject instanceof Boolean))
    {
      paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    else if ((paramObject instanceof boolean[]))
    {
      paramBundle.putBooleanArray(paramString, (boolean[])paramObject);
    }
    else if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
    }
    else if ((paramObject instanceof double[]))
    {
      paramBundle.putDoubleArray(paramString, (double[])paramObject);
    }
    else if ((paramObject instanceof Integer))
    {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    }
    else if ((paramObject instanceof int[]))
    {
      paramBundle.putIntArray(paramString, (int[])paramObject);
    }
    else if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    }
    else if ((paramObject instanceof long[]))
    {
      paramBundle.putLongArray(paramString, (long[])paramObject);
    }
    else if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, (String)paramObject);
    }
    else if ((paramObject instanceof JSONArray))
    {
      paramBundle.putString(paramString, ((JSONArray)paramObject).toString());
    }
    else
    {
      if (!(paramObject instanceof JSONObject)) {
        break label238;
      }
      paramBundle.putString(paramString, ((JSONObject)paramObject).toString());
    }
    return true;
    label238:
    return false;
  }
  
  public static void putNonEmptyString(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (!isNullOrEmpty(paramString2)) {
      paramBundle.putString(paramString1, paramString2);
    }
  }
  
  public static void putUri(Bundle paramBundle, String paramString, Uri paramUri)
  {
    if (paramUri != null) {
      putNonEmptyString(paramBundle, paramString, paramUri.toString());
    }
  }
  
  public static FetchedAppSettings queryAppSettings(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (fetchedAppSettings.containsKey(paramString))) {
      return (FetchedAppSettings)fetchedAppSettings.get(paramString);
    }
    JSONObject localJSONObject = getAppSettingsQueryResponse(paramString);
    if (localJSONObject == null) {
      return null;
    }
    return parseAppSettingsFromJSON(paramString, localJSONObject);
  }
  
  /* Error */
  public static String readStreamToString(InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 380	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 383	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_3
    //   9: new 939	java/io/InputStreamReader
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 940	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: new 288	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   25: astore_2
    //   26: sipush 2048
    //   29: newarray char
    //   31: astore 4
    //   33: aload_0
    //   34: aload 4
    //   36: invokevirtual 943	java/io/InputStreamReader:read	([C)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +15 -> 57
    //   45: aload_2
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 946	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -21 -> 33
    //   57: aload_2
    //   58: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_2
    //   62: aload_3
    //   63: invokeinterface 329 1 0
    //   68: aload_0
    //   69: invokeinterface 329 1 0
    //   74: aload_2
    //   75: areturn
    //   76: astore_2
    //   77: goto +14 -> 91
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_0
    //   83: goto +8 -> 91
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_3
    //   92: ifnull +9 -> 101
    //   95: aload_3
    //   96: invokeinterface 329 1 0
    //   101: aload_0
    //   102: ifnull +9 -> 111
    //   105: aload_0
    //   106: invokeinterface 329 1 0
    //   111: goto +3 -> 114
    //   114: aload_2
    //   115: athrow
    //   116: astore_3
    //   117: goto -49 -> 68
    //   120: astore_0
    //   121: aload_2
    //   122: areturn
    //   123: astore_3
    //   124: goto -23 -> 101
    //   127: astore_0
    //   128: goto -14 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramInputStream	InputStream
    //   39	11	1	i	int
    //   25	50	2	localObject	Object
    //   76	1	2	localThrowable1	Throwable
    //   80	1	2	localThrowable2	Throwable
    //   86	36	2	localThrowable3	Throwable
    //   8	88	3	localBufferedInputStream	BufferedInputStream
    //   116	1	3	localIOException1	IOException
    //   123	1	3	localIOException2	IOException
    //   31	16	4	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   18	33	76	java/lang/Throwable
    //   33	40	76	java/lang/Throwable
    //   45	54	76	java/lang/Throwable
    //   57	62	76	java/lang/Throwable
    //   9	18	80	java/lang/Throwable
    //   0	9	86	java/lang/Throwable
    //   62	68	116	java/io/IOException
    //   68	74	120	java/io/IOException
    //   95	101	123	java/io/IOException
    //   105	111	127	java/io/IOException
  }
  
  public static Map readStringMapFromParcel(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    if (j < 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramParcel.readString(), paramParcel.readString());
      i += 1;
    }
    return localHashMap;
  }
  
  public static void refreshAvailableExternalStorage()
  {
    try
    {
      boolean bool = externalStorageExists();
      if (bool)
      {
        Object localObject = Environment.getExternalStorageDirectory();
        localObject = new StatFs(((File)localObject).getPath());
        int i = ((StatFs)localObject).getAvailableBlocks();
        l = i;
        i = ((StatFs)localObject).getBlockSize();
        availableExternalStorageGB = l * i;
      }
      double d = availableExternalStorageGB;
      long l = convertBytesToGB(d);
      availableExternalStorageGB = l;
      return;
    }
    catch (Exception localException) {}
  }
  
  public static int refreshBestGuessNumberOfCPUCores()
  {
    int i = numCPUCores;
    if (i > 0) {
      return i;
    }
    try
    {
      Object localObject = new File("/sys/devices/system/cpu/");
      localObject = ((File)localObject).listFiles(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return Pattern.matches("cpu[0-9]+", paramAnonymousString);
        }
      });
      numCPUCores = localObject.length;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (numCPUCores <= 0) {
      numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }
    return numCPUCores;
  }
  
  public static void refreshCarrierName(Context paramContext)
  {
    if (carrierName.equals("NoCarrier")) {
      try
      {
        paramContext = paramContext.getSystemService("phone");
        paramContext = (TelephonyManager)paramContext;
        paramContext = paramContext.getNetworkOperatorName();
        carrierName = paramContext;
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static void refreshPeriodicExtendedDeviceInfo(Context paramContext)
  {
    if ((timestampOfLastCheck == -1L) || (System.currentTimeMillis() - timestampOfLastCheck >= 1800000L))
    {
      timestampOfLastCheck = System.currentTimeMillis();
      refreshTimezone();
      refreshCarrierName(paramContext);
      refreshTotalExternalStorage();
      refreshAvailableExternalStorage();
    }
  }
  
  public static void refreshTimezone()
  {
    try
    {
      Object localObject = TimeZone.getDefault();
      localObject = ((TimeZone)localObject).getDisplayName(((TimeZone)localObject).inDaylightTime(new Date()), 0);
      deviceTimezone = (String)localObject;
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void refreshTotalExternalStorage()
  {
    try
    {
      boolean bool = externalStorageExists();
      if (bool)
      {
        Object localObject = Environment.getExternalStorageDirectory();
        localObject = new StatFs(((File)localObject).getPath());
        int i = ((StatFs)localObject).getBlockCount();
        l = i;
        i = ((StatFs)localObject).getBlockSize();
        totalExternalStorageGB = l * i;
      }
      double d = totalExternalStorageGB;
      long l = convertBytesToGB(d);
      totalExternalStorageGB = l;
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String safeGetStringFromResponse(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optString(paramString, "");
    }
    return "";
  }
  
  public static void setAppEventAttributionParameters(JSONObject paramJSONObject, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean)
    throws JSONException
  {
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAttributionId() != null)) {
      paramJSONObject.put("attribution", paramAttributionIdentifiers.getAttributionId());
    }
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidAdvertiserId() != null))
    {
      paramJSONObject.put("advertiser_id", paramAttributionIdentifiers.getAndroidAdvertiserId());
      paramJSONObject.get("advertiser_tracking_enabled", paramAttributionIdentifiers.isTrackingLimited() ^ true);
    }
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidInstallerPackage() != null)) {
      paramJSONObject.put("installer_package", paramAttributionIdentifiers.getAndroidInstallerPackage());
    }
    paramJSONObject.put("anon_id", paramString);
    paramJSONObject.get("application_tracking_enabled", paramBoolean ^ true);
  }
  
  public static void setAppEventExtendedDeviceInfoParameters(JSONObject paramJSONObject, Context paramContext)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("a2");
    refreshPeriodicExtendedDeviceInfo(paramContext);
    Object localObject2 = paramContext.getPackageName();
    int i = -1;
    try
    {
      localObject1 = paramContext.getPackageManager().getPackageInfo((String)localObject2, 0);
      i = versionCode;
      localObject1 = versionName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject1;
      for (;;) {}
    }
    localObject1 = "";
    localJSONArray.put(localObject2);
    localJSONArray.put(i);
    localJSONArray.put(localObject1);
    localJSONArray.put(Build.VERSION.RELEASE);
    localJSONArray.put(Build.MODEL);
    try
    {
      localObject1 = paramContext.getResources().getConfiguration();
      localObject1 = locale;
    }
    catch (Exception localException)
    {
      double d;
      for (;;) {}
    }
    localObject1 = Locale.getDefault();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Locale)localObject1).getLanguage());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(((Locale)localObject1).getCountry());
    localJSONArray.put(((StringBuilder)localObject2).toString());
    localJSONArray.put(deviceTimezone);
    localJSONArray.put(carrierName);
    d = 0.0D;
    try
    {
      paramContext = paramContext.getSystemService("window");
      paramContext = (WindowManager)paramContext;
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        localObject1 = new DisplayMetrics();
        paramContext.getMetrics((DisplayMetrics)localObject1);
        i = widthPixels;
        j = heightPixels;
        d = density;
      }
    }
    catch (Exception paramContext)
    {
      int j;
      for (;;) {}
    }
    i = 0;
    j = 0;
    localJSONArray.put(i);
    localJSONArray.put(j);
    localJSONArray.put(String.format("%.2f", new Object[] { Double.valueOf(d) }));
    localJSONArray.put(refreshBestGuessNumberOfCPUCores());
    localJSONArray.put(totalExternalStorageGB);
    localJSONArray.put(availableExternalStorageGB);
    paramJSONObject.put("extinfo", localJSONArray.toString());
  }
  
  public static String sha1hash(String paramString)
  {
    return hashWithAlgorithm("SHA-1", paramString.getBytes());
  }
  
  public static String sha1hash(byte[] paramArrayOfByte)
  {
    return hashWithAlgorithm("SHA-1", paramArrayOfByte);
  }
  
  public static boolean stringsEqualOrEmpty(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((bool1) && (bool2)) {
      return true;
    }
    if ((!bool1) && (!bool2)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public static JSONArray tryGetJSONArrayFromResponse(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONArray(paramString);
    }
    return null;
  }
  
  public static JSONObject tryGetJSONObjectFromResponse(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject(paramString);
    }
    return null;
  }
  
  public static Collection unmodifiableCollection(Object... paramVarArgs)
  {
    return Collections.unmodifiableCollection(Arrays.asList(paramVarArgs));
  }
  
  public static void writeStringMapToParcel(Parcel paramParcel, Map paramMap)
  {
    if (paramMap == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    paramParcel.writeInt(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeString((String)localEntry.getValue());
    }
  }
  
  public static class DialogFeatureConfig
  {
    public String dialogName;
    public Uri fallbackUrl;
    public String featureName;
    public int[] featureVersionSpec;
    
    public DialogFeatureConfig(String paramString1, String paramString2, Uri paramUri, int[] paramArrayOfInt)
    {
      dialogName = paramString1;
      featureName = paramString2;
      fallbackUrl = paramUri;
      featureVersionSpec = paramArrayOfInt;
    }
    
    public static DialogFeatureConfig parseDialogConfig(JSONObject paramJSONObject)
    {
      String str1 = paramJSONObject.optString("name");
      boolean bool = Utility.isNullOrEmpty(str1);
      Uri localUri = null;
      if (bool) {
        return null;
      }
      Object localObject = str1.split("\\|");
      if (localObject.length != 2) {
        return null;
      }
      str1 = localObject[0];
      localObject = localObject[1];
      if (!Utility.isNullOrEmpty(str1))
      {
        if (Utility.isNullOrEmpty((String)localObject)) {
          return null;
        }
        String str2 = paramJSONObject.optString("url");
        if (!Utility.isNullOrEmpty(str2)) {
          localUri = Uri.parse(str2);
        }
        return new DialogFeatureConfig(str1, (String)localObject, localUri, parseVersionSpec(paramJSONObject.optJSONArray("versions")));
      }
      return null;
    }
    
    public static int[] parseVersionSpec(JSONArray paramJSONArray)
    {
      int[] arrayOfInt;
      if (paramJSONArray != null)
      {
        int m = paramJSONArray.length();
        arrayOfInt = new int[m];
        int j = 0;
        while (j < m)
        {
          int i = -1;
          int k = paramJSONArray.optInt(j, -1);
          if (k == -1)
          {
            String str = paramJSONArray.optString(j);
            if (!Utility.isNullOrEmpty(str)) {
              try
              {
                k = Integer.parseInt(str);
                i = k;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                Utility.logd("FacebookSDK", localNumberFormatException);
              }
            }
          }
          i = k;
          arrayOfInt[j] = i;
          j += 1;
        }
      }
      return null;
      return arrayOfInt;
    }
    
    public String getDialogName()
    {
      return dialogName;
    }
    
    public Uri getFallbackUrl()
    {
      return fallbackUrl;
    }
    
    public String getFeatureName()
    {
      return featureName;
    }
    
    public int[] getVersionSpec()
    {
      return featureVersionSpec;
    }
  }
  
  public static class FetchedAppSettings
  {
    public Map<String, Map<String, Utility.DialogFeatureConfig>> dialogConfigMap;
    public FacebookRequestErrorClassification errorClassification;
    public String nuxContent;
    public boolean nuxEnabled;
    public boolean supportsImplicitLogging;
    
    public FetchedAppSettings(boolean paramBoolean1, String paramString, boolean paramBoolean2, Map paramMap, FacebookRequestErrorClassification paramFacebookRequestErrorClassification)
    {
      supportsImplicitLogging = paramBoolean1;
      nuxContent = paramString;
      nuxEnabled = paramBoolean2;
      dialogConfigMap = paramMap;
      errorClassification = paramFacebookRequestErrorClassification;
    }
    
    public Map getDialogConfigurations()
    {
      return dialogConfigMap;
    }
    
    public FacebookRequestErrorClassification getErrorClassification()
    {
      return errorClassification;
    }
    
    public String getNuxContent()
    {
      return nuxContent;
    }
    
    public boolean getNuxEnabled()
    {
      return nuxEnabled;
    }
    
    public boolean supportsImplicitLogging()
    {
      return supportsImplicitLogging;
    }
  }
  
  public static abstract interface GraphMeRequestWithCacheCallback
  {
    public abstract void onFailure(FacebookException paramFacebookException);
    
    public abstract void onSuccess(JSONObject paramJSONObject);
  }
  
  public static abstract interface Mapper<T, K>
  {
    public abstract Object apply(Object paramObject);
  }
  
  public static abstract interface Predicate<T>
  {
    public abstract boolean apply(Object paramObject);
  }
}
